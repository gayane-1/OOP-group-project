public class Jupiter extends Planet
{
    public Jupiter()
    {
        super(142.984E6, 1.427E6, 9.65606, 0.42625,
                5.688E26, 763.59, 0.69, -140, 60,
                10752.9,26.7, 0.44416667, 29.471362, 287.690033,
                92.861407, 0.055581,
                9.554747, 2.488980, 113.576139, 165.60);
    }

    public String toString()
    {
        return PlanetName.JUPITER.toString();
    }
}
