public class airConditioner {
    class aircondition {
      int temperature ;
      int ison;

      aircondition (int temperature ,int ison  ) {
          this.temperature  = temperature;
          this.ison=ison;
      }

      void checktemperature() {
          if (temperature>= 20) {
              System.out.println("temperature is high");
          }
          else if (temperature >= 18) {
              System.out.println("temperature is high");
          }
          else if (temperature  >= 10) {
              System.out.println("temperature is cold");
          }
          else {
              System.out.println("off");
          }
      }
  }

  

}