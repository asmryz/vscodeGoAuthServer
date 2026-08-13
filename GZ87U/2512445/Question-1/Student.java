public class Student {
    String name ;
    String regno ;
    double cgpa ;

    public Student(String name, String regno, double cgpa) {
        this.name = name;
        this.regno = regno;
        this.cgpa = cgpa;
    }

    void displayinfo(){
        System.out.println("Student name is = "+ name );
        System.out.println("\n");
        System.out.println("Student reg no is = " + regno);
        System.out.println("\n");
        System.out.println("Studen cgpa is = "+ cgpa);
    }


}
