public class Student {
    String name;
    Course[] courses = new Course[5];
    Grade[] grades = new Grade[5];
    int courseCount = 0;

public Student(String name){
    this.name =  name;
}

public void registerCourse(Course course, Grade grade){
    if (courseCount< 5){
        courses[courseCount]=course;
        grades[gradeCount]=grade;
        courseCount++;
    }else{
        System.out,println("Cannot register more than 5 courses.");
    }
}

public double calculateSGPA(){
    if (courseCount == 0) return 0.0;

    double totalPoints = 0;
    for (int i = 0; i < courseCount; i++){
        totalPoints += grades[i].getGradePoints();
    }
    return totalPoints/ courseCount;
}

}