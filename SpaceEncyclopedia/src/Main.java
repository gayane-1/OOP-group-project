import javax.management.modelmbean.InvalidTargetObjectTypeException;
import astro.practical.containers.CivilDate;
import astro.practical.containers.CivilDateTime;
import astro.practical.containers.CivilTime;
import astro.practical.containers.GreenwichSiderealTime;
import astro.practical.containers.LocalSiderealTime;
import astro.practical.containers.UniversalDateTime;
import astro.practical.containers.UniversalTime;
import astro.practical.lib.PADateTime;
import astro.practical.lib.PAUtil;
import astro.practical.test.TestLib;
import astro.practical.types.PAWarningFlag;
public class Main
{

    public static void main(String[] args)
    {
        Planet e = new Earth();
        Planet m = new Mercury();
        Planet v = new Venus();

        double mass = 175 / e.surfaceGravity();


        System.out.println(e.surfaceWeight(mass));
        System.out.println(m.surfaceWeight(mass));
        System.out.println(v.surfaceWeight(mass));

        v.displayStats();
        System.out.println();
        e.displayStats();

        Earth.dateOfEaster(2024);
        Earth.civilDateToDayNumber(new CivilDate(11,22,1988));
        Earth.civilTimeToDecimalHours(12,30,23);
        Earth.decimalHoursToCivilTime(12.50);
        Earth.civilTimeToUniversalTime(new CivilDateTime(9,37,12,4,9,2003),
                4,true);
        System.out.println();
        Earth.universalTimeToCivilTime(new UniversalDateTime(4,37,12,4,9,2003),
                4,false);
    }
}
