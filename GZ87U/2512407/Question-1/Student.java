public class Student {
    String name;
    String reg;
    double CGPA;

    Student(String name, String reg, double CGPA) {
        this.name = name;
        this.reg = reg;
        this.CGPA = CGPA;
    }

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Reg: " + reg);
        System.out.println("CGPA: " + CGPA);
        System.out.println("--------------------");
    }
}