public class Main {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("acc000111", 5000);
        acc.deposit(2000);
        acc.withdraw(3000);
        acc.withdraw(10000);
    }
}