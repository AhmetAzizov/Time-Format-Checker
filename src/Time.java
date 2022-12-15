public class Time
{
   private int hours;
   private int minutes;
   private boolean afternoon;



   public Time(String militaryTime) throws InputFormatException {
      if (militaryTime == "")
      {
         throw new InputFormatException("You haven't entered any Input");
      }
      else if (militaryTime.length() != 5)
      {
         throw new InputFormatException("Length of the input you have entered is incorrect");
      }
      else  if (militaryTime.charAt(2) != ':')
      {
         throw new InputFormatException("Input is in incorrect format");
      }
      else
         {
            for (int n = 0; n < militaryTime.length(); n++){
               if (n == 2) continue;
               else if (!Character.isDigit(militaryTime.charAt(n))) {
                  throw new InputFormatException("Input contains non-digit character(s)");
               }
            }


            hours = Integer.parseInt(String.valueOf(militaryTime.split(":")[0]));
            minutes = Integer.parseInt(String.valueOf(militaryTime.split(":")[1]));

            if(hours > 23)
            {
               System.out.println(militaryTime +
                                  " is not a " +
                                  "valid military time." );
            }
            else if(minutes > 59)
            {
               System.out.println(militaryTime +
                                  " is not a " +
                                  "valid military time." );
            }
            else if (hours > 12)
            {
               hours = hours - 12;
               afternoon = true;
               System.out.println(this.toString());
            }
            else if (hours == 0)
            {
               hours = 12;
               System.out.println(this.toString());
            }
            else if (hours == 12)
            {
               afternoon = true;
               System.out.println(this.toString());
            }
            else
            {
               System.out.println(this.toString());
            }
         }
      }

   /**
      The toString method returns a conventional time.
      @return A conventional time with am or pm.
   */
   public String toString()
   {
      String am_pm;
      String zero = "";

      if (afternoon)
         am_pm = "PM";
      else
         am_pm = "AM";
      if (minutes < 10)
         zero = "0";

      return hours + ":" + zero + minutes + " " + am_pm;
   }
}