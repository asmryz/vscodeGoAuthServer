   class AirConditioner {
    boolean ison;
    int temp;

       AirCondiotioner(boolean is on,int temperature){
            this.ison=ison;
            this.temperature=tempertaure;
        }
         void operate(){
            if(ison){
                if(temperature>=24){
                    System.out.println("AC is switched off");
                }
                else if(temperature>25){
                    System.out.println("AC is on and temp and temp:"+temp+"(high)");
                }
                else{
                    System.out.println("AC is on,temp:" +temp+ );
                }
            }
        }
    