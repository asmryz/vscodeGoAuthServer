public class BankAccount{
    private String accountNumber;
    private double balance;

    public BankAccount() {

    }

    public BankAccount(String accNum, double bal) {
        this.accountNumber = accNum;
        this.balance = bal;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return  balance;
    }

    public void setAccountNumber(String accNum) {
        this.accountNumber = accNum;
    }

    public void setBalance(double bal) {
        this.balance = bal;

    }

    public void deposit(double depositamount) {
        if (depositamount > 0) {
            balance += depositamount;
            System.out.println("Your amount is deposited to the bank account! New balance: " + balance);
        }
    }

    public void withdraw(double withdraw) {
        if (withdraw > balance) {
            System.out.println("Withdrawal amount is more than balance! Withdrawal Failed!");
        }
        else {
            balance -= withdraw;
            System.out.println("Amount withdrew! Remaining balance is: " + balance);

        }
    }
}
