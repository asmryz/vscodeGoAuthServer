public class BankAccount {
    int accountNumber;
    double balance;

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

      void deposit(int amount){
        balance=balance+amount;

    }
    void withdraw(int amount){
        if(balance > amount)
        balance=balance-amount;
        else{
            System.out.println("insufficient balance");
        }

    }

    }

