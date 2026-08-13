public class Main {
    public static void main(String[] args) {

        Student student = new Student();

        System.out.println(student.name);

        System.out.println(student.department);

        System.out.println(student.regNo);

        student.displayCGPA();

        // Not allowed because cgpa is private:
        // System.out.println(student.cgpa);
    }
}