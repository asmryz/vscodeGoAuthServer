
    public class Main {
        public static void main(String[] args) {
            BankAccount b = new BankAccount();

            b.setBalance(500);
            b.setAccountNumber(2525);
            System.out.println(" Current Balance: "+b.getBalance());

            System.out.println("Account Number : "+ b.getAccountNumber());
            b.Withdraw(200);
            System.out.println(" balance  After withdraw: "+b.getBalance());




        }
    }

