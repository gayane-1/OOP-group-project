package core;

import measures.*;

public class Converter
{
    /**
     * Convert an measures.Angle (degrees, minutes, and seconds) to Decimal Degrees
     */
    public static double angleToDecimalDegrees(double degrees, double minutes, double seconds)
    {
        var a = Math.abs(seconds) / 60;
        var b = (Math.abs(minutes) + a) / 60;
        var c = Math.abs(degrees) + b;
        var d = (degrees < 0 || minutes < 0 || seconds < 0) ? -c : c;

        return d;
    }
    public static Angle decimalDegreesToAngle(double decimalDegrees)
    {
        double unsignedDecimal = Math.abs(decimalDegrees);
        double totalSeconds = unsignedDecimal * 3600;
        double seconds2DP = Math.ceil(totalSeconds % 60);
        double correctedSeconds = (seconds2DP == 60) ? 0 : seconds2DP;
        double correctedRemainder = (seconds2DP == 60) ? totalSeconds + 60 : totalSeconds;
        double minutes = Math.floor(correctedRemainder / 60) % 60;
        double unsignedDegrees = Math.floor(correctedRemainder / 3600);
        double signedDegrees = (decimalDegrees < 0) ? -1 * unsignedDegrees : unsignedDegrees;

        return new Angle(signedDegrees, minutes, Math.floor(correctedSeconds));
    }
    /**
     * Return the hour part of a Decimal Hours
     */
    public static int decimalHoursHour(double decimalHours)
    {
        double a = Math.abs(decimalHours);
        double b = a * 3600;
        double c = Math.ceil(b - 60 * Math.floor(b / 60));
        double e = (c == 60) ? b + 60 : b;

        return (decimalHours < 0) ? (int) -(Math.floor(e / 3600)) : (int) Math.floor(e / 3600);
    }
    /**
     * Return the minutes part of a Decimal Hours
     */
    public static int decimalHoursMinute(double decimalHours)
    {
        double a = Math.abs(decimalHours);
        double b = a * 3600;
        double c = Math.ceil(b - 60 * Math.floor(b / 60));
        double e = (c == 60) ? b + 60 : b;

        return (int) Math.floor(e / 60) % 60;
    }
    /**
     * Return the seconds part of a Decimal Hours
     */
    public static double decimalHoursSecond(double decimalHours)
    {
        double a = Math.abs(decimalHours);
        double b = a * 3600;
        double c = Math.ceil(b - 60 * Math.floor(b / 60));
        double d = (c == 60) ? 0 : c;

        return d;
    }
    /**
     * Gets the date of Easter for the year specified.
     */
    public static CivilDate getDateOfEaster(int inputYear) throws IllegalDateException
    {
        double year = inputYear;

        double a = year % 19;
        double b = Math.floor(year / 100);
        double c = year % 100;
        double d = Math.floor(b / 4);
        double e = b % 4;
        double f = Math.floor((b + 8) / 25);
        double g = Math.floor((b - f + 1) / 3);
        double h = ((19 * a) + b - d - g + 15) % 30;
        double i = Math.floor(c / 4);
        double k = c % 4;
        double l = (32 + 2 * (e + i) - h - k) % 7;
        double m = Math.floor((a + (11 * h) + (22 * l)) / 451);
        double n = Math.floor((h + l - (7 * m) + 114) / 31);
        double p = (h + l - (7 * m) + 114) % 31;

        int day = (int)(p + 1);
        double month = n;

        return new CivilDate( day, (int)month, (int) year);
    }
    /**
     * Calculate day number for a date.
     */
    public static int civilDateToDayNumber(CivilDate date) throws IllegalDateException
    {
        int month  = date.getMonth();
        int year  = date.getYear();
        int day  = date.getDay();

        if (date.getMonth() <= 2)
        {
            month = month - 1;
            month = isLeapYear(year) ? month * 62 : month * 63;
            month = (int) Math.floor((double) month / 2);
        } else
        {
            month = (int) Math.floor(((double) month + 1) * 30.6);
            month = (isLeapYear(year)) ? month - 62 : month - 63;
        }

        return month + day;
    }

    /**
     * Determine if year is a leap year.
     */
    public static boolean isLeapYear(int inputYear) throws IllegalDateException
    {
        double year = inputYear;

        if (year % 4 == 0)
        {
            if (year % 100 == 0)
                return (year % 400 == 0);
            else
                return true;
        } else
            return false;
    }

    /**
     * Convert Civil measures.Time (hours,minutes,seconds) to Decimal Hours
     */
    public static double civilTimeToDecimalHours(double hours, double minutes, double seconds)
    {
        double fHours = hours;
        double fMinutes = minutes;
        double fSeconds = seconds;

        double a = Math.abs(fSeconds) / 60;
        double b = (Math.abs(fMinutes) + a) / 60;
        double c = Math.abs(fHours) + b;

        return (fHours < 0 || fMinutes < 0 || fSeconds < 0) ? -c : c;
    }
    /**
     * Convert Decimal Hours to Civil measures.Time (hours,minutes,seconds)
     */
    public static Time decimalHoursToCivilTime(double decimalHours)
    {
        double hours = decimalHoursHour(decimalHours);
        double minutes = decimalHoursMinute(decimalHours);
        double seconds = decimalHoursSecond(decimalHours);

        return new Time(hours, minutes, seconds);
    }

    /**
     * Convert a Greenwich Date/Civil Date (day,month,year) to Julian Date
     */
    public static double civilDateToJulianDate(CivilDate date) throws IllegalDateException
    {
        double fDay =  date.getDay();
        double fMonth = date.getMonth();
        double fYear =  date.getYear();

        double y = (fMonth < 3) ? fYear - 1 : fYear;
        double m = (fMonth < 3) ? fMonth + 12 : fMonth;

        double b;

        if (fYear > 1582)
        {
            double a = Math.floor(y / 100);
            b = 2 - a + Math.floor(a / 4);
        } else
        {
            if (fYear == 1582 && fMonth > 10)
            {
                double a = Math.floor(y / 100);
                b = 2 - a + Math.floor(a / 4);
            } else
            {
                if (fYear == 1582 && fMonth == 10 && fDay >= 15)
                {
                    double a = Math.floor(y / 100);
                    b = 2 - a + Math.floor(a / 4);
                } else
                    b = 0;
            }
        }

        double c = (y < 0) ? Math.floor(((365.25 * y) - 0.75)) : Math.floor(365.25 * y);
        double d = Math.floor(30.6001 * (m + 1.0));

        return b + c + d + fDay + 1720994.5;
    }
    /**
     * Returns the day part of a Julian Date
     */
    public static double julianDateDay(double julianDate)
    {
        double i = Math.floor(julianDate + 0.5);
        double f = julianDate + 0.5 - i;
        double a = Math.floor((i - 1867216.25) / 36524.25);
        double b = (i > 2299160) ? i + 1 + a - Math.floor(a / 4) : i;
        double c = b + 1524;
        double d = Math.floor((c - 122.1) / 365.25);
        double e = Math.floor(365.25 * d);
        double g = Math.floor((c - e) / 30.6001);

        return c - e + f - Math.floor(30.6001 * g);
    }
    /**
     * Returns the month part of a Julian Date
     */
    public static int julianDateMonth(double julianDate)
    {
        double i = Math.floor(julianDate + 0.5);
        double a = Math.floor((i - 1867216.25) / 36524.25);
        double b = (i > 2299160) ? i + 1 + a - Math.floor(a / 4) : i;
        double c = b + 1524;
        double d = Math.floor((c - 122.1) / 365.25);
        double e = Math.floor(365.25 * d);
        double g = Math.floor((c - e) / 30.6001);

        double returnValue = (g < 13.5) ? g - 1 : g - 13;

        return (int) returnValue;
    }

    /**
     * Returns the year part of a Julian Date
     */
    public static int julianDateYear(double julianDate)
    {
        double i = Math.floor(julianDate + 0.5);
        double a = Math.floor((i - 1867216.25) / 36524.25);
        double b = (i > 2299160) ? i + 1.0 + a - Math.floor(a / 4.0) : i;
        double c = b + 1524;
        double d = Math.floor((c - 122.1) / 365.25);
        double e = Math.floor(365.25 * d);
        double g = Math.floor((c - e) / 30.6001);
        double h = (g < 13.5) ? g - 1 : g - 13;

        double returnValue = (h > 2.5) ? d - 4716 : d - 4715;

        return (int) returnValue;
    }
    /**
     * Convert a Civil measures.Time (hours,minutes,seconds) to Decimal Hours
     */
    public static double hmsToDH(double hours, double minutes, double seconds)
    {
        double fHours = hours;
        double fMinutes = minutes;
        double fSeconds = seconds;

        double a = Math.abs(fSeconds) / 60;
        double b = (Math.abs(fMinutes) + a) / 60;
        double c = Math.abs(fHours) + b;

        return (fHours < 0 || fMinutes < 0 || fSeconds < 0) ? -c : c;
    }

    /**
     * Convert local Civil measures.Time to Universal measures.Time
     */
    public static DateTime localCivilTimeToUniversalTime(double lctHours, double lctMinutes, double lctSeconds,
                                                  boolean isDaylightSavings, int zoneCorrection, double localDay, int localMonth, int localYear) throws IllegalDateException
    {
        double lct = civilTimeToDecimalHours(lctHours, lctMinutes, lctSeconds);

        int daylightSavingsOffset = (isDaylightSavings) ? 1 : 0;

        double utInterim = lct - daylightSavingsOffset - zoneCorrection;
        double gdayInterim = localDay + (utInterim / 24);

        double jd = civilDateToJulianDate(new CivilDate((int)gdayInterim, localMonth, localYear));

        double gDay = julianDateDay(jd);
        int gMonth = julianDateMonth(jd);
        int gYear = julianDateYear(jd);

        double ut = 24 * (gDay - Math.floor(gDay));

        return new DateTime((int) Math.floor(gDay), gMonth, gYear, decimalHoursHour(ut), decimalHoursMinute(ut),
                (int)decimalHoursSecond(ut));
    }

    /**
     * Convert Universal measures.Time to local Civil measures.Time
     */
    public static DateTime universalTimeToLocalCivilTime(double utHours, double utMinutes, double utSeconds,
                                                       boolean isDaylightSavings, int zoneCorrection, int gwDay, int gwMonth, int gwYear)
                                                    throws IllegalDateException
    {
        int dstValue = (isDaylightSavings) ? 1 : 0;
        double ut = hmsToDH(utHours, utMinutes, utSeconds);
        double zoneTime = ut + zoneCorrection;
        double localTime = zoneTime + dstValue;
        double localJDPlusLocalTime = civilDateToJulianDate(new CivilDate(gwDay, gwMonth, gwYear)) + (localTime / 24);
        double localDay = julianDateDay(localJDPlusLocalTime);
        double integerDay = Math.floor(localDay);
        int localMonth = julianDateMonth(localJDPlusLocalTime);
        int localYear = julianDateYear(localJDPlusLocalTime);

        double lct = 24 * (localDay - integerDay);

        return new DateTime(decimalHoursHour(lct), decimalHoursMinute(lct),
                (int)decimalHoursSecond(lct), (int) integerDay, localMonth, localYear);
    }

    /**
     * Convert Universal measures.Time to Greenwich Sidereal measures.Time
     */
    public static Time universalTimeToGreenwichSiderealTime(double utHours, double utMinutes,
                                                     double utSeconds, double gwDay, int gwMonth, int gwYear) throws IllegalDateException
    {
        double jd = civilDateToJulianDate(new CivilDate((int)gwDay, gwMonth, gwYear));
        double s = jd - 2451545;
        double t = s / 36525;
        double t01 = 6.697374558 + (2400.051336 * t) + (0.000025862 * t * t);
        double t02 = t01 - (24.0 * Math.floor(t01 / 24));
        double ut = hmsToDH(utHours, utMinutes, utSeconds);
        double a = ut * 1.002737909;
        double gst1 = t02 + a;
        double gst2 = gst1 - (24.0 * Math.floor(gst1 / 24));

        double gstHours = decimalHoursHour(gst2);
        double gstMinutes = decimalHoursMinute(gst2);
        double gstSeconds = decimalHoursSecond(gst2);

        return new Time(gstHours, gstMinutes, gstSeconds);
    }

    /**
     * Convert Greenwich Sidereal measures.Time to Universal measures.Time
     */
    public static Time greenwichSiderealTimeToUniversalTime(double gstHours, double gstMinutes, double gstSeconds,
                                                              double gwDay, int gwMonth, int gwYear) throws IllegalDateException
    {
        double jd = civilDateToJulianDate(new CivilDate((int)gwDay, gwMonth, gwYear));
        double s = jd - 2451545;
        double t = s / 36525;
        double t1 = 6.697374558 + (2400.051336 * t) + (0.000025862 * t * t);
        double t2 = t1 - (24 * Math.floor(t1 / 24));
        double gstHours1 = hmsToDH(gstHours, gstMinutes, gstSeconds);

        double a = gstHours1 - t2;
        double b = a - (24 * Math.floor(a / 24));
        double ut = b * 0.9972695663;
        double utHours = decimalHoursHour(ut);
        double utMinutes = decimalHoursMinute(ut);
        double utSeconds = decimalHoursSecond(ut);

        if(ut < 0.065574)
        {
            throw new IllegalDateException();
        }

        return new Time(utHours, utMinutes, utSeconds);
    }

    /**
     * Convert Greenwich Sidereal measures.Time to Local Sidereal measures.Time
     */
    public static Time greenwichSiderealTimeToLocalSiderealTime(double gstHours, double gstMinutes,
                                                                      double gstSeconds, double geographicalLongitude)
    {
        double gst = hmsToDH(gstHours, gstMinutes, gstSeconds);
        double offset = geographicalLongitude / 15;
        double lstHours1 = gst + offset;
        double lstHours2 = lstHours1 - (24 * Math.floor(lstHours1 / 24));

        double lstHours = decimalHoursHour(lstHours2);
        double lstMinutes = decimalHoursMinute(lstHours2);
        double lstSeconds = decimalHoursSecond(lstHours2);

        return new Time(lstHours, lstMinutes, lstSeconds);
    }

    /**
     * Convert Local Sidereal measures.Time to Greenwich Sidereal measures.Time
     */
    public static Time localSiderealTimeToGreenwichSiderealTime(double lstHours, double lstMinutes,
                                                                          double lstSeconds, double geographicalLongitude)
    {
        var gst = hmsToDH(lstHours, lstMinutes, lstSeconds);
        var longHours = geographicalLongitude / 15;
        var gst1 = gst - longHours;
        var gst2 = gst1 - (24 * Math.floor(gst1 / 24));

        var gstHours = decimalHoursHour(gst2);
        var gstMinutes = decimalHoursMinute(gst2);
        var gstSeconds = decimalHoursSecond(gst2);

        return new Time(gstHours, gstMinutes, gstSeconds);
    }
}
