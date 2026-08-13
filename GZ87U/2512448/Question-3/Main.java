public class Main {
    public static void main(String[] args) {

        AirConditioner AC1 = new AirConditioner(true, 16);
        AirConditioner Ac2 = new AirConditioner(false,0);
        AirConditioner Ac3 = new AirConditioner(true,22);

        Ac1.operate();
        Ac2.operate();
        Ac3.operate();

        

        

    }
}