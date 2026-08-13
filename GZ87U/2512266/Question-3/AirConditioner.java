public class AirConditioner {
    boolean isOn;
    int temperature;
    public AirConditioner(boolean isOn, int temperature){
        this.isOn = isOn;
        this.temperature = temperature;
    }

    public void operate(){
        if (isOn==1){
            if (temperature >= 20){
                System.out.println("AC is on and Room Tempratuer high");
            } else {
                System.out.println("AC is on but Room Temperatuer Normal");
            }
        } else {
            System.out.println("AC is OFF");
        }
        
    }
}