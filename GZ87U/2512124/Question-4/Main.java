public class main4 {
    public static void main(String[] args) {
        student s1 = new student("RAAHIM", "2025-CS2512124");

        course c1 = new course("OOP", "CS101");
        course c2 = new course("MATHS", "CS102");
        course c3 = new course("ENG", "MA101");

        s1.registerCourse(new grade(c1, 85));
        s1.registerCourse(new grade(c2, 92));
        s1.displayResult();
    }
}