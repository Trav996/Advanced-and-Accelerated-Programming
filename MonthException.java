//MonthException.java

public class MonthException extends Exception
{
    public MonthException()
    {
        super("Invalid value for month.");
    }

    public MonthException
    (
        String message //in
    )
    {
        super(message);
    }

    public MonthException
    (
        int monthNumber //in
    )
    {
        super("\n" + monthNumber + " is an invalid month number "
                                 + "(must be a number in 1..12).");
    }
}
