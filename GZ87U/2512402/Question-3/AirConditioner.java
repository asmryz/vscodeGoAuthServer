public class AirConditioner {
    boolean isOn;
    int temperature;

    public AirConditioner(boolean isOn, int temperature){
        this.isOn = isOn;
        this.temperature = temperature;
    }

    public void operate(){
        if (isOn){
            if (temperature >= 24){
                System.out.println("AC on and Room Temp high");
            } else {
                System.out.println("AC on but Room Temp Norm");
            }
        } else {
            System.out.println("AC is off");
        }
        
    }
}