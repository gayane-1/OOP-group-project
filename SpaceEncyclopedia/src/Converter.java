import astro.practical.containers.*;
import astro.practical.lib.PADateTime;

public class Converter
{
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
    public static int civilDateToDayNumber(CivilDate date)
    {
        PADateTime paDateTime = new PADateTime();
        int dayNumber = paDateTime.civilDateToDayNumber(date.month, date.day, date.year);

        return dayNumber;
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

        System.out.println(civilTime.toString());
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

        System.out.println(universalDateTime.toString());
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

        System.out.println(civilDateTime.toString());
    }
    public static void universalTimeToGreenwichSiderealTime(UniversalDateTime dateTime)
    {
        PADateTime paDateTime = new PADateTime();
        GreenwichSiderealTime gst = paDateTime.universalTimeToGreenwichSiderealTime(dateTime.hours, dateTime.minutes,
                                                                dateTime.seconds, dateTime.day, dateTime.month, dateTime.year);

        System.out.println(gst.toString());
    }
    public static void greenwichSiderealTimeToUniversalTime(GreenwichSiderealTime dateTime, CivilDate date)
    {
        PADateTime paDateTime = new PADateTime();
        UniversalTime udt = paDateTime.greenwichSiderealTimeToUniversalTime(dateTime.hours, dateTime.minutes,
                dateTime.seconds, date.day, date.month, date.year);

        System.out.println(udt.toString());
    }
    public static void greenwichSiderealTimeToLocalSiderealTime(GreenwichSiderealTime dateTime, double longitude)
    {
        PADateTime paDateTime = new PADateTime();
        LocalSiderealTime lst = paDateTime.greenwichSiderealTimeToLocalSiderealTime(dateTime.hours, dateTime.minutes, dateTime.seconds, longitude);

        System.out.println(lst.toString());
    }
    public static void localSiderealTimeToGreenwichSiderealTime(LocalSiderealTime dateTime, double longitude)
    {
        PADateTime paDateTime = new PADateTime();
        GreenwichSiderealTime gst = paDateTime.localSiderealTimeToGreenwichSiderealTime(dateTime.hours, dateTime.minutes, dateTime.seconds, longitude);

        System.out.println(gst.toString());
    }
}
