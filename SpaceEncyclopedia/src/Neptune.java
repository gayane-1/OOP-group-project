public class Neptune extends Planet
{
    public Neptune()
    {
        super(49.532390E6, 4506.163, 5.47177, 0.67125,
                1.024E26, 57.74, 1.64, -200, 13,
                60152,28.3, 0.67125, 164.79246, 282.349556,
                48.009758, 0.009003,
                30.109570, 1.770646, 131.670599, 62.2);
    }

    public String toString()
    {
        return PlanetName.NEPTUNE.toString();
    }
}
