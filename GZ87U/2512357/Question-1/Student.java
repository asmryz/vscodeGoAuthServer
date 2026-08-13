


class Student
{
    String name;
    String regno;
    String cgpa;

    void input()
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student Name: ");
        name = sc.nextLine();

        System.out.print("Regno: ");
        regno = sc.nextLine();

        System.out.print("cgpa: ");
        cgpa = sc.nextLine();

    }

    void display()
    {
        System.out.println("\nStudent Name : " + name);
        System.out.println("Regno  : " + regno);
        System.out.println("cgpa   : " + cgpa);

    }
}
