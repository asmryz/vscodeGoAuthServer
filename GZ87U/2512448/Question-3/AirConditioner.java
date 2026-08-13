public class AirConditioner {

    boolean isOn = true;
    int temperature;


    public AirConditioner(boolean isOn, int temperature) {
        this.isOn = isOn;
        this.temperature = temperature;
    }
    void isOn() {
        isOn = false;
    }


    void operate() {
        if (isOn) {
            if(temperature > 0) {
                System.out.println("air conditioner started cooling:");
            }

        }
        else {
            System.out.println("Turn on the ac first:");
        }





    }
}