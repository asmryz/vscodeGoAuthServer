public class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public String getAccountNumber(){
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber){
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
    public void deposit(double amount){
        if(amount>0){
            balance += amount;
            System.out.println("successfully deposited: $" + amount);
        }else {
            System.out.println("invalid deposit amount");
        }
    }public void withdraw (double amount){
        if (amount > 0 && amount <= balance){
            balance -= amount;
            System.out.println("successfully withdrew: $" + amount);
        }else if (amount > balance){
            System.out.println("error insufficient funds");
        }else{
            System.out.println("invalid withdrawal amount");
        }
    }
}
