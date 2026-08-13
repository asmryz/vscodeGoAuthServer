public class Student {
    String name;
    int rollNo;
    double cgpa;

    Student(String n, int r ,double c){
        name = n;
        rollNo = r;
        cgpa = c;
    }

    void displayInfo(){
        System.out.println("Student Name: "+ name);
        System.out.println("Student RegNo: "+ rollNo);
        System.out.println("Student cgpa: "+ cgpa);

    }

}