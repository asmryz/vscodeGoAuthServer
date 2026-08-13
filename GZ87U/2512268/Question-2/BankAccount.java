public class BankAccount {

        int accountNumber;
        double balance;

        BankAccount( int accountNumber, double balance) {

            this.accountNumber = accountNumber;
            this.balance = balance;
        }
        public String getAccountNumber() {
            return accountNumber;
        }
        public void setAccountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
        }
        public double getBalance() {
            return balance;
        }

    public void setBalance(double balance) {
        this.balance = balance;
    }

   public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Deposited: " + amount + " new balance"+ balance);
            }
        }

        public void withdraw(double amount) {
            if (amount > balance) {
                System.out.println("Insufficient balance.");
            } else {
                balance -= amount;
                System.out.println("Withdrawn: " + amount + "new balance"+ balance);
            }
        }


        void display() {
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Balance: " + balance);
        }
    }

