
public class Course {

    public String[] courseName = {"OOP" ,"ICS" , "DLD" , "FOP", "Stats"};
    public String[] courseCode = {"CS234" ,"CS543" , "CS220" , "CS2201", "CS123"};



   void displayCourseDetails(){
        for(int i = 0; i < courseName.length; i++){
            System.out.println("Course Name: " + courseName[i] + " & Course Code: "+ courseCode[i]);
        }
   }

}
