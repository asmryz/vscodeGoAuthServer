public class Main {
    public static void main(String[] args) {
        public class BankAccount {

            public BankAccount(BankAccount account) {
                this.account = account;
            }

            public BankAccount(deposit) {
                this.deposit = deposit;
            }

            public BankAccount(withdraw) {
                this.withdraw = withdraw;
            }

            public BankAccount(balance) {
                this.balance = balance;
            }
            BankAccount account = new BankAccount("ACC-1001", 5000);
        System.out.println("Initial Balance: " + account.getBalance());
        account.deposit(2000);
        System.out.println("After Deposit: " + account.getBalance());
        account.withdraw(3000);
        System.out.println("After Withdrawal: " + account.getBalance());
        account.withdraw(10000);
    }
}

    <deposit>void(deposit) {
        System.out.println("Initial Balance: " + account.getdeposit());
        .getdeposit();
    }

    <withdraw>void(withdraw) {
        if(balance>3000){
            system.out.println("insufficient balance")}
        else(){
        System.out.println("Initial Balance: " + account.getwithdraw());
        .getwithdraw();
    }

    <balance>void(balance) {
        System.out.println("Initial Balance: " + account.getBalance());
        .getbalance();
    }


    }
}