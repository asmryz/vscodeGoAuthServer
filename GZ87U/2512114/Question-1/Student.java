public class Student {
    String name;
    String RegNo;
    double cgpa;
    public Student(String name , String regNo , double cgpa) {


        this.name = name;
        this.RegNo = regNo;
        this.cgpa = cgpa;

    }
    void displayInfo(){
        System.out.println("Name"+name+ "regNo"+RegNo+ "cgpa"+cgpa);}

}
