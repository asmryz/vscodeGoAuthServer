class BankAccount{
    private string accountNum;
    private double balance;

BankAccount(string accountNum, double balance){

    this.accountNum = accountNum;
    this.balance = balance;

}

public string getAccountNum(){
    return accountNum;
}

public double getBalance(){
    return balance;
}

public void setAccountNum( string accountNum){
this.accountNum =  accountNum;
}

public void setBalance(double balance){
    this.balance = balance;
}
public void deposit(double amount){
    if (amount >  0){
        balance += amount;

        System.out.println("deposited: "+ amount + "new balance: "+ balance);
    }
    else{
        System.out.println("invalid amount deposited");
    }
}
}
public void withdrawal(double amount){
    if( amount > balance){
        System.out.println("withdrawal failed");
        System.out.println("requested: " +amount);
    }

} 


