public class BankAccount {

    private String accountNumber;
    private double balance = 100000 ;
    double amount = 2000;

    public String  getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
    void deposit(){
        int deposit = 10000;
        System.out.println(deposit + "amount deposited.");
    }



    void withdraw(){
        if (amount>balance){
            System.out.println("not enough balance");
        }
    }

}