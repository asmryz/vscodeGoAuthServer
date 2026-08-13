class student {
    private String name;
    private String regNo;
    private grade[] grades;
    private int courseCount;

    public student(String name, String regNo) {
        this.name = name;
        this.regNo = regNo;
        this.grades = new grade[5];
        this.courseCount = 0;
    }

    public void registerCourse(grade g) {
        if (courseCount < 5) {
            grades[courseCount] = g;
            courseCount++;
        } else {
            System.out.println("Cannot register more than 5 courses.");
        }
    }
}