public class Main {

    static void main(String[] args) {

        BankAccount  account = new BankAccount(50000, 5000);
        System.out.println("Initial Balance: " + account.getBalance());
        account.deposit(5000);
        account.withdrawAmount(30000);
    }
}
