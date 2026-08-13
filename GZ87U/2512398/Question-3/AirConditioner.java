

public class AirConditioner {


    boolean on;
    int temperature;

    public AirConditioner(boolean on, int temperature) {
        this.on = on;
        this.temperature = temperature;
    }

    public void operator(){
        if(on && temperature > 23){
            System.out.println("Air Conditioner Starting Cooling at temperature: " + temperature);
        }else{
            System.out.println("Air Conditioner is idle at temperature: " + temperature);
        }
    }

}
