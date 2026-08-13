public class AirConditioner {
String isOn ;
String temperature;
void operates (){
    if(isOn.equals("Yes"||"yes")&&temperature.equals("High"||"high")){
        System.out.println("AC is on!!");
    } else{
        System.out.println("Turn on your AC");
}
}