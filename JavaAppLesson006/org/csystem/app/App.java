/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Klavyeden alınan gün, ay ve yıl bilgilerine göre kişinin doğum günü geçmişse
    "geçmiş doğum gününü kutlu olsun", o an doğum günü ise "doğum gününüz kutlu olsun", doğum henüz gelmemişse
    "doğum gününüz şimdiden kutlu olsun" mesajlarından birini ekrana basan programı Calendar sınıfını kullanarak yazınız
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.util.Calendar;

class App {
    public static void main(String[] args)
    {
        Calendar now = Calendar.getInstance();

        Console.writeLine("%02d/%02d/%04d %02d:%02d:%02d.%03d",
                now.get(Calendar.DAY_OF_MONTH),
                now.get(Calendar.MONTH) + 1,
                now.get(Calendar.YEAR),
                now.get(Calendar.HOUR_OF_DAY),
                now.get(Calendar.MINUTE),
                now.get(Calendar.SECOND),
                now.get(Calendar.MILLISECOND));

        now.set(Calendar.HOUR_OF_DAY, 10);

        Console.writeLine("%02d/%02d/%04d %02d:%02d:%02d.%03d",
                now.get(Calendar.DAY_OF_MONTH),
                now.get(Calendar.MONTH) + 1,
                now.get(Calendar.YEAR),
                now.get(Calendar.HOUR_OF_DAY),
                now.get(Calendar.MINUTE),
                now.get(Calendar.SECOND),
                now.get(Calendar.MILLISECOND));
    }
}
