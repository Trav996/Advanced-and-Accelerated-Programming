//DateFormatConverter.java
//Barrett:Travelle:A00380824:csc122822
//Submission 08
//Converting Date Formats

/*
 *The program does not satisfy all conditions.
 */

import java.util.Scanner;

public class DateFormatConverter
{
    public static String monthValue = null;
    public static String dayValue = null;
    public static int maxDay;
   
    public static void main (String[] args)
    {
        if (args.length == 0)
        {
            OpeningScreen os = new OpeningScreen();
            os.displayIdentificationInfo();
            ProgramDescription pd = new ProgramDescription();
            pd.display();
        }
        try
        {
            if (!args[0].contains("/"))
            
                throw new BadInputException("\nBad input: The / separator is "
                    +"missing.");
        
            String monthValue = args[0].split("/")[0];
            String dayValue = args[0].split("/", -1)[1];

            if (monthValue.length() < 1 || monthValue.length() > 2 
                    || monthValue.isEmpty())
                throw new BadInputException("\nBad input: Exactly one or two"
                        +" digits must precede the / separator.");
            else if (dayValue.length() < 1 || dayValue.length() > 2 
                    || dayValue.isEmpty())
                throw new BadInputException("\nBad input: Exactly one or two"
                        +" digits must follow the / separator.");
            char m = monthValue.charAt(0);
            char m1 = monthValue.charAt(1);
            if (Character.isLetter(m) || Character.isLetter(m1))
                throw new BadInputException("\nBad input: The month value "
                        +" contains non-digits");
            char d = dayValue.charAt(0);
            char d1 = dayValue.charAt(1);
            if (Character.isLetter(d) || Character.isLetter(d1))
                throw new BadInputException("\nBad input: The day value "
                        +"contains non-digits");
            DateFormatConverter convert = new DateFormatConverter();
            convert.setDayValues(monthValue);
            int dVal = Integer.parseInt(dayValue);
            int mVal = Integer.parseInt(monthValue);
            if (mVal < 1 || mVal > 12)
            {
                throw new MonthException(mVal);
            }
            else if (dVal < 1 || dVal > maxDay)
            {
                throw new DayException(dVal, mVal, "1..31");
            }
            System.out.print("\n" + monthValue + "/" + dayValue + " is " 
                    + convert.getMonthNames() 
                    + " " + dayValue);
            Scanner kbd = new Scanner(System.in);
            System.out.print("\nPress Enter to continue ...");
            kbd.nextLine();
        }  
        catch (Exception e)
        {
             System.out.println(e.getMessage());
             Scanner kbd = new Scanner(System.in);
             System.out.print("Press Enter to continue ... ");
             kbd.nextLine();
        }
    }

        public String getMonthNames()
        {
            switch (Integer.parseInt(monthValue))
            {
                case 1: monthValue = "January"; break;
                case 2: monthValue = "February"; break;
                case 3: monthValue = "March"; break;
                case 4: monthValue = "April"; break;
                case 5: monthValue = "May"; break;
                case 6: monthValue = "June"; break;
                case 7: monthValue = "July"; break;
                case 8: monthValue = "August"; break;
                case 9: monthValue = "September"; break;
                case 10: monthValue = "October"; break;
                case 11: monthValue = "November"; break;
                case 12: monthValue = "December"; break;           
           }
           return monthValue;
       }

       public void setDayValues(String m)
       {
           switch (Integer.parseInt(monthValue))
            {
                case 1: maxDay = 31; break;
                case 2: maxDay = 29; break;
                case 3: maxDay = 31; break;
                case 4: maxDay = 30; break;
                case 5: maxDay = 31; break;
                case 6: maxDay = 30; break;
                case 7: maxDay = 31; break;
                case 8: maxDay = 31; break;
                case 9: maxDay = 30; break;
                case 10: maxDay = 31; break;
                case 11: maxDay = 30; break;
                case 12: maxDay = 31; break;  

       }
        

    }


}
