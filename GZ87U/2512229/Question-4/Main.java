/*create Java classes `Student`, `Course`, and `Grade`. A `Student` can register for a maximum of five courses. The `Course` class should store course information, while the `Grade` class should store the marks for each course using a parameterized constructor. Implement appropriate methods to determine the grade and grade points from the marks and calculate the student's Semester GPA (SGPA) for all registered courses.*/
class Student{
    String courseName;
    int creditHours;
course(String courseName, int creditHours){
    this.courseName =  courseName;
    this.creditHours = creditHours;
}

}



class grade{

    double marks;

    grade( double marks){
    this.marks = marks;
}
string Getgrade(){

    if(marks >=85)
    return 'A';
    
    else if(marks >=75)
    return 'B';

     else if(marks >=65)
    return 'C';

     else if(marks >=55)
    return 'D';

    else 
    return "F";
}

}



public class Main {
    public static void main(String[] args) {
        Course course = new Course("OOP");

        System.out.println("Course Name: " + name);
        System.out.println("Course Code: " + Course);
        System.out.println("Course CGPA: " + cgpa);
    }
}