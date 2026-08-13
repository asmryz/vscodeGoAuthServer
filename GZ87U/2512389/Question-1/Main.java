public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Hassan Javed",2512389,3.53);
        Student student2 = new Student();

        student1.displayInfo();//Parameterized constructor used

        student2.displayInfo();//Implicit initialised constructor used
    }
}