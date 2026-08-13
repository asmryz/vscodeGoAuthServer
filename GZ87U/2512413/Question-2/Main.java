public class Main {
    public static void main(String[] args) {

    BankAccount account = new BankAccount("Abc11",50000);
   System.out.println("Initial Balance : "+account.getBalance());
   account.depositBalance(5000);
   System.out.println("After Deposit : "+account.getBalance());
   account.withDraw(2000);
   System.out.println("WithDraw : "+account.getBalance());
   account.depositBalance(10000);
   account.display();

    }

}