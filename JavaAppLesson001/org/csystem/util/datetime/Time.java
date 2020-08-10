/*----------------------------------------------------------------------------------------------------------------------
    Time sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util.datetime;

import java.util.Calendar;
import java.util.Random;

public class Time {
    private int m_hour, m_minute, m_second, m_millisecond;

    private static void doWorkForError(String msg)
    {
        throw new DateTimeException(msg);
    }

    private static boolean isValidForBounds(int val, int max)
    {
        return 0 <= val && val <= max;
    }

    private static boolean isValidTime(int h, int m, int s, int ms)
    {
        return isValidHour(h) && isValidMinute(m) && isValidSecond(s) && isValidMillisecond(ms);
    }

    private static boolean isValidHour(int val)
    {
        return isValidForBounds(val, 23);
    }

    private static boolean isValidMinute(int val)
    {
        return isValidForBounds(val, 59);
    }

    private static boolean isValidSecond(int val)
    {
        return isValidForBounds(val, 59);
    }

    private static boolean isValidMillisecond(int val)
    {
        return isValidForBounds(val, 999);
    }

    private void controlForTime(int h, int m, int s, int ms)
    {
        if (!isValidTime(h, m, s, ms))
            doWorkForError("Invalid time value(s)");

        m_hour = h;
        m_minute = m;
        m_second = s;
        m_millisecond = ms;
    }

    private void controlForHour(int val)
    {
        if (!isValidHour(val))
            doWorkForError("Invalid hour value");

        m_hour = val;
    }

    private void controlForMinute(int val)
    {
        if (!isValidMinute(val))
            doWorkForError("Invalid minute value");

        m_minute = val;
    }

    private void controlForSecond(int val)
    {
        if (!isValidSecond(val))
            doWorkForError("Invalid second value");

        m_second = val;
    }

    private void controlForMillisecond(int val)
    {
        if (!isValidMillisecond(val))
            doWorkForError("Invalid millisecond value");

        m_millisecond = val;
    }

    public static Time randomShortTime()
    {
        return randomShortTime(new Random());
    }

    public static Time randomShortTime(Random r)
    {
        int hour = r.nextInt(24);
        int minute = r.nextInt(60);

        return new Time(hour, minute, 0, 0);
    }

    public static Time randomTime()
    {
        return randomTime(new Random());
    }

    public static Time randomTime(Random r)
    {
        Time time = randomShortTime(r);

        time.setSecond(r.nextInt(60));

        return time;
    }

    public static Time randomLongTime()
    {
        return randomLongTime(new Random());
    }

    public static Time randomLongTime(Random r)
    {
        Time time = randomTime();

        time.setMillisecond(r.nextInt(1000));

        return time;
    }

    public Time() //Bu ctor'un kodları önemsiz. Çalışılan sitemdeki o anki zaman bilgiini alır
    {
        Calendar now = Calendar.getInstance();

        m_hour = now.get(Calendar.HOUR);
        m_minute = now.get(Calendar.MINUTE);
        m_second = now.get(Calendar.SECOND);
        m_millisecond = now.get(Calendar.MILLISECOND);
    }

    public Time(int hour, int minute)
    {
        this(hour, minute, 0);
    }

    public Time(int hour, int minute, int second)
    {
        this(hour, minute, second, 0);
    }

    public Time(int hour, int minute, int second, int millisecond)
    {
        this.controlForTime(hour, minute, second, millisecond);
    }

    public int getHour()
    {
        return m_hour;
    }

    public void setHour(int hour)
    {
        if (hour == m_hour)
            return;

        this.controlForHour(hour);
    }

    public int getMinute()
    {
        return m_minute;
    }

    public void setMinute(int minute)
    {
        if (minute == m_minute)
            return;

        this.controlForMinute(minute);
    }

    public int getSecond()
    {
        return m_second;
    }

    public void setSecond(int second)
    {
        if (second == m_second)
            return;

        this.controlForSecond(second);
    }

    public int getMillisecond()
    {
        return m_millisecond;
    }

    public void setMillisecond(int millisecond)
    {
        if (millisecond == m_millisecond)
            return;

        this.controlForMillisecond(millisecond);
    }

    public String toShortTimeString()
    {
        return String.format("%02d:%02d", m_hour, m_minute);
    }

    public String toString()
    {
        return String.format("%s:%02d", this.toShortTimeString(), m_second);
    }

    public String toLongTimeString()
    {
        return String.format("%s.%03d", this.toString(), m_millisecond);
    }
}
