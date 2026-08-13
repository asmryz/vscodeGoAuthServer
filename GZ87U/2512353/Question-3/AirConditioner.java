public class AirConditioner {
boolean isOn;
double temperature;

public AirConditioner(boolean isOn, double temperature){
    this.isOn = isOn;
    this.temperature = temperature;
}
public void operate(){
    if (isOn) {
        if (temperature > 25.0){
            System.out.println("air conditioner is ON. High temperature (" + temperature + "C).cooling started");
        } else {
            System.out.println("air conditioner is ON. Normal temperaqture(" + temperature + C);
        }
        else {
            System.out.println("air conditioner is off");
        }
    }
}
}