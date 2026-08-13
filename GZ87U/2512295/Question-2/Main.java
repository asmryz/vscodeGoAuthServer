public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Ali", 12345, 5000);

        account.display();

        System.out.println("\n--- Deposit ---");
        account.deposit(100000);

        System.out.println("\n--- Withdrawal ---");
        account.withdraw(15000);

        System.out.println("\n--- Final Balance ---");
        account.display();
    }
}