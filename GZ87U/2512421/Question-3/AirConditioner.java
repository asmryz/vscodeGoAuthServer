 public class AirConditioner {
    boolean isOn;
     double Temp  ;

    public AirConditioner(boolean isOn, double temp) {
        this.isOn = isOn;
         this.Temp = temp;
    }

    public void Oprate(){
        if(isOn == true && Temp >=16){
            System.out.println("Start Colling");
        }

    }
    public void AcOff(){
if (isOn == true && Temp <= 16 ){
    System.out.println("idle");
}

}
 }