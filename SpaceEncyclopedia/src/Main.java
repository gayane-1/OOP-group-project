import javax.management.modelmbean.InvalidTargetObjectTypeException;

public class Main
{

    public static void main(String[] args)
    {
        Planet e = new Earth();
        Planet m = new Mercury();

        double mass = 175 / e.surfaceGravity();


        System.out.println(e.surfaceWeight(mass));
        System.out.println(m.surfaceWeight(mass));

        e.displayStats();
        try
        {
            m.compareDistanceFromSun(e);
            System.out.println(e.massRatio(m));
        }
        catch (InvalidTargetObjectTypeException exception)
        {
            System.out.println("null");
        }
    }
}
