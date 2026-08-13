public  class AirConditioner {
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
                System.out.println("ac will start cooling as it is high .");
            } else if (temperature < 25 ){
                System.out.println("ac is on but temperature is" + temperature + "so it is idle as the temp is not high  " );

            }
        } else {
            System.out.println(" ac is off and is not cooling at the moment ");
        }
    }
}