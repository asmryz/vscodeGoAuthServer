public class Main {
    public static void main(String[] args) {
// courses names
        Course c1 = new Course("CS101", "Programming in Java", 4);
        Course c2 = new Course("CS102", "Data Structures", 4);
        Course c3 = new Course("mATH101", "Mathematics I", 3);
        Course c4 = new Course("eNG101", "English Communication", 2);
        Course c5 = new Course("PHY101", "Physics I", 3);
        Course c6 = new Course("CHEM101", "Chemistry I", 3); 


        Student student = new Student("saeed ahmed", "2512228);


        student.registerCourse(c1, 88);   
        student.registerCourse(c2, 75);   
        student.registerCourse(c3, 92);   
        student.registerCourse(c4, 55);  
        student.registerCourse(c5, 68);   
        student.registerCourse(c6, 80);   

        student.displayStudentReport();

        System.out.println("\nSGPA Calculation Verification");
        System.out.println("CS101: 9 × 4 = 36");
        System.out.println("CS102: 8 × 4 = 32");
        System.out.println("MATH101: 10 × 3 = 30");
        System.out.println("ENG101: 6 × 2 = 12");
        System.out.println("PHY101: 7 × 3 = 21");
        System.out.println("Total Credit Points = 131");
        System.out.println("Total Credits = 16");
        System.out.println("SGPA = 131 / 16 = 8.19");
    }
}
