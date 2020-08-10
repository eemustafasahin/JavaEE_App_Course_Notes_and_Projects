/*----------------------------------------------------------------------------------------------------------------------
	Sınıf Çalışması: Parametresi ile aldığı gün, ay ve yıl bilgisine ilişkin tarihin aşağıdaki açıklamalara
	göre yılın hangi günü olduğu bilgisini döndüren getDayOfWeek isimli metodu yazınız.
	Açıklamalar:
	- Metot geçersiz bir tarih için -1 değerine dönecektir
	- Metot 1900 yılından önceki tarihler için geçersiz tarih kabul edecektir.
	- Gün bilgisi "1.1.1900 ile verilen tarih arasındaki geçen gün sayısının 7 ile bölümünden elde
	edilen kalan" ile bulunabilir. Kalan değeri 0 için Pazar, 1 için Pazartesi, ..., 6 için Cumartesi
	olacak şekilde düşünülmelidir
	- Tarih bilgisi gün bilgisi ile birlikte yazdırılacaktır. Yazdırma işlemi için displayDateTR ve
	displayDateEN isimli Türkçe ve İngilizce olarak ekrana basan metotlar yazılarak yapılabilir
	- Tarih hafta sonuna geliyorsa "Bugün kurs var. Tekrar yaptınız mı?" mesajı hafta içi bir güne geliyorsa
	"Tekrar yapmayı unutmayınız" biçiminde mesaj yazılacaktır
	- İleride daha iyileri yazılacak
----------------------------------------------------------------------------------------------------------------------*/

package org.csystem.app.samples.dateapp;

import org.csystem.util.datetime.Date;

public class DateTestApp {
	private DateTestApp() {}

	public static void run()
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		for (;;) {
			System.out.print("Gün?");
			int day = Integer.parseInt(kb.nextLine());
			
			if (day == 0)
				break;
			
			System.out.print("Ay?");
			int mon = Integer.parseInt(kb.nextLine());
			
			System.out.print("Yıl?");
			int year = Integer.parseInt(kb.nextLine());

			Date date = new Date(day, mon, year);

			System.out.println(date.toLongDateStringTR());
			System.out.println(date.toLongDateStringEN());

			if (date.isWeekend())
				System.out.println("Bugün kurs var tekrar yaptnız mı?");
			else
				System.out.println("Hafta sonu kurs var tekrar yapmayı unutmayınız!!!");
		}				
	}
}