public class Main {
    public static void main(String[] args) {
        AirConditioner ac1 = new AirConditioner(true, 26);
        AirConditioner ac2 = new AirConditioner(false, 23);

        ac1.operate();
        ac2.operate();
    }
}