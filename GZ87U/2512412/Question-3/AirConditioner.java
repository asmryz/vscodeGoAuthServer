public class AirConditioner {
    boolean isOn;
    int temperature;

    AirConditioner(boolean isOn, int temperature){
        this.isOn = isOn;
        this.temperature = temperature;
    }
    void operate(){
        if(!isOn){
            System.out.println("Air Conditioner is Switched Off.");
        } else if(temperature>25) {
            System.out.println("AC is on the temp :"+ temperature+ "C (high)");

        } else{
            System.out.println("Ac is on temp: "+ temperature+ "C (Normal)");
        }
    }
}