class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
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
            System.out.println("Amount deposited!");
        }
        balance += amount;
    }
    
    void withdraw(double amount) {
        if ( amount > balance) {
            System.out.println("Insufficient Balance!");
        }
        else {
            System.out.println("Amount Deposited!");
        }
        balance -= amount; }
    }