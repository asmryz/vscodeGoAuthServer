public class BankAccount {
    int accountNumber;
    double balance;
    double withdraw;
    double deposit;

    public BankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    void input(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;

    }

    public void deposit(int i) {
       balance+=deposit;
    }

    public void withdraw(int i) {
        balance-=withdraw;
    }
}

