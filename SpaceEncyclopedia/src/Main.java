public class Main
{

    public static void main(String[] args)
    {
        Planet earth = Planet.EARTH;
        Planet mars = Planet.MARS;
        Planet mercury = Planet.MERCURY;
        Planet jupiter = Planet.JUPITER;

        System.out.println(earth.calculateCoordinatesOfPlanet(new CivilDate(22,11,1988)));
        System.out.println(jupiter.distanceOfThePlanetFromEarth(new CivilDate(22,11,1988)));
    }
}
