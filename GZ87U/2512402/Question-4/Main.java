public class Main {
    public static void main(String[] args) {
        Course course = new Course("OOP");

        System.out.println("Course Name: " + course.name);
        System.out.println("Course Code: " + course.Course);
        System.out.println("Course CGPA: " + course.cgpa);

        Grade grade = new Grade(82);
        System.out.println("Marks: " + grade.marks);
        System.out.println("Letter grade: " + grade.gettergrade());

        Student student1 = new Student("Muhammad Shahmeer", 3, 5.2);
        student1.displayDetails();
        
    }
}