public class Angle
{
    private double hours;
    private double minutes;
    private double seconds;
    public Angle(double hours, double minutes, double seconds)
    {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public double getHours()
    {
        return hours;
    }

    public double getMinutes()
    {
        return minutes;
    }

    public double getSeconds()
    {
        return seconds;
    }

    @Override
    public String toString()
    {
        return hours + "h " + minutes + "m " + seconds + "s ";
    }
}
