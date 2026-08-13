public class Main {
    public static void main(String[] args) {

               AirConditioner a1 = new AirConditioner();
        AirConditioner a2 = new AirConditioner();


        a1.isON = false;
        a1.temperature = "low";

        a2.isON = true;
        a2.temperature = "high";

        a1.Operate();
        System.out.println(" ");
        a2.Operate();

    }
}