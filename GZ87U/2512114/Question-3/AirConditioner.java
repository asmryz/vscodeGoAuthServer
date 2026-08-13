public class AirConditioner {
    Boolean isOn;
    Double temperature;
    public AirConditioner(boolean isOn , double temperature){
        this.isOn=isOn;
        this.temperature=temperature;

    }

    void operator() {
        if (isOn) {
            if (temperature > 26.0) {
                System.out.println("Ac is on and temp is high");
            }
            else  {
                System.out.println("Ac is not on and temp is low");
            }
            else {
                System.out.println("Ac is switched off");
            }
        }
        }




