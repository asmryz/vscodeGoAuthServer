package Question2;

public class BankAccount {

        public int accNumber;
        public double balance;


    public void setAccNumber(int accNumber) {
        this.accNumber = accNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public  BankAccount(int accNumber, double balance){

            this.accNumber = accNumber;
            this.balance = balance;
        }

    public int getAccNumber() {
        return accNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double depositAmount){

            balance += depositAmount;
            System.out.println("Deposit Successfully! Your Current Amount: " + balance );

        }

        public void withdrawAmount(double withdrawAmount){

        if(withdrawAmount < balance) {
            balance -= withdrawAmount;
            System.out.println("Withdraw Successfully! Your Current Amount: " + balance);
        }else{

                System.out.println("Insufficient Balance." );

            }
        }


}
