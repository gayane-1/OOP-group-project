public class Mars extends Planet
{
    public Mars()
    {
        super(6.794650E6, 228.527, 24.1402, 1.02625,
                6.421E23, 0.15, 3.93, -63, 2,
                687,25.2, 1.02625, 1.880932, 240.739474,
                335.874939, 0.093396,
                1.523688, 1.849736, 49.480308, 9.36);
    }

    public String toString()
    {
        return PlanetName.MARS.toString();
    }
}
