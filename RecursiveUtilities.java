//RecursiveUtilities.java
//Barrett:Travelle:A00380824:csc122822
//Submission 10
//Implementing Some Recursive Utilities

/*
 *The program works accurately.
 */

import java.util.Scanner;
import java.util.Arrays;

/**
 * This program provides three "utilities" for computing the gcd 
 * (greatest common divisor) of two positive integers, computing the 
 * first n Fibonacci numbers, or determining whether a string is a palindrome. 
 * @Author Travelle Barrett
 */
public class RecursiveUtilities
{
    /**
     * A simple tester method for each recursive condition.
     * @param args The command-line arguments. 
     */  
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in); //create Scanner object
        try
        {
            if (args.length == 0)
            {
                OpeningScreen os = new OpeningScreen();
                os.displayIdentificationInfo();
                ProgramDescription pd = new ProgramDescription();
                pd.display();
            }
            else if(args[0].equals("gcd") && args.length == 3)
            {
                System.out.println("\nThe greatest common divisor of "
                        + args[1] + " and " + args[2] + " is " 
                        + greatestCommonDivisor(Integer.parseInt(args[1]),
                            Integer.parseInt(args[2])) + ".");
                System.out.print("Press Enter to continue ...");
                keyboard.nextLine();
            }
            else if(args[0].equals("gcd") && args.length != 3)
            {
                System.out.println("\nWrong number of parameters."
                        +"\ngcd requires "
                        +"exactly two additional values.");
                System.out.print("Press Enter to continue ...");
                keyboard.nextLine();
            }
            else if(args[0].equals("fib") && args.length == 2 
                    && !args[1].equals("1"))
            {
                int operand = Integer.parseInt(args[1]);
                System.out.print("\nHere are the first " + operand 
                        + " values "
                        + "of the Fibonacci sequence: ");
                for(int i = 1; i<= operand; i++)
                {
                    if((i - 1) % 6 == 0)
                    {
                        System.out.println();
                    }
                    System.out.printf("%12d", fibonacci(i));
                }
                System.out.print("\nPress Enter to continue ...");
                keyboard.nextLine();
            }
            else if(args[1].equals("1"))
            {
                System.out.print("\nHere is the first value in the "
                        +"Fibonacci sequence: " + "\n");
                System.out.printf("%12d", 1);
                System.out.println();
                System.out.print("Press Enter to continue ...");
                keyboard.nextLine();
            }
            else if(args[0].equals("fib") && args.length != 2)
            {
                System.out.println("\nWrong number of parameters."
                        +"\nfib requires "
                        +"exactly one additional value.");
                System.out.print("Press Enter to continue ...");
                keyboard.nextLine();
            }
            else if(args[0].equals("pal"))
            {
                if(args.length >= 2)
                {
                    System.out.println("\nThe input string");
                    String [] arr = new String[args.length - 1];
                    System.arraycopy(args, 1, arr, 0, (args.length - 1));
                    String inputString = Arrays.toString(arr);
                    String string = inputString.replaceAll("[^a-zA-Z]","").
                        toLowerCase();
                    System.out.print(string + " ");
                    System.out.println("\nhas been converted to");
                    System.out.print(string.replaceAll("[^a-zA-Z]","").
                            toLowerCase());
                    if(isPal(string))
                    {
                        System.out.print("\nand this string is a "
                                +"palindrome.");
                    }
                    else
                    {
                        System.out.print("\nand this string is not a "
                                +"palindrome.");
                    }
                    System.out.print("\nPress Enter to continue ...");
                    keyboard.nextLine();
                }
            }
            else if(!args[0].equals("gcd")|| !args[0].equals("fib")
                    || !args[0].equals("pal"))
            {
                System.out.println("\nBad first parameter: Invalid command.");
                System.out.print("Press Enter to continue ...");
                keyboard.nextLine();
            }
        }
        catch(NumberFormatException e)
        {
            System.out.println("\nBad input value: Integer expected.");
            System.out.print("Press Enter to continue ...");
            keyboard.nextLine();
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("\nWrong number of parameters."
                    +"\npal requires "
                    +"at least one additional value.");
            System.out.print("Press Enter to continue ...");
            keyboard.nextLine();
        }

    }//end main

    // --------------------- Helper Methods ----------------------------- //
    /**
     * A method to find the greatest common divisors of two numbers.
     * @param operand1 The first number.
     * @param operand2 The second number.
     */ 
    private static int greatestCommonDivisor
    (
     int operand1, int operand2
    )
    {
        if(operand2 == 0)
        {
            return operand1;
        }
        return greatestCommonDivisor(operand2, operand1 % operand2);
    }
 
    /**
     * A method to get the Fibonacci sequence of a given number.
     * @param operand The number the user inputs.
     */ 
    private static int fibonacci
    (
     int operand
    )
    {
        if(operand == 1)
        {
            return 1;
        }
        else if(operand == 2)
        {
            return 1;
        }
        else
        {
            return fibonacci(operand - 2) + fibonacci(operand - 1);
        }
    }
    /**
     * A method to convert and check if a string is a palindrome.
     * @param inputString The string entered by the user.
     */
    private static boolean isPal
    (
     String inputString
    )
    {
        inputString = inputString.replaceAll("\\s+", "").toLowerCase();
        if(inputString.length() == 0 || inputString.length() == 1)
        {
            return true;
        }

        if(inputString.charAt(0) == inputString.charAt(inputString.
                    length() - 1))
        {
            return isPal(inputString.substring(1, inputString.length() - 1));
        }
        return false;
    }

}
