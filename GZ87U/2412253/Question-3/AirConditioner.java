class AirConditioner {
    private boolean ison;
    private int temperature;

    public AirConditioner(boolean ison, int temperature) {
        this.ison = ison;
        this.temperature = temperature;
    }

    public void operate() {
        if (ison) {
            if (temperature > 25) {
                System.out.println("ac is on temperature is high " + temperature );
            } else {
                System.out.println("ac is on but temperature is" + temperature );
            }
        } else {
            System.out.println("ac is off.");
        }
    }
}