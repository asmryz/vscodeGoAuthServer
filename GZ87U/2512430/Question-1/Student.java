public class Student {
    String name;
    int regNo;
    double cgpa;
   // int numberofcourses;



    public Student(String nm, int regN, double cgp) {
        this.name = nm;
        this.regNo = regN;
        this.cgpa = cgp;
       // this.numberofcourses = numberCourses;
    }

    public Student() { // this is default constructor/initialize values
        name = "abc";
        regNo = 123;
        cgpa = 3.5;
    }

    public void displayInfo() {
        System.out.println("Student name: " + name);
        System.out.println("Registration Number: " + regNo);
        System.out.println("CGPA: " + cgpa);
    }

//    public void regCourse() {
//        if (numberofcourses > 5) {
//            System.out.println("Can not register more than 5 courses!");
//        }
//        else {
//            System.out.println("Courses registered!");
//        }
//    }




}
