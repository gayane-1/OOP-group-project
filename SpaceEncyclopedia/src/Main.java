import astro.practical.containers.CivilDate;
import astro.practical.containers.CivilDateTime;
import astro.practical.containers.CivilTime;
import astro.practical.containers.GreenwichSiderealTime;
import astro.practical.containers.LocalSiderealTime;
import astro.practical.containers.UniversalDateTime;
import astro.practical.containers.UniversalTime;
import astro.practical.lib.PADateTime;
public class Main
{

    public static void main(String[] args)
    {
        Planet earth = Planet.EARTH;
        Planet mars = Planet.MARS;

        earth.calculateCoordinatesOfPlanet(new CivilDate(12,30,1999));
        earth.compareDistanceFromSun(mars);

        System.out.println();
        earth.displayStats();
    }
}
