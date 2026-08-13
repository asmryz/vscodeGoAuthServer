public class Main {
    public static void main(String[] args) {
        AirConditioner ac1 = new AirConditioner(false, 30);
        System.out.println("First test 1-ac off,high temp");
         ac1.operate();
        AirConditioner ac2 = new AirConditioner(true, 22);
        System.out.println("Second test 2-ac off,high temp");
        ac2.operate();
        AirConditioner ac3 = new AirConditioner(true, 22);
        System.out.println("Second test 3-ac off,high temp");
        ac3.operate();
        AirConditioner ac4 = new AirConditioner(true, 25);
        System.out.println("Second test 4-ac off,high temp");
        ac4.operate();
    }
}