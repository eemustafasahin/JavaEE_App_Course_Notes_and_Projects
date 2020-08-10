package org.csystem.app.samples.dateapp;

public class DateUtil {
	private static int [] ms_daysOfMonths = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private  static  String [] ms_weekDaysTR = {"Pazar", "Pazartesi", "Salı", "Çarşamba", "Perşembe", "Cuma", "Cumartesi"};
	private  static  String [] ms_weekDaysEN = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
	private static String [] ms_monthsTR = {"", "Ocak", "Şubat", "Mart", "Nisan", "Mayıs", "Haziran",
										"Temmuz", "Ağustos", "Eylül", "Ekim", "Kasım", "Aralık"};
	private static String [] ms_monthsEN = {"", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

	private DateUtil() {}

	public static void displayDateTR(int day, int mon, int year)
	{
		int dayOfWeek = getDayOfWeek(day, mon, year);
		
		if (dayOfWeek == -1) {
			System.out.println("Geçersiz tarih");
			return;
		}

		System.out.printf("%02d %s %04d %s%n", day, ms_monthsTR[mon], year, ms_weekDaysTR[dayOfWeek]);
		
		if (isWeekend(day, mon, year))
			System.out.println("Bugün kurs var. Tekrar yaptınız mı?");
		else
			System.out.println("Tekrar yapmayı unutmayınız!!!");
	}

	public static void displayDateEN(int day, int mon, int year)
	{
		int dayOfWeek = getDayOfWeek(day, mon, year);

		if (dayOfWeek == -1) {
			System.out.println("Geçersiz tarih");
			return;
		}

		System.out.printf("%02d %s %04d %s%n", day, ms_monthsEN[mon], year, ms_weekDaysEN[dayOfWeek]);
	}

	public static boolean isWeekend(int day, int mon, int year)
	{		
		int dayOfWeek = getDayOfWeek(day, mon, year);
		
		//...
		
		return dayOfWeek == 0 || dayOfWeek == 6;
	}
	
	public static boolean isWeekday(int day, int mon, int year)
	{
		return !isWeekend(day, mon, year);		
	}
	
	public static int getDayOfWeek(int day, int mon, int year)
	{
		int dayOfYear = getDayOfYear(day, mon, year);
		
		if (dayOfYear == -1 || year < 1900)
			return -1;
		
		int totalDays = dayOfYear;
		
		for (int y = 1900; y < year; ++y)
			totalDays += isLeapYear(y) ? 366 : 365;
		
		return totalDays % 7;		
	}
	
	public static int getDayOfYear(int day, int mon, int year)
	{
		if (!isValidDate(day, mon, year))
			return -1;

		int dayOfYear = day;
		
		for (int m = mon - 1; m >= 1; --m)
			dayOfYear += ms_daysOfMonths[m];

		if (mon > 2 && isLeapYear(year))
			++dayOfYear;

		return dayOfYear;		
	}
	
	public static boolean isValidDate(int day, int mon, int year)
	{
		if (day < 1 || day > 31 || mon < 1 || mon > 12)		
			return false;

		int days = mon == 2 && isLeapYear(year) ? 29 : ms_daysOfMonths[mon];
		
		return day <= days;		
	}
	
	public static boolean isLeapYear(int year)	
	{
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	}
}