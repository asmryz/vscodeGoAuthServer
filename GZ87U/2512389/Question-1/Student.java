public class Student {
    String name;
    int regNo;
    double cgpa;

    public Student(String name, int regNo, double cgpa) {
        this.name = name;
        this.regNo = regNo;
        this.cgpa = cgpa;
    }
    //implicit initialization
    public Student(){
    }

    public String getName() {
        return name;
    }

    public int getRegNo() {
        return regNo;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void displayInfo(){
        System.out.println("Student Name: "+getName()+"\nRegistration Number: "+getRegNo()+"\nCGPA: "+getCgpa());
    }


}