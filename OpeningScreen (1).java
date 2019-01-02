//OpeningScreen.java
//Barrett:Travelle:A00380824:csc122822
//Submission 06
//Processing Names

/*
 *The program works accurately.
 */

import java.util.Scanner;

/**
 *A class to display an opening screen of identification information.
 */
public class OpeningScreen
{
    // ---------- Class Field ------------------------------------- //
    private Scanner keyboard = new Scanner(System.in);

    // ---------- Program Method ---------------------------------- //

    /**
     * Displays three lines of identification information, indented by 
     * two tab widths from the left margin and centered (more or less) 
     * vertically on the screen, with a pause for the user to press Enter 
     * to continue at the end of the display. The screen is otherwise blank.
     */
    public void displayIdentificationInfo()
    {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\tBarrett:"
                + "Travelle:A00380824:csc122822");
        System.out.println("\tSubmission 07");
        System.out.println("\tIllustrating Inheritance with Person,"
                +" Student and Undergraduate\n\n\n\n\n\n\n\n\n\n\n\n");

        System.out.print("Press Enter to continue ... ");//pause
        keyboard.nextLine(); 
    }

    /**
     *A simple test driver for this class. It creates an object of 
     *this class and then displays it.
     */
    public static void main (String[] args)
    {
        OpeningScreen screen = new OpeningScreen();
        screen.displayIdentificationInfo();
    }

}//end class
