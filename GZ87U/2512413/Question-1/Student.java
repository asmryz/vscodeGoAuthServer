public class Student {
    String Name;
    int registorNo;
    double cgpa;

    public Student(String name, int registorNo, double cgpa) {
        Name = name;
        this.registorNo = registorNo;
        this.cgpa = cgpa;
    }

    public void displayInfo(){
        System.out.println("Student Name : "+Name);
        System.out.println("Student Registration Number : "+registorNo);
        System.out.println("CGPA :"+cgpa);
    }
}
