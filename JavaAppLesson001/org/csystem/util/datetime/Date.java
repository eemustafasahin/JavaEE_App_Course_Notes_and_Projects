/*----------------------------------------------------------------------------------------------------------------------
    Date sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util.datetime;

import java.util.Calendar;
import java.util.Random;

public class Date {
    private  static final String [] MS_WEEK_DAYS_TR;
    private  static  final String [] MS_WEEK_DAYS_EN;
    private static final String [] MS_MONTHS_TR;
    private static final String [] MS_MONTHS_EN;
    private static final Month [] MS_MONTHS;

    static {
        MS_WEEK_DAYS_TR = new String[]{"Pazar", "Pazartesi", "Salı", "Çarşamba", "Perşembe", "Cuma", "Cumartesi"};
        MS_WEEK_DAYS_EN = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        MS_MONTHS_TR = new String[]{"", "Ocak", "Şubat", "Mart", "Nisan", "Mayıs", "Haziran",
                "Temmuz", "Ağustos", "Eylül", "Ekim", "Kasım", "Aralık"};
        MS_MONTHS_EN = new String[]{"", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        MS_MONTHS = Month.values();
    }

    private int m_day, m_mon, m_year;
    private int m_dayOfWeek;

    private static void doWorkForError(String msg)
    {
        throw new DateTimeException(msg);
    }

    private static int getDayOfWeek(int day, int mon, int year)
    {
        int totalDays = getDayOfYear(day, mon, year);

        for (int y = 1900; y < year; ++y)
            totalDays += Month.isLeapYear(y) ? 366 : 365;

        return totalDays % 7;
    }

    private static int getDayOfYear(int day, int mon, int year)
    {
        int dayOfYear = day;

        for (int m = mon - 1; m >= 1; --m)
            dayOfYear += MS_MONTHS[m - 1].getDaysByYear(year);

        return dayOfYear;
    }

    private static boolean isValidDate(int day, int mon, int year)
    {
        if (day < 1 || day > 31 || mon < 1 || mon > 12)
            return false;

        int days = MS_MONTHS[mon - 1].getDaysByYear(year);

        return day <= days;
    }

    private static void control(int day, int mon, int year, String msg)
    {
        if (!isValidDate(day, mon, year))
            doWorkForError(msg);
    }

    private void controlForDay(int day)
    {
        control(day, m_mon, m_year, "Invalid day value");
    }

    private void controlForMonth(int mon)
    {
        control(m_day, mon, m_year, "Invalid month value");
    }

    private void controlForYear(int year)
    {
        control(m_day, m_mon, year, "Invalid year value");
    }

    private void setDayOfWeek()
    {
        m_dayOfWeek = getDayOfWeek(m_day, m_mon, m_year);
    }

    private void set(int day, int mon, int year)
    {
        m_day = day;
        m_mon = mon;
        m_year = year;
        this.setDayOfWeek();
    }

    private String getDayPosfix()
    {
        String postfix = "th";

        switch (m_day) {
            case 1:
            case 21:
            case 31:
                postfix = "st";
                break;

            case 2:
            case 22:
                postfix = "nd";
                break;
            case 3:
            case 23:
                postfix = "rd";
                break;
        }

        return postfix;
    }

    public static Date randomDate()
    {
        return randomDate(new Random());
    }

    public static Date randomDate(Random r)
    {
        Date now = new Date();

        return randomDate(r, now.m_year);
    }

    public static Date randomDate(int year)
    {
        return randomDate(new Random(), year);
    }

    public static Date randomDate(Random r, int year)
    {
        return randomDate(r, year, year);
    }

    public static Date randomDate(int minYear, int maxYear)
    {
        return randomDate(new Random(), minYear, maxYear);
    }

    public static Date randomDate(Random r, int minYear, int maxYear)
    {
        int year = r.nextInt(maxYear - minYear + 1) + minYear;
        int mon = r.nextInt(12) + 1;
        int day = r.nextInt(MS_MONTHS[mon - 1].getDaysByYear(year)) + 1;

        return new Date(day, mon, year);
    }

    public Date() //Bu ctor'un kodları önemsiz. Çalışılan sitemdeki o anki tarih bilgiini alır
    {
        Calendar now = Calendar.getInstance();

        m_day = now.get(Calendar.DAY_OF_MONTH);
        m_mon = now.get(Calendar.MONTH) + 1;
        m_year = now.get(Calendar.YEAR);
        this.setDayOfWeek();
    }

    public Date(int day, Month mon, int year)
    {
        this(day, mon.ordinal() + 1, year);
    }

    public Date(int day, int mon, int year)
    {
        control(day, mon, year, "Invalid date value(s)");
        this.set(day, mon, year);
    }

    public void setDay(int val)
    {
        if (val == m_day)
            return;

        this.controlForDay(val);
        m_day = val;
        this.setDayOfWeek();
    }

    public int getDay()
    {
        return m_day;
    }

    public void setMonth(Month mon)
    {
        this.setMonthValue(mon.ordinal() + 1);
    }

    public Month getMonth()
    {
        return MS_MONTHS[m_mon - 1];
    }

    public void setMonthValue(int val)
    {
        if (val == m_mon)
            return;

        this.controlForMonth(val);
        m_mon = val;
        this.setDayOfWeek();
    }

    public int getMonthValue()
    {
        return m_mon;
    }

    public void setYear(int val)
    {
        if (val == m_year)
            return;

        this.controlForYear(val);
        m_year = val;
        this.setDayOfWeek();
    }

    public int getYear()
    {
        return m_year;
    }
    public DayOfWeek getDayOfWeek() {return DayOfWeek.values()[m_dayOfWeek];}
    public String getDayOfWeekTR() {return MS_WEEK_DAYS_TR[m_dayOfWeek];}
    public String getDayOfWeekEN() {return MS_WEEK_DAYS_EN[m_dayOfWeek];}
    public int getDayOfYear() {return getDayOfYear(m_day, m_mon, m_year);}
    public boolean isLeapYear() {return Month.isLeapYear(m_year);}
    public boolean isWeekend() {return m_dayOfWeek == 0 || m_dayOfWeek == 6;}
    public boolean isWeekday() {return !this.isWeekend();}
    public String toString(char delim)
    {
        return String.format("%02d%c%02d%c%04d", m_day, delim, m_mon, delim, m_year);
    }

    public String toString()
    {
        return this.toString('/');
    }
    public String toStringTR(char delim)
    {
        return String.format("%s %s", this.toString(delim), this.getDayOfWeekTR());
    }

    public String toStringTR()
    {
        return this.toStringTR('/');
    }

    public String toStringEN(char delim)
    {
        return String.format("%s %s", toString(delim), this.getDayOfWeekEN());
    }

    public String toStringEN()
    {
        return this.toStringEN('/');
    }

    public String toLongDateStringTR()
    {
        return String.format("%d %s %d %s", m_day, MS_MONTHS_TR[m_mon], m_year, this.getDayOfWeekTR());
    }

    public String toLongDateStringEN()
    {
        return String.format("%d%s %s %d %s", m_day, getDayPosfix(), MS_MONTHS_EN[m_mon], m_year, this.getDayOfWeekEN());
    }
}
