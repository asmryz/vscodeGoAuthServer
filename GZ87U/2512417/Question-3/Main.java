
public class Main{
    public static void main(String[]args){
        AirConditioner ac1=new AirConditioner(false,30);
        ac1.operate();
        AirConditioner ac2=new AirConditioner(true,33);
        ac2.operate();
        System.out.println("Ac is on high temp");
        AirConditioner ac3=new AirConditioner(true,16);
        System.out.println("Ac is on normal");
        ac3.operate();



    }
}