package core;

import measures.CivilDate;
import measures.IllegalDateException;

public enum Planet
{
        EARTH(12.75566E6,150,29.77286,1,
                5.976E24,108.321E10,5.52,15,1, 365.25,
                23.5, 1, 1.00004, 99.403308, 102.768413,
                0.016713, 1.0, 0,0,0),
        MERCURY(4.879531E6, 57.9364, 47.877984, 176, 3.303E23,  	6.083E10,
                5.43, 167, 0, 87.97, 0,
                58.65, 0.240852, 60.750646,
                77.299833,0.205633, 0.387099,
                7.004540, 48.212740, 6.74),
        VENUS(12.10388E6, 108.1479, 35, 117, 4.869E24,  	92.843E10,
                5.2, 464, 0, 224.7, 2.7,
                243, 0.615211, 88.455855,
                131.430236, 0.006778,
                0.723332, 3.394535, 76.589820, 16.92),
        MARS(6.794650E6, 228.527, 24.1402, 1.02625,
                6.421E23,  	16.312E10, 3.93, -63, 2,
                687,25.2, 1.02625, 1.880932, 240.739474,
                335.874939, 0.093396,
                1.523688, 1.849736, 49.480308, 9.36),
        JUPITER(142.984E6, 1.427E6, 9.65606, 0.42625,
                5.688E26, 143128E10, 0.69, -140, 60,
                10752.9,26.7, 0.44416667, 29.471362, 287.690033,
                92.861407, 0.055581,
                9.554747, 2.488980, 113.576139, 165.60),
        SATURN(120.535E6, 778.922, 12.8748, 0.41,
                1.9E27, 82713E10, 1.33, -110, 62,
                4332.55,3.1, 0.41375, 11.863075, 90.638185,
                14.170747, 0.048482,
                5.202561, 1.303613, 100.353142, 196.74),
        URANUS(51.117593E6, 2867.851, 6.839712, 0.7183,
                8.686E25, 6833E10, 1.32, -197, 27,
                30660,98, 0.7183, 84.039492, 271.063148,
                172.884833, 0.046321,
                19.21814, 0.773059, 73.926961, 65.80),
        NEPTUNE(49.532390E6, 4506.163, 5.47177, 0.67125,
                1.024E26, 6254E10, 1.64, -200, 13,
                60152,28.3, 0.67125, 164.79246, 282.349556,
                48.009758, 0.009003,
                30.109570, 1.770646, 131.670599, 62.2);

    public static final double G = 6.67300E-11;
    private final double orbitsSun;
    private final double spinsOnItsAxes;
    private final double axisTilt;
    private final double diameter;
    private final double averageDistanceFromSun;
    private final double orbitalSpeedAroundSun;
    private final double sunRiseTosunRise;
    private final double mass;
    private final double volume;
    private final double averageDensity;
    private final double averageSurfaceTemperature;
    private final double numberOfMoons;
    private final double period;
    private final double longitudeDegrees;
    private final double longitudePerihelionDegrees;
    private final double eccentricityOfTheOrbit;
    private final double semiMajorAxisOfTheOrbit;
    private final double inclinationOfTheOrbit;
    private final double longitudeOfTheAscendingNode;
    private final double angularDiameterAtOneAU;

     Planet(double diameter, double averageDistanceFromSun, double orbitalSpeedAroundSun, double sunRiseTosunRise,
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

    public String displayStats()
    {
        return
        ("This is Planet " + toString()) + '\n' +
        ("Planet " + toString() + "'s vital statistics.") + '\n' +
        ("Diameter: " + getDiameter() + " m") + '\n' +
        ("Average Distance From Sun: " + getAverageDistanceFromSun() + " million km") + '\n' +
        ("Orbital Speed Around Sun: " + getOrbitalSpeedAroundSun() + " km/s") + '\n' +
        ("Sun Rise To Sun Rise: " + getSunRiseTosunRise() + " day(s)")+ '\n' +
        ("Mass: " + getMass() + " kg") + '\n' +
        ("Volume: " + getVolume() + " km3") + '\n' +
        ("Average Density: " + getAverageDensity() + "x1000 kg/m3") + '\n' +
        ("Surface Gravity: " + surfaceGravity() + " N/kg") + '\n' +
        ("Average Surface Temperature: " + getAverageSurfaceTemperature() + " C") + '\n' +
        ("Number Of Moons: " + getNumberOfMoons()) + '\n' +
        ("Orbits Sun in: " + getOrbitsSun() + " days") + '\n' +
        ("Spins On Its Axis: " + getSpinsOnItsAxes() + " days") + '\n' +
        ("Vertical Axis Tilt: " + getAxisTilt() + " degrees") + '\n' +
        ("Period: " + getPeriod() + " tropical years") + '\n' +
        ("Longitude at Epoch: " + getLongitudeDegrees() + " degrees") + '\n' +
        ("Longitude of The Perihelion: " + getLongitudePerihelionDegrees() + " degrees") + '\n' +
        ("Eccentricity of The Orbit: " + getEccentricityOfTheOrbit()) + '\n' +
        ("Semi-major Axis of The Orbit: " + getSemiMajorAxisOfTheOrbit() + " AU") + '\n' +
        ("Inclination of The Orbit: " + getInclinationOfTheOrbit() + " degrees") + '\n' +
        ("Longitude of The Ascending Node: " + getLongitudeOfTheAscendingNode() + " degrees") + '\n' +
        ("Angular Diameter: " + getAngularDiameterAtOneAU() + " arcseconds") + '\n';

    }
    public static String info()
    {
        return "    Anomaly: " + '\n' +
                " True anomaly is the angle, V, between lines " +
                "drawn from the centre of mass (near the centre" +
                " of the " + "Sun), to a planet, and to the " +
                "perihelion point, where the planet comes closest to the Sun. " +
                "The mean anomaly is the angle between lines drawn " +
                "from the Sun to the perihelion point and to a point " +
                "moving in the orbit at a uniform rate " +
                "corresponding to the period of revolution of " +
                "the planet" + '\n' +
                "   Vernal equinox: " + '\n' +
                " Two moments in the year when the Sun is exactly " +
                "above the Equator and day and night are of equal length" + '\n' +
                "   Heliocentric Longitude:  " + '\n' +
                "A coordinate that gives the position " +
                "of an object around the ecliptic as it " +
                "would be seen from " + "the centre of the Sun. " +
                "It is measured in degrees from 0° to 360° " +
                "clockwise along the ecliptic," +
                " starting at the vernal equinox." + '\n' +
                "   Longitude at Epoch: " + '\n' +
                "True longitude at epoch is the angle " +
                "between the reference direction " +
                "(usually the vernal equinox)" +
                " and the satellite's position. It is measured " +
                "from the reference direction to the ascending node " +
                "(if one exists) in the reference plane and " +
                "then from the ascending node to the satellite's position" +
                " in the plane of orbit. " + '\n' +
                "   Eccentricity of The Orbit: " + '\n' +
                "Eccentricity is a measure of how " +
                "non-circular the orbit of a body is" + '\n' +
                "   Semi Major Axis of The Planet: " + '\n' +
                "The semi-major axis of an ellipse is " +
                "defined as the longest radius of the ellipse" + '\n' +
                "   Angular Diameter: " + '\n' +
                "The angular diameter is an angular distance " +
                "describing how large a sphere or circle appears " +
                "from a given point of view." + '\n';

    }
    public String compareDistanceFromSun(Planet planet)
    {
        if(planet == null)
            throw new NullPointerException();

        if(getAverageDistanceFromSun() > planet.getAverageDistanceFromSun())
            return toString() + " is more farther from Sun";
        else
           return planet.toString() + " is more farther from Sun";

    }

    public double surfaceGravity()
    {
        return G * getMass() / (getDiameter() * getDiameter() / 4);
    }

    public double surfaceWeight(double otherWeight)
    {
        return otherWeight * surfaceGravity() / EARTH.surfaceGravity();
    }
    public double massRatio(Planet planet)
    {
        if(planet == null)
            throw new NullPointerException();

        return getMass() / planet.getMass();
    }

    public int calculateDaysFromNow(CivilDate date) throws IllegalDateException
    {
        int day =  Converter.civilDateToDayNumber(date);
        CivilDate currentDate = new CivilDate(1,1,2024);
        int daysFromCurrentYear = currentDate.getYear();

        return Math.abs(day - (daysFromCurrentYear - date.getYear()) * 365);
    }
    public double meanAnomaly(CivilDate date) throws IllegalDateException
    {
        int days = calculateDaysFromNow(date);
        double meanAnomaly = (360 / 365.242191) * (days / getPeriod()) + getLongitudeDegrees() -
            getLongitudePerihelionDegrees();

        while (Math.abs(meanAnomaly) >= 360)
        {
            if(meanAnomaly < 0)
                meanAnomaly += 360;
            else
                meanAnomaly -= 360;
        }
        return meanAnomaly;

    }
    public double heliocentricLongitude(CivilDate date) throws IllegalDateException
    {

        double meanAnomaly = meanAnomaly(date);

        double longitude = meanAnomaly + getLongitudePerihelionDegrees() + (360 / Math.PI) * getEccentricityOfTheOrbit()
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
    public double ratioToEarthsOrbit(CivilDate date) throws IllegalDateException
    {

        double ratio = getSemiMajorAxisOfTheOrbit() * (1 - getEccentricityOfTheOrbit() * getEccentricityOfTheOrbit()) /
                                    (1 + getEccentricityOfTheOrbit() * Math.cos(heliocentricLongitude(date) - getLongitudePerihelionDegrees()));

        return ratio;

    }
    public double calculateCoordinatesOfPlanet(CivilDate date) throws IllegalDateException
    {

        double l = heliocentricLongitude(date);
        double heliocentricLatitude = Math.asin(Math.sin(l - getLongitudeOfTheAscendingNode()) * Math.sin(getInclinationOfTheOrbit()));

        double y = Math.sin(l - getLongitudeOfTheAscendingNode()) * Math.cos(getInclinationOfTheOrbit());
        double x = Math.cos(l - getLongitudeOfTheAscendingNode());

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
        double longitudeNew = angle + getLongitudeOfTheAscendingNode();
        double ratioNew = ratioToEarthsOrbit(date) * Math.cos(heliocentricLatitude);

        double a = Math.atan((ratioNew * Math.sin(EARTH.heliocentricLongitude(date) - longitudeNew))
                                        / EARTH.ratioToEarthsOrbit(date) -
                ratioNew * Math.cos(heliocentricLongitude(date) - - longitudeNew));

        double geocentricLongitude = 180 + heliocentricLongitude(date) + a;
        while (Math.abs(geocentricLongitude) >= 360)
        {
            if(geocentricLongitude < 0)
                geocentricLongitude += 360;
            else
                geocentricLongitude -= 360;
        }
        double geocentricLatitude = Math.atan(ratioNew * Math.tan(heliocentricLatitude) *
                Math.sin(geocentricLongitude - longitudeNew) / EARTH.ratioToEarthsOrbit(date) *
                Math.sin(longitudeNew - EARTH.heliocentricLongitude(date)));

        System.out.println("Geocentric Longitude in Degrees alfa: " + geocentricLongitude);

        return geocentricLongitude;
    }
    public double distanceOfThePlanetFromEarth(CivilDate date) throws IllegalDateException
    {
        double earthRatio = EARTH.ratioToEarthsOrbit(date);
        double planetRatio = ratioToEarthsOrbit(date);
        double distanceAU = Math.sqrt(earthRatio * earthRatio + planetRatio * planetRatio -
                2 * earthRatio * planetRatio * Math.cos(heliocentricLongitude(date) - EARTH.heliocentricLongitude(date)));

        double angularDiameter = angularDiameterAtOneAU / distanceAU;

        return angularDiameter;
    }
}
