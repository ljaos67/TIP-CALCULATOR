/**********************************************************
 *                                                        *
 *  CSCI 470/502        Assignment 3         Summer 2021  *
 *                                                        *
 *  Developer(s):  Leonart Jaos                           *
 *                                                        *
 *  Section: 0Y01                                         *
 *                                                        *
 *  Due Date/Time:  July 2nd, 2021 @ 11:59 PM             *
 *                                                        *
 *  Purpose: This console app calculates costs for bills  *
 *  with tips for a user-input amount of bills. Calculate *
 *  Tips is a method that generates bill totals as long   *
 *  as the user does not input a terminating character    *
 *  (Anything but 'y' or 'Y'. Each bill is represented by *
 *  a TipCalculator object, which has the base bill total *
 *  , the percent the user wants to tip, and the amount of*
 *  ways the bill was to be split amongst a group. This   * 
 *  driving class calls CalculateTips(), which            *
 *  is a method that uses the TipCalculator() methods to  *
 *  fill in and display members of each bill. After a bill*
 *  is input, its base total, tip percentage, party size, *
 *  bill total (with tips), and split costs are displayed.*
 *  This is repeated until terminated by the user.        *
 *                                                        *
 **********************************************************/


import java.util.Scanner;
// driving class
public class TipApp
{
  // creates a TipCalculator object for access to bill members
  TipCalculator defObj = new TipCalculator();
  // main function that calls CalculateTips()
  public static void main(String[] args)
  {
    TipApp defBill = new TipApp();
    defBill.CalculateTips();
  }
  // This function takes user input for CalculateTip() members
  // and outputs the input. If the user input is invalid, the user
  // is prompted until valid input is entered
  private void CalculateTips()
  {
    // variable used to hold bill input from user
    double tmp = 0;
    // used to hold tip percent and party size input from user
    int chk = 0;
    boolean flag = false;
    // used for terminating char
    char ans;
    Scanner input = new Scanner(System.in);
    System.out.print("*** Tip Calculator ***\n\n");
    // prompts for bill members while user inputs 'y' or 'Y'
    do
    {
      // input and validation for base bill amount
      System.out.print("Enter the bill amount: ");
      // preset false flag that becomes true when the input for the bill amount
      // is a valid double input and is positive
      while(!flag)
      {
        // take input and check if it is a double value
        // error message prints and advances scanner if input is non-valid
        if(!(input.hasNextDouble()))
        {
          System.out.print("Please enter a valid bill amount.\n\n");
          System.out.print("Enter the bill amount: ");
          input.nextLine();
          continue;
        }
        // if loop reaches this point, the input is double, but may not be positive
        // below contains the errorchecking and possible printing if an error arises
        tmp = input.nextDouble();
        if(tmp < 0)
        {
          System.out.print("Please enter a valid bill amount.\n\n");
          System.out.print("Enter the bill amount: ");
          input.nextLine();
        }
        // case if input is double and positive
        else
        {
          flag = true;
        }
      }
      // resets while loop flag to repeat logic above in percentage input
      flag = false;
      // sets defObj bill member to user input value from above
      defObj.setBill(tmp);
      // input and error checking for tip percentage
      System.out.print("Enter your desired tip percentage (20 equals 20%): ");    
      while(!flag)
      {
        // error if input is not an int
        if(!(input.hasNextInt()))
        {
          System.out.print("Please enter a valid tip percentage.\n\n");
          System.out.print("Enter your desired tip percentage (20 equals 20%): ");
          input.next();
          continue;
        }
        // error if input is less than 0, 0 percent tip is okay
        chk = input.nextInt();
        if(chk < 0)
        {
          System.out.print("Please enter a valid tip percentage.\n\n");
          System.out.print("Enter your desired tip percentage (20 equals 20%): ");
          input.nextLine();
        }
        // ends loop upon valid data entry
        else
        {
          flag = true;
        }
      }
      // reset while loop flag
      flag = false;
      // sets percentage as user input value from above
      defObj.setPct(chk);
      // input and error checking for party size
      System.out.print("Enter the size of your party: ");
      while(!flag)
      {
        // party size member is also an int, same error message
        if(!(input.hasNextInt()))
        {
          System.out.print("Please enter a valid party size.\n\n");
          System.out.print("Enter the size of your party: ");
          input.next();
          continue;
        }
        chk = input.nextInt();
        // party size must at least be 1
        if(chk < 1)
        {
          System.out.print("Please enter a valid party size.\n\n");
          System.out.print("Enter the size of your party: ");
          input.nextLine();     
        }
        else
        {
          flag = true;
        }
      }
      // resets while loop
      // sets user input party value as pty value
      flag = false;
      defObj.setPty(chk);
      // uses TipCalculator methods of defObj to print members
      System.out.print("*** Your Bill ***\n\n");
      System.out.printf("Bill Amount: $%.2f%n", defObj.getBill());
      System.out.printf("Tip Percentage: %d%%%n", defObj.getPct());
      System.out.printf("Party Size: %d%n%n", defObj.getPty());
      System.out.printf("Total Bill (with Tip): $%.2f%n", defObj.getTotalBill());
      System.out.printf("Share for Each Individual: $%.2f%n", defObj.getIndividualShare());
      System.out.print("Another bill? (y/n): \n");
      // collect user input for continuation of bill input
      ans = input.next().charAt(0);
    }
    while(ans == 'y' || ans == 'Y');
    // end app message
    System.out.println("\nGoodbye!");
  }
}