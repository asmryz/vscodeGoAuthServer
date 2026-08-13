public class Student {
    String name;
    int rollNo;
    double cgpa;

    public void input(String name, int rollNo ,double cgpa){
        this.name = name;
        this.rollNo = rollNo;
        this.cgpa = cgpa;
    }

    public void display(){
        System.out.println("Student Name: "+ name);
        System.out.println("Student RegNo: "+ rollNo);
        System.out.println("Student cgpa: "+ cgpa);

    }

}