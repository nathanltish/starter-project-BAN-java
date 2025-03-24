/********************************************
*	InputHandler Class
*********************************************
*	Provides methods to handle user input.
*********************************************/

import java.util.Scanner;

class InputHandler {
  private static Scanner scanner = new Scanner(System.in);

  /** Prompts the user for a string input and returns the result */
  public static String getStringInput(String prompt) {
    System.out.print(prompt);
    return scanner.nextLine();
  }

  /** Prompts the user for a double input and keeps reprompting until valid input is given */
  public static double getDoubleInput(String prompt) {
    double value = 0.0;
    while (true) {
      System.out.print(prompt);
      String input = scanner.nextLine();
      try {
        value = Double.parseDouble(input);
        return value;
      } catch (NumberFormatException e) {
        System.out.println("Invalid number format. Please enter a valid number.");
      }
    }
  }

  /** Closes the scanner resource */
  public static void closeScanner() {
    scanner.close();
  }
}
