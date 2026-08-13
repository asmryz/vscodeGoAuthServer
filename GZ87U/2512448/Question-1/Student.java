public class Student {
   public String name;
    public int RegId;
    public int cgpa;

    Student(String name,int RegId,int cgpa){
        this.name=name;
        this.RegId=RegId;
        this.cgpa=cgpa;

    }

   public void displayDetails(){
        System.out.printf("Name: "+name);
        System.out.printf("RegNo: "+RegId);
        System.out.printf("cgpa: "+cgpa);

    }

}