public class BankAccount {
    int accountNumber;
    Double balance;
    double withdraw;
    double deposit;


    public BankAccount(int accountNumber, double balance){
        this.accountNumber=accountNumber;
        this.balance=balance;


    }
    
    public int getAccountNumber(){
        return accountNumber;
        
        
        
    }
    public void setAccountNumber(int accountNumber){
        this.accountNumber=accountNumber;
    }
    public double getAccountNumber(){
        return accountNumber;
    }
    public void setAccountNumber(double balance){
        this.balance=balance;
    }
   
    
    void input(int accountNumber, double balance){
        this.accountNumber=accountNumber;
        this.balance=balance;
    }
    public void deposit(int i){
        balance+=deposit;
    }
    public void withdraw(int i){
        balance+=withdraw;
    }
}