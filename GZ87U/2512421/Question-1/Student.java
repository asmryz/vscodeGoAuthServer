public class Student {
    String name ;
    double gpa ;
    int RegNo;

    public Student(String name, double gpa, int regNo) {
        this.name = name;
        this.gpa = gpa;
          this.RegNo = regNo;
    }

    public void displayInfo(){
        System.out.println("Name : "+name +
                " ,Cgpa :  "+gpa +
                " ,RegNo : "+RegNo);
    }

   
}

