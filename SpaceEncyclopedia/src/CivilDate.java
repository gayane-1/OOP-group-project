public class CivilDate
{
    private int day;
    private int month;
    private int year;

    public CivilDate(int day, int month, int year)
    {
        try
        {
            setDay(day);
            setMonth(month);
            setYear(year);
        }catch (IllegalDateException e)
        {
            System.out.println(e.getMessage());
            System.exit(0);
        }
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
    public void setDay(int day) throws IllegalDateException
    {
        if(day < 0 || day > 31)
            throw new IllegalDateException();
        else
            this.day = day;
    }
    public void setMonth(int month) throws IllegalDateException
    {
        if(month < 0 || month > 12)
            throw new IllegalDateException();
        else
            this.month = month;
    }
    public void setYear(int year) throws IllegalDateException
    {
        if(year < 0 || year > 3000)
            throw new IllegalDateException();
        else
            this.year = year;
    }
    @Override
    public String toString()
    {
        return day + "/" + month + "/" + year;
    }
}
