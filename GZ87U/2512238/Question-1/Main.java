public class Main {
public static void main(String[]args ) {
    Student s1=new Student();
    Student s2=new Student();

    s1.inputData("Yogesh",2512238,3.9);
    
    s2.inputData("Shivam",2512345,3.89);
    s1.displayinfo();
    s2.displayinfo();
}
}