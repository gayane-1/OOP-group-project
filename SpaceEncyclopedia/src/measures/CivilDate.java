package measures;

import core.Converter;

public class CivilDate
{
    private int day;
    private int month;
    private int year;

    public CivilDate()
    {
        day = 0;
        month = 0;
        year = 0;
    }

    public CivilDate(int day, int month, int year) throws IllegalDateException
    {
            setMonth(month);
            setYear(year);
            setDay(day);
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
        if(!checkDay(day))
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

    public boolean checkDay(int day) throws IllegalDateException
    {
        if (day < 0 || day > 31)
            return false;
        if (month == 2)
        {
            if (Converter.isLeapYear(year) && day > 29)
                return false;
            else if (!Converter.isLeapYear(year) && day > 28)
                return false;
        } else if (month == 4 || month == 6 || month == 9 || month == 11)
        {
            return day <= 30;
        }
        return true;
    }
    @Override
    public String toString()
    {
        return day + "/" + month + "/" + year;
    }
}
