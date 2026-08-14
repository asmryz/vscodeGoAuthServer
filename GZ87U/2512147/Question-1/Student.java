public class Student {
    String name;
    int regNo;
    float cgpa;

    public Student(String name, int regNo, float cgpa) {
        this.name = "Ismail";
        this.regNo = 2512136;
        this.cgpa = (float) 3.95;

    }

    String displayInfo() {
        return "Student [name=" + name + ", regNo=" + regNo + ", cgpa=" + cgpa + "]";
    }
}
