public class AirConditioner {
    boolean isOn;
    String temperature;


    public AirConditioner(){
        this.isOn = false;
        this.temperature = "Low";
    }

    public AirConditioner(boolean isOn, String temperature) {
        this.isOn = isOn;
        this.temperature = temperature;
    }


    public boolean getisOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public void operate(){
        if(!getisOn()){
            System.out.println("System is off! Please Turn on.");
        }
        else{
            if(getTemperature() == "Low"){
                setTemperature("High");
                System.out.println("System has started cooling!");
            }
            else {
                System.out.println("Sufficient Temperature! Will Idle.");
            }
        }
    }
}