class Course {
    private String courseCode;
    private String courseName;
    private int credits;

    Course(String courseCode, String courseName, int credits) {
    this.courseCode = courseCode;
    this.courseName = courseName;
    this.credits = credits;
    }
    public String getCourseCode() { return courseCode; }
    public String getCourseName() { return courseName; }
    public int getCredits() { return credits; }
}
class Grade {
    private Course course;
    private double marks;
    private String grade;
    private double gradePoint;
    Grade(Course course, double marks) {
     this.course = course;
     this.marks = marks;
        determineGradeAndPoints();
    }
    private void determineGradeAndPoints() {
    if (marks >= 90) {
            grade = "O"; gradePoint = 10;
        } else if (marks >= 80) {
            grade = "A+"; gradePoint = 9;
        } else if (marks >= 70) {
            grade = "A"; gradePoint = 8;
        } else if (marks >= 60) {
            grade = "B+"; gradePoint = 7;
        } else if (marks >= 50) {
            grade = "B"; gradePoint = 6;
        } else if (marks >= 40) {
            grade = "C"; gradePoint = 5;
        } else {
            grade = "F"; gradePoint = 0;
        }
    }
    public double getGradePoint() { return gradePoint; }
    public int getCredits() { return course.getCredits(); }
    public String getCourseCode() { return course.getCourseCode(); }
    public String getCourseName() { return course.getCourseName(); }
    public String getGrade() { return grade; }
    public double getMarks() { return marks; }

    public void display() {
        System.out.printf("%-10s %-25s %-8s %-8s %-8d%n",
                course.getCourseCode(), course.getCourseName(),
                marks, grade, course.getCredits());
    }
}
class Student {
    private String name;
    private String regNo;
    private Course[] courses;
    private Grade[] grades;
    private int courseCount;
    private static final int MAX_COURSES = 5;

    Student(String name, String regNo) {
        this.name = name;
        this.regNo = regNo;
        this.courses = new Course[MAX_COURSES];
        this.grades = new Grade[MAX_COURSES];
        this.courseCount = 0;
    }

    public boolean registerCourse(Course course, double marks) {
        if (courseCount >= MAX_COURSES) {
            System.out.println("ERROR: Cannot register more than " + MAX_COURSES + " courses!");
            return false;
        }
        courses[courseCount] = course;
        grades[courseCount] = new Grade(course, marks);
        courseCount++;
        return true;
    }

    public double calculateSGPA() {
        double totalCreditPoints = 0;
        int totalCredits = 0;

        for (int i = 0; i < courseCount; i++) {
            totalCreditPoints += grades[i].getGradePoint() * grades[i].getCredits();
            totalCredits += grades[i].getCredits();
        }

        return (totalCredits == 0) ? 0 : totalCreditPoints / totalCredits;
    }
    public void displayStudentReport() {
        System.out.println("STUDENT SEMESTER REPORT ");
        System.out.println(" Name: " + name);
        System.out.println("Registration No: " + regNo);
        System.out.printf("%-10s %-25s %-8s %-8s %-8s%n",
                "Code", "Course Name", "Marks", "Grade", "Credits");

        for (int i = 0; i < courseCount; i++) {
            grades[i].display();
        }
        System.out.printf("SGPA: %.2f%n", calculateSGPA());
    }
}

public class Main {
    public static void main(String[] args) {

        Course c1 = new Course("java", "Programming in Java", 4);
        Course c2 = new Course("coding", "Data Structures", 4);
        Course c3 = new Course("Maths", "Mathematics I", 3);
        Course c4 = new Course("Enlish", "English Communication", 2);
        Course c5 = new Course("PHysics", "Physics I", 3);
        Course c6 = new Course("Chemistry1", "Chemistry I", 3);

        Student student = new Student("saeed", "2512228");

        student.registerCourse(c1, 88);
        student.registerCourse(c2, 75);
        student.registerCourse(c3, 92);
        student.registerCourse(c4, 55);
        student.registerCourse(c5, 68);
        student.registerCourse(c6, 80);

        student.displayStudentReport();

        System.out.println("\nSGPA Calculation Verification");
        System.out.println("CS101: 9 × 4 = 36");
        System.out.println("CS102: 8 × 4 = 32");
        System.out.println("MATH101: 10 × 3 = 30");
        System.out.println("ENG101: 6 × 2 = 12");
        System.out.println("PHY101: 7 × 3 = 21");
        System.out.println("Total Credit Points = 131");
        System.out.println("Total Credits = 16");
        System.out.println("SGPA = 131 / 16 = 8.19");
    }
}
