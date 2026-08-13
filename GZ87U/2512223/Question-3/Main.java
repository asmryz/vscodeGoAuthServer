public class Main {


  public static void main(String[] args) {

        AirConditioner ac1 = new AirConditioner(false, 30);
        System.out.println("first test 1 - ac off, high remp:");
        ac1.operate();
        AirConditioner ac2 = new AirConditioner(true, 32);
        System.out.println("\nsecond test 2 - ac on, high temp:");
        ac2.operate();
        AirConditioner ac3 = new AirConditioner(true, 22);
        System.out.println("\nthird test 3 - ac on, normal temp:");
        ac3.operate();
        AirConditioner ac4 = new AirConditioner(true, 25);
        System.out.println("\nfourth test 4 - ac on, limit temp:");
        ac4.operate();
    }
}
