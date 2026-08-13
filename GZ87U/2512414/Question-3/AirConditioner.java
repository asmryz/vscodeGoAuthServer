public class AirConditioner {
    boolean isOn;
    int temperature;

    AirConditioner(boolean o, int t){
        isOn= o;
        temperature= t;
    }

    void operate(){
     if(isOn=true && temperature > 40){
         System.out.println("Cooling Started");
     }
     else if(isOn=false && temperature < 40){
         System.out.println("No Need For Cooling");
     }
    }
}