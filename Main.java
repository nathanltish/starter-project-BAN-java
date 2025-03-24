/********************************************
*	AUTHOR: Nathan Tshishimbi
* COLLABORATORS: Alex Burman, Nathan Tshishimbi, Brody Wilson
*	LAST MODIFIED:	03/23/2025
********************************************/

/********************************************
*	GLOBAL CURRRENCY CONVERTER
*********************************************
*	PROGRAM DESCRIPTION:
*	This program takes a user input to convert between USD, EUR, and JPY
* with current exchange rates using static methods. If user enters an 
* invalid currency, program repromts for a valid input rather than closing.
*********************************************
*	ALGORITHM:
*	1. Prompts user for base currency, target currency, and amount.
*	2. Validates the currency inputs in a loop until valid.
*	3. Validates the numeric input in a loop until valid.
*	4. Performs conversion using a static method.
*	5. Displays the result using formatted output.
*********************************************
*	STATIC METHODS:
*	- convertCurrency(String original_rate, String new_rate, double amount) <Alex>
*	- formatCurrency(String currencyCode, double amount) <Nathan>
*	- isValidCurrency(String code) <Brody>
*********************************************/

public class Main 
{
  /***** CONSTANT SECTION *****/
  static final double USD_TO_EUR = 0.924;
  static final double USD_TO_JPY = 149.6;
  static final double EUR_TO_USD = 1.082;
  static final double EUR_TO_JPY = 161.9;
  static final double JPY_TO_USD = 0.0067;
  static final double JPY_TO_EUR = 0.00618;

  public static void main(String[] args)
  {

    /***** INTRO SECTION *****/
    System.out.println("===================================");
    System.out.println("  Welcome to Global Currency Converter");
    System.out.println("===================================\n");

    /***** USER INPUT SECTION *****/
    // Ensures base currency input is valid
    String baseCurrency = "";
    while(true) 
    {
      baseCurrency = InputHandler.getStringInput("Enter base currency (USD, EUR, JPY): ").toUpperCase();
      if(isValidCurrency(baseCurrency))
        break;
      System.out.println("Invalid currency entered. Please enter one of: USD, EUR, JPY.");
    }

    // Ensures amount input is valid
    double baseAmount = InputHandler.getDoubleInput("Enter amount to convert: ");

    // Ensures target currency input is valid
    String targetCurrency = "";
    while(true) 
    {
      targetCurrency = InputHandler.getStringInput("Enter target currency (USD, EUR, JPY): ").toUpperCase();
      if(isValidCurrency(targetCurrency))
        break;
      System.out.println("Invalid currency entered. Please enter one of: USD, EUR, JPY.");
    }


    /***** PROCESSING SECTION *****/
    double convertedAmount = convertCurrency(baseCurrency, targetCurrency, baseAmount);


    /***** OUTPUT SECTION *****/
    System.out.printf("\n%s %s is equal to %s\n", formatCurrency(baseCurrency, baseAmount), baseCurrency, formatCurrency(targetCurrency, convertedAmount));
    System.out.printf("\nThank you for using the Global Currency Converter!");

    // Demonstration of typecasting: explicitly cast a double to an int
    // This casts the convertedAmount (a double) into an integer, truncating the decimal part.
    int intConvertedAmount = (int) convertedAmount;
    System.out.printf("Rounded converted amount (typecasting from double to int): %d\n", intConvertedAmount);
    InputHandler.closeScanner();
  }


  /***** STATIC METHODS *****/

  // Checks if the given currency abbreviation is valid
  public static boolean isValidCurrency(String code) 
  {
    return code.equals("USD") || code.equals("EUR") || code.equals("JPY");
  }
  
  // Converts from one currency to another using the preset exchange rates
  public static double convertCurrency(String original_rate, String new_rate, double amount) 
  {
    if(original_rate.equalsIgnoreCase(new_rate)) 
    {
      System.out.printf("Hmm " + original_rate + " to " + new_rate + " is difficult... let me think. Calculating... Calculating... I think it's the same number.");
      return amount; // No conversion needed if currencies are the same 
    }

    double result = 0.0;
    
    // Used if-else instead of switch due to simple nature of program
    if (original_rate.equals("USD") && new_rate.equals("EUR")) {
      result = amount * USD_TO_EUR;
    } else if (original_rate.equals("USD") && new_rate.equals("JPY")) {
      result = amount * USD_TO_JPY;
    } else if (original_rate.equals("EUR") && new_rate.equals("USD")) {
      result = amount * EUR_TO_USD;
    } else if (original_rate.equals("EUR") && new_rate.equals("JPY")) {
      result = amount * EUR_TO_JPY;
    } else if (original_rate.equals("JPY") && new_rate.equals("USD")) {
      result = amount * JPY_TO_USD;
    } else if (original_rate.equals("JPY") && new_rate.equals("EUR")) {
      result = amount * JPY_TO_EUR;
    }
    return result;
  }

// Returns a formatted currency string with the appropriate symbol
public static String formatCurrency(String currencyCode, double amount) 
{
String symbol;

    if (currencyCode == "USD") {
      symbol = "$";
    } else if (currencyCode == "EUR") {
      symbol = "€";
    } else if (currencyCode == "JPY") {
      symbol = "¥";
    } else {
      symbol = "";
    }

    return String.format("%s%,.2f", symbol, amount);
  }
}
