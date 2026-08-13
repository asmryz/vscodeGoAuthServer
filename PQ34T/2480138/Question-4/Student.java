public class Student {
    public String name = "Ali";
    private double cgpa = 3.5;
    protected String department = "Computer Science";
    String regNo = "BSCS-001";

    public void displayCGPA() {
        System.out.println("CGPA: " + cgpa);
    }
}