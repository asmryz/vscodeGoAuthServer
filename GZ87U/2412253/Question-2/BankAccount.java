public class    BankAccount {

    private int accountnumber;
    private double balance ;

    public BankAccount(int accountnumber, double balance) {
        this.accountnumber = accountnumber;
        this.balance = balance;
    }

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

    void withdrawal (double amount ) {
        if ( balance >= amount ) {
            balance = balance - amount ;
            System.out.println(amount+" has been taken out  from ur acc ");
            System.out.println("Your new balance is = "+balance );
        }
        else {
            System.out.println(" insufficient balance right here for acc owner " );

        }

    }
    void deposit (double amount ) {
        balance+= amount;
        System.out.println(amount+" has been deposited in ur acc ");

    }

}
