class Student {
    private String name;
    private String regNo;
    private double cgpa;

    public Student(String name, String regNo, double cgpa) {
        this.name = name;
        this.regNo = regNo;
        this.cgpa = cgpa;
    }

    public void displayInfo() {
        System.out.println("name " + name);
        System.out.println("reg no " + regNo);
        System.out.println("cgpa " + cgpa);
    }
}

