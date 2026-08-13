public class Main {
    public static void main(String[] args) {


        AirConditioner ac4 = new AirConditioner(true,"28");
        AirConditioner ac2 = new AirConditioner(false,"18");

        ac4.Operate();
        ac2.Operate();
        

    }
}