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
        System.out.println("requested: " +amount + "available" +balance);
    }
    else if(amount<= 0){
        System.out.println("invalid withdrawal amount");

    }
    else{ 
        balance-= amount; 
        System.out.println("withdrawal" +amount + "remaining balance" +balance);
    }

}
 public static void main(String[] args){
    BankAccount = new BankAccount(accountNum: "2638v21", balance 2300);

     System.out.println("initial balance" + account.getBalance());
      System.out.println();


      account.deposit(3400);
      account.withdrawal(300);
        account.withdrawal(500);

        System.out.println("final balance: "+account + account.getBalance());
     
 }



