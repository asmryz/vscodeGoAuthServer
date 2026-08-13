
public class Grade {
    private String course;
    private double marks;

    public Grade(String course,double marks){
        this.course=course;
        this.marks=marks;

    }
    public String getGradeLetter(){
        if(marls>=90)return"A";
        else if (marks>=80)return"B";
        else if (marks>=70)return"C";
        else return "F";


    }
    public Course getCourse(){
        return course;

    }
    public double getMarks(){
        return marks;
    }

}
