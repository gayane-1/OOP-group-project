import javax.management.modelmbean.InvalidTargetObjectTypeException;

public class Main
{

    public static void main(String[] args)
    {
        Planet e = new Earth();
        Planet m = new Mercury();
        Planet v = new Venus();

        double mass = 175 / e.surfaceGravity();


        System.out.println(e.surfaceWeight(mass));
        System.out.println(m.surfaceWeight(mass));
        System.out.println(v.surfaceWeight(mass));

        v.displayStats();
        System.out.println();
        e.displayStats();



    }
}
