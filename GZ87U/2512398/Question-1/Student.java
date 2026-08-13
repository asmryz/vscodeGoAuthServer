


public class Student {
    public String name;
    public int registrationNo;
    public double cgpa;

    public Student(String  name, int registrationNo, double cgpa) {
        this.name = name;
        this.registrationNo = registrationNo;
        this.cgpa=cgpa;
    }


    public void displayInfo(){
        System.out.println("------- Student Record --------");
        System.out.println("Student Name        : " + name);
        System.out.println("Registration Number : " + registrationNo);
        System.out.println("Semester Cgpa       : " + cgpa);

    }
}

