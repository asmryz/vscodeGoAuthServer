 public class Main{
 public static void main(String[] args) {
        AirConditioner ac1 = new AirConditioner(false, 30);
        ac1.operate();
        AirConditioner ac2 = new AirConditioner(true, 32);
        System.out.println("AC on high temp");
        ac2.operate();
        AirConditioner ac3 = new AirConditioner(true, 22);
        System.out.println("AC is on normal");
        ac3.operate();

    }
    }