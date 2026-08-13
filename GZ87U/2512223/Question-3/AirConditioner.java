class AirConditioner {
    boolean isOn;
    int temperature;


    AirConditioner(boolean isOn, int temperature) {
        this.isOn = isOn;
        this.temperature = temperature;
    }
    void operate() {
        if (!isOn) {
            System.out.println("air conditioner is switched off");
        } else if (temperature > 25) {
            System.out.println("air conditioner is on, the Temperature: " + temperature +
                    "°C (high)");
        } else {
            System.out.println("air conditioner is on, temperature: " + temperature +
                    "°C (normal temp), on idle no use");
        }
    }
   
}
