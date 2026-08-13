public class AirConditioner {
    public boolean ison;
    public int Temperature;

    public AirConditioner(boolean ison, int temperature) {
        this.ison = ison;
        this.Temperature = temperature;
    }

    public void operate() {
        if (ison) {
            if (Temperature > 25) {
                System.out.println("AC is ON and temperature is high   " + Temperature);
            } else if {
                System.out.println("AC is on but temperature is low " + Temperature);
            }
            else{
                System.out.println("Ac is off");
            }

            }
    
        
    }
}
