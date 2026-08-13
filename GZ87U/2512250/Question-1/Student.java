/*
Create a Java class `Student` with attributes `name`, `regNo`, and `cgpa`. Provide a constructor to initialize these attributes and a method `displayInfo()` to display the student information. Create two `Student` objects in the `main()` method and display their details.
*/

import java.util.Scanner;

public class Student {

     String name;
    int reg_no;
    double cgpa;

    void input(){
        Scanner input= new Scanner(System.in);
        System.out.println("Enter Student name: "+name);
        name=input.nextLine();
        System.out.println("enter Student reg num: "+reg_no);
        reg_no=input.nextInt();
        input.nextLine();
        System.out.println("enter student cgpa: "+ cgpa);
        cgpa=input.nextInt();
        input.nextLine();


    }
    void display(){
        System.out.println("student name"+name);
        System.out.println("student reg_no: "+reg_no);
        System.out.println("student cgpa"+ cgpa);
    }

}