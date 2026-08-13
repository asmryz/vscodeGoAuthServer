import java.util.Scanner;
public class Student {
    public String name;
    public int regNo;
    public int cgpa;

    void input(){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter student name: ");
        String name = sc.nextLine();

        System.out.println("enter student regNo: ");
        int regNo = sc.nextInt();

        System.out.println("enter student cgpa: ");
        int cgpa = sc.nextInt();
    }
    void display(){
        System.out.println("student name: "+ name);
        System.out.println("student id: "+ regNo);
        System.out.println("student cgpa: "+cgpa);
    }
}