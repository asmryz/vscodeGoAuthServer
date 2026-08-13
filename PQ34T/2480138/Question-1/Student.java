public class Student {
    String name;
    String regNo;
    double cgpa;

    public Student(String name, String regNo, double cgpa) {
        this.name = name;
        this.regNo = regNo;
        this.cgpa = cgpa;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Registration No: " + regNo);
        System.out.println("CGPA: " + cgpa);
    }
}