public class Student {
    String name;
    int course;
    float cgpa;

    public Student(String name, String course, String cgpa) {
        this.name = name;
        this.course = course;
        this.cgpa = cgpa;
    }

    public void displayDetails() {
        System.out.println ("name: " + name);
        System.out.println("course: " + course);
        System.out.println("CGPA: " + cgpa);
    }
}
