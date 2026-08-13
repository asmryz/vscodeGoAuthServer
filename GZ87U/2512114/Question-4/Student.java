public class Student {
Grade [] grade = new Grade [5];
int count=0;
public void addGrade (Grade g){
    if (count <5){
        grade [count++]=g;
    }
}
   public void calculateSgpa(){
    double sum=0;
    for (int i=0;i<count ;i++){
        sum +=grade[i].getGradePoint();
    }
    double sgpa = count >0 ? sum/count : 0.0;
    System.out.println("Semetester gpa "+sgpa);
   
   }
   public static void main (String[] args){
    Student s = new Student();
    s.addGrade(new Grade (88));
    s.addGrade(new Grade (75));
    s.addGrade(new Grade (60));
    s.calculateSgpa();;
   }
}