/*----------------------------------------------------------------------------------------------------------------------
    DateTime sınıfı
    TODO:
    1. Rasgele tarih zaman üreten overload metotlar ekleyiniz
    2. Daha farklı toXXXString metotlarını ekleyiniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util.datetime;

import java.util.Calendar;
import java.util.Random;

public class DateTime {
    private final Date m_date;
    private final Time m_time;

    public static DateTime randomDateTime()
    {
        Random r = new Random();
        return new DateTime(Date.randomDate(r), Time.randomTime(r));
    }

    public static DateTime randomDateTime(Random r)
    {
        return new DateTime(Date.randomDate(r), Time.randomTime(r));
    }

    public DateTime() //Kodlar önemsiz
    {
        Calendar now = Calendar.getInstance();

        m_date = new Date(now.get(Calendar.DAY_OF_MONTH), now.get(Calendar.MONTH) + 1, now.get(Calendar.YEAR));
        m_time = new Time(now.get(Calendar.HOUR), now.get(Calendar.MINUTE),
                now.get(Calendar.SECOND), now.get(Calendar.MILLISECOND));
    }

    public DateTime(Date date, Time time)
    {
        this(date.getDay(), date.getMonthValue(), date.getYear(),
                time.getHour(), time.getMinute(), time.getSecond(), time.getMillisecond());
    }

    public DateTime(int day, int month, int year)
    {
        this(day, month, year, 0, 0);
    }

    public DateTime(int day, int month, int year, int hour, int minute)
    {
        this(day, month, year, hour, minute, 0);
    }

    public DateTime(int day, int month, int year, int hour, int minute, int second)
    {
        this(day, month, year, hour, minute, second, 0);
    }

    public DateTime(int day, int month, int year, int hour, int minute, int second, int millisecond)
    {
        m_date = new Date(day, month, year);
        m_time = new Time(hour, minute, second, millisecond);
    }

    public int getDay()
    {
        return m_date.getDay();
    }

    public void setDay(int val)
    {
        m_date.setDay(val);
    }

    public void setMonth(Month mon)
    {
        m_date.setMonth(mon);
    }

    public Month getMonth()
    {
        return m_date.getMonth();
    }

    public void setMonthValue(int val)
    {
        m_date.setMonthValue(val);
    }

    public int getMonthValue()
    {
        return m_date.getMonthValue();
    }

    public void setYear(int val)
    {
        m_date.setYear(val);
    }

    public int getYear()
    {
        return m_date.getYear();
    }

    public DayOfWeek getDayOfWeek()
    {
        return m_date.getDayOfWeek();
    }

    public String getDayOfWeekTR()
    {
        return m_date.getDayOfWeekTR();
    }

    public String getDayOfWeekEN()
    {
        return m_date.getDayOfWeekEN();
    }

    public int getDayOfYear()
    {
        return m_date.getDayOfYear();
    }

    public boolean isLeapYear()
    {
        return m_date.isLeapYear();
    }

    public boolean isWeekend()
    {
        return m_date.isWeekend();
    }

    public boolean isWeekday()
    {
        return m_date.isWeekday();
    }

    public int getHour()
    {
        return m_time.getHour();
    }

    public void setHour(int hour)
    {
        m_time.setHour(hour);
    }

    public int getMinute()
    {
        return m_time.getMinute();
    }

    public void setMinute(int minute)
    {
        m_time.setMinute(minute);
    }

    public int getSecond()
    {
        return m_time.getSecond();
    }

    public void setSecond(int second)
    {
        m_time.setSecond(second);
    }

    public int getMillisecond()
    {
        return m_time.getMillisecond();
    }

    public void setMillisecond(int millisecond)
    {
        m_time.setMillisecond(millisecond);
    }

    public String toStringTR(char delim)
    {
        return m_date.toStringTR(delim);
    }

    public String toStringTR()
    {
        return m_date.toStringTR();
    }

    public String toStringEN(char delim)
    {
        return m_date.toStringEN(delim);
    }

    public String toStringEN()
    {
        return m_date.toStringEN();
    }

    public String toLongDateStringTR()
    {
        return m_date.toLongDateStringTR();
    }

    public String toLongDateStringEN()
    {
        return m_date.toLongDateStringEN();
    }

    public String toShortTimeString()
    {
        return m_time.toShortTimeString();
    }

    public String toLongTimeString()
    {
        return m_time.toLongTimeString();
    }

    public String toString(char delimiter)
    {
        return String.format("%s %s", m_date.toString(delimiter), m_time.toString());
    }

    public String toString()
    {
        return String.format("%s", this.toString('.'));
    }
}
