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
        Converter.universalTimeToGreenwichSiderealTime(new UniversalDateTime(12,23,40,10,10,2001));
        Converter.universalTimeToCivilTime(new UniversalDateTime(12,30,21,10,12,2000),4,true);
        Converter.civilTimeToUniversalTime(new CivilDateTime(12,30,20,10,2,1100),4,false);
        Converter.greenwichSiderealTimeToUniversalTime(new GreenwichSiderealTime(13,40,22.31),new CivilDate(10,10,2001));
        Converter.greenwichSiderealTimeToLocalSiderealTime(new GreenwichSiderealTime(13,40,22.31), earth.getLongitudeDegrees());
    }
}
