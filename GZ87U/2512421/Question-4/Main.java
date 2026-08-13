public class Main {
    public static void main(String[] args) {
        Course c = new Course("OOp , Fop , English , Math , Physics");
        Student s1 = new Student("OOP , Math , phy, English, Fop","B+ , A , A+ , A+ , B","Majid");
        Grade g = new Grade("B+ , A , A+ , A+ , B");


        System.out.println("Name: "+ s1.name);
        System.out.println("Courses: "+c.Courses);
        System.out.println("grade: "+ g.grade);


    }
}
