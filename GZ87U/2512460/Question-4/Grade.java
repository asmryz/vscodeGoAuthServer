class Grade {
     int Marks;

    public Grade(int marks) {
        Marks = marks;
    }

    public int getGrade() {
        if (Marks <= 100 && Marks >= 90) {
            System.out.println("A1");
        } else if (Marks <= 90 && Marks >= 80) {
            System.out.println("A");
        } else if (Marks <= 70 && Marks >= 60) {
            System.out.println("B");
        } else if (Marks <= 60 && Marks > 50) {
            System.out.println("C");
        } else {
            System.out.println("Fail");
        }
    }
}