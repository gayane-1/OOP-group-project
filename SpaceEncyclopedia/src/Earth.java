public class Earth extends Planet
{
    public static final double TRACEGASES = 1.0;
    public static final double OXYGEN = 20.9;
    public static final double NITGROGEN = 78.1;

    public static final double warmerPerYear = 0.02;


    private enum Atmosphere
    {
        TROPOSPHERE,
        STRATOSPHERE,
        MESOSPHERES,
        THERMOSPHERE
    }
}
