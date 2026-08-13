public class BankAccount {
    public BankAccount() {
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount("ACC-1001", 5000);
        String BankAccount;
        int accountNumber;
        int balance;
        int deposit;
        int withdraw;

        public static void BankAccount (String BankAccount,int balance,int deposit,int withdraw) {
            this.BankAccount;
            this.balance;
            this.deposit;
            this.withdraw;
        }

        if (withdraw>deposit){
            System.out.println("INSUFFICIENT BALANCE!");
        } else {
            System.out.println("WITHDRAW SUCCESSFUL!");
        }

            System.out.println("Initial Balance: " + account.getBalance());
        account.deposit(2000);
        System.out.println("After Deposit: " + account.getBalance());
        account.withdraw(3000);
        System.out.println("After Withdrawal: " + account.getBalance());
        account.withdraw(10000);

    }
        }