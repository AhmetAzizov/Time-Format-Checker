import javax.swing.*;
import java.awt.*;
import java.awt.print.PrinterException;
import java.util.Scanner;

public class Main {
   public static void main(String[] args) throws PrinterException {
      Scanner keyboard = new Scanner(System.in);
      char answer = 'Y';
      String enteredTime;
      String response;


      while (Character.toUpperCase(answer) == 'Y') {
         System.out.print("\nPlease enter a military time using the ##:## format: ");
         enteredTime = keyboard.nextLine();
         System.out.println();

         try {
            Time now = new Time(enteredTime);

            System.out.println(now);
         } catch (InputFormatException e) {
            System.out.println(e.getMessage());
         }

         // While loop continues until there is no exception to throw.
         while (true) {
            try {
               System.out.print("\nWould you like to enter another number (Press Y)? ");
               response = keyboard.nextLine();
               System.out.println();
               if (response == "")
                  throw new InputFormatException("Input is null");
               answer = response.charAt(0);
               break;
            } catch (InputFormatException e) {
               System.out.println(e.getMessage());
            }
         }
      }

      keyboard.close();
      System.out.println("Goodbye!");
   }
}