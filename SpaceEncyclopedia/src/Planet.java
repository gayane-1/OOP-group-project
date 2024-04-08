import astro.practical.containers.CivilDate;

public abstract class Planet implements IPlanet
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
    private double averageSurfaceTemperature;
    private double numberOfMoons;
    private double period;
    private double longitudeDegrees;
    private double longitudePerihelionDegrees;
    private double eccentricityOfTheOrbit;
    private double semiMajorAxisOfTheOrbit;
    private double inclinationOfTheOrbit;
    private double longitudeOfTheAscendingNode;
    private double angularDiameterAtOneAU;
    protected enum PlanetName
    {
        EARTH,
        MERCURY,
        VENUS,
        MARS,
        JUPITER,
        SATURN,
        URANUS,
        NEPTUNE

    }

    public Planet(double diameter, double averageDistanceFromSun, double orbitalSpeedAroundSun, double sunRiseTosunRise,
                  double mass, double volume, double averageDensity, double averageSurfaceTemperature,
                  double numberOfMoons, double orbitsSun, double axisTilt, double spinsOnItsAxes,
                  double period, double longitudeDegrees, double longitudePerihelionDegrees, double eccentricityOfTheOrbit,
                  double semiMajorAxisOfTheOrbit, double inclinationOfTheOrbit, double longitudeOfTheAscendingNode, double angularDiameterAtOneAU)
    {
        this.diameter = diameter;
        this.averageDistanceFromSun = averageDistanceFromSun;
        this.orbitalSpeedAroundSun = orbitalSpeedAroundSun;
        this.sunRiseTosunRise = sunRiseTosunRise;
        this.mass = mass;
        this.volume = volume;
        this.averageDensity = averageDensity;
        this.averageSurfaceTemperature = averageSurfaceTemperature;
        this.numberOfMoons = numberOfMoons;
        this.axisTilt = axisTilt;
        this.orbitsSun = orbitsSun;
        this.spinsOnItsAxes = spinsOnItsAxes;
        this.period = period;
        this.longitudeDegrees = longitudeDegrees;
        this.longitudePerihelionDegrees = longitudePerihelionDegrees;
        this.eccentricityOfTheOrbit = eccentricityOfTheOrbit;
        this.semiMajorAxisOfTheOrbit = semiMajorAxisOfTheOrbit;
        this.inclinationOfTheOrbit = inclinationOfTheOrbit;
        this.angularDiameterAtOneAU = angularDiameterAtOneAU;
        this.longitudeOfTheAscendingNode = longitudeOfTheAscendingNode;
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

    public double getVolume()
    {
        return volume;
    }
    public double getOrbitsSun(){return  orbitsSun;}
    public double getPeriod(){return period;}
    public double getLongitudeDegrees(){return longitudeDegrees;}
    public double getLongitudePerihelionDegrees(){return longitudePerihelionDegrees;}

    public double getEccentricityOfTheOrbit()
    {
        return eccentricityOfTheOrbit;
    }

    public double getSemiMajorAxisOfTheOrbit()
    {
        return semiMajorAxisOfTheOrbit;
    }

    public double getInclinationOfTheOrbit()
    {
        return inclinationOfTheOrbit;
    }

    public double getAngularDiameterAtOneAU()
    {
        return angularDiameterAtOneAU;
    }

    public double getLongitudeOfTheAscendingNode()
    {
        return longitudeOfTheAscendingNode;
    }

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
        System.out.println("Surface Gravity: " + surfaceGravity() + " N/kg");
        System.out.println("Average Surface Temperature: " + getAverageSurfaceTemperature() + " C");
        System.out.println("Number Of Moons: " + getNumberOfMoons());
        System.out.println("Orbits Sun in: " + getOrbitsSun() + " days");
        System.out.println("Spins On Its Axis: " + getSpinsOnItsAxes() + " days");
        System.out.println("Vertical Axis Tilt: " + getAxisTilt() + " degrees");
        System.out.println("Period: " + getPeriod() + " tropical years");
        System.out.println("Longitude at Epoch: " + getLongitudeDegrees() + " degrees");
        System.out.println("Longitude of The Perihelion: " + getLongitudePerihelionDegrees() + " degrees");
        System.out.println("Eccentricity of The Orbit: " + getEccentricityOfTheOrbit());
        System.out.println("Semi-major Axis of The Orbit: " + getSemiMajorAxisOfTheOrbit() + " AU");
        System.out.println("Inclination of The Orbit: " + getInclinationOfTheOrbit() + " degrees");
        System.out.println("Longitude of The Ascending Node: " + getLongitudeOfTheAscendingNode() + " degrees");
        System.out.println("Angular Diameter: " + getAngularDiameterAtOneAU() + " arcseconds");

    }

    public void compareDistanceFromSun(Object planet) throws IllegalArgumentException
    {
        if(planet == null)
            throw new NullPointerException();

        if(!(planet instanceof Planet))
            throw new IllegalArgumentException();

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
    public double massRatio(Object planet) throws IllegalArgumentException, NullPointerException
    {
        if(planet == null)
            throw new NullPointerException();

        if(!(planet instanceof Planet))
            throw new IllegalArgumentException();

        Planet p = (Planet)planet;
        return getMass() / p.getMass();
    }

    private static int calculateDaysFromNow(CivilDate date)
    {
        int day =  Earth.civilDateToDayNumber(date);
        CivilDate currentDate = new CivilDate(1,1,2024);
        int daysFromCurrentYear = currentDate.year;

        return day - (daysFromCurrentYear - date.year) * 365;
    }
    private static double meanAnomaly(CivilDate date, Object planet) throws IllegalArgumentException, NullPointerException
    {
        if(planet == null)
            throw new NullPointerException();
        if(!(planet instanceof Planet))
            throw new IllegalArgumentException();

        Planet p = (Planet) planet;
        int days = calculateDaysFromNow(date);
        double meanAnomaly = (360 / 365.242191) * (days / p.getPeriod()) + p.getLongitudeDegrees() -
            p.getLongitudePerihelionDegrees();

        while (Math.abs(meanAnomaly) >= 360)
        {
            if(meanAnomaly < 0)
                meanAnomaly += 360;
            else
                meanAnomaly -= 360;
        }
        return meanAnomaly;

    }
    private static double heliocentricLongitude(CivilDate date, Object planet) throws IllegalArgumentException, NullPointerException
    {
        if(planet == null)
            throw new NullPointerException();
        if(!(planet instanceof Planet))
            throw new IllegalArgumentException();

        Planet p = (Planet) planet;
        double meanAnomaly = meanAnomaly(date, p);

        double longitude = meanAnomaly + p.getLongitudePerihelionDegrees() + (360 / Math.PI) * p.getEccentricityOfTheOrbit()
                                                                * Math.sin(meanAnomaly);

        while (Math.abs(longitude) >= 360)
        {
            if(longitude < 0)
                longitude += 360;
            else
                longitude -= 360;
        }
        return longitude;
    }
    private static double ratioToEarthsOrbit(CivilDate date, Object planet) throws IllegalArgumentException, NullPointerException
    {
        if(planet == null)
            throw new NullPointerException();
        if(!(planet instanceof Planet))
            throw new IllegalArgumentException();

        Planet p = (Planet) planet;
        double ratio = p.getSemiMajorAxisOfTheOrbit() * (1 - p.getEccentricityOfTheOrbit() * p.getEccentricityOfTheOrbit()) /
                                    (1 + p.getEccentricityOfTheOrbit() * Math.cos(heliocentricLongitude(date,p) - p.getLongitudePerihelionDegrees()));

        return ratio;

    }
    public static void calculateCoordinatesOfPlanet(CivilDate date, Object planet) throws IllegalArgumentException, NullPointerException
    {
        if(planet == null)
            throw new NullPointerException();
        if(!(planet instanceof Planet))
            throw new IllegalArgumentException();

        Planet p = (Planet) planet;
        double l = p.heliocentricLongitude(date, p);
        double heliocentricLatitude = Math.asin(Math.sin(l - p.getLongitudeOfTheAscendingNode()) * Math.sin(p.getInclinationOfTheOrbit()));

        double y = Math.sin(l - p.getLongitudeOfTheAscendingNode()) * Math.cos(p.getInclinationOfTheOrbit());
        double x = Math.cos(l - p.getLongitudeOfTheAscendingNode());

        double angle = Math.atan(y / x);

        if(y > 0 && x < 0)
            angle += 180;
        else if(y < 0 && x > 0)
            angle += 360;
        else if(y < 0 && x < 0)
        {
            angle -= 270;
            angle = Math.abs(angle);
        }
        else if(y > 0 && x > 0)
        {
            angle -= 90;
            angle = Math.abs(angle);
        }
        double longitudeNew = angle + p.getLongitudeOfTheAscendingNode();
        double ratioNew = ratioToEarthsOrbit(date,p) * Math.cos(heliocentricLatitude);

        double a = Math.atan((ratioNew * Math.sin(heliocentricLongitude(date, new Earth()) - longitudeNew))
                                        / ratioToEarthsOrbit(date, new Earth()) -
                ratioNew * Math.cos(heliocentricLongitude(date, new Earth()) - - longitudeNew));

        double geocentricLongitude = 180 + heliocentricLongitude(date, new Earth()) + a;
        while (Math.abs(geocentricLongitude) >= 360)
        {
            if(geocentricLongitude < 0)
                geocentricLongitude += 360;
            else
                geocentricLongitude -= 360;
        }
        double geocentricLatitude = Math.atan(ratioNew * Math.tan(heliocentricLatitude) *
                Math.sin(geocentricLongitude - longitudeNew) / ratioToEarthsOrbit(date, new Earth()) *
                Math.sin(longitudeNew - heliocentricLongitude(date, new Earth())));

        System.out.println("Geocentric Longitude in Degrees alfa: " + geocentricLongitude);
        System.out.println("Geocentric Latitude in Degrees betta: " + geocentricLatitude);
    }
}

