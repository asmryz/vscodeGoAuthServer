public class Student {
    public Student() {
    }

    public static void main(String[] args) {
       Student student = new Student("Yusra", 2512420, 3);
      public String name;
      public int regNo;
      public double cgpa;

       public Student(String name,int regNo,double cgpa){

            this.name = name;
            this.regNo = regNo;
            this.cgpa = cgpa;
        }


        System.out.println("======STUDENT INFORMATION======");
        System.out.println("Enter Student Name:    " +name);
        System.out.println("Enter Registration No: " +regNo);
        System.out.println("Enter Cgpa: " +cgpa);

       student.displayDetails();
    }

}
