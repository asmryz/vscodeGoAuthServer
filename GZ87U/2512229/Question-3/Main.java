/*Create a Java class `AirConditioner` containing attributes isOn and temperature. Implement a method `operate()` that checks whether the air conditioner is switched on. If it is on and the temperature is high, the air conditioner should start cooling; otherwise, it should remain idle. Display an appropriate message for each condition.*/
class AirConditioner {

    boolean isOn ;
    boolean hightemperature ;

    
    void operate(boolean isOn, boolean hightemperature){
        if(isOn ==  true  && hightemperature == true){
            System.out.println("AC should start cooling");
            
        }
        else{
             System.out.println("AC should remain idle");
        }
         
        
    }
}
public class Main {
    public static void main(String[] args) {
        AirConditioner checkAc = new  checkAc(true, true);
        AirConditioner checkAc = new  checkAc(false, true);
        
      
    }
}