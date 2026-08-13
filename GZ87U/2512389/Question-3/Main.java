public class Main {
    public static void main(String[] args) {
        AirConditioner ac1 = new AirConditioner(true,"Low");
        AirConditioner ac2 = new AirConditioner(true,"High");
        AirConditioner ac3 = new AirConditioner();

        ac1.operate();
        ac2.operate();
        ac3.operate();
    }
}