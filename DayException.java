//DayException.java

public class DayException extends Exception
{
    public DayException()
    {
        super("Invalid value for day.");
    }

    public DayException
    (
        String message //in
    )
    {
        super(message);
    }

    //Note that dayRange should be the range within which dayNumber must
    //lie, for the given month number. For example, if monthNumber is 3,
    //then dayRange should be "1..31" since there are 31 days in March.
    public DayException
    (
        int dayNumber,   //in
        int monthNumber, //in
        String dayRange  //in
    )
    {
        super("\nBad day: Day value " + dayNumber + " is invalid "
            + "for month number " + monthNumber
            + ".\nDay must lie in the range " + dayRange + ".");
    }
}
