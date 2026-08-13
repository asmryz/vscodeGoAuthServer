public class Bankaccount {
    int accountnumber;
    double balance;
    double withdraw;

    public int getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(int accountnumber) {
        this.accountnumber = accountnumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

 void deposit(){
    balance=balance+deposit;
 }
 void withdraw(){
    balance=balance-withdraw;
    if(withdraw>balance){
        System.out.print("Insufficient balance");
    }
 }