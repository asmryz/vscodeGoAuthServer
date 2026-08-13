

public class Student {

    public String studentName;
    public int studentId;
    public char studentSection;


    public Student(String studentName, int studentId, char studentSection) {
        this.studentName = studentName;
        this.studentId = studentId;
        this.studentSection = studentSection;
    }

    public void StudentInfo(){
        System.out.println("------ Student Details ------ " );
        System.out.println("Name                : " + studentName);
        System.out.println("Registration Number : " + studentId);
        System.out.println("Section             : " + studentSection);

    }
}
