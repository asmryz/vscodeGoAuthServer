class Student {

    String name;
    String regNo;
    double cgpa;

    Student(String name, String regNo, double cgpa) {
        this.name = name;
        this.regNo = regNo;
        this.cgpa = cgpa;
    }
    void displayInfo() {
        System.out.println("name: " + name);
        System.out.println("regno: " + regNo);
        System.out.println("cgpa: " + cgpa);
    }
    public static void main(String[] args) {
        Student student1 = new Student("ahmed", "27582228", 3.72);
        Student student2 = new Student("ali", "296421", 2.94 );
        System.out.println("student 1 detail");
        student1.displayInfo();
        System.out.println("\nstudent 2 detail");
        student2.displayInfo();
    }
}