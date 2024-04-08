public class Venus extends Planet
{
    public Venus()
    {
        super(12.10388E6, 108.1479, 35, 117, 4.869E24, 0.86,
                5.2, 464, 0, 224.7, 2.7,
                243, 0.615211, 88.455855,
                131.430236, 0.006778,
                0.723332, 3.394535, 76.589820, 16.92);
    }

    public String toString()
    {
        return PlanetName.VENUS.toString();
    }
}
