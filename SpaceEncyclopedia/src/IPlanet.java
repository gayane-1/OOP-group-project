import javax.management.modelmbean.InvalidTargetObjectTypeException;

public interface IPlanet
{
    void displayStats();
    double surfaceGravity();
    double massRatio(Object planet) throws InvalidTargetObjectTypeException;
}
