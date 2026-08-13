public class Main {
    public static void main(String[] args) {
       BankAccount customer1 = new BankAccount(7891,9000);
        BankAccount customer2 = new BankAccount(895719 , 890 );
        customer1.withdraw(2300);
        customer2.withdraw(1200);
        customer2.deposit(1455);
        customer2.withdraw(6544);
    }
}