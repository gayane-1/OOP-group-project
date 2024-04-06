import javax.management.modelmbean.InvalidTargetObjectTypeException;

public interface PlanetInterface
{
    void displayStats();
    double surfaceGravity();
    void compareDistanceFromSun(Object planet) throws InvalidTargetObjectTypeException;
    double massRatio(Object planet) throws InvalidTargetObjectTypeException;

}
