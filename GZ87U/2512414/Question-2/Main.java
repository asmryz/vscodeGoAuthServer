public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("ACC-1001", 5000);
        System.out.println("Initial Balance: " + account.getBalance());
        account.deposit(2000);
        System.out.println("After Deposit: " + account.getBalance());
        account.withdraw(3000);
        System.out.println("After Withdrawal: " + account.getBalance());
        account.withdraw(10000);
    }
}
