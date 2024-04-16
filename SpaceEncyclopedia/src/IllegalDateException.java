public class IllegalDateException extends Exception
{
    public IllegalDateException()
    {
        super("Illegal Date:");
    }
    public IllegalDateException(String message)
    {
        super(message);
    }
}
