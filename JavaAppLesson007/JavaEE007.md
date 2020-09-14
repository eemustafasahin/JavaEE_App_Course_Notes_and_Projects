### Sınıf Çalışması: Doğum günü kutlaması
```java
/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Klavyeden alınan gün, ay ve yıl bilgilerine göre kişinin doğum günü geçmişse
    "geçmiş doğum gününüz kutlu olsun", o an doğum günü ise "doğum gününüz kutlu olsun", doğum henüz gelmemişse
    "doğum gününüzü şimdiden kutlarız" mesajlarından birini ekrana basan programı Calendar sınıfını kullanarak yazınız
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.util.Calendar;
import java.util.GregorianCalendar;

class App {
    public static void main(String[] args)
    {
        BirthDateApp.run();
    }
}

final class BirthDateApp {
    private static BirthDateInfo getBirtDateInfo()
    {
        Console.writeLine("Doğum tarihi bilgilerinizi giriniz:");
        var day = Console.readInt("Gün?", "Hatalı giriş yaptınız:");

        if (day <= 0)
            return null;

        var mon = Console.readInt("Ay?", "Hatalı giriş yaptınız:");
        var year = Console.readInt("Yıl?", "Hatalı giriş yaptınız:");

        return new BirthDateInfo(day, mon, year);
    }

    private BirthDateApp()
    {}

    public static void run()
    {
        while (true) {
            var birthDateInfo = getBirtDateInfo();

            if (birthDateInfo == null)
                break;

            String message = "";

            switch (birthDateInfo.getDateStatus()) {
                case AFTER:
                    message = "Doğum günüzünüzü şimdiden kutlarız";
                    break;
                case BEFORE:
                    message = "Geçmiş doğum gününüz kutlu kutlarız";
                    break;
                default:
                    message = "Doğum gününüz kutlu olsun";
            }

            Console.writeLine("%s. Yaşınız:%f", message, birthDateInfo.getAge());
        }

        Console.writeLine("Tekrar yapıyor musunuz?");
    }
}

enum DateStatus {BEFORE, AFTER, SAME}

class BirthDateInfo {
    private static final double SCALE_FOR_DAY = 1000. * 60  * 60 * 24 * 365;
    private Calendar m_birthDate;

    private static Calendar tooDate(Calendar calendar)
    {
        return new GregorianCalendar(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
    }

    public BirthDateInfo()
    {
        m_birthDate = Calendar.getInstance();
    }

    public BirthDateInfo(int day, int mon, int year)
    {
        setBirthDate(day, mon, year);
    }

    public void setBirthDate(int day, int mon, int year)
    {
        m_birthDate = new GregorianCalendar(year, mon - 1, day);
    }

    public double getAge()
    {
        var today = tooDate(new GregorianCalendar());

        return (today.getTimeInMillis() - m_birthDate.getTimeInMillis()) / SCALE_FOR_DAY;
    }

    public DateStatus getDateStatus()
    {
        var today = tooDate(new GregorianCalendar());
        var birthDay = new GregorianCalendar(today.get(Calendar.YEAR), m_birthDate.get(Calendar.MONTH), m_birthDate.get(Calendar.DAY_OF_MONTH));

        DateStatus dateStatus = DateStatus.SAME;

        if (birthDay.after(today))
            dateStatus = DateStatus.AFTER;
        else if (birthDay.before(today))
            dateStatus = DateStatus.BEFORE;

        return dateStatus;
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Klavyeden alınan gün, ay ve yıl bilgilerine göre kişinin doğum günü geçmişse
    "geçmiş doğum gününüz kutlu olsun", o an doğum günü ise "doğum gününüz kutlu olsun", doğum henüz gelmemişse
    "doğum gününüzü şimdiden kutlarız" mesajlarından birini ekrana basan programı Calendar sınıfını kullanarak yazınız
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;
import org.csystem.util.datetime.DateTime;

class App {
    public static void main(String[] args)
    {
        BirthDateApp.run();
    }
}

final class BirthDateApp {
    private static BirthDateInfo getBirtDateInfo()
    {
        Console.writeLine("Doğum tarihi bilgilerinizi giriniz:");
        var day = Console.readInt("Gün?", "Hatalı giriş yaptınız:");

        if (day <= 0)
            return null;

        var mon = Console.readInt("Ay?", "Hatalı giriş yaptınız:");
        var year = Console.readInt("Yıl?", "Hatalı giriş yaptınız:");

        return new BirthDateInfo(day, mon, year);
    }

    private BirthDateApp()
    {}

    public static void run()
    {
        while (true) {
            var birthDateInfo = getBirtDateInfo();

            if (birthDateInfo == null)
                break;

            String message = "";

            switch (birthDateInfo.getDateStatus()) {
                case AFTER:
                    message = "Doğum günüzünüzü şimdiden kutlarız";
                    break;
                case BEFORE:
                    message = "Geçmiş doğum gününüz kutlu kutlarız";
                    break;
                default:
                    message = "Doğum gününüz kutlu olsun";
            }

            Console.writeLine("%s. Yaşınız:%f", message, birthDateInfo.getAge());
        }

        Console.writeLine("Tekrar yapıyor musunuz?");
    }
}

enum DateStatus {BEFORE, AFTER, SAME}

class BirthDateInfo {
    private static final double SCALE_FOR_DAY = 1000. * 60  * 60 * 24 * 365;
    private DateTime m_birthDate;

    public BirthDateInfo()
    {
        m_birthDate = DateTime.today();
    }

    public BirthDateInfo(int day, int mon, int year)
    {
        setBirthDate(day, mon, year);
    }

    public void setBirthDate(int day, int mon, int year)
    {
        m_birthDate = DateTime.of(day, mon, year);
    }

    public double getAge()
    {
        return (DateTime.today().getTimeInMillis() - m_birthDate.getTimeInMillis()) / SCALE_FOR_DAY;
    }

    public DateStatus getDateStatus()
    {
        var today = DateTime.today();
        var birthDay = m_birthDate.withYear(today.getYear());

        DateStatus dateStatus = DateStatus.SAME;

        if (birthDay.isAfter(today))
            dateStatus = DateStatus.AFTER;
        else if (birthDay.isBefore(today))
            dateStatus = DateStatus.BEFORE;

        return dateStatus;
    }
}


package org.csystem.util.datetime;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static java.util.Calendar.*;

public final class DateTime implements Serializable, Comparable<DateTime> {
    private static final long serialVersionUID = 1L;
    private static final int [] DAYS_OF_MONTHS = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private final Calendar m_calendar;

    private static boolean isValidDate(int day, int mon, int year)
    {
        if (day < 1 || day > 31 || mon < 1 || mon > 12)
            return false;

        int days = mon == 2 && isLeapYear(year) ? 29 :  DAYS_OF_MONTHS[mon];

        return day <= days;
    }

    private static boolean isLeapYear(int year)
    {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    private static boolean isValidForTime(int hour, int minute, int second, int millisecond)
    {
        return isValidForHour(hour) && isValidForMinute(minute)
                && isValidForSecond(second) && isValidForMillisecond(millisecond);
    }

    private static boolean isValidForHour(int hour)
    {
        return isValidForBounds(hour, 23);
    }

    private static boolean isValidForMinute(int minute)
    {
        return isValidForBounds(minute, 59);
    }

    private static boolean isValidForSecond(int second)
    {
        return isValidForBounds(second, 59);
    }
    private static boolean isValidForMillisecond(int second)
    {
        return isValidForBounds(second, 999);
    }

    private static boolean isValidForBounds(int val, int max)
    {
        return 0 <= val && val <= max;
    }

    private static void controlForDate(int day, int mon, int year, String msg)
    {
        if (!isValidDate(day, mon, year))
            doWorkForException(msg);
    }
    private static void controlForTime(int hour, int minute, int second, int millisecond, String msg)
    {
        if (!isValidForTime(hour, minute, second, millisecond))
            doWorkForException(msg);
    }

    public static void controlForHour(int hour)
    {
        if (!isValidForHour(hour))
            doWorkForException("Invalid Hour");
    }

    public static void controlForMinute(int minute)
    {
        if (!isValidForMinute(minute))
            doWorkForException("Invalid Minute");
    }

    public static void controlForSecond(int second)
    {
        if (!isValidForSecond(second))
            doWorkForException("Invalid Second");
    }

    public static void controlForMillisecond(int millisecond)
    {
        if (!isValidForMillisecond(millisecond))
            doWorkForException("Invalid Millisecond");
    }

    private static void control(int day, int mon, int year, int hour, int minute, int second, int millisecond, String msg)
    {
        controlForDate(day, mon, year, msg);
        controlForTime(hour, minute, second, millisecond, msg);
    }

    private static void doWorkForException(String msg)
    {
        throw new DateTimeException(msg);
    }

    private DateTime(Calendar calendar)
    {
        m_calendar = calendar;
    }

    private DateTime()
    {
        m_calendar = Calendar.getInstance();
    }

    private DateTime(int day, int mon, int year, int hour, int minute, int second, int milliseconds)
    {
        control(day, mon, year, hour, minute, second, milliseconds, "Invalid org.csystem.util.datetime.DateTime");
        m_calendar = new GregorianCalendar(year, mon - 1, day, hour, minute, second);
        m_calendar.set(MILLISECOND, milliseconds);
    }

    private DateTime plus(int field, int amount)
    {
        Calendar calendar = (Calendar)m_calendar.clone();

        calendar.add(field, amount);

        return new DateTime(calendar);
    }

    private DateTime with(int field, int value)
    {
        Calendar calendar = (Calendar)m_calendar.clone();

        calendar.set(field, value);

        return new DateTime(calendar);
    }

    public static DateTime of(long milliseconds)
    {
        DateTime dateTime = new DateTime();

        dateTime.m_calendar.setTimeInMillis(milliseconds);

        return dateTime;
    }

    public static DateTime of(int day, int mon, int year)
    {
        return of(day, mon, year, 0, 0);
    }

    public static DateTime of(int day, Month mon, int year)
    {
        return of(day, mon.ordinal() + 1, year);
    }

    public static DateTime of(int day, Month mon, int year, int hour, int minute)
    {
        return of(day, mon.ordinal() + 1, year, hour, minute);
    }

    public static DateTime of(int day, int mon, int year, int hour, int minute)
    {
        return of(day, mon, year, hour, minute, 0);
    }

    public static DateTime of(int day, Month mon, int year, int hour, int minute, int second)
    {
        return of(day, mon.ordinal() + 1, year, hour, minute, second);
    }

    public static DateTime of(int day, int mon, int year, int hour, int minute, int second)
    {
        return of(day, mon, year, hour, minute, second, 0);
    }

    public static DateTime of(int day, Month mon, int year, int hour, int minute, int second, int millisecond)
    {
        return of(day, mon.ordinal() + 1, year, hour, minute, second, millisecond);
    }

    public static DateTime of(int day, int mon, int year, int hour, int minute, int second, int millisecond)
    {
        return new DateTime(day, mon, year, hour, minute, second, millisecond);
    }

    public static DateTime now() {return new DateTime();}
    public static DateTime today()
    {
        DateTime now = now();

        now.m_calendar.set(HOUR_OF_DAY, 0);
        now.m_calendar.set(MINUTE, 0);
        now.m_calendar.set(SECOND, 0);
        now.m_calendar.set(MILLISECOND, 0);

        return now;
    }

    public int getDay() {return m_calendar.get(DAY_OF_MONTH);}

    public int getMonthValue() {return m_calendar.get(MONTH) + 1;}

    public Month getMonth() {return Month.values()[getMonthValue() - 1];}

    public int getYear() {return m_calendar.get(YEAR);}

    public DayOfWeek getDayOfWeek() {return DayOfWeek.values()[m_calendar.get(DAY_OF_WEEK) - 1];}

    public int getDayOfYear() {return m_calendar.get(DAY_OF_YEAR);}

    public int getHour() {return m_calendar.get(HOUR_OF_DAY);}

    public int getMinute() {return m_calendar.get(MINUTE);}

    public int getSecond() {return m_calendar.get(SECOND);}

    public int getMillisecond() {return m_calendar.get(MILLISECOND);}

    public long getTimeInMillis()
    {
        return m_calendar.getTimeInMillis();
    }

    public int getEndOfMonth() {return m_calendar.getActualMaximum(DAY_OF_MONTH);}

    public boolean isAfter(DateTime other) {return compareTo(other) > 0;}

    public boolean isBefore(DateTime other) {return compareTo(other) < 0;}

    public boolean isEqual(DateTime other) {return equals(other);}

    public boolean isLeapYear()
    {
        return isLeapYear(getYear());
    }

    public boolean isWeekday() {return !isWeekend();}

    public boolean isWeekend()
    {
        DayOfWeek dow = getDayOfWeek();

        return dow == DayOfWeek.SAT || dow == DayOfWeek.SUN;
    }

    public DateTime plusDays(int days)
    {
        return plus(DAY_OF_MONTH, days);
    }

    public DateTime plusMonths(int months)
    {
        return plus(MONTH, months);
    }

    public DateTime plusYears(int years)
    {
        return plus(YEAR, years);
    }

    public DateTime plusHours(int hours)
    {
        return plus(HOUR_OF_DAY, hours);
    }

    public DateTime plusMinutes(int minutes)
    {
        return plus(MINUTE, minutes);
    }

    public DateTime plusSeconds(int seconds)
    {
        return plus(SECOND, seconds);
    }

    public DateTime plusMilliseconds(int milliseconds)
    {
        return plus(MILLISECOND, milliseconds);
    }

    public DateTime minusDays(int days)
    {
        return plusDays(-days);
    }

    public DateTime minusMonths(int months)
    {
        return plusMonths(-months);
    }

    public DateTime minusYears(int years)
    {
        return plusYears(-years);
    }

    public DateTime minusHours(int hours)
    {
        return plusHours(-hours);
    }

    public DateTime minusMinutes(int minutes)
    {
        return plusMinutes(-minutes);
    }

    public DateTime minusSeconds(int seconds)
    {
        return plusSeconds(-seconds);
    }

    public DateTime minusMilliseconds(int milliseconds)
    {
        return plusMilliseconds(-milliseconds);
    }


    public DateTime withDay(int day)
    {
        controlForDate(day, getMonthValue(), getYear(), "Invalid Day");

        return with(DAY_OF_MONTH, day);
    }

    public DateTime withMonthValue(int month)
    {
        controlForDate(getDay(), month, getYear(), "Invalid org.csystem.util.datetime.Month");

        return with(MONTH, month - 1);
    }

    public DateTime withMonth(Month month)
    {
        return withMonthValue(month.ordinal() + 1);
    }

    public DateTime withYear(int year)
    {
        controlForDate(getDay(), getMonthValue(), year, "Invalid Year");

        return with(YEAR, year);
    }

    public DateTime withHour(int hour)
    {
        controlForHour(hour);

        return with(HOUR_OF_DAY, hour);
    }

    public DateTime withMinute(int minute)
    {
        controlForMinute(minute);

        return with(MINUTE, minute);
    }

    public DateTime withSecond(int second)
    {
        controlForSecond(second);

        return with(SECOND, second);
    }

    public DateTime withMillisecond(int millisecond)
    {
        controlForMillisecond(millisecond);

        return with(MILLISECOND, millisecond);
    }

    @Override
    public int compareTo(DateTime other)
    {
        return m_calendar.compareTo(other.m_calendar);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (!(obj instanceof DateTime))
            return false;

        return m_calendar.equals(obj);
    }

    @Override
    public int hashCode()
    {
        return m_calendar.hashCode();
    }


    @Override
    public String toString()
    {
        return toString('/');
    }

    public String toString(char delim)
    {
        return String.format("%s %s", toDateString(delim), toTimeString());
    }

    public String toDateString()
    {
        return toDateString('/');
    }

    public String toDateString(char delim)
    {
        return String.format("%02d%c%02d%c%04d",
                getDay(), delim, getMonthValue(), delim, getYear());
    }

    public String toLongTimeString()
    {
        return String.format("%s.%d", toTimeString(), getMillisecond());
    }

    public String toTimeString()
    {
        return String.format("%02d:%02d:%02d", getHour(), getMinute(), getSecond());
    }
}

package org.csystem.util.datetime;

public class DateTimeException extends RuntimeException  {
    public DateTimeException()
    {}

    public DateTimeException(String msg)
    {
        super(msg);
    }
}
package org.csystem.util.datetime;

public enum DayOfWeek {
    SUN, MON, TUE, WED, THU, FRI, SAT
}

package org.csystem.util.datetime;

public enum Month {
    JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV, DEC
}
```
### LocalDate sınıfının of metotları
```java
/*----------------------------------------------------------------------------------------------------------------------
    LocalDate sınıfının of metotları
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.time.LocalDate;

class App {
    public static void main(String[] args)
    {
        var date = LocalDate.of(2020, 9, 12);

        Console.writeLine("%02d/%02d/%04d", date.getDayOfMonth(), date.getMonthValue(), date.getYear());
        Console.writeLine("%02d %s %04d %s", date.getDayOfMonth(), date.getMonth(), date.getYear(), date.getDayOfWeek());
    }
}
```
### LocalDate sınıfının Month parametreli ctor elemanı
```java
/*----------------------------------------------------------------------------------------------------------------------
    LocalDate sınıfının Month parametreli ctor elemanı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.time.LocalDate;
import java.time.Month;

class App {
    public static void main(String[] args)
    {
        var date = LocalDate.of(2020, Month.SEPTEMBER, 12);

        Console.writeLine("%02d/%02d/%04d", date.getDayOfMonth(), date.getMonthValue(), date.getYear());
        Console.writeLine("%02d %s %04d %s", date.getDayOfMonth(), date.getMonth(), date.getYear(), date.getDayOfWeek());
    }
}
```
### LocalDate sınıfı (ve tüm diğer Java 8 tarih-zaman sınıfları) geçerlilik kontrolü yapar.
```java
/*----------------------------------------------------------------------------------------------------------------------
    LocalDate sınıfı (ve tüm diğer Java 8 tarih-zaman sınıfları) geçerlilik kontrolü yapar. Bu sınıflar geçerli olmayan
    bilgiler için DateTimeException nesnesi fırlatır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.time.LocalDate;
import java.time.Month;

class App {
    public static void main(String[] args)
    {
        var date = LocalDate.of(2019, Month.FEBRUARY, 29);

        Console.writeLine("%02d/%02d/%04d", date.getDayOfMonth(), date.getMonthValue(), date.getYear());
        Console.writeLine("%02d %s %04d %s", date.getDayOfMonth(), date.getMonth(), date.getYear(), date.getDayOfWeek());
    }
}
```
### LocalDate sınıfının now iismli static metodu sistemin tarih bilgisini elde etmekte kullanılır
```java
/*----------------------------------------------------------------------------------------------------------------------
    LocalDate sınıfının now iismli static metodu sistemin tarih bilgisini elde etmekte kullanılır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.time.LocalDate;

class App {
    public static void main(String[] args)
    {
        var date = LocalDate.now();

        Console.writeLine("%02d/%02d/%04d", date.getDayOfMonth(), date.getMonthValue(), date.getYear());
        Console.writeLine("%02d %s %04d %s", date.getDayOfMonth(), date.getMonth(), date.getYear(), date.getDayOfWeek());
    }
}
```
### LocalDate sınıfının isAfter ve isBefore metotları
```java
/*----------------------------------------------------------------------------------------------------------------------
    LocalDate sınıfının isAfter ve isBefore metotları
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.time.LocalDate;
import java.time.Month;

class App {
    public static void main(String[] args)
    {
        var today = LocalDate.now();
        var date = LocalDate.of(2020, Month.OCTOBER, 7);

        Console.writeLine(date.isAfter(today));
        Console.writeLine(today.isBefore(date));
    }
}
```
### ChronoUnit enum sınıfı ile tarih-zaman ölçümleri yapılabilir
```java
/*----------------------------------------------------------------------------------------------------------------------
    ChronoUnit enum sınıfı ile tarih-zaman ölçümleri yapılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

class App {
    public static void main(String[] args)
    {
        var today = LocalDate.now();
        var date = LocalDate.of(1999, Month.AUGUST, 17);

        Console.writeLine(ChronoUnit.DAYS.between(date, today));
        Console.writeLine(ChronoUnit.YEARS.between(date, today));
        Console.writeLine(ChronoUnit.MONTHS.between(date, today));
    }
}
```
### Sınıf Çalışması: Doğum günü kutlaması (2)
```java
/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Klavyeden alınan gün, ay ve yıl bilgilerine göre kişinin doğum günü geçmişse
    "geçmiş doğum gününüz kutlu olsun", o an doğum günü ise "doğum gününüz kutlu olsun", doğum henüz gelmemişse
    "doğum gününüzü şimdiden kutlarız" mesajlarından birini ekrana basan programı Calendar sınıfını kullanarak yazınız
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class App {
    public static void main(String[] args)
    {
        BirthDateApp.run();
    }
}

final class BirthDateApp {
    private static BirthDateInfo getBirtDateInfo()
    {
        Console.writeLine("Doğum tarihi bilgilerinizi giriniz:");
        var day = Console.readInt("Gün?", "Hatalı giriş yaptınız:");

        if (day <= 0)
            return null;

        var mon = Console.readInt("Ay?", "Hatalı giriş yaptınız:");
        var year = Console.readInt("Yıl?", "Hatalı giriş yaptınız:");

        return new BirthDateInfo(day, mon, year);
    }

    private BirthDateApp()
    {}

    public static void run()
    {
        while (true) {
            var birthDateInfo = getBirtDateInfo();

            if (birthDateInfo == null)
                break;

            String message = "";

            switch (birthDateInfo.getDateStatus()) {
                case AFTER:
                    message = "Doğum günüzünüzü şimdiden kutlarız";
                    break;
                case BEFORE:
                    message = "Geçmiş doğum gününüz kutlu kutlarız";
                    break;
                default:
                    message = "Doğum gününüz kutlu olsun";
            }

            Console.writeLine("%s. Yaşınız:%f", message, birthDateInfo.getAge());
        }

        Console.writeLine("Tekrar yapıyor musunuz?");
    }
}

enum DateStatus {BEFORE, AFTER, SAME}

class BirthDateInfo {
    private LocalDate m_birthDate;

    public BirthDateInfo()
    {
        m_birthDate = LocalDate.now();
    }

    public BirthDateInfo(int day, int mon, int year)
    {
        setBirthDate(day, mon, year);
    }

    public void setBirthDate(int day, int mon, int year)
    {
        m_birthDate = LocalDate.of(year, mon, day);
    }

    public double getAge()
    {
        return ChronoUnit.DAYS.between(m_birthDate, LocalDate.now()) / 365.;
    }

    public DateStatus getDateStatus()
    {
        var today = LocalDate.now();
        var birthDay = m_birthDate.withYear(today.getYear());

        DateStatus dateStatus = DateStatus.SAME;

        if (birthDay.isAfter(today))
            dateStatus = DateStatus.AFTER;
        else if (birthDay.isBefore(today))
            dateStatus = DateStatus.BEFORE;

        return dateStatus;
    }
}
```
### LocalDate sıfınının plusXXX metotları
```java
/*----------------------------------------------------------------------------------------------------------------------
    LocalDate sıfınının plusXXX metotları
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.time.LocalDate;

class App {
    public static void main(String[] args)
    {
        var today = LocalDate.now();
        var date = today.plusWeeks(7);

        Console.writeLine(today);
        Console.writeLine(date);
    }
}
```
### LocalDate sıfınının metotları ile zincir çağırma yapılabilir
```java
/*----------------------------------------------------------------------------------------------------------------------
    LocalDate sıfınının metotları ile zincir çağırma yapılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.time.LocalDate;

class App {
    public static void main(String[] args)
    {
        var today = LocalDate.now();
        var date = today.plusWeeks(7).minusDays(3);

        Console.writeLine(today);
        Console.writeLine(date);
    }
}
```
### LocalTime sınıfının atDate metodu
```java
/*----------------------------------------------------------------------------------------------------------------------
    LocalTime sınıfının atDate metodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

class App {
    public static void main(String[] args)
    {
        var time = LocalTime.of(11, 33, 34);
        LocalDateTime datetime = time.atDate(LocalDate.now());

        Console.writeLine(datetime);
    }
}
```
### LocalDate sınıfının atTime metodu
```java
/*----------------------------------------------------------------------------------------------------------------------
    LocalDate sınıfının atTime metodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

class App {
    public static void main(String[] args)
    {
        var date = LocalDate.of(2020, Month.APRIL, 12);
        LocalDateTime datetime = date.atTime(LocalTime.now());

        Console.writeLine(datetime);
    }
}
```
### Sınıf Çalışması
```java
/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: 17.08.1999 tarihinde 03:02:00 zamanında gerçekleşmiş olan büyük depremden bu zamana kadar geçen
    süreyi saniye olarak artarak devam eden bir biçimde ekrana basan metodu yazınız
    (ileride daha iyisi yazılacak. Bu efektif olmayan versiyon)
    (İşletim sisteminin console'nu (terminal) kullanarak test ediniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.samples.bigearthquakeremainderapp.BigEarthquakeRemainderApp;

class App {
    public static void main(String[] args)
    {
        BigEarthquakeRemainderApp.run();
    }
}

package org.csystem.samples.bigearthquakeremainderapp;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public final class BigEarthquakeRemainderApp {
    private BigEarthquakeRemainderApp()
    {}

    public static void run()
    {
        var earthQuakeDateTime = LocalDateTime.of(1999, Month.AUGUST, 17, 3, 2);

        while (true) {
            var now = LocalDateTime.now();
            var seconds = ChronoUnit.SECONDS.between(earthQuakeDateTime, now);

            System.out.printf("Depremden bu zamana kadar geçen saniye:%d\r", seconds);
        }
    }
}
```
###  LocalDateTime sınıfının toLocalDate ve toLocalTime sınıfları
```java
/*----------------------------------------------------------------------------------------------------------------------
    LocalDateTime sınıfının toLocalDate ve toLocalTime sınıfları
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.time.LocalDateTime;

class App {
    public static void main(String[] args)
    {
        var now = LocalDateTime.now();
        var date = now.toLocalDate();
        var time = now.toLocalTime();

        Console.writeLine(now);
        Console.writeLine(date);
        Console.writeLine(time);
    }
}
```
### DateTimeUtil sınıfı ve test kodu
```java
/*----------------------------------------------------------------------------------------------------------------------
    DateTimeUtil sınıfı ve test kodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;
import org.csystem.util.datetime.DateTimeUtil;

import java.time.LocalDateTime;

class App {
    public static void main(String[] args)
    {
        var now = LocalDateTime.now();
        var millis = DateTimeUtil.toMilliseconds(now);

        Console.writeLine(now);
        Console.writeLine(millis);
        var datetime = DateTimeUtil.toLocalDateTime(millis);
        Console.writeLine(datetime);
    }
}

package org.csystem.util.datetime;

import java.time.*;

public final class DateTimeUtil {
    private DateTimeUtil() {}

    public static long toMilliseconds(LocalDateTime localDateTime)
    {
        return toMilliseconds(localDateTime, ZoneId.systemDefault());
    }

    public static long toMilliseconds(LocalDateTime localDateTime, ZoneId zoneId)
    {
        return localDateTime.atZone(zoneId).toInstant().toEpochMilli();
    }

    public static LocalDateTime toLocalDateTime(long milliseconds)
    {
        return toLocalDateTime(milliseconds, ZoneId.systemDefault());
    }

    public static LocalDateTime toLocalDateTime(long milliseconds, ZoneId zoneId)
    {
        return Instant.ofEpochMilli(milliseconds).atZone(zoneId).toLocalDateTime();
    }

    public static long toMilliseconds(LocalDate localDate)
    {
        return toMilliseconds(localDate, ZoneId.systemDefault());
    }

    public static long toMilliseconds(LocalDate localDate, ZoneId zoneId)
    {
        return localDate.atStartOfDay(zoneId).toInstant().toEpochMilli();
    }

    public static LocalDate toLocalDate(long milliseconds)
    {
        return toLocalDate(milliseconds, ZoneId.systemDefault());
    }

    public static LocalDate toLocalDate(long milliseconds, ZoneId zoneId)
    {
        return Instant.ofEpochMilli(milliseconds).atZone(zoneId).toLocalDate();
    }
}
```
### Java'da içiçe tür bildirimleri (nested types):
```java
/*----------------------------------------------------------------------------------------------------------------------
    Java'da içiçe tür bildirimleri (nested types):
    Java'da içiçe tür bildirimleri yapılabilir. Burada öncelikle sınıf içerisinde sınıf bildirimleri ele alınacaktır.
    Java'da 4(dört) şekilde sınıf içerisinde sınıf bildirimi yapılabilir:
    1. static sınıf bildirimi (nested class)
    2. non-static sınıf bildirimi (inner class)
    3. Yerel sınıf bildirimi (local classes)
    4. Anonim sınıf bildirimi (anonymous class)

    Anahtar Notlar: Bunlar dışında Java 8 ile eklenmiş fonksiyonel programlama tekniklerinin daha gelişmiş olarak
    yapılabilmesini sağlayan "Lambda ifadeleri ve metot referansları" konusu ileride detaylı olarak ele alınacaktır
----------------------------------------------------------------------------------------------------------------------*/
```
### Hiç bir tür içerisinde bulunmayan bir sınıfa "top-level class" denir
```java
/*----------------------------------------------------------------------------------------------------------------------
    Hiç bir tür içerisinde bulunmayan bir sınıfa "top-level class" denir
----------------------------------------------------------------------------------------------------------------------*/
```
### Top-level class'lar static olarak bildirilemez
```java
/*----------------------------------------------------------------------------------------------------------------------
    Top-level class'lar static olarak bildirilemez
----------------------------------------------------------------------------------------------------------------------*/
static class Sample { //error

}

```
### Bir sınıf içerisinde başka bir sınıf static olarak bildirilebilir.
```java
/*----------------------------------------------------------------------------------------------------------------------
    Bir sınıf içerisinde başka bir sınıf static olarak bildirilebilir. Bu durumda içteki sınıf dıştaki sınıfın bir
    elemanıdır (member). Dolayısıyla sınıfın bir elemanı static olabileceğinden (ctor hariç) içteki sınıf da static
    anahtar sözcüğü ile bildirilebilir. Tüm sınıf elemanlarında olduğu gibi içte bildirilen bir sınıf da erişim
    belirleyici alabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class A {
    public static class B {
        //...
    }

    private static class C {
        //...
    }

    static class D {
        //...
    }

    protected static class E {
        //...
    }
}
```
### static sınıfların da elemanları olabilir.
```java
/*----------------------------------------------------------------------------------------------------------------------
    static sınıfların da elemanları olabilir. static bir sınıfa sınıf dışından onu kapsayan sınıf ismi ve nokta
    operatörü ile erişilebilir. Şüphesiz bu durumda erişim belirleyicinin de uygun olması gerekir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String[] args)
    {
        A.B b = new A.B();
        b.x = 10;
        b.foo();

        A.B.bar();
    }
}

class A {
    public static class B {
        public int x;

        public void foo()
        {
            System.out.println("foo");
        }

        public static void bar()
        {
            System.out.println("bar");
        }
    }


}
```
###  static sınıflar static elemanlar olduğundan import static bildirimi ile isimleri doğrudan kullanılabilir.
```java
/*----------------------------------------------------------------------------------------------------------------------
    static sınıflar static elemanlar olduğundan import static bildirimi ile isimleri doğrudan kullanılabilir.
    Ancak bu durumda kullanım "yop-level class" biçiminde olduğundan okunabilirliğin bozulmamasına dikkat edilmelidir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import static org.csystem.app.A.B;

class App {
    public static void main(String[] args)
    {
        B b = new B();
        b.x = 10;
        b.foo();

        B.bar();
    }
}

class A {
    public static class B {
        public int x;

        public void foo()
        {
            System.out.println("foo");
        }

        public static void bar()
        {
            System.out.println("bar");
        }
    }
}
```
### Kapsayan sınıfta static sınıfın elemanlarına erişilebilir
```java
/*----------------------------------------------------------------------------------------------------------------------
    Kapsayan sınıfta static sınıfın elemanlarına erişilebilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String[] args)
    {
        A a = new A();

        a.tar(10);
    }
}

class A {
    public void tar(int val)
    {
        B b = new B();

        b.x = val;
        b.foo();
        B.bar();
    }

    public static class B {
        public int x;

        public void foo()
        {
            System.out.println("foo");
            System.out.printf("x=%d%n", x);
        }

        public static void bar()
        {
            System.out.println("bar");
        }
    }
}
```
###  Kapsayan sınıfta static sınıfın private elemanlarına da erişilebilir
```java
/*----------------------------------------------------------------------------------------------------------------------
    Kapsayan sınıfta static sınıfın private elemanlarına da erişilebilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String[] args)
    {
        A a = new A();

        a.tar(10);
    }
}

class A {
    public void tar(int val)
    {
        B b = new B();

        b.m_x = val;
        b.foo();
        B.bar();
    }

    private static class B {
        private int m_x;

        private void foo()
        {
            System.out.println("foo");
            System.out.printf("x=%d%n", m_x);
        }

        private static void bar()
        {
            System.out.println("bar");
        }
    }
}
```
### static sınıf kapsayan sınıfın private elemanlarına erişebilir
```java
/*----------------------------------------------------------------------------------------------------------------------
    static sınıf kapsayan sınıfın private elemanlarına erişebilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String[] args)
    {
        A.B b = new A.B();

        b.foo(30);
    }
}

class A {
    private int m_x;
    private void tar(int val)
    {
        System.out.println("A.tar");
    }
    public static class B {
        private int m_x;

        public void foo(int val)
        {
            System.out.println("foo");
            m_x = val;
            System.out.printf("B.m_x=%d%n", m_x);

            A a = new A();

            a.tar(30);
            a.m_x = 2 * m_x;

            System.out.printf("A.m_x=%d%n", a.m_x);
        }

        private static void bar()
        {
            System.out.println("bar");
        }
    }
}
```
### Aşağıdaki durumda B sınıfının foo metodu kendisini çağırdığından exception oluşur
```java
/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki durumda B sınıfının foo metodu kendisini çağırdığından exception oluşur
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String[] args)
    {
        A.B a = new A.B();

        a.foo(10);
    }
}

class A {
    private static void foo(int val)
    {
        System.out.println("A.foo");
    }

    public static class B {
        public void foo(int val)
        {
            System.out.println("B.foo");
            foo(val); //recursion
        }
    }
}
```
### Yukarıdaki problem aşağıdaki gibi çözülebilir
```java
/*----------------------------------------------------------------------------------------------------------------------
    Yukarıdaki problem aşağıdaki gibi çözülebilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String[] args)
    {
        A.B a = new A.B();

        a.foo(10);
    }
}

class A {
    private static void foo(int val)
    {
        System.out.println("A.foo");
    }

    public static class B {
        public void foo(int val)
        {
            System.out.println("B.foo");
            A.foo(val);
        }
    }
}
```
### Aşağıdaki bar çağrısı doğrudan yapılmıştır.
```java
/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki bar çağrısı doğrudan yapılmıştır. Bu durumda bar ismi B sınıfında bulunmadığından onu kapsayan A sınıfına
    da bakılır. Yani aşağıdaki durumda bar çağrısı için sınıf ismi kullanmaya gerek yoktur
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String[] args)
    {
        A.B a = new A.B();

        a.foo(10);
    }
}

class A {
    private static void bar(int val)
    {
        System.out.println("A.bar");
    }

    public static class B {
        public void foo(int val)
        {
            System.out.println("B.foo");
            bar(val);
        }
    }
}
```
### Android programalamada kullanılan meşhur R sınıfı
```java
/*----------------------------------------------------------------------------------------------------------------------
    Android programalamada kullanılan meşhur R sınıfı, içerisinde static bildirilmiş sınıflar olacak şekilde
    tasarlanmıştır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String[] args)
    {
        //...
    }
}

class View {

}

class TextView extends View {
    //...
}

class Button extends View {
    //...
}

class Context {
    public View findViewById(int id)
    {
        //...
        return new View();
    }
}

class Activity extends Context {
    //...
}

class MyActivity extends Activity {
    private TextView m_textViewResult;
    private Button m_buttonOK;

    public void onCreate(/*...*/)
    {
        m_textViewResult = (TextView)findViewById(R.id.MAINACTIVITY_TEXTVIEW_RESULT);
        m_buttonOK = (Button)findViewById(R.id.MAINACTIVITY_BUTTON_OK);
    }
}

class R {
    public static class id {
        public static final int MAINACTIVITY_TEXTVIEW_RESULT = 0x1234;
        public static final int MAINACTIVITY_BUTTON_OK = 0x1234;
    }

    public static class string {
        public static final int label_name = 0x3456;
        public static final int ok_button_text = 0x34568;
        //...
    }

    public static class color {
        public static final int red_color = 0x567;
        //...
    }

    //...
}
```
### Bir sınıf içerisinde non-static bildirilmiş bir sınıf olabilir (inner class)
```java
/*----------------------------------------------------------------------------------------------------------------------
    Bir sınıf içerisinde non-static bildirilmiş bir sınıf olabilir (inner class)
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class A {
    public class B {
        //...
    }
}
```
###  inner class'ın static elemanları olamaz
```java
/*----------------------------------------------------------------------------------------------------------------------
    inner class'ın static elemanları olamaz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class A {
    public class B {
        private static int ms_x; //error
        public static void foo() //error
        {}
    }
}
```
###  inner class türünden bir nesne kapsadığı sınıf dışında referans.new sentaksı ile yaratılabilir.
```java
/*----------------------------------------------------------------------------------------------------------------------
    inner class türünden bir nesne kapsadığı sınıf dışında <referans>.new sentaksı ile yaratılabilir. Yani bir inner class
    türünden nesnenin yaratılabilmesi için kapsayan sınıf türünden bir nesne yaratılmış olmalıdır. Daha açık olarak
    söylemek gerekirse, inner class türünden bir nesne kapsadığı sınıf türünden bir nesne kullanılarak yaratılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String[] args)
    {
        A x = new A();
        A.B y = x.new B();

        y.foo();

        A.B z = x.new B();

        z.foo();
    }
}

class A {
    public class B {
        public  void foo()
        {
            System.out.println("B.foo");
        }
    }
}
```
### non-static bildirilmiş bir sınıf içerisinde o nesnenin ilişkin olduğu kapsayan sınıf nesnesinin non-static veri elemanlarına doğrudan erişilebilir
```java
/*----------------------------------------------------------------------------------------------------------------------
    non-static bildirilmiş bir sınıf içerisinde o nesnenin ilişkin olduğu kapsayan sınıf nesnesinin non-static veri
    elemanlarına doğrudan erişilebilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String[] args)
    {
        A x = new A();
        A.B y = x.new B();

        y.foo(23);

        System.out.printf("x.m_a=%d%n", x.getA());

        var z = x.new B();

        z.foo(67);

        System.out.printf("x.m_a=%d%n", x.getA());
    }
}

class A {
    private int m_a;

    public int getA() {return m_a;}

    public class B {
        public void foo(int val)
        {
            m_a = val;
        }
    }
}
```
### Anahtar Notlar: static ve non-static sınıflar için derleyici ürettiği arakod isimlendirmesinde kapsayan sınıf ismini de dahil eder.
```java
/*----------------------------------------------------------------------------------------------------------------------
    Anahtar Notlar: static ve non-static sınıflar için derleyici ürettiği arakod isimlendirmesinde kapsayan sınıf
    ismini de dahil eder. Genel isimlendirme:
    class A {
        publix class B {

        }
    }

    bildirimi için B ister static ister non-static olsun, B'nin byte kodu A$B.class dosyası biçiminde yaratılır
----------------------------------------------------------------------------------------------------------------------*/
```
###  inner class içerisinde A nın static metotları da doğrudan çağrılabilir
```java
/*----------------------------------------------------------------------------------------------------------------------
    inner class içerisinde A nın static metotları da doğrudan çağrılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String[] args)
    {
        A x = new A();
        A.B y = x.new B();

        y.bar();
    }
}

class A {
    public static void foo()
    {
        System.out.println("A.foo");
    }

    public class B {
        public void bar()
        {
            foo();
        }
    }
}
```
### Aşağıdaki örnekte B'nin foo metodu içerisinde kendisini çağırmaması için A sınıfının foo metodu çağrısında sınıf ismi kullanılmıştır
```java
/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte B'nin foo metodu içerisinde kendisini çağırmaması için A sınıfının foo metodu
    çağrısında sınıf ismi kullanılmıştır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String[] args)
    {
        A x = new A();
        A.B y = x.new B();

        y.foo();
    }
}

class A {
    public static void foo()
    {
        System.out.println("A.foo");
    }

    public class B {
        public void foo()
        {
            A.foo();
        }
    }
}
```
### Tekrar: "non-static bir metoda metodu çağırmakta kullanılan referans gizlice geçirilir"
```java
/*----------------------------------------------------------------------------------------------------------------------
    Tekrar: Arakod düzeyinde non-stati metot kavramı doğrudan yoktur. Tüm metotlar static metotlara dönüştürülür.
    Şüphesiz bu mantıksal bir anlatımdır. Daha aşağı seviyede static metot kavramı da yoktur. Çağırma
    işleminde de non-static metodu çağırmada kullanılan referans argüman olarak oluşturulan static metoda
    geçilir. Aşağıdaki kodlar temsili yazılmış kodlardır

    Yani kısaca şu söylenebilir:
    "non-static bir metoda metodu çağırmakta kullanılan referans gizlice geçirilir"
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String[] args)
    {
        Sample s = new Sample();

        s.foo(20);

        //Bu çağrının arakod temsili karşılığı
        Sample.foo(s, 20);

    }
}

class Sample {
    private int m_val;

    //...
    public void foo(int val)
    {
        m_val = val;
    }

    //foo metodunun arakoddaki temsili karşılığı
    public static void foo(Sample s, int val)
    {
        s.m_val = val;
    }
}
```
### Tekrar: İşte yukarıda belirtilen gizlice geçirilen adrese non-static metot içerisinde this referansı ile erişilebilir
```java
/*----------------------------------------------------------------------------------------------------------------------
    Tekrar: İşte yukarıda belirtilen gizlice geçirilen adrese non-static metot içerisinde this referansı ile
    erişilebilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String[] args)
    {

    }
}

class Sample {
    private int m_val;

    //...
    public void foo(int val)
    {
        this.m_val = val;
        this.bar();
    }

    private void bar()
    {
        //...
    }
}
```
### Tekrar: this referansını okunabilirliği bozmamak kaydıyla non-static metot çağrılarında kullanılmalıdır.
```java
/*----------------------------------------------------------------------------------------------------------------------
    Tekrar: this referansını okunabilirliği bozmamak kaydıyla non-static metot çağrılarında kullanılmalıdır. Bu durumda
    okunabilirlik açısından hangi metodun static hangi metodun non-static olduğu çağrıda anlaşılabilir duruma gelir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String[] args)
    {

    }
}

class Sample {
    private int m_val;

    //...
    public void foo(int val)
    {
        m_val = val;
        this.bar();
        tar();
    }

    private void bar()
    {
        //...
    }

    private static void tar()
    {

    }
}
```
### Tekrar: Aşağıdaki durumda this referansı kullanımı zorunludur
```java
/*----------------------------------------------------------------------------------------------------------------------
    Tekrar: Aşağıdaki durumda this referansı kullanımı zorunludur
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

class App {
    public static void main(String[] args)
    {
        Point p = new Point(100, 100);

        Console.writeLine("(%d, %d)", p.x, p.y);
    }
}

class Point {
    public int x, y;

    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}
```
### Aşağıdaki örnekte foo metodunun içerisinde this referansı B sınıfı türünden olduğundan error oluşur
```java
/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte foo metodunun içerisinde this referansı B sınıfı türünden olduğundan error oluşur
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String[] args)
    {

    }
}

class A {
    private int m_x;
    public void bar()
    {
        //..
    }

    public class B {
        public void foo(int val)
        {
            this.m_x = val; //error:
            this.bar(); //error:
        }
    }
}
```
###  Yukarıdaki durumdan dolayı aşağıdaki çağırmada exception oluşur (StackOverflowException)
```java
/*----------------------------------------------------------------------------------------------------------------------
    Yukarıdaki durumdan dolayı aşağıdaki çağırmada exception oluşur (StackOverflowException)
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String[] args)
    {
        A a = new A();
        A.B b = a.new B();

        b.foo(45);
    }
}

class A {
    private int m_x;
    public void foo()
    {
        //..
    }

    public class B {
        public void foo(int val)
        {
            m_x = val;
            this.foo(val);
        }
    }
}
```
### this expression'ın genel biçimi
```java
/*----------------------------------------------------------------------------------------------------------------------
    this expression'ın genel biçimi
        <sınıf ismi>.this
    şeklindedir. Bu durumda this expression ile kullanılan sınıf türünden referans elde edilmiş olur.
    Aşağıdaki kodda A.this diyerek B'nin içerisinde gizlice tutulan A referansına erişilmiş olur. Bu A referansı
    ilgili B nesnesinin yaratılmasında kullanılan A nesnesinin referansıdır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

class App {
    public static void main(String[] args)
    {
        A a = new A();
        A.B b = a.new B();

        b.foo(45);
    }
}

class A {
    private int m_x;
    public void foo(int val)
    {
        Console.writeLine("A.foo");
    }

    public class B {
        public void foo(int val)
        {
            m_x = val;
            Console.writeLine("B.foo");
            A.this.foo(val);
        }
    }
}
```
###  Aşağıdaki örnekte makeText metoduna foo içerisinde ilgili B nesnesinin yaratılmasında kullanılan A nesnesinin referansının geçirilmesi gerektiğinden this expression kullanılmalıdır
```java
/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte makeText metoduna foo içerisinde ilgili B nesnesinin yaratılmasında kullanılan A nesnesinin
    referansının geçirilmesi gerektiğinden this expression kullanılmalıdır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String[] args)
    {

    }
}

class Toast {
    public static void makeText(A a, String message)
    {
        //...
    }
}

class A {
    //...
    class B {
        public void foo(String message)
        {
            Toast.makeText(A.this, message);
        }
    }
}
```
### Aşağıdaki örnekte bellek sızıntısı (memory leak) oluşur.
```java
/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte bellek sızıntısı (memory leak) oluşur. İleride böyle bir senaryoda bellek sızıntısı durumunun
    nasıl engelleneceği çeşitli yöntemlerle ele alınacaktır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String[] args)
    {
        Sample.foo();
        Sample.foo();

        while (true) //Program devam ediyor
            ;
    }
}

class Sample {
    public static void foo()
    {
        A a = new A();

        a.doWork("merhaba");
    }
}
class A {
    private B m_b;

    private class B {
        public void foo(String message)
        {

        }
    }

    //...

    public void doWork(String message)
    {
        m_b = this.new B();

        m_b.foo(message);
    }
}

/*----------------------------------------------------------------------------------------------------------------------

----------------------------------------------------------------------------------------------------------------------*/
```
