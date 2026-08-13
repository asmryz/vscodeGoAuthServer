public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        account.setAccountNumber("111-222-555-908");
        account.setBalance(1700);
        account.deposit(500);
        account.withdraw(350);
        account.deposit(100);
        account.withdraw(600);
    }
}