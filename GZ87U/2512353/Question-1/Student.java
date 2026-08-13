public class Student {
    String name;
    int regNo;
    double cgpa;

    public Student(String name, int regNo, double cgpa){
        this.name = name;
        this.regNo = regNo;
        this.cgpa = cgpa;
    }



    public void displayInfo() {
        System.out.println("Student Name: " + name);
        System.out.println("Registration No: " + regNo);
        System.out.println("CGPA: " + cgpa);
    }

}