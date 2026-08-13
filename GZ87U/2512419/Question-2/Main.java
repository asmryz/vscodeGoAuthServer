public class Main {
    public static void main(String[] args) {
        BankAccount b1=new BankAccount("120",20000);
        b1.setAccountNumber(b1.getAccountNumber());
        b1.setBalance(b1.getBalance());
        b1.deposit(b1.getBalance());
        b1.withdraw(b1.getBalance());


    }
}