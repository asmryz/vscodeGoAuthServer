public class AirConditioner {
    class aircondition {
      int temperature ;
      int ison

      aircondition (int temperature  ) {
          this.temperature  = temperature;
      }

      void checktemperature() {
          if (temperature>= 20) {
              System.out.println("ison");
          }
          else if (temperature >= 18) {
              System.out.println("ison");
          }
          else if (temperature  >= 10) {
              System.out.println("ison");
          }
          else {
              System.out.println("off");
          }
      }
  }

  

}