 class AirConditioner {
    boolean isOn;
    int temperature;


static void main(String[] args);

    AirConditioner(boolean is On, int temperature){
        this.isOn = isOn;
        this.temperature = temperature;
    }

     void operate(){
        if (isOn){
            if (temperature >= 25){
                System.out.println("AC is on and temp annd temp:"+temp+"(high)");
            } else {
                System.out.println("AC on but Room Temp Norm");
            }
        } else {
            System.out.println("AC is off");
        }
        
    }
}