public class Student {
    String name;
    String course;
    String cgpa;

    Student(String name, String course, String cgpa) {
        this.name = name;
        this.course = course;
        this.cgpa = cgpa;
    }

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("course: " + course);
        System.out.println("CGPA: " + cgpa);
    }
}