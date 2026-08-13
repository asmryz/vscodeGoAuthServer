public class BankAccount {
private String accountNumber;
private double balance;

public BankAccount(String accountNumber, double balance){
    this.accountNumber = accountNumber;
    this.balance = balance;
}
public String getAccountNumber() { return accountNumber; }
public void setAccountNumber(String accountNumber) {this.accountNumber = accountNumber; }

public double getBalance() { return balance; }
public void setBalance(double balance) {this.balance = balance; }

public void deposit(double amount) {
    if (amount > 0) {
        balance += amount;
        System.out.println("Deposited: Rs. " + amount);
        } else {
            System.out.println("insufficient amount");
        }
}
public void withdraw(double amount){
    if (amount > balance){
        System.out.println("Withdrawn: Rs. " + amount);
        else if (amount > 0){
            balance -= amount;
            System.out.println("Withdrwan");
            else{
                System.out.println("Invalid amount");
            }
        }
    }
}
}