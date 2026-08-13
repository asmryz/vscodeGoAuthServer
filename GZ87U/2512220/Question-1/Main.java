
public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();

        System.out.println("student name: ");
        s1.input();

        System.out.println("student regNo: ");
        s2.input();

        System.out.println("student cgpa: ");
        s3.input();

        System.out.println("\nstudent record ");
        s1.display();
        s2.display();
        s3.display();
    }
}