public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student();


        s1.name = "Bilal";
        s1.regNo = 2512430;
        s1.cgpa = 3.6;

        s2.name = "John Smith";
        s2.regNo = 2512433;
        s2.cgpa = 3.2;

        s1.displayInfo();
        s2.displayInfo();
    }
}