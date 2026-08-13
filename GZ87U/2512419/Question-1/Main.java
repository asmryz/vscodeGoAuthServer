public class Main {
    public static void main(String[] args) {
        Student student = new Student("Vishwas", 3"Computer Science");

        student.displayDetails();
    }
    public class Student {
        String name;
        int cgpa;
        String department;

        Student(String name, int cgpa, String department) {
            this.name = name;
            this.cgpa = cgpa;
            this.department = department;
        }

        void displayDetails() {
            System.out.println("Name: " + name);
            System.out.println("CGPA: " + cgpa);
            System.out.println("Department: " + department);
        }
    }
    public static void main(String[] args) {
        Student student = new Student("Vishwas", 3, "Computer Science");

        student.displayDetails();
    }
}
