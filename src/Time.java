public class Time {
   private int hours;
   private int minutes;
   private boolean afternoon;

   public Time(){}

   public Time(String militaryTime) throws InputFormatException {
      if (militaryTime == "") {
         throw new InputFormatException("You haven't entered any Input");
      } else if (militaryTime.length() != 5) {
         throw new InputFormatException("Length of the input you have entered is incorrect");
      } else if (militaryTime.charAt(2) != ':') {
         throw new InputFormatException("Input is in incorrect format");
      } else {
         for (int n = 0; n < militaryTime.length(); n++) {
            if (n == 2)
               continue;
            else if (!Character.isDigit(militaryTime.charAt(n))) {
               throw new InputFormatException("Input contains non-digit character(s)");
            }
         }
         hours = Integer.parseInt(String.valueOf(militaryTime.split(":")[0]));
         minutes = Integer.parseInt(String.valueOf(militaryTime.split(":")[1]));

         if (hours > 23) {
            throw new InputFormatException("Hour entered is greater than 23");
         } else if (minutes > 59) {
            throw new InputFormatException("Minute entered is greater than 59");
         } else {
            if (hours > 12) {
               hours = hours - 12;
               afternoon = true;
            } else if (hours == 0) {
               hours = 12;
            } else if (hours == 12) {
               afternoon = true;
            }
         }
      }
   }

   public int getHours() {
      return hours;
   }

   public int getMinutes() {
      return minutes;
   }

   public boolean isAfternoon() {
      return afternoon;
   }

   @Override
   public String toString() {
      String am_pm;
      String zero = "";

      if (isAfternoon()) {
         am_pm = "PM";
      } else {
         am_pm = "AM";
      }

      if (getMinutes() < 10) {
         zero = "0";
      }

      return "Regular Time: " + getHours() + ":" + zero + getMinutes() + " " + am_pm;
   }
}