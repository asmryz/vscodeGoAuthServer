//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    bankaccount customer1 = new bankaccount(7891,900);
    bankaccount customer2 = new bankaccount(895719 , 890 );
    customer1.withdrawal(400);
    customer2.withdrawal(1000);
    customer2.deposit(6000);
    customer2.withdrawal(1000);

}
