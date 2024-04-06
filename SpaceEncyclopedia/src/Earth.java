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

    public Earth()
    {
        super(12.75566E6,150,29.77286,1,
                5.976E24,1,5.52,15,1, 365.25, 23.5, 1);
    }

    public String toString()
    {
        return PlanetName.EARTH.toString();
    }


}
