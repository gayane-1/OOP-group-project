public class DateTime
{
    private int day;
    private int month;
    private int year;
    private int hours;
    private int minutes;
    private int seconds;

    public DateTime(int day, int month, int year, int hours, int minutes, int seconds)
    {
        this.day = day;
        this.month = month;
        this.year = year;
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    @Override
    public String toString()
    {
        return day + "/" + month + "/" + year + "\n" + hours + "h " + minutes + "m " + seconds + "s ";
    }

    public int getDay()
    {
        return day;
    }

    public int getHours()
    {
        return hours;
    }

    public int getMinutes()
    {
        return minutes;
    }

    public int getMonth()
    {
        return month;
    }

    public int getSeconds()
    {
        return seconds;
    }

    public int getYear()
    {
        return year;
    }
}
