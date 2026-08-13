
void main() {
    Bankaccount customer1 = new BankAccount(7891,900);
    BankAccount customer2 = new BankAccount(895719 , 890 );
    customer1.withdrawal(400);
    customer2.withdrawal(1000);
    customer2.deposit(6000);
    customer2.withdrawal(1000);

}
