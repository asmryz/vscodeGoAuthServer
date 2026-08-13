class grade {
    private course course;
    private double marks;

    public grade(course course, double marks) {
        this.course = course;
        this.marks = marks;
    }

    public String getGradeLetter() {
        if (marks >= 90) return "A";
        else if (marks >= 80) return "B";
        else if (marks >= 70) return "C";
        else return "F";
    }

    public course getCourse() {
        return course;
    }

    public double getMarks() {
        return marks;
    }
}