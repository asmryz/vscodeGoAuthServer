public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Ali", "2023-2312450");

        Course c1 = new Course("FOP", "CS101");
        Course c2 = new Course("DSA", "CS102");

        s1.registerCourse(new Grade(c1, 85));
        s1.registerCourse(new Grade(c2, 92));

    }
}