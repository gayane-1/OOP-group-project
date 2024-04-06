import javax.management.modelmbean.InvalidTargetObjectTypeException;

public interface PlanetInterface
{
    void displayStats();
    double surfaceGravity();
    double massRatio(Object planet) throws InvalidTargetObjectTypeException;
}
