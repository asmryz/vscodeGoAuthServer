

public class Main {

    public static void main(String[] args) {

        Student s1 = new Student("Haziq Siddiqui", 2512398, 'G');
        s1.StudentInfo();

        Course course = new Course();
        System.out.println("\n------- Course Record --------");
        course.displayCourseDetails();

        System.out.println("\n------- Grading Record --------");
        Grade grade  = new Grade(400);
        System.out.println(grade.getGradeLetter());

    }
}
