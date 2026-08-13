public class Grade {

    int marks;

    public Grade(int marks) {
        this.marks = marks;
    }

    public void getMarks() {
        if (marks > 80) {
            System.out.println("A");
        } else if (marks > 70){
            System.out.println("B");
        }
        else if (marks > 60) {
            System.out.println("C");
        }
        else if (marks < 50) {
            System.out.println("F");
        }
    }
}