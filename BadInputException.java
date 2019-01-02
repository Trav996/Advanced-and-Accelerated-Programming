//BadInputException.java

public class BadInputException extends Exception
{
    public BadInputException()
    {
        super("Bad input.");
    }

    public BadInputException
    (
        String message //in
    )
    {
        super(message);
    }
}
