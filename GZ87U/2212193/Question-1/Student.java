public class Student {
    String name;
    String reg;
    String cgpa;

    Student(String name, String reg, String cgpa) {
        this.name = name;
        this.reg = reg;
        this.cgpa = cgpa;
    }

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("reg: " + reg);
        System.out.println("CGPA: " + cgpa);
    }
}