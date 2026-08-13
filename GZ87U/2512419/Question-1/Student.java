public class Student {
    String name;
    int cgpa;
    String department;

    Student(String name, int cgpa, String department) {
        this.name = name;
        this.cgpa = this.cgpa;
        this.department = department;
    }

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + cgpa);
        System.out.println("Department: " + department);
    }
}
public static void main(String[] args) {
    Student student = new Student("vish", 3 "Data Science");

    student.displayDetails();
    System.out.println("Name: " + name);
    System.out.println("CGPA: " + cgpa);
    System.out.println("Department: " + department);
    Student student = new Student("Vishwas",20,"CS");
}