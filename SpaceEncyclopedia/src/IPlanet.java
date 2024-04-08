public interface IPlanet
{
    void displayStats();
    double surfaceGravity();
    double massRatio(Object planet) throws IllegalArgumentException;

}
