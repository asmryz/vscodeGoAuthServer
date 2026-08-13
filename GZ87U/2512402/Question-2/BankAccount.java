public class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double initialBalance){
        this.accountNumber = accountNumber;
        if (initialBalance >= 0){
            this.balance = initialBalance;

        } else {
            this.balance = 0;
        }
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber){
        this.accountNumber = accountNumber;
    }

    public void getBalance(){
        return balance;

    }

    public void setBalance(double balance){
        if (balance > 0){
            this.balance = balance;
        }
    }

    public void deposit(double amount){
        if (amount > 0){
            balance += amount;
            System.out.println("Successfully Deposited: $" + amount);
        } else {
            System.out.println("Invalid Amount");
        }
    }

    public void withdraw(double amount){
        if (amount <= 0){
            System.out.println("Invalid Withdrawal amount");
        } else if (amount > balance){
            System.out.println("Insufficient Balance");
        } else {
            balance -= amount;
            System.out.println("Withdrawn");
        }
    }

}