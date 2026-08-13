public class Main {
    public static void main(String[] args) {
      AirConditioner A1 = new AirConditioner(true,45);
      AirConditioner A2 = new AirConditioner(false,35);
      A1.operate();
      A2.operate();
    }
}