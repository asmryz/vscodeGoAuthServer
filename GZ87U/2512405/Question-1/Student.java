public class Student {
String name;
int regNo;
double cgpa;

    public Student(String name, int regNo, double cgpa) {
        this.name = name;
        this.regNo = regNo;
        this.cgpa = cgpa;
    }
     void displayinfo(){
         System.out.println("Name: ");
         System.out.println("Registration ID: ");
         System.out.println("CGPA: ");
     }
}