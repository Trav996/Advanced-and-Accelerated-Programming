//FileProcessor.java
//Barrett:Travelle:A00380824:csc122822
//Submission 09
//Processing Lines of Integers in a Textfile

/*
 *The program works accurately.
 */

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileInputStream;

/**
 * This program reads in, from the command line, the 
 * name of a textfile containing any number of lines of 
 * integers and then processes each line in turn.
 * @Author Travelle Barrett
 */
public class FileProcessor
{
    public static void main(String[] args) throws FileNotFoundException
    {
        if (args.length == 0)
        {
            OpeningScreen os = new OpeningScreen();
            os.displayIdentificationInfo();
            ProgramDescription pd = new ProgramDescription();
            pd.display();
        }
        
        Scanner keyboard = new Scanner(System.in);
        File file = new File("sample_input.txt"); //creates file object
        Scanner inputStream = new Scanner(file);//Scanner opens file for input
        int lineNumber = 1; //count the lines

        try
        {
            //check if the file exists
            if(file.exists() && args[0].equals("sample_input.txt"))
            {
                System.out.print("\nThe file " + file + " was successfully"
                        +" opened.\nThe data in it will now be processed.");
                System.out.print("\nPress Enter to continue ...");
                keyboard.nextLine();
            }
            else 
            {
                throw new FileNotFoundException("\n" + args[0] 
                        + " (The system cannot find the file "
                        +"specified)\nProgram will now terminate.");
            }
            while(inputStream.hasNextLine()) //reads text file
            {
                String ints_Per_Line = inputStream.nextLine();
                try
                {
                    if(ints_Per_Line.length() == 0)
                    {
                        System.out.println("\nLine " + lineNumber + ":"
                                + " This is a blank line.");
                        System.out.print("Press Enter to continue ...");
                        keyboard.nextLine();
                    }
                    
                    if(ints_Per_Line.length() <= 15 || 
                            ints_Per_Line.length() >= 1)
                    {
                        System.out.println("\nLine " + lineNumber + ": "
                                + "Number of values = " 
                                + countIntegers(ints_Per_Line)
                                + " and range value is " 
                                + "[" + getMin(ints_Per_Line) + ", " 
                                + getMax(ints_Per_Line)  + "].");
                       System.out.print("Press Enter to continue ...");
                       keyboard.nextLine();
                    }
                    else if(ints_Per_Line.length() > 15 && 
                            ints_Per_Line.length() < 1)
                    {
                        System.out.println("\nLine " + lineNumber + ":" 
                                +" This line contains more than the "
                                +"maximum of 15 allowed data values.");
                        System.out.print("Press Enter to continue ...");
                        keyboard.nextLine();
                    }
                    if(ints_Per_Line.length() == 1)
                    {
                         System.out.println("\nLine " + lineNumber + ": "
                                 + "Number of values = " + countIntegers
                                 (ints_Per_Line) + "and value range "
                                 +"consists of this single value.");
                         System.out.print("Press Enter to continue ...");
                         keyboard.nextLine();
                    }
                    if(ints_Per_Line.isEmpty() || ints_Per_Line.equals(" "))
                    {
                        System.out.println("\nLine " + lineNumber + ":"
                                + " This is a blank line.");
                        System.out.print("Press Enter to continue ...");
                        keyboard.nextLine();
                    }
                }
                catch(NumberFormatException e)
                {
                    System.out.println("\nLine " + lineNumber + ":"
                            +" This line contains an invalid integer"
                            +" value.");
                    System.out.print("Press Enter to continue ...");
                    keyboard.nextLine();
                }
                lineNumber++;
            }
            inputStream.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.print(e.getMessage());
            System.out.print("\nPress Enter to continue ...");
            keyboard.nextLine();
        }
        catch(ArrayIndexOutOfBoundsException e)  
        {
            System.out.print("");
        }
    
    }//end main

    // ---------- Helper Methods -------------------------------- //
    /**
     * A method to count the number of integers in the text file.
     * @param line This is the amount of integers on each line.
     */ 
    private static int countIntegers(String line)
    {
        String[] nums = line.split(" ");
        int count = nums.length;
        return count;
    }
    /**
     * A method to get the largest integer from the text file 
     * on each line.
     * @param strArray Variable to split integers and get max.
     */
    private static int getMax(String strArray) 
    {
        String [] array = strArray.split(" ");
        int maxValue = Integer.parseInt(array[0]);
        for (int i = 1; i < array.length; i++) 
        {
            if (Integer.parseInt(array[i]) > maxValue) 
            {
                maxValue = Integer.parseInt(array[i]);
            }
        }
        return maxValue;
   }
   /**
    * A method to get the smallest integer from the text file 
    * on each line.
    * @param strArr Variable to split integers and get min.
    */
   private static int getMin(String strArr) 
   {
       String [] arr = strArr.split(" ");
       int minValue = Integer.parseInt(arr[0]);
       for (int i = 1; i < arr.length; i++)
       {
           if (Integer.parseInt(arr[i]) < minValue)
           {
               minValue = Integer.parseInt(arr[i]);
           }
       }
       return minValue;
   }
                      
}
