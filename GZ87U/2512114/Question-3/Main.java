public class Main {
    public static void main(String[] args) {
        AirConditioner ac1= new AirConditioner(true , 30.5);
        ac1.operator();
        AirConditioner ac2 = new AirConditioner(true , 22.0);
        ac2.operator();
        AirConditioner ac3 = new AirConditioner(false , 21.9);
        ac3.operator();

    }
}