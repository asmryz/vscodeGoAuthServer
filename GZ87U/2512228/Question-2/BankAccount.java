class BankAccount {
    private String accountNumber;
    private double balance;

    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public double getBalance() {
        return balance;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("deposited: $" + amount + " | new balance: $" + balance);
        } else 
            System.out.println("Invalid deposit amount!");
        }
    }
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("withdrawal failed: no balance!");
            System.out.println("requested: $" + amount + " available: $" + balance);
        } else if (amount <= 0) {
            System.out.println("invalid withdrawal amount!");
        } else {
            balance -= amount;
            System.out.println("withdrawn: $" + amount + "remaining balance: $" + balance);
        }
    }
    public static void main(String[] args) {
        BankAccount account = new BankAccount("acc2512228", 5000.00);

        System.out.println("initial Balance: $" + account.getBalance());
        System.out.println();

        account.deposit(2000.00);
        account.withdraw(1500.00);
        account.withdraw(6000.00);

        System.out.println("\nFinal Balance: $" + account.getBalance());
    }
