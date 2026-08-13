class AirConditioner {
   boolean turnOn;
   int temperature;

    public AirConditioner(boolean turnOn, int temperature) {
        this.turnOn = turnOn;
        this.temperature = temperature;
    }

    void operate() {
        if (!turnOn) {
            System.out.println("Turn on your AC!");
            return;
        }

        if (turnOn && temperature < 24) {
            System.out.println("Cool Mode!");
        }
        else {
            System.out.println("Idle Mode!");
        }
    }
}