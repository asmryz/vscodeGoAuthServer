import java.util.Scanner;
public class Student {
    Scanner= new Scanner.(System.in);
    public static void main(String[] args) {

    String name;
    int RegID;
    float CGPA;

    public Student(String name,int RegID,float CGPA) {
        this.name = name;
        RegID = RegID;
        this.CGPA = CGPA;
    }

    void displayInfo(){
        System.out.println("Name :"+name);
        System.out.println("RegID"+RegID);
        System.out.println("CGPA"+CGPA);

        }
    }
}