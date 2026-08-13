public class Main {
    public static void main(String[] args) {
        AirConditioner ac1 = new AirConditioner(true, 28);
        AirConditioner ac2 = new AirConditioner(false, 30);
        AirConditioner ac3 = new AirConditioner(true, 20);
    ac1.operate();
    ac2.operate();
    ac3.operate();
    
    }
}