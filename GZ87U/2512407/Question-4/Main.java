public class MainyStudentGrade {
    public static void main(String[] args) {
        Student s = new Student("Sarah");

        s.registerCourse(new Course("CS101", "OOP"), new Grade(88));
        s.registerCourse(new Course("CS102", "DLD"), new Grade(75));
        s.registerCourse(new Course("CS103", "JAVA"), new Grade(62));

System.out.println("Student: " +s.name);
System.out.println("Calculated SGPA:" + s.calculateSGPA());

}
}