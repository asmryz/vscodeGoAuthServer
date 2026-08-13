class Student {
    String name;
    int regNo;
    double cgpa;

    public Student(String name, int regNo, double cgpa) {
        this.name = name;
        this.regNo = regNo;
        this.cgpa = cgpa;
    }

    void displayInfo() {
        System.out.println("Name: " +name);
        System.out.println("ID: " + regNo);
        System.out.println("CGPA: "+ cgpa);
    }
}