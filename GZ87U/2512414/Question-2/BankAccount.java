public class BankAccount {
    private String accountNumber;
    private double balance;

    BankAccount(String n, double b){
        accountNumber=n;
        balance=b;
    }

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
    }

    void deposit(double deposit){
        balance= balance + deposit;
    }

    void withdraw(double amount){
        if(amount < balance){
            balance = balance - amount;

        }

        else {
            System.out.println("Not Enough Balance");
        }
    }

}
