Viewed main.go:748-779

Here is how you can write the entire `classroom-auth` server in **Node.js (JavaScript / Express)**.

---

### Key Node.js Packages Needed

Install the required packages using npm:

```bash
npm install express cookie-parser http-proxy-middleware better-sqlite3 bcryptjs
```

---

### Complete Node.js Implementation (`server.js`)

```js
const express = require('express');
const cookieParser = require('cookie-parser');
const { createProxyMiddleware } = require('http-proxy-middleware');
const Database = require('better-sqlite3');
const bcrypt = require('bcryptjs');
const { execFile } = require('child_process');
const fs = require('fs');
const path = require('path');
const net = require('net');
const crypto = require('crypto');

// Configuration
const PORT = 8090;
const DB_FILE = './classroom.db';
const BASE_STUDENT_DIR = '/home/aismriaz/web-editor/GZ87U';
const DOCKER_IMAGE = 'vscode-java';
const CONTAINER_PREFIX = 'vscode-java-';
const SESSION_COOKIE = 'classroom_session';
const SESSION_DURATION = 8 * 60 * 60 * 1000; // 8 hours in ms

const regnoPattern = /^[A-Za-z0-9_-]{1,40}$/;

// 1. Database Initialization
const db = new Database(DB_FILE);

db.exec(`
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
    FOREIGN KEY(regno) REFERENCES students(regno) ON DELETE CASCADE
  );

  CREATE INDEX IF NOT EXISTS idx_sessions_regno ON sessions(regno);
  CREATE INDEX IF NOT EXISTS idx_sessions_expires ON sessions(expires_at);
`);

// 2. Helper Functions
function ensureStudentDirectory(regno) {
  if (!regnoPattern.test(regno)) {
    throw new Error('Invalid registration number');
  }

  const studentDir = path.join(BASE_STUDENT_DIR, regno);
  
  if (!fs.existsSync(studentDir)) {
    fs.mkdirSync(studentDir, { recursive: true, mode: 0o777 });
    fs.chmodSync(studentDir, 0o777);
  }

  return studentDir;
}

function execAsync(cmd, args) {
  return new Promise((resolve, reject) => {
    execFile(cmd, args, (err, stdout, stderr) => {
      if (err) return reject(err);
      resolve(stdout.trim());
    });
  });
}

// Ensure and start/create student Docker container
async function ensureStudentContainer(student) {
  const containerName = `${CONTAINER_PREFIX}${student.regno}`;
  const studentDir = ensureStudentDirectory(student.regno);

  try {
    const isRunning = await execAsync('docker', ['inspect', '-f', '{{.State.Running}}', containerName]);
    if (isRunning === 'true') {
      return; // Container is already running
    }
    // Container exists but stopped -> start it
    await execAsync('docker', ['start', containerName]);
  } catch {
    // Container doesn't exist -> run new container with proper entrypoint & volume mount
    const portBinding = `127.0.0.1:${student.port}:8080`;
    const volumeBinding = `${studentDir}:/home/coder/project`;

    const dockerArgs = [
      'run', '-d',
      '--name', containerName,
      '--hostname', student.regno,
      '--restart', 'unless-stopped',
      '--security-opt', 'no-new-privileges:true',
      '--cap-drop', 'ALL',
      '-p', portBinding,
      '-v', volumeBinding,
      '--entrypoint', '/usr/bin/entrypoint.sh',
      DOCKER_IMAGE,
      '--bind-addr', '0.0.0.0:8080',
      '--auth', 'none',
      '--disable-telemetry',
      '/home/coder/project'
    ];

    console.log(`Creating container ${containerName}`);
    await execAsync('docker', dockerArgs);
  }
}

// Wait until code-server port is listening
function waitForPort(port, timeoutMs = 15000) {
  return new Promise((resolve, reject) => {
    const start = Date.now();

    const check = () => {
      const socket = new net.Socket();
      socket.setTimeout(500);

      socket.on('connect', () => {
        socket.destroy();
        resolve();
      });

      socket.on('error', () => {
        socket.destroy();
        if (Date.now() - start > timeoutMs) {
          reject(new Error(`Timeout waiting for 127.0.0.1:${port}`));
        } else {
          setTimeout(check, 250);
        }
      });

      socket.connect(port, '127.0.0.1');
    };

    check();
  });
}

// Hash session token
function hashToken(token) {
  return crypto.createHash('sha256').update(token).digest('hex');
}

// Get student from request session cookie
function getStudentFromSession(req) {
  const token = req.cookies[SESSION_COOKIE];
  if (!token) return null;

  const tokenHash = hashToken(token);
  const now = Math.floor(Date.now() / 1000);

  const row = db.prepare(`
    SELECT s.regno, s.password_hash, s.port, s.enabled
    FROM sessions sess
    JOIN students s ON s.regno = sess.regno
    WHERE sess.token_hash = ? AND sess.expires_at > ?
  `).get(tokenHash, now);

  return row ? { regno: row.regno, port: row.port, enabled: Boolean(row.enabled) } : null;
}

// 3. CLI Command Support (`node server.js add/enable/disable`)
const args = process.argv.slice(2);
if (args.length > 0) {
  const cmd = args[0];

  if (cmd === 'add' && args.length === 4) {
    const [, regno, password, portStr] = args;
    const port = parseInt(portStr, 10);
    const passwordHash = bcrypt.hashSync(password, 10);

    db.prepare(`
      INSERT INTO students (regno, password_hash, port, enabled)
      VALUES (?, ?, ?, 1)
      ON CONFLICT(regno) DO UPDATE SET password_hash = excluded.password_hash, port = excluded.port, enabled = 1
    `).run(regno, passwordHash, port);

    const studentDir = ensureStudentDirectory(regno);
    console.log(`Student created/updated:\nRegistration: ${regno}\nPort: ${port}\nDirectory: ${studentDir}`);
    process.exit(0);
  }

  if ((cmd === 'enable' || cmd === 'disable') && args.length === 2) {
    const regno = args[1];
    const enabled = cmd === 'enable' ? 1 : 0;
    db.prepare('UPDATE students SET enabled = ? WHERE regno = ?').run(enabled, regno);
    console.log(`Student ${regno} enabled=${enabled === 1}`);
    process.exit(0);
  }

  console.error('Invalid arguments');
  process.exit(1);
}

// 4. Express Server Setup
const app = express();
app.use(express.urlencoded({ extended: true }));
app.use(cookieParser());

// HTML Login Page Template
const loginHTML = (error = '') => `
<!DOCTYPE html>
<html>
<head>
  <title>Java Classroom</title>
  <style>
    body { font-family: Arial, sans-serif; background: #1e1e1e; color: white; display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0; }
    .login-box { width: 340px; padding: 30px; background: #252526; border-radius: 8px; }
    h2 { text-align: center; margin-bottom: 25px; }
    input { width: 100%; box-sizing: border-box; padding: 12px; margin-bottom: 15px; border: 1px solid #555; background: #333; color: white; border-radius: 4px; }
    button { width: 100%; padding: 12px; background: #007acc; color: white; border: none; border-radius: 4px; cursor: pointer; }
    button:hover { background: #0062a3; }
    .error { background: #5a1d1d; padding: 10px; margin-bottom: 15px; border-radius: 4px; }
  </style>
</head>
<body>
  <div class="login-box">
    <h2>Java Classroom</h2>
    ${error ? `<div class="error">${error}</div>` : ''}
    <form method="POST" action="/login">
      <input type="text" name="regno" placeholder="Registration Number" required autocomplete="username">
      <input type="password" name="password" placeholder="Password" required autocomplete="current-password">
      <button type="submit">Login</button>
    </form>
  </div>
</body>
</html>`;

// Login GET
app.get('/login', (req, res) => {
  if (getStudentFromSession(req)) {
    return res.redirect('/');
  }
  res.setHeader('Content-Type', 'text/html');
  res.send(loginHTML());
});

// Login POST
app.post('/login', async (req, res) => {
  const { regno, password } = req.body;

  if (!regnoPattern.test(regno)) {
    return res.send(loginHTML('Invalid registration number or password'));
  }

  const student = db.prepare('SELECT * FROM students WHERE regno = ?').get(regno);
  if (!student || !student.enabled || !bcrypt.compareSync(password, student.password_hash)) {
    return res.send(loginHTML('Invalid registration number or password'));
  }

  try {
    ensureStudentDirectory(student.regno);
    await ensureStudentContainer(student);
    await waitForPort(student.port);

    const token = crypto.randomBytes(32).toString('hex');
    const tokenHash = hashToken(token);
    const expiresAt = Math.floor((Date.now() + SESSION_DURATION) / 1000);

    db.prepare('DELETE FROM sessions WHERE regno = ?').run(student.regno);
    db.prepare('INSERT INTO sessions (token_hash, regno, expires_at) VALUES (?, ?, ?)').run(tokenHash, student.regno, expiresAt);

    res.cookie(SESSION_COOKIE, token, {
      httpOnly: true,
      sameSite: 'lax',
      path: '/',
      maxAge: SESSION_DURATION,
    });

    res.redirect('/');
  } catch (err) {
    console.error(err);
    res.status(500).send('Java environment failed to start');
  }
});

// Logout
app.get('/__classroom/logout', (req, res) => {
  const token = req.cookies[SESSION_COOKIE];
  if (token) {
    db.prepare('DELETE FROM sessions WHERE token_hash = ?').run(hashToken(token));
  }
  res.clearCookie(SESSION_COOKIE);
  res.redirect('/login');
});

// Dynamic Reverse Proxy Handler for Authenticated Sessions
const dynamicProxy = createProxyMiddleware({
  target: 'http://127.0.0.1:8080', // Fallback, updated per request
  ws: true, // Enables WebSocket proxying for VS Code terminals
  router: (req) => {
    const student = getStudentFromSession(req);
    if (!student || !student.enabled) return null;
    return `http://127.0.0.1:${student.port}`;
  },
  onError: (err, req, res) => {
    console.error('Proxy error:', err);
    res.status(502).send('Java environment unavailable');
  }
});

// Guard all routes with Proxy
app.use((req, res, next) => {
  const student = getStudentFromSession(req);
  if (!student) {
    return res.redirect('/login');
  }
  return dynamicProxy(req, res, next);
});

// Start Server
app.listen(PORT, '0.0.0.0', () => {
  console.log(`Java Classroom Auth Server listening on http://0.0.0.0:${PORT}`);
});
```

---

### Commands Usage

1. **Add Student**:
   ```bash
   node server.js add 2512147 student789 21003
   ```
2. **Enable / Disable Student**:
   ```bash
   node server.js enable 2512147
   node server.js disable 2512147
   ```
3. **Run Server**:
   ```bash
   node server.js
   ```