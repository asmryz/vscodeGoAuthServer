
public class Grade {
 double marks;
public Grade (double marks){
    this.marks = marks;
}
public String getGrade(){
    if (marks>= 85) return "A";
    else if (marks >= 70) return "B";
    else if (marks >= 50) return "C";
    else return "F";
}
public double getGradePoints(){
    if (marks>= 85) return 4.0;
    else if (marks >= 70) return 3.0;
    else if (marks >= 50) return 2.0;
    else return 0.0;

}
}
