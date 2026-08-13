
public class Grade {
    int marks;

    public Grade(int marks){
        this.marks = marks;
    }

    public String getLetterGrade(){
        if(marks <= 100 && marks > 91){
            System.out.println(" A ");
        } else if(marks >= 90 && marks > 81){
            System.out.println(" A- ");
        } else if(marks >= 80 && marks > 71){
            System.out.println(" B ");
        } else if(marks >= 70 && marks > 61){
            System.out.println(" C+ ");
        } else if(marks >= 60 && marks > 51){
            System.out.println(" C ");
        } else {
            System.out.println(" F ");
        }
    }

}
