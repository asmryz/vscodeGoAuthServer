public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Muzammil Rathore", 998432, 5000);

        account.display();

        System.out.println("\n--- Deposit ---");
        account.deposit(2000);

        System.out.println("\n--- Withdrawal ---");
        account.withdraw(1500);

        System.out.println("\n--- Final Balance ---");
        account.display();
    }
}