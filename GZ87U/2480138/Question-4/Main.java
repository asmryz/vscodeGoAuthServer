public class Main {

    public static void main(String[] args) {




        System.out.println("COURSES: ");
        Course c1 = new Course();

        c1.courseName = "ICT";
        c1.courseCode = 12;
        c1.credhrs = 2.5;

        Student s1 = new Student();
        s1.numberofcourses = 4;
        s1.cgpa = 3.6;
        s1.name = "Bilal";
        s1.regNo = 2512430;

        Grade g1 = new Grade();
        g1.marks = 90;
        g1.determineGrade();
        
        









        }
    }
