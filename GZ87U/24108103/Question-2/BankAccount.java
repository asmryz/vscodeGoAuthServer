// public class BankAccount {
//     public class BankAccount {
//     String accountHolder;
//     int accountNumber;
//     double balance;

//     BankAccount(String accountHolder, int accountNumber, double balance) {
//         this.accountHolder = accountHolder;
//         this.accountNumber = accountNumber;
//         this.balance = balance;
//     }

//     void deposit(double amount) {
//         if (amount > 0) {
//             balance += amount;
//             System.out.println("Deposited: " + amount);
//         } else {
//             System.out.println("Invalid deposit amount.");
//         }
//     }

//     void withdraw(double amount) {
//         if (amount > balance) {
//             System.out.println("Insufficient balance.");
//         } else if (amount <= 0) {
//             System.out.println("Invalid withdrawal amount.");
//         } else {
//             balance -= amount;
//             System.out.println("Withdrawn: " + amount);
//         }
//     }

//     void display() {
//         System.out.println("Account Holder: " + accountHolder);
//         System.out.println("Account Number: " + accountNumber);
//         System.out.println("Balance: " + balance);
//     }
// }
// }
class BankAccount{
    private string accountNum;
    private double balance;

BankAccount(string accountNum, double balance){

    this.accountNum = accountNum;
    this.balance = balance;

}
        public String getAccountHolder() {
            return accountHolder;
        }

        public void setAccountHolder(String accountHolder) {
            this.accountHolder = accountHolder;
        }

        public int getAccountNumber() {
            return accountNumber;
        }

        public void setAccountNumber(int accountNumber) {
            this.accountNumber = accountNumber;
        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

            void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        }
    }

    void display() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}
    

