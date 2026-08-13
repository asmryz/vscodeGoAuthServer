class AirConditioner {
    private boolean isOn;
    private int temperature;

    public AirConditioner(boolean isOn, int temperature) {
        this.isOn = isOn;
        this.temperature = temperature;
    }

    public void operate() {
        if (isOn) {
            if (temperature > 25) {
                System.out.println("ac is on Temperature is high " + temperature );
            } else {
                System.out.println("ac is on but temperature " + temperature );
            }
        } else {
            System.out.println("ac is off.");
        }
    }
}