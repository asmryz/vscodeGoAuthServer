class Student {
    private String name;
    private String regNo;
    private Grade[] grades = new String[5];
    private int courseCount;

    public Student(String name, String regNo) {
        this.name = name;
        this.regNo = regNo;
        this.grades = new Grade[5];
        this.courseCount = 0;
    }

    public void registerCourse(grade g) {
        if (courseCount < 5) {
            grades[courseCount] = g;
            courseCount++;
        } else {
            System.out.println("cannot register more than 5 courses.");
        }
    }

}