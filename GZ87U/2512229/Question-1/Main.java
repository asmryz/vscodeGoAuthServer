class Student {

    string name;
    int regNo;
    double cgpa;

    Student(String name, int regNo, double cgpa) {
        this.name = name;
        this.regNo = regNo;
        this.cgpa = cgpa;
    }
    void displayInfo() {
    System.out.println("name: "+ name);
    System.out.println("reg No: "+regNo);
    System.out.println("cgpa: "+ cgpa);

}

}


public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("saniya" ,101,3.3);
        Student student2 = new Student("ali", 210,4.0);


        studen1.displayInfo();
        student2.displayInfo();

    }
}