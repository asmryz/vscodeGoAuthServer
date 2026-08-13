public class BankAccount
{
    int BankAccount;
    int accountNumber;
    int withdraw;
    int deposit;

    void deposite()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Bankaccount: ");
        BankAccount= sc.nextLine();

        System.out.print("Enter accountNumber: ");
        accountNumber= sc.nextLine();

        System.out.print("Enter withdraw amount: ");
        withdraw= sc.nextLine();

        System.out.print("Enter deposit ammount: ");
        deposit= sc.nextLine();


    }

    void display()
    {
        System.out.println("\naccountnumber : " + accountNumber);

    }
}