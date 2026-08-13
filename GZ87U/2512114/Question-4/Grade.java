
public class Grade {
double marks;
public Grade (double marks){
    this.marks=marks;
}
public double getGradePoint(){
    if (marks >=85)return 4.0;
    if (marks >=70)return 3.0;
    if (marks >=50)return 2.0;
    return 0.0;
}
}