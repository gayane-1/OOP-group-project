import javax.management.modelmbean.InvalidTargetObjectTypeException;

public interface PlanetInteface
{
    void displayStats();
    double surfaceGravity();
    double massRatio(Object planet) throws InvalidTargetObjectTypeException;
}
