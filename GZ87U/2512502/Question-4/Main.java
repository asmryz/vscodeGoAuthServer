public class Main {
    public static void main(String[] args) {
        student s1 = new student("Ali Khan", "2023-CS2556101");

        course c1 = new course("FOP", "CS101");
        course c2 = new course("DSA", "CS102");
        course c3 = new course("DMS", "MA101");

        s1.registerCourse(new grade(c1, 85));
        s1.registerCourse(new grade(c2, 92));
        s1.registerCourse(new grade(c3, 67));

    }
}