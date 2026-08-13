public class AirConditioner {
    boolean isOn;
    int temperature;

    public AirConditioner(boolean isOn, int temperature ){
        this.isOn = isOn;
        this.temperature = temperature;
    }
    public void operate(){
        if (isOn && temperature > 25){
            System.out.println("Air conditioner started cooling. ");
        }else{
            System.out.println("Air conditioner is remaining idle. ");
        }
    }
}