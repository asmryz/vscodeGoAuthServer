public class BankAccount {
    public static void main(String[] args) {
        private int accountNumber,balance,amount=10000;
        
        deposit(amount){
            if(amount<10000){
                System.out.println("Amount deposit succesfully");
            }
        }

        withdraw(amount){
            if(amount>10000){
                System.out.println("Amount exceeds");
                else{
                    System.out.println("Amount succesfully withrawed");
                }
            }
        }
    }
}
