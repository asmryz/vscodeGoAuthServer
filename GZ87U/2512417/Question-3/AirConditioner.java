public class AirConditioner {
    boolean isOn;
    int temperature;

    AirConditioner(boolean isOn,int temperature){
        this.isOn=isOn;
        this.temperature=temperature;

    }

    public void operate(){
        if (!isOn){
            System.out.println("Air conditioner is swicted off ");
        }else if(temperature>24){
            System.out.println("Air conditioner is on temperature "+temperature+"high");
        }
        else{
            System.out.println("Air conditioner remain idle"+temperature);
        }
    }


}