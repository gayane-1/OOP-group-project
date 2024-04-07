import astro.practical.containers.CivilDate;
import astro.practical.containers.CivilDateTime;
import astro.practical.containers.CivilTime;
import astro.practical.containers.GreenwichSiderealTime;
import astro.practical.containers.LocalSiderealTime;
import astro.practical.containers.UniversalDateTime;
import astro.practical.containers.UniversalTime;
import astro.practical.lib.PADateTime;

public class Earth extends Planet
{
    public static final double TRACEGASES = 1.0;
    public static final double OXYGEN = 20.9;
    public static final double NITGROGEN = 78.1;
    public static final double warmerPerYear = 0.02;

    private enum Atmosphere
    {
        TROPOSPHERE,
        STRATOSPHERE,
        MESOSPHERES,
        THERMOSPHERE
    }

    public Earth()
    {
        super(12.75566E6,150,29.77286,1,
                5.976E24,1,5.52,15,1, 365.25, 23.5, 1);
    }

    /**
     * Calculates the date of Easter in a given year.
     * @param year <code>int</code> year of Easter.
     */
    public static void dateOfEaster(int year)
    {
        PADateTime paDateTime = new PADateTime();
        CivilDate date = paDateTime.getDateOfEaster(year);

        System.out.println("The date of Easter in " + year + " is " + date.day + "/" + date.month + "/" + date.year);
    }

    /**
     * Calculates the day of a given date in a year.
     * @param date <code>CivilDate</code> date.
     */
    public static void civilDateToDayNumber(CivilDate date)
    {
        PADateTime paDateTime = new PADateTime();
        int dayNumber = paDateTime.civilDateToDayNumber(date.month, date.day, date.year);

        System.out.println(dayNumber);
    }

    /**
     * Calculates civil time from decimal hours
     * @param hours <code>double</code> hours.
     * @param minutes <code>double</code> minutes.
     * @param seconds <code>double</code> seconds.
     */
    public static void civilTimeToDecimalHours(double hours, double minutes, double seconds)
    {
        PADateTime paDateTime = new PADateTime();
        double decimalHours = paDateTime.civilTimeToDecimalHours(hours, minutes, seconds);

        System.out.println(decimalHours);
    }

    /**
     * Calculates decimal hours from civil time.
     * @param decimalHours <code>double</code> decimal hours.
     */
    public static void decimalHoursToCivilTime(double decimalHours)
    {
        PADateTime paDateTime = new PADateTime();
        CivilTime civilTime = paDateTime.decimalHoursToCivilTime(decimalHours);

        System.out.println(civilTime.hours + " " + civilTime.minutes + " " + civilTime.seconds);
    }

    /**
     * Converts civil time to universal time.
     * @param dateTime <code>CivilDateTime</code> date.
     * @param zoneCorrection <code>int<code/> zone correction.
     * @param isDaylightSavings <code>boolean<code/> daylight savings.
     */
    public static void civilTimeToUniversalTime(CivilDateTime dateTime, int zoneCorrection, boolean isDaylightSavings)
    {
        PADateTime paDateTime = new PADateTime();
        UniversalDateTime universalDateTime = paDateTime.localCivilTimeToUniversalTime(dateTime.hours, dateTime.minutes,
                dateTime.seconds, isDaylightSavings, zoneCorrection, dateTime.day, dateTime.month, dateTime.year);

        System.out.println("Universal hours: " + universalDateTime.hours);
        System.out.println("Universal minutes: " + universalDateTime.minutes);
        System.out.println("Universal seconds: " + universalDateTime.seconds);
        System.out.println("Universal year: " + universalDateTime.year);
        System.out.println("Universal month: " + universalDateTime.month);
        System.out.println("Universal day: " + universalDateTime.day);
    }
    /**
     * Converts universal time to civil time.
     * @param dateTime <code>UniversalDateTime</code> date.
     * @param zoneCorrection <code>int<code/> zone correction.
     * @param isDaylightSavings <code>boolean<code/> daylight savings.
     */
    public static void universalTimeToCivilTime(UniversalDateTime dateTime, int zoneCorrection,
                                                boolean isDaylightSavings)
    {
        PADateTime paDateTime = new PADateTime();
        CivilDateTime civilDateTime = paDateTime.universalTimeToLocalCivilTime(dateTime.hours,dateTime.minutes,
                dateTime.seconds,isDaylightSavings,zoneCorrection, dateTime.day, dateTime.month, dateTime.year);

        System.out.println("Civil time hours: " + civilDateTime.hours);
        System.out.println("Civil time minutes: " + civilDateTime.minutes);
        System.out.println("Civil time seconds: " + civilDateTime.seconds);
        System.out.println("Civil time year: " + civilDateTime.year);
        System.out.println("Civil time month: " + civilDateTime.month);
        System.out.println("Civil time day: " + civilDateTime.day);
    }

    public String toString()
    {
        return PlanetName.EARTH.toString();
    }


}
