public class CivilDate
{
    private int day;
    private int month;
    private int year;

    public CivilDate(int day, int month, int year)
    {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getYear()
    {
        return year;
    }

    public int getDay()
    {
        return day;
    }

    public int getMonth()
    {
        return month;
    }

    @Override
    public String toString()
    {
        return day + "/" + month + "/" + year;
    }
}
