public class Student {
    String name;
    int reg;
    double gpa;

    Student(String n, int r, double g){

        name = n;
        reg = r;
        gpa = g;
    }
    void displayinfo(){
        System.out.println("Name:"+name);
        System.out.println("RegID:"+reg);
        System.out.println("Gpa:"+gpa);
    }


}





