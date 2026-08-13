import java.util.Objects;

public class AirConditioner {
    boolean isON;
    String temperature;

    public  AirConditioner(boolean isON, int i) {

    }

    public  AirConditioner(boolean isON, String temp) {
        this.isON = isON;
        this.temperature = temp;
    }

    public void Operate() {
        if (isON && Objects.equals(temperature, "high")) {
            System.out.println("High temperature, Cooling ON.");
        }
        else {
            System.out.println("Idle temperature, Cooling is OFF.");
        }
    }


    public void operater() {
    }
}