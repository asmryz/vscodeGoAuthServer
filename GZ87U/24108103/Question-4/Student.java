public class Student {
    String name;
    int regID;
    String course;
    float cgpa;
 public stu(){

 }

    public Stu(String name, int regID, String course, float cgpa) {
        this.name = name;
        this.regID = regID;
        this.course = course;
        this.cgpa = cgpa;
    }

    void courserigister(){
        System.out.println("name " +name);
        System.out.println("regID" +regID);
        System.out.println("cgpa" +cgpa);
        System.out.println("course" +course);
}
}