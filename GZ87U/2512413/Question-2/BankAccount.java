public class BankAccount {
    private String accountNumber;
    private double  balance;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
        if (balance > 1000) {
            System.out.println("Balance : "+balance);
        }else {
            System.out.println("Invalid Balnace ");
        }
    }

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;


    }
    public void depositBalance(double amount) {
        System.out.println("Deposit Balance ");
        if (balance > 100) {
            balance = balance +amount;
            System.out.println("Desposit amount :"+amount);
        }else {
            System.out.println("Invalide Deposit");
        }

    }
    public void withDraw(double amount) {
        if (balance > 1000) {
            balance = balance - amount;
            System.out.println("WithDarw Amount : "+amount);
        }else {
            System.out.println("Invalide withdarw");
        }
    }

    public void display() {
        System.out.println("Account Number :" + accountNumber);
        System.out.println("Balance : " + balance);
    }

}