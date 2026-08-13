public class BankAccount {
    String accNumber;
    int balance;

    public BankAccount(String accNumber, int balance) {
        this.accNumber = accNumber;
        this.balance = balance;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void deposit(int amount){
        setBalance(this.balance+amount);
    }
    public void withdraw(int amount){
        if(getBalance()<amount){
            System.out.println("Not enough funds");
        }
        else {
            setBalance(this.balance - amount);
        }

    }
}