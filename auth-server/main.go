package main

import (
	"context"
	"crypto/rand"
	"crypto/sha256"
	"database/sql"
	"encoding/base64"
	"fmt"
	"html/template"
	"log"
	"net"
	"net/http"
	"net/http/httputil"
	"net/url"
	"os"
	"os/exec"
	"path/filepath"
	"regexp"
	"strconv"
	"strings"
	"time"

	"golang.org/x/crypto/bcrypt"
	_ "modernc.org/sqlite"
)

const (
	listenAddress        = "0.0.0.0:8090"
	databaseFile         = "./classroom.db"
	baseStudentDirectory = "/home/aismriaz/web-editor/GZ87U"
	dockerImage          = "vscode-java"
	containerPrefix      = "vscode-java-"
	sessionCookieName    = "classroom_session"
	sessionDuration      = 8 * time.Hour
)

var (
	db           *sql.DB
	regnoPattern = regexp.MustCompile(`^[A-Za-z0-9_-]{1,40}$`)
)

type Student struct {
	RegNo        string
	PasswordHash string
	Port         int
	Enabled      bool
}

const loginPage = `
<!DOCTYPE html>
<html>
<head>
    <title>Java Classroom</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background: #1e1e1e;
            color: white;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .login-box {
            width: 340px;
            padding: 30px;
            background: #252526;
            border-radius: 8px;
        }

        h2 {
            text-align: center;
            margin-bottom: 25px;
        }

        input {
            width: 100%;
            box-sizing: border-box;
            padding: 12px;
            margin-bottom: 15px;
            border: 1px solid #555;
            background: #333;
            color: white;
            border-radius: 4px;
        }

        button {
            width: 100%;
            padding: 12px;
            background: #007acc;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        button:hover {
            background: #0062a3;
        }

        .error {
            background: #5a1d1d;
            padding: 10px;
            margin-bottom: 15px;
            border-radius: 4px;
        }
    </style>
</head>

<body>

<div class="login-box">

    <h2>Java Classroom</h2>

    {{if .Error}}
    <div class="error">
        {{.Error}}
    </div>
    {{end}}

    <form method="POST" action="/login">

        <input
            type="text"
            name="regno"
            placeholder="Registration Number"
            autocomplete="username"
            required
        >

        <input
            type="password"
            name="password"
            placeholder="Password"
            autocomplete="current-password"
            required
        >

        <button type="submit">
            Login
        </button>

    </form>

</div>

</body>
</html>
`

func main() {
	var err error
	db, err = sql.Open("sqlite", databaseFile)
	if err != nil {
		log.Fatal(err)
	}
	defer db.Close()
	if err := initializeDatabase(); err != nil {
		log.Fatal(err)
	}

	/*
	   Commands:
	   Add student:
	   ./classroom-auth add 2512147 password123 21001
	   Disable student:
	   ./classroom-auth disable 2512147
	   Enable student:
	   ./classroom-auth enable 2512147
	   Normal server:
	   ./classroom-auth
	*/

	if len(os.Args) > 1 {
		switch os.Args[1] {
		case "add":
			handleAddStudentCommand()
			return

		case "disable":
			handleEnableDisableCommand(false)
			return

		case "enable":
			handleEnableDisableCommand(true)
			return

		default:
			log.Fatalf("Unknown command: %s", os.Args[1])
		}
	}

	go cleanupExpiredSessions()
	mux := http.NewServeMux()
	mux.HandleFunc("/login", loginHandler)
	mux.HandleFunc("/__classroom/logout", logoutHandler)

	/*
	   Everything else goes through authentication.
	   That means:

	   /
	   /workbench.html
	   /static/...
	   /web-extension-resource/...
	   WebSocket connections
	   etc.
	   are protected by the session.
	*/
	mux.HandleFunc("/", authenticatedProxyHandler)

	server := &http.Server{
		Addr:              listenAddress,
		Handler:           mux,
		ReadHeaderTimeout: 10 * time.Second,
	}

	log.Println("-------------------------------------------")
	log.Println("Java Classroom Authentication Server")
	log.Printf("Listening on http://%s", listenAddress)
	log.Printf("Student root: %s", baseStudentDirectory)
	log.Println("-------------------------------------------")

	log.Fatal(server.ListenAndServe())
}

func initializeDatabase() error {

	query := `
	CREATE TABLE IF NOT EXISTS students (
		regno TEXT PRIMARY KEY,
		password_hash TEXT NOT NULL,
		port INTEGER UNIQUE NOT NULL,
		enabled INTEGER NOT NULL DEFAULT 1,
		created_at DATETIME DEFAULT CURRENT_TIMESTAMP
	);

	CREATE TABLE IF NOT EXISTS sessions (
		token_hash TEXT PRIMARY KEY,
		regno TEXT NOT NULL,
		expires_at INTEGER NOT NULL,

		FOREIGN KEY(regno)
			REFERENCES students(regno)
			ON DELETE CASCADE
	);

	CREATE INDEX IF NOT EXISTS idx_sessions_regno
	ON sessions(regno);

	CREATE INDEX IF NOT EXISTS idx_sessions_expires
	ON sessions(expires_at);
	`

	_, err := db.Exec(query)

	return err
}

func handleAddStudentCommand() {

	if len(os.Args) != 5 {
		fmt.Println(
			"Usage:",
			os.Args[0],
			"add <regno> <password> <port>",
		)
		return
	}

	regno := strings.TrimSpace(os.Args[2])
	password := os.Args[3]

	port, err := strconv.Atoi(os.Args[4])

	if err != nil {
		log.Fatal("Invalid port")
	}

	if !regnoPattern.MatchString(regno) {
		log.Fatal("Invalid registration number")
	}

	if port < 1024 || port > 65535 {
		log.Fatal("Port must be between 1024 and 65535")
	}

	passwordHash, err := bcrypt.GenerateFromPassword(
		[]byte(password),
		bcrypt.DefaultCost,
	)

	if err != nil {
		log.Fatal(err)
	}

	_, err = db.Exec(`
		INSERT INTO students(
			regno,
			password_hash,
			port,
			enabled
		)
		VALUES (?, ?, ?, 1)

		ON CONFLICT(regno)
		DO UPDATE SET
			password_hash = excluded.password_hash,
			port = excluded.port,
			enabled = 1
	`,
		regno,
		string(passwordHash),
		port,
	)

	if err != nil {
		log.Fatal(err)
	}

	studentDirectory := filepath.Join(
		baseStudentDirectory,
		regno,
	)

	if err := os.MkdirAll(
		studentDirectory,
		0777,
	); err != nil {
		log.Fatal(err)
	}
	_ = os.Chmod(studentDirectory, 0777)

	fmt.Println("Student created/updated:")
	fmt.Println("Registration:", regno)
	fmt.Println("Port:", port)
	fmt.Println("Directory:", studentDirectory)
}

func handleEnableDisableCommand(enabled bool) {

	if len(os.Args) != 3 {
		log.Fatalf(
			"Usage: %s enable|disable <regno>",
			os.Args[0],
		)
	}

	regno := os.Args[2]

	value := 0

	if enabled {
		value = 1
	}

	_, err := db.Exec(
		`UPDATE students SET enabled = ? WHERE regno = ?`,
		value,
		regno,
	)

	if err != nil {
		log.Fatal(err)
	}

	fmt.Printf(
		"Student %s enabled=%v\n",
		regno,
		enabled,
	)
}

func loginHandler(
	w http.ResponseWriter,
	r *http.Request,
) {

	/*
	   Already logged in?
	*/

	if r.Method == http.MethodGet {

		if _, err := getStudentFromSession(r); err == nil {

			http.Redirect(
				w,
				r,
				"/",
				http.StatusSeeOther,
			)

			return
		}

		renderLogin(w, "")

		return
	}

	if r.Method != http.MethodPost {

		http.Error(
			w,
			"Method not allowed",
			http.StatusMethodNotAllowed,
		)

		return
	}

	if err := r.ParseForm(); err != nil {

		renderLogin(
			w,
			"Invalid request",
		)

		return
	}

	regno := strings.TrimSpace(
		r.FormValue("regno"),
	)

	password := r.FormValue("password")

	if !regnoPattern.MatchString(regno) {

		renderLogin(
			w,
			"Invalid registration number or password",
		)

		return
	}

	student, err := findStudent(regno)

	if err != nil {

		renderLogin(
			w,
			"Invalid registration number or password",
		)

		return
	}

	if !student.Enabled {

		renderLogin(
			w,
			"Your account is disabled",
		)

		return
	}

	err = bcrypt.CompareHashAndPassword(
		[]byte(student.PasswordHash),
		[]byte(password),
	)

	if err != nil {

		renderLogin(
			w,
			"Invalid registration number or password",
		)

		return
	}

	/*
	   Student authenticated.

	   Make sure their project directory exists.
	*/

	studentDirectory, err := ensureStudentDirectory(
		student.RegNo,
	)

	if err != nil {

		log.Println(err)

		http.Error(
			w,
			"Unable to prepare student directory",
			http.StatusInternalServerError,
		)

		return
	}

	log.Printf(
		"Authenticated %s directory=%s",
		student.RegNo,
		studentDirectory,
	)

	/*
	   Start container if needed.
	*/

	if err := ensureStudentContainer(student); err != nil {

		log.Printf(
			"Container error for %s: %v",
			student.RegNo,
			err,
		)

		http.Error(
			w,
			"Unable to start Java environment",
			http.StatusInternalServerError,
		)

		return
	}

	/*
	   Wait until code-server is listening before redirecting.
	*/

	if err := waitForPort(student.Port); err != nil {

		log.Printf(
			"code-server not ready for %s: %v",
			student.RegNo,
			err,
		)

		http.Error(
			w,
			"Java environment failed to start",
			http.StatusInternalServerError,
		)

		return
	}

	token, tokenHash, err := generateSessionToken()

	if err != nil {

		http.Error(
			w,
			"Unable to create session",
			http.StatusInternalServerError,
		)

		return
	}

	expires := time.Now().
		Add(sessionDuration).
		Unix()

	/*
	   Remove previous sessions for the student.
	   This makes one current login session per student.
	*/

	_, _ = db.Exec(
		`DELETE FROM sessions WHERE regno = ?`,
		student.RegNo,
	)

	_, err = db.Exec(`
		INSERT INTO sessions(
			token_hash,
			regno,
			expires_at
		)
		VALUES (?, ?, ?)
	`,
		tokenHash,
		student.RegNo,
		expires,
	)

	if err != nil {

		http.Error(
			w,
			"Unable to create session",
			http.StatusInternalServerError,
		)

		return
	}

	http.SetCookie(
		w,
		&http.Cookie{
			Name:     sessionCookieName,
			Value:    token,
			Path:     "/",
			HttpOnly: true,
			SameSite: http.SameSiteLaxMode,

			/*
			   LAN HTTP environment.

			   If you later use HTTPS,
			   change this to true.
			*/

			Secure: false,

			Expires: time.Unix(
				expires,
				0,
			),
		},
	)

	log.Printf(
		"Login successful: %s",
		student.RegNo,
	)

	http.Redirect(
		w,
		r,
		"/",
		http.StatusSeeOther,
	)
}

func renderLogin(
	w http.ResponseWriter,
	errorMessage string,
) {

	w.Header().Set(
		"Content-Type",
		"text/html; charset=utf-8",
	)

	w.Header().Set(
		"Cache-Control",
		"no-store",
	)

	t, err := template.New(
		"login",
	).Parse(loginPage)

	if err != nil {
		http.Error(w, err.Error(), 500)
		return
	}

	data := struct {
		Error string
	}{
		Error: errorMessage,
	}

	_ = t.Execute(w, data)
}

func findStudent(
	regno string,
) (*Student, error) {

	var student Student

	var enabled int

	err := db.QueryRow(`
		SELECT
			regno,
			password_hash,
			port,
			enabled
		FROM students
		WHERE regno = ?
	`,
		regno,
	).Scan(
		&student.RegNo,
		&student.PasswordHash,
		&student.Port,
		&enabled,
	)

	if err != nil {
		return nil, err
	}

	student.Enabled = enabled == 1

	return &student, nil
}

func ensureStudentDirectory(
	regno string,
) (string, error) {

	if !regnoPattern.MatchString(regno) {
		return "", fmt.Errorf(
			"invalid registration number",
		)
	}

	directory := filepath.Join(
		baseStudentDirectory,
		regno,
	)

	/*
	   Additional protection against path traversal.
	*/

	baseClean := filepath.Clean(
		baseStudentDirectory,
	)

	directoryClean := filepath.Clean(
		directory,
	)

	expectedPrefix := baseClean +
		string(os.PathSeparator)

	if !strings.HasPrefix(
		directoryClean,
		expectedPrefix,
	) {
		return "", fmt.Errorf(
			"invalid student directory",
		)
	}

	err := os.MkdirAll(
		directoryClean,
		0777,
	)

	if err != nil {
		return "", err
	}

	_ = os.Chmod(directoryClean, 0777)

	return directoryClean, nil
}

func containerName(
	regno string,
) string {

	return containerPrefix + regno
}

func ensureStudentContainer(
	student *Student,
) error {

	name := containerName(
		student.RegNo,
	)

	studentDirectory, err := ensureStudentDirectory(
		student.RegNo,
	)

	if err != nil {
		return err
	}

	/*
	   Check if container already exists.
	*/

	cmd := exec.Command(
		"docker",
		"inspect",
		"-f",
		"{{.State.Running}}",
		name,
	)

	output, err := cmd.Output()

	if err == nil {

		running := strings.TrimSpace(
			string(output),
		)

		if running == "true" {
			return nil
		}

		/*
		   Container exists but is stopped.
		*/

		start := exec.Command(
			"docker",
			"start",
			name,
		)

		start.Stdout = os.Stdout
		start.Stderr = os.Stderr

		return start.Run()
	}

	/*
	   Container doesn't exist.

	   IMPORTANT:

	   Port is bound to 127.0.0.1 ONLY.

	   Example:

	   127.0.0.1:21001:8080

	   LAN users cannot directly connect to 21001.
	*/

	portBinding := fmt.Sprintf(
		"127.0.0.1:%d:8080",
		student.Port,
	)

	volumeBinding := fmt.Sprintf(
		"%s:/home/coder/project",
		studentDirectory,
	)

	hostname := student.RegNo

	args := []string{
		"run",
		"-d",

		"--name",
		name,

		"--hostname",
		hostname,

		"--restart",
		"unless-stopped",

		"--security-opt",
		"no-new-privileges:true",

		"--cap-drop",
		"ALL",

		"-p",
		portBinding,

		"-v",
		volumeBinding,

		"--entrypoint",
		"/usr/bin/entrypoint.sh",

		dockerImage,

		"--bind-addr",
		"0.0.0.0:8080",

		"--auth",
		"none",

		"--disable-telemetry",

		"/home/coder/project",
	}

	log.Printf(
		"Creating container %s",
		name,
	)

	log.Printf(
		"Mounting %s -> /home/coder/project",
		studentDirectory,
	)

	command := exec.Command(
		"docker",
		args...,
	)

	command.Stdout = os.Stdout
	command.Stderr = os.Stderr

	return command.Run()
}

func waitForPort(port int) error {

	address := fmt.Sprintf(
		"127.0.0.1:%d",
		port,
	)

	deadline := time.Now().
		Add(15 * time.Second)

	for time.Now().Before(deadline) {

		conn, err := net.DialTimeout(
			"tcp",
			address,
			500*time.Millisecond,
		)

		if err == nil {

			conn.Close()

			return nil
		}

		time.Sleep(
			250 * time.Millisecond,
		)
	}

	return fmt.Errorf(
		"timeout waiting for %s",
		address,
	)
}

func authenticatedProxyHandler(
	w http.ResponseWriter,
	r *http.Request,
) {

	student, err := getStudentFromSession(r)

	if err != nil {

		/*
		   THIS IS WHAT PROTECTS DIRECT URL ACCESS.

		   Someone entering:

		   http://SERVER-IP:8090/

		   or:

		   http://SERVER-IP:8090/workbench.html

		   without authentication is redirected here.
		*/

		http.Redirect(
			w,
			r,
			"/login",
			http.StatusSeeOther,
		)

		return
	}

	if !student.Enabled {

		deleteSession(r)

		http.Redirect(
			w,
			r,
			"/login",
			http.StatusSeeOther,
		)

		return
	}

	target, err := url.Parse(
		fmt.Sprintf(
			"http://127.0.0.1:%d",
			student.Port,
		),
	)

	if err != nil {

		http.Error(
			w,
			"Proxy configuration error",
			500,
		)

		return
	}

	/*
	   Use Go's modern Rewrite API.

	   The browser always talks to port 8090.

	   It never receives the actual student
	   Docker port.
	*/

	proxy := &httputil.ReverseProxy{

		Rewrite: func(
			proxyRequest *httputil.ProxyRequest,
		) {

			proxyRequest.SetURL(
				target,
			)

			proxyRequest.SetXForwarded()

			/*
			   Preserve original Host value.

			   This generally works better
			   with web applications like code-server.
			*/

			proxyRequest.Out.Host =
				proxyRequest.In.Host
		},

		ErrorHandler: func(
			w http.ResponseWriter,
			r *http.Request,
			err error,
		) {

			log.Printf(
				"Proxy error user=%s error=%v",
				student.RegNo,
				err,
			)

			http.Error(
				w,
				"Java environment unavailable",
				http.StatusBadGateway,
			)
		},
	}

	proxy.ServeHTTP(
		w,
		r,
	)
}

func generateSessionToken() (
	string,
	string,
	error,
) {

	bytes := make(
		[]byte,
		32,
	)

	if _, err := rand.Read(bytes); err != nil {
		return "", "", err
	}

	token := base64.RawURLEncoding.
		EncodeToString(bytes)

	hash := sha256.Sum256(
		[]byte(token),
	)

	hashText := fmt.Sprintf(
		"%x",
		hash[:],
	)

	return token, hashText, nil
}

func hashToken(
	token string,
) string {

	hash := sha256.Sum256(
		[]byte(token),
	)

	return fmt.Sprintf(
		"%x",
		hash[:],
	)
}

func getStudentFromSession(
	r *http.Request,
) (*Student, error) {

	cookie, err := r.Cookie(
		sessionCookieName,
	)

	if err != nil {
		return nil, err
	}

	tokenHash := hashToken(
		cookie.Value,
	)

	var student Student

	var enabled int

	var expires int64

	err = db.QueryRow(`
		SELECT
			s.regno,
			s.password_hash,
			s.port,
			s.enabled,
			sess.expires_at

		FROM sessions sess

		JOIN students s
			ON s.regno = sess.regno

		WHERE sess.token_hash = ?
	`,
		tokenHash,
	).Scan(
		&student.RegNo,
		&student.PasswordHash,
		&student.Port,
		&enabled,
		&expires,
	)

	if err != nil {
		return nil, err
	}

	if time.Now().Unix() > expires {

		_, _ = db.Exec(
			`DELETE FROM sessions WHERE token_hash = ?`,
			tokenHash,
		)

		return nil, fmt.Errorf(
			"session expired",
		)
	}

	student.Enabled = enabled == 1

	return &student, nil
}

func logoutHandler(
	w http.ResponseWriter,
	r *http.Request,
) {

	cookie, err := r.Cookie(
		sessionCookieName,
	)

	if err == nil {

		tokenHash := hashToken(
			cookie.Value,
		)

		_, _ = db.Exec(
			`DELETE FROM sessions WHERE token_hash = ?`,
			tokenHash,
		)
	}

	http.SetCookie(
		w,
		&http.Cookie{
			Name:     sessionCookieName,
			Value:    "",
			Path:     "/",
			HttpOnly: true,
			MaxAge:   -1,
			Expires:  time.Unix(0, 0),
		},
	)

	http.Redirect(
		w,
		r,
		"/login",
		http.StatusSeeOther,
	)
}

func deleteSession(
	r *http.Request,
) {

	cookie, err := r.Cookie(
		sessionCookieName,
	)

	if err != nil {
		return
	}

	tokenHash := hashToken(
		cookie.Value,
	)

	_, _ = db.Exec(
		`DELETE FROM sessions WHERE token_hash = ?`,
		tokenHash,
	)
}

func cleanupExpiredSessions() {

	ticker := time.NewTicker(
		30 * time.Minute,
	)

	defer ticker.Stop()

	for range ticker.C {

		_, err := db.Exec(
			`DELETE FROM sessions WHERE expires_at < ?`,
			time.Now().Unix(),
		)

		if err != nil {
			log.Println(
				"Session cleanup:",
				err,
			)
		}
	}
}

/*
   Optional helper if you later need to stop
   a student's environment programmatically.
*/

func stopStudentContainer(
	ctx context.Context,
	regno string,
) error {

	if !regnoPattern.MatchString(regno) {
		return fmt.Errorf("invalid registration number")
	}

	command := exec.CommandContext(
		ctx,
		"docker",
		"stop",
		containerName(regno),
	)

	return command.Run()
}
