public class Main {
    public static void main(String[] args) {
        BankAccount bank = new BankAccount();

        bank.setBalance(1000);
        bank.setAccountNumber(2525);
        System.out.println(" Current Balance: "+bank.getBalance());

        System.out.println("Account Number : "+ bank.getAccountNumber());
        bank.Withdraw(200);
        System.out.println(" balance  After withdraw: "+bank.balance);




    }
}