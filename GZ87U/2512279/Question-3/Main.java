
public class Main {
    public static void main(String[] args) {
        AirConditioner ac1 = new AirConditioner(false, 20);
        AirConditioner ac2 = new AirConditioner(true, 26);
        AirConditioner ac3 = new AirConditioner(true, 18);
ac1.operate();
ac2.operate();
ac3.operate();

    }
}
