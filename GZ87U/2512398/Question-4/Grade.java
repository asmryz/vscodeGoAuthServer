

class Grade {

    public double marks;


    public Grade( double marks) {
        this.marks = marks;
    }

    public String getGradeLetter() {
        if (marks >= 450)
        {
            return "A+";
        }

        else if (marks >= 400)
        {
            return "A";
        }
        else if (marks >= 350)
        {
            return "B";
        }
        else if (marks >= 300)
        {
            return "C";
        }
        else return "F";
    }


    public double getMarks() {
        return marks;
    }
}