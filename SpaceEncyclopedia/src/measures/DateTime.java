package measures;

public class DateTime extends CivilDate
{
    private int hours;
    private int minutes;
    private int seconds;

    public DateTime(int day, int month, int year, int hours, int minutes, int seconds) throws IllegalDateException
    {
        super(day, month, year);
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    @Override
    public String toString()
    {
        return super.getDay() + "/" + super.getMonth() + "/" + super.getYear() + "\n" + hours + "h " + minutes + "m " + seconds + "s ";
    }

    public int getHours()
    {
        return hours;
    }

    public int getMinutes()
    {
        return minutes;
    }


    public int getSeconds()
    {
        return seconds;
    }

}
