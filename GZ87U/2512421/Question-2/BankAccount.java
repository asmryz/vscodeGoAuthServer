public class BankAccount {
    private double balance;
    private int AccountNumber;




    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("Invalid balance");
        }

    }

    public int getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        AccountNumber = accountNumber;
    }

    public void  depositAmount(double amount) {
        if (amount > 0) {
            balance += amount;

        } else {
            System.out.println("Invalid deposit Amount ");
        }

    }

    public void  Withdraw(double amount){
        if (amount<balance ){
            balance =balance- amount;

        }else{
            System.out.println("invalid Withdraw amount");
        }

    }

    public double getBalance() {

        return balance;
    }

}
