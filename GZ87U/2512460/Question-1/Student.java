public class Student {

        String Studentname;
        int regID;
        double CGPA;
        public Student(){

        }

        public Student(String studentname, int regID, double CGPA) {
            Studentname = studentname;
            this.regID = regID;
            this.CGPA = CGPA;
        }
        void displaydetails() {
            System.out.println("Student name: " +Studentname);
            System.out.println("Student REGID: " +regID);
            System.out.println("Student Cgpa: " +CGPA);
        }
    }
