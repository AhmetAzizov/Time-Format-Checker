import java.util.Scanner;

/**
   This program demonstrates the Time class.
*/

public class Main
{
   public static void main(String[] args)
   {

      Scanner keyboard = new Scanner(System.in);
      char answer = 'Y';
      String enteredTime;
      String response;

      while (Character.toUpperCase(answer) == 'Y')
      {
         System.out.print("\nPlease enter a military time using the ##:## format: ");
         enteredTime = keyboard.nextLine();

         try {
            Time now = new Time(enteredTime);
         }catch(InputFormatException e){
            System.out.println(e.getMessage());
         }

         // While loop continues until there is no exception to throw.
         while (true) {
            try {
               System.out.println("\nWould you like to enter another number (Press Y)? ");
               response = keyboard.nextLine();
               if (response == "") throw new InputFormatException("Input is null");
               answer = response.charAt(0);
               break;
            } catch (InputFormatException e) {
               System.out.println(e.getMessage());
            }
         }
      }
   }
}