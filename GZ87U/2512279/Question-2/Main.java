public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("ACC-1001", 5000);
        account.withdraw(6700);
        account.deposit(10000);
        account.getBalance();
    }
}