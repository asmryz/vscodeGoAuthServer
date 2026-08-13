public class Grade {
    int marks;
    String grade;

    public Grade() {

    }

    public Grade(int mrks, String grd) {
        this.marks = mrks;
        this.grade = grd;
    }

    public void determineGrade() {
        if (marks >= 90) {
            grade = "A";
        }
        else if (marks >= 80) {
            grade = "B";
        }
        else if (marks >= 70) {
            grade = "C";
        }
        else if (marks >= 60) {
            grade = "D";
        }
        else if (marks >= 50) {
            grade = "E";
        }
        else {
            System.out.println("Fail.");
        }
    }


}
