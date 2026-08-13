  public class student {
    
    String name ;
    int regNo;
    int cgpa;

    
    student(String name, int regNo, int cgpa) {
        this.name = name;
        this.regNo = regNo;
        this.cgpa=cgpa;
    }

    void display() {
        System.out.println("name:"+name);
        System.out.println("regNo: " + regNo);
        System.out.println("cgpa:"+cgpa);

    }
}

