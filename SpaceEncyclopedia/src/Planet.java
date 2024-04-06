import javax.management.modelmbean.InvalidTargetObjectTypeException;

public abstract class Planet implements PlanetInterface
{
    public static final double G = 6.67300E-11;
    private double orbitsSun;
    private double spinsOnItsAxes;
    private double axisTilt;

    private double diameter;
    private double averageDistanceFromSun;
    private double orbitalSpeedAroundSun;
    private double sunRiseTosunRise;
    private double mass;
    private double volume;
    private double averageDensity;
    private double surfaceGravity;
    private double averageSurfaceTemperature;
    private double numberOfMoons;

    protected enum PlanetName
    {
        EARTH,
        MERCURY,

    }

    public Planet(double diameter, double averageDistanceFromSun, double orbitalSpeedAroundSun, double sunRiseTosunRise,
                  double mass, double volume,
                  double averageDensity, double surfaceGravity, double averageSurfaceTemperature,
                  double numberOfMoons, double orbitsSun, double axisTilt, double spinsOnItsAxes)
    {
        this.diameter = diameter;
        this.averageDistanceFromSun = averageDistanceFromSun;
        this.orbitalSpeedAroundSun = orbitalSpeedAroundSun;
        this.sunRiseTosunRise = sunRiseTosunRise;
        this.mass = mass;
        this.volume = volume;
        this.averageDensity = averageDensity;
        this.surfaceGravity = surfaceGravity;
        this.averageSurfaceTemperature = averageSurfaceTemperature;
        this.numberOfMoons = numberOfMoons;
        this.axisTilt = axisTilt;
        this.orbitsSun = orbitsSun;
        this.spinsOnItsAxes = spinsOnItsAxes;
    }

    public double getAverageDensity()
    {
        return averageDensity;
    }

    public double getDiameter()
    {
        return diameter;
    }

    public double getAverageDistanceFromSun()
    {
        return averageDistanceFromSun;
    }

    public double getOrbitalSpeedAroundSun()
    {
        return orbitalSpeedAroundSun;
    }

    public double getSpinsOnItsAxes()
    {
        return spinsOnItsAxes;
    }

    public double getSunRiseTosunRise()
    {
        return sunRiseTosunRise;
    }

    public double getAxisTilt()
    {
        return axisTilt;
    }

    public double getAverageSurfaceTemperature()
    {
        return averageSurfaceTemperature;
    }

    public double getMass()
    {
        return mass;
    }

    public double getNumberOfMoons()
    {
        return numberOfMoons;
    }
    public double getSurfaceGravity()
    {
        return surfaceGravity;
    }

    public double getVolume()
    {
        return volume;
    }
    public double getOrbitsSun(){return  orbitsSun;}

    public void displayStats()
    {
        System.out.println("This is Planet " + toString());
        System.out.println("Planet " + toString() + "'s vital statistics.");
        System.out.println("Diameter: " + getDiameter() + " m");
        System.out.println("Average Distance From Sun: " + getAverageDistanceFromSun() + " million km");
        System.out.println("Orbital Speed Around Sun: " + getOrbitalSpeedAroundSun() + " km/s");
        System.out.println("Sun Rise To Sun Rise: " + getSunRiseTosunRise() + " day(s)");
        System.out.println("Mass: " + getMass() + " kg");
        System.out.println("Volume: " + getVolume() + " Earth");
        System.out.println("Average Density: " + getAverageDensity() + "x1000 kg/m3");
        System.out.println("Surface Gravity: " + getSurfaceGravity() + "x1000 N/kg");
        System.out.println("Average Surface Temperature: " + getAverageSurfaceTemperature() + " C");
        System.out.println("Number Of Moons: " + getNumberOfMoons());
        System.out.println("Orbits Sun in : " + getOrbitsSun());
        System.out.println("Spins On Its Axis : " + getSpinsOnItsAxes());
        System.out.println("Vertical Axis Tilt : " + getAxisTilt() + " degrees");

    }

    public void compareDistanceFromSun(Object planet) throws InvalidTargetObjectTypeException
    {
        if(planet == null)
            throw new InvalidTargetObjectTypeException();

        if(!(planet instanceof Planet))
            throw new InvalidTargetObjectTypeException();

        Planet p = (Planet)planet;
        if(getAverageDistanceFromSun() > p.getAverageDistanceFromSun())
            System.out.println(toString() + " is more farther from Sun");
        else
            System.out.println(p.toString() + " is more farther from Sun");

    }

    public double surfaceGravity()
    {
        return G * getMass() / (getDiameter() * getDiameter() / 4);
    }

    public double surfaceWeight(double otherWeight)
    {
        return otherWeight * surfaceGravity();
    }
    public double massRatio(Object planet) throws InvalidTargetObjectTypeException
    {
        if(planet == null)
            throw new InvalidTargetObjectTypeException();

        if(!(planet instanceof Planet))
            throw new InvalidTargetObjectTypeException();

        Planet p = (Planet)planet;
        return getMass() / p.getMass();
    }


}

