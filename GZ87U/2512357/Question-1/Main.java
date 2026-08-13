
public class Main
 {
    public static void main(String[] args)
     {
        Student s1 = new Student();
        Student s2 = new Student();

        System.out.println("Details of Student 1");
        s1.input();

        System.out.println("\nDetails of Student 2");
        s2.input();

        System.out.println("\nStudent Record");
        s1.display();
        s2.display();
    }
}


