import java.util.Scanner;
public class Student {
    String[] courses = new String[5];
    int StdID;

    public Student(String[] courses, int stdID) {
        this.courses = courses;
        StdID = stdID;
    }

    public String[] getCourses() {
        return courses;
    }

    public void setCourses(String[] courses) {
        this.courses = courses;
    }

    public int getStdID() {
        return StdID;
    }

    public void setStdID(int stdID) {
        StdID = stdID;
    }






}