public class Student {
    String name;
    int regNo;
    double cgpa;

    void inputData(String name, int regNo, double cgpa) {
        this.name = name;
        this.regNo = regNo;
        this.cgpa = cgpa;
    }
     void displayinfo(){
         System.out.println("Name: "+name);
         System.out.println("Registration ID: "+regNo);
         System.out.println("CGPA: "+cgpa);
     }
}