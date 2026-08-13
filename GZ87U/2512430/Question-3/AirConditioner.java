import java.util.Objects;

public class AirConditioner {
    boolean isON;
    String temperature;

    public  AirConditioner() {

    }

    public  AirConditioner(boolean isON, String temp) {
        this.isON = isON;
        this.temperature = temp;
    }

    public void Operate() {
        if (isON && Objects.equals(temperature, "high")) {
            System.out.println("High temperature, Cooling is ON");
        }
        else {
            System.out.println("Idle temperature, Cooling is OFF.");
        }
    }


}
