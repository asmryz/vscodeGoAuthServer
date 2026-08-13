class Grade{
    private Course course;
    private double marks;

    public Grade(course course,double marks){
        this.course = course;
        this.marks = marks;

    }
    public (string getGradeletter()){
        if (marks>=90)return "A";
        if (marks>= 80)return "B";
        if (marks>= 70)return "C";
        else return "F";

    }
    public course getcourse(){
        return course;
    
    }

    public double getmarks(){
        return marks;
    }
}
