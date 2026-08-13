public class Main {

    public static void main(String[] args) {
        BankAccount  account = new BankAccount(2345678, 5000);
        System.out.println("Initial Balance: " + account.getBalance());
        account.deposit(6000);
        account.withdrawAmount(20000);
    }
}
