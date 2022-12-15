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
         Time now = new Time (enteredTime);
         System.out.println("\nWould you like to enter another number (Press Y)? ");

         response = keyboard.nextLine();

         answer = response.charAt(0);
      }
   }
}