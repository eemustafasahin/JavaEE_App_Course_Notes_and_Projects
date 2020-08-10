### StringBuilder sınıfının subString metodu
```java
/*----------------------------------------------------------------------------------------------------------------------
    StringBuilder sınıfının subString metodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

class App {
    public static void main(String [] args)
    {
        StringBuilder sb = new StringBuilder("ankara");

        Console.writeLine(sb.substring(2));
        Console.writeLine(sb.substring(2, 5));
    }
}
```
### Sınıf Çalışması: String birleştirme
```java
/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Klavyeden quit girilene kadar alınan yazıların arasında - olacak şekilde birleştiren
    ve bir String elde eden programı yazınız. Programda tamamyla boşluk karakterlerinden oluşan yazılar
    dikkate alınmayacaktır.
    Not: String sınıfına Java 11 ile birlikte isBlank isimli bir metot eklenmiştir bu metot bir yazının tamamen
    boşluk karaktelerinden oluşup oluşmadığını test etmekte kullanılır. Bu metottan önce bu işlemin
        s.trim().isEmpty()
    ile yapılabileceğini anımsayınız
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

class App {
    public static void main(String [] args)
    {
        ConcatWithDelimApp.run();
    }
}

class ConcatWithDelimApp {
    public static void run()
    {
        StringBuilder sb = new StringBuilder();

        for (;;) {
            String s = Console.read("Bir yazı giriniz:");

            if (s.isBlank())
                continue;

            if (s.equals("quit"))
                break;

            if (sb.length() > 0)
                sb.append('-');

            sb.append(s);
        }

        String str = sb.toString();

        Console.writeLine(str);
    }
}
```
### Sınıf Çalışması: Stringler arasına tire koyarak birleştirme
```java
/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Klavyeden quit girilene kadar alınan yazıların arasında - olacak şekilde birleştiren
    ve bir String elde eden programı yazınız. Programda tamamyla boşluk karakterlerinden oluşan yazılar
    dikkate alınmayacaktır.
    Not: String sınıfına Java 11 ile birlikte isBlank isimli bir metot eklenmiştir bu metot bir yazının tamamen
    boşluk karaktelerinden oluşup oluşmadığını test etmekte kullanılır. Bu metottan önce bu işlemin
        s.trim().isEmpty()
    ile yapılabileceğini anımsayınız
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

class App {
    public static void main(String [] args)
    {
        ConcatWithDelimApp.run();
    }
}

class ConcatWithDelimApp {
    public static void run()
    {
        StringBuilder sb = new StringBuilder();

        for (;;) {
            String s = Console.read("Bir yazı giriniz:");

            if (s.isBlank())
                continue;

            if (s.equals("quit"))
                break;

            sb.append(s).append('-');
        }

        String str = sb.substring(0, sb.length() - 1);
        Console.writeLine(str);
    }
}
```
 ### Sınıf Çalışması: Birinci yazıdan ikinci yazıyı çıkarma
```java
/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Parametresi ile aldığı iki yazıdan birincisi içerisinden ikincisinin karaketerlerinin
    atılmış olduğu yazıyı döndüren squeeze isimli metodu StringUtil sınıfı içerisinde yazınız.
    Örnek: adana, ankara -> d
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;
import org.csystem.util.StringUtil;

class App {
    public static void main(String [] args)
    {
        SqueezeTest.run();
    }
}

class SqueezeTest {
    public static void run()
    {
        for (;;) {
            String s1 = Console.read("Birinci yazıyı giriniz");
            String s2 = Console.read("İkinci yazıyı giriniz");

            Console.writeLine("Sonuç:%s", StringUtil.squeeze(s1, s2));

            if (s1.equals("quit"))
                break;
        }

        Console.writeLine("Tekrar yapıypr musunuz?");
    }
}
```
###  StringBuilder sınıfının String parametreli ctor'u capacity değerini yazının uzunluğu + 16 değerine çeker
```java
/*----------------------------------------------------------------------------------------------------------------------
    StringBuilder sınıfının String parametreli ctor'u capacity değerini yazının uzunluğu + 16 değerine çeker
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;
import org.csystem.util.StringUtil;

class App {
    public static void main(String [] args)
    {
        StringBuilder sb = new StringBuilder("ankara");

        Console.writeLine("Capacity:%d", sb.capacity());
        Console.writeLine("Length:%d", sb.length());
    }
}
```
### StringBuilder sınıfının insert metodu
```java
/*----------------------------------------------------------------------------------------------------------------------
    StringBuilder sınıfının insert metodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

class App {
    public static void main(String [] args)
    {
        StringBuilder sb = new StringBuilder();
        
        for (;;) {
            String str = Console.read("Bir yazı giriniz:");

            if (str.equals("quit"))
                break;

            sb.insert(0, str);
        }

        Console.writeLine(sb);
    }
}
```
### StringBuilder sınıfının setLength metodu ile uzunluk değiştirilebilir. Eğer büyütülürse eklenen karakterler yerine null karakter '\0' karakteri yarleştirilir
```java
/*----------------------------------------------------------------------------------------------------------------------
    StringBuilder sınıfının setLength metodu ile uzunluk değiştirilebilir. Eğer büyütülürse eklenen
    karakterler yerine null karakter '\0' karakteri yarleştirilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

class App {
    public static void main(String [] args)
    {
        StringBuilder sb = new StringBuilder("ankara");

        Console.writeLine("Length:%d", sb.length());
        sb.setLength(10);
        Console.writeLine("Length:%d", sb.length());
        sb.append("istanbul");

        Console.writeLine("Length:%d", sb.length());
        Console.writeLine(sb);

        Console.writeLine("//////////////////////////");

        for (int i = 0; i < sb.length(); ++i)
            if (sb.charAt(i) == '\0')
                Console.write("%d ", i);

        Console.writeLine();
    }
}
```
### StringBuilder sınıfının setLength metodu ile uzunluk küçültülebilir
```java
/*----------------------------------------------------------------------------------------------------------------------
    StringBuilder sınıfının setLength metodu ile uzunluk küçültülebilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

class App {
    public static void main(String [] args)
    {
        StringBuilder sb = new StringBuilder("ankara");

        Console.writeLine("Length:%d", sb.length());
        Console.writeLine("Capacity:%d", sb.capacity());

        sb.setLength(2);
        Console.writeLine("Length:%d", sb.length());
        Console.writeLine("Capacity:%d", sb.capacity());

        Console.writeLine(sb);
    }
}
```
### StringBuilder sınıfının trimToSize metodu
```java
/*----------------------------------------------------------------------------------------------------------------------
    StringBuilder sınıfının trimToSize metodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

class App {
    public static void main(String [] args)
    {
        StringBuilder sb = new StringBuilder("ankara");

        Console.writeLine("Length:%d", sb.length());
        Console.writeLine("Capacity:%d", sb.capacity());

        sb.trimToSize();

        Console.writeLine("Length:%d", sb.length());
        Console.writeLine("Capacity:%d", sb.capacity());
    }
}
```
### StringBuilder sınıfının replace metodu
```java
/*----------------------------------------------------------------------------------------------------------------------
    StringBuilder sınıfının replace metodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

class App {
    public static void main(String [] args)
    {
        StringBuilder sb = new StringBuilder("Benim adım Ali. Nasılsın");

        sb.replace(11, 14, "Veli");

        Console.writeLine(sb);

    }
}
```
# var anahtar sözcüğü
```java
/*----------------------------------------------------------------------------------------------------------------------
    var anahtar sözcüğü Java 10 ile eklenmiştir. Yerel değişkenlerde ve ileride göreceğimiz Lambda
    ifadelerinde (Java 11) kullanılabilir. Bu anahtar sözcük sonradan eklendiği için kullanım yerine
    göre anahtar sözcük olup olmadığı anlaşılır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

class App {
    public static void main(String [] args)
    {
        int var;

        var = 20;

        Console.writeLine(var);
    }
}
```
###  var ile bildirilen bir değişkenlere ilk değer verilmelidir
```java
/*----------------------------------------------------------------------------------------------------------------------
    var ile bildirilen bir değişkenlere ilk değer verilmelidir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

class App {
    public static void main(String [] args)
    {
        var a; //error

        a = 10;


    }
}
```
### var ile bildirilen bir değişkene verilen ilk değere göre türü tespit edilir (type deduction, inference).
```java
/*----------------------------------------------------------------------------------------------------------------------
    var ile bildirilen bir değişkene verilen ilk değere göre türü tespit edilir (type deduction, inference).
    ve değişken yaşamı boyunca aynı türdedir. Java' da bir değişkenin türünün değişmeyeceğini anımsayınız
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        var a = 10;

        a = 2.3; //error
    }
}
```
### Java' da bir değişkenin türünün değişmeyeceğini anımsayınız
```java
/*----------------------------------------------------------------------------------------------------------------------
    var ile bildirilen bir değişkene verilen ilk değere göre türü tespit edilir (type deduction, inference).
    ve değişken yaşamı boyunca aynı türdedir. Java' da bir değişkenin türünün değişmeyeceğini anımsayınız
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

class App {
    public static void main(String [] args)
    {
        var sb = new StringBuilder();

        sb.append(10);

        Console.writeLine(sb);
    }
}
```
### var değişkenler for döngü deyiminde de kullanılabilir
```java
/*----------------------------------------------------------------------------------------------------------------------
    var değişkenler for döngü deyiminde de kullanılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

class App {
    public static void main(String [] args)
    {
        for (var i = 1.3; i < 2.3; i += 0.1)
            Console.writeLine(i);
    }
}
```
### var değişkenler parametre değişkenlerinde ve sınıf veri elemanlarında kullanılamaz
```java
/*----------------------------------------------------------------------------------------------------------------------
    var değişkenler parametre değişkenlerinde ve sınıf veri elemanlarında kullanılamaz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

class App {
    public static void main(String [] args)
    {

    }
}

class Sample {
    public var x; //error

    public void foo(var a) //error
    {
        //...
    }
}
```
###  Aşağıdaki örnekte b nin türü double olmaktadır
```java
/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte b nin türü double olmaktadır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

class App {
    public static void main(String [] args)
    {
        var a = Console.readInt("Bir sayı giriniz:");
        var b = a > 0 ? 12 : 3.4;

        Console.writeLine("b=%d", b);
    }
}
```
### Aşağıdaki örnekte b nin türünün ne olduğu ileride ele alınacaktır. Şu an mantıksal olarak atanan değerin türü olur denebilir
```java
/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte b nin türünün ne olduğu ileride ele alınacaktır. Şu an mantıksal olarak
    atanan değerin türü olur denebilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

class App {
    public static void main(String [] args)
    {
        var a = Console.readInt("Bir sayı giriniz:");
        var b = a > 0 ? 12 : "ankara";

        Console.writeLine("b=%s", b);
    }
}
```
### Aşağıdaki örnekte yine yuvarlama hatası oluşur
```java
/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte yine yuvarlama hatası oluşur
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

class App {
    public static void main(String [] args)
    {
        float a = 0.134F;

        Console.writeLine("a=%.20f", a);
    }
}
```
### Aşağıdaki örnekte yine klavyeden girilen değere göre yuvarlama hatası oluşabilir
```java
/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte yine klavyeden girilen değere göre yuvarlama hatası oluşabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

class App {
    public static void main(String [] args)
    {
        float a = Console.readFloat("Bir sayı giriniz:");

        Console.writeLine("a=%.20f", a);
    }
}
```
### Aşağıdaki örnekte double türü için mantıksal bir eşitlik karşılaştırması yaklaşımı yazılmıştır
```java
/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte double türü için mantıksal bir eşitlik karşılaştırması yaklaşımı yazılmıştır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

class App {
    public static void main(String [] args)
    {
        double a = Console.readDouble("Birinci sayıyı giriniz:");
        double b = Console.readDouble("İkinci sayıyı giriniz:");
        double c = Console.readDouble("Üçüncü sayıyı giriniz:");
        double d;

        d = a + b;
        Console.writeLine("a=%.20f", a);
        Console.writeLine("b=%.20f", b);
        Console.writeLine("c=%.20f", c);
        Console.writeLine("d=%.20f", d);

        double e = 0.0001;

        if (Math.abs(c - d) < e)
            Console.writeLine("Eşit");
        else
            Console.writeLine("Eşit değil");
    }
}
```
###  Aşağıdaki örnekte double türü için mantıksal bir eşitlik karşılaştırması yaklaşımı yazılmıştır
```java
/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte double türü için mantıksal bir eşitlik karşılaştırması yaklaşımı yazılmıştır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

class App {
    public static void main(String [] args)
    {
        double a = Console.readDouble("Birinci sayıyı giriniz:");
        double b = Console.readDouble("İkinci sayıyı giriniz:");
        double c = Console.readDouble("Üçüncü sayıyı giriniz:");
        double d;

        d = a + b;
        Console.writeLine("a=%.20f", a);
        Console.writeLine("b=%.20f", b);
        Console.writeLine("c=%.20f", c);
        Console.writeLine("d=%.20f", d);

        String cStr = String.format("%.4f", c);
        String dStr = String.format("%.4f", d);

        if (cStr.equals(dStr))
            Console.writeLine("Eşit");
        else
            Console.writeLine("Eşit değil");
    }
}
```
### Aşağıdaki örnekte double türü için mantıksal bir eşitlik karşılaştırması yaklaşımı yazılmıştır
```java
/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte double türü için mantıksal bir eşitlik karşılaştırması yaklaşımı yazılmıştır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

class App {
    public static void main(String [] args)
    {
        double a = Console.readDouble("Birinci sayıyı giriniz:");
        double b = Console.readDouble("İkinci sayıyı giriniz:");
        double c = Console.readDouble("Üçüncü sayıyı giriniz:");
        double d;

        d = a + b;
        Console.writeLine("a=%.20f", a);
        Console.writeLine("b=%.20f", b);
        Console.writeLine("c=%.20f", c);
        Console.writeLine("d=%.20f", d);

        c = Math.rint(c * Math.pow(10, 4)) / Math.pow(10, 4);
        d = Math.rint(d * Math.pow(10, 4)) / Math.pow(10, 4);

        Console.writeLine("c=%.20f", c);
        Console.writeLine("d=%.20f", d);

        if (c == d)
            Console.writeLine("Eşit");
        else
            Console.writeLine("Eşit değil");
    }
}
```
# BigDecimal sınıfı
```java
/*----------------------------------------------------------------------------------------------------------------------
    BigDecimal sınıfı genel olarak yuvralamanın nasıl olacağının belirlenebildiği aynı zamanda çok büyük
    çok küçük gerçek sayılar ile çalışabilmek için tasarlanmıştır. Yuvarlama hatalarının belirlenebilmesi
    yuvarlama yapılmamasını da belirleyebilmemizi sağlar. Aşağıdaki örnekte yuvarlama hatası olmayan gerçek
    sayı işlemi yapılmıştır. BigDecimal sınıfı immutable bir sınıftır
----------------------------------------------------------------------------------------------------------------------*/
```
### Aşağıdaki örnekte yuvarlama hatası olmayan gerçek sayı işlemi yapılmıştır
```java
/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte yuvarlama hatası olmayan gerçek sayı işlemi yapılmıştır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.math.BigDecimal;

class App {
    public static void main(String [] args)
    {
        var a = BigDecimal.valueOf(0.1);
        var b = BigDecimal.valueOf(0.2);
        var c = a.add(b);

        Console.writeLine("%.20f", c.doubleValue());
    }
}
```
### BigDecimal sınıfının static ONE, ZERO ve TEN veri elemanları
```java
/*----------------------------------------------------------------------------------------------------------------------
    BigDecimal sınıfının static ONE, ZERO ve TEN veri elemanları
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.math.BigDecimal;

class App {
    public static void main(String [] args)
    {
        var one = BigDecimal.ONE;
        var zero = BigDecimal.ZERO;
        var ten = BigDecimal.TEN;

        Console.writeLine(one);
        Console.writeLine(zero);
        Console.writeLine(ten);
    }
}
```
###  BigDecimal sınıfının int parametreli ctor'u
```java
/*----------------------------------------------------------------------------------------------------------------------
    BigDecimal sınıfının int parametreli ctor'u
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.math.BigDecimal;

class App {
    public static void main(String [] args)
    {
        int val = Console.readInt("Bir sayı giriniz:");
        var bd = new BigDecimal(val);

        //...
        Console.write(bd);
    }
}
```
### BigDecimal sınıfının String parametreli ctor'u
```java
/*----------------------------------------------------------------------------------------------------------------------
    BigDecimal sınıfının String parametreli ctor'u
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.math.BigDecimal;

class App {
    public static void main(String [] args)
    {
        var valStr = Console.read("Bir sayı giriniz:");
        var bd = new BigDecimal(valStr);

        //...
        Console.write(bd);
    }
}
```
### BigDecimal sınıfının double porametreli ctor elemanı default olarak yuvarlama işlemi yapar. Bu ctor ile elde edilen değerin BigDecimal içerisindeki değeri aynı olmayabilir.
```java
/*----------------------------------------------------------------------------------------------------------------------
    BigDecimal sınıfının double porametreli ctor elemanı default olarak yuvarlama işlemi yapar. Bu ctor ile elde edilen
    değerin BigDecimal içerisindeki değeri aynı olmayabilir. Programcı bu duruma dikkat etmelidir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.math.BigDecimal;

class App {
    public static void main(String [] args)
    {
        var bd1 = new BigDecimal(0.123100001);
        var bd2 = new BigDecimal(-0.367900001);

        var result = bd1.add(bd2);

        Console.writeLine(result);
    }
}
```
### Yukarıdaki problem valueOf metodu kullanılarak çözülebilir. Aşağıdaki örnekte yaratılam BigDecimal nesneleri yuvarlama hatası olmayacak şekilde işlem yaparlar
```java
/*----------------------------------------------------------------------------------------------------------------------
    Yukarıdaki problem valueOf metodu kullanılarak çözülebilir. Aşağıdaki örnekte yaratılam BigDecimal nesneleri
    yuvarlama hatası olmayacak şekilde işlem yaparlar
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.math.BigDecimal;

class App {
    public static void main(String [] args)
    {
        var bd1 = BigDecimal.valueOf(0.123100001);
        var bd2 = BigDecimal.valueOf(-0.367900001);

        var result = bd1.add(bd2);

        Console.writeLine(result);
    }
}
```
### BigDecimal sınıfının multiply metodu
```java
/*----------------------------------------------------------------------------------------------------------------------
    BigDecimal sınıfının multiply metodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

class App {
    public static void main(String [] args)
    {
        var bd1 = Console.readBigDecimal("Birinci sayıyı giriniz:", "Hatalı giriş!");
        var bd2 = Console.readBigDecimal("Birinci sayıyı giriniz:", "Hatalı giriş!");
        var result = bd1.multiply(bd2);

        Console.writeLine(result);
    }
}
```
### BigDecimal sınıfının abs metodu
```java
/*----------------------------------------------------------------------------------------------------------------------
    BigDecimal sınıfının abs metodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.math.BigDecimal;

class App {
    public static void main(String [] args)
    {
        var bd = Console.readBigDecimal("Bir sayı giriniz:");
        var abs = bd.abs();

        Console.writeLine(bd);
        Console.writeLine(abs);

        Console.write(bd == abs);
    }
}
```
### BigDecimal sınıfının equals metodu
```java
/*----------------------------------------------------------------------------------------------------------------------
    BigDecimal sınıfının equals metodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.math.BigDecimal;

class App {
    public static void main(String [] args)
    {
        var bd1 = Console.readBigDecimal("Birinci sayıyı giriniz:");
        var bd2 = Console.readBigDecimal("İkinci sayıyı giriniz:");

        Console.writeLine(bd1.equals(bd2) ? "Aynı sayı" : "Farklı sayılar");
    }
}
```
### BigDecimal sınıfının compareTo metodu:
```java
/*----------------------------------------------------------------------------------------------------------------------
    BigDecimal sınıfının compareTo metodu:
    res = x.compareTo(y);
    çağrısı için:
    1. x < y ise res == -1
    2. x > y ise res == 1
    3. x == y ise res == 0
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.math.BigDecimal;

class App {
    public static void main(String [] args)
    {
        var bd1 = Console.readBigDecimal("Birinci sayıyı giriniz:");
        var bd2 = Console.readBigDecimal("İkinci sayıyı giriniz:");

        Console.writeLine(bd1.compareTo(bd2));
    }
}
```
### BigDecimal sınıfının pow metodu
```java
/*----------------------------------------------------------------------------------------------------------------------
    BigDecimal sınıfının pow metodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.math.BigDecimal;

class App {
    public static void main(String [] args)
    {
        var bd1 = Console.readBigDecimal("Bir sayı giriniz:");
        var n = Console.readInt("Üssü giriniz:");
        var result = bd1.pow(n);

        Console.writeLine(result);
    }
}
```
###  Aşağıdaki örnekte [star, end) arasındaki BigDecimal sayılar toplanmıştır
```java
/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte [star, end) arasındaki BigDecimal sayılar toplanmıştır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.math.BigDecimal;

class App {
    public static void main(String [] args)
    {
        var start = Console.readBigDecimal("Birinci sayıyı giriniz:");
        var end = Console.readBigDecimal("İkinci sayıyı giriniz:");
        var sum = BigDecimal.ZERO;

        for (var bd = start; bd.compareTo(end) < 0; bd = bd.add(BigDecimal.ONE))
            sum = sum.add(bd);

        Console.writeLine("Toplam:%s", sum);

        Console.writeLine("Tekrar yapıyor musunuz?");
    }
}
```
### BigDecimal sınıfı
```java
/*----------------------------------------------------------------------------------------------------------------------
    BigDecimal sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.math.BigDecimal;

class App {
    public static void main(String [] args)
    {
        var start = Console.readBigDecimal("Birinci sayıyı giriniz:");
        var end = Console.readBigDecimal("İkinci sayıyı giriniz:");
        var sum = BigDecimal.ZERO;
        var inc = BigDecimal.valueOf(1.03);

        for (var bd = start; bd.compareTo(end) < 0; bd = bd.add(inc)) {
            Console.writeLine(bd);
            sum = sum.add(bd);
        }

        Console.writeLine("Toplam:%s", sum);

        Console.writeLine("Tekrar yapıyor musunuz?");
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    BigDecimal sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.math.BigDecimal;

class App {
    public static void main(String [] args)
    {
        var start = Console.readBigDecimal("Birinci sayıyı giriniz:");
        var end = Console.readBigDecimal("İkinci sayıyı giriniz:");
        var sum = BigDecimal.ZERO;
        var inc = BigDecimal.valueOf(1.03);

        for (var bd = start; bd.compareTo(end) < 0; bd = bd.add(inc)) {
            Console.writeLine(bd);
            sum = sum.add(bd);
        }

        Console.writeLine("Toplam:%s", sum);

        Console.writeLine("Tekrar yapıyor musunuz?");
    }
}
```
### BigDecimal sınıfının sqrt metodu
```java
/*----------------------------------------------------------------------------------------------------------------------
    BigDecimal sınıfının sqrt metodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.math.MathContext;
import java.math.RoundingMode;

class App {
    public static void main(String [] args)
    {
        var bd = Console.readBigDecimal("Bir sayı giriniz:");
        var sqrt = bd.sqrt(new MathContext(30, RoundingMode.HALF_UP)); // var sqrt = bd.sqrt(new MathContext(20));

        Console.writeLine(sqrt);
    }
}
```
### BigDecimal sınıfının divide metodu
```java
/*----------------------------------------------------------------------------------------------------------------------
    BigDecimal sınıfının divide metodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.math.RoundingMode;

class App {
    public static void main(String [] args)
    {
        var bd1 = Console.readBigDecimal("Birinci sayıyı giriniz:");
        var bd2 = Console.readBigDecimal("İkinci sayıyı giriniz:");
        var result = bd1.divide(bd2, 10, RoundingMode.HALF_UP);

        Console.writeLine(result);
    }
}
```
### BigDecimal sınıfının divide metodu
```java
/*----------------------------------------------------------------------------------------------------------------------
    BigDecimal sınıfının divide metodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.math.MathContext;
import java.math.RoundingMode;

class App {
    public static void main(String [] args)
    {
        var bd1 = Console.readBigDecimal("Birinci sayıyı giriniz:");
        var bd2 = Console.readBigDecimal("İkinci sayıyı giriniz:");
        var result = bd1.divide(bd2, new MathContext(10, RoundingMode.HALF_UP));

        Console.writeLine(result);
    }
}
```
### Sınıf Çalışması: Klavyeden sıfır girilene kadar alınan BigDecimal sayıların en büyüğünü, en küçüğünü ve toplamlarını bulan programı yazınız
```java
/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Klavyeden sıfır girilene kadar alınan BigDecimal sayıların en büyüğünü, en küçüğünü
    ve toplamlarını bulan programı yazınız
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.math.BigDecimal;

class App {
    public static void main(String [] args)
    {
        FindMinMaxTotalApp.run();
    }
}

class FindMinMaxTotalApp {
    public static void run()
    {
        var val = Console.readBigDecimal("Bir sayı giriniz:");

        if (!val.equals(BigDecimal.ZERO)) {
            var min = val;
            var max = val;
            var sum = val;

            for (;;) {
                val = Console.readBigDecimal("Bir sayı giriniz:");
                if (val.equals(BigDecimal.ZERO))
                    break;

                if (val.compareTo(min) < 0)
                    min = val;

                if (max.compareTo(val) < 0)
                    max = val;

                sum = sum.add(val);
            }

            Console.writeLine("En küçük sayı:%s", min);
            Console.writeLine("En büyük sayı:%s", max);
            Console.writeLine("Toplam:%s", sum);
        }
        else
            Console.writeLine("Hiç sayı girilmedi");
    }
}
```
### Sınıf Çalışması: Klavyeden sıfır girilene kadar alınan BigDecimal sayıların en büyüğünü, en küçüğünü ve toplamlarını bulan programı yazınız
```java
/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Klavyeden sıfır girilene kadar alınan BigDecimal sayıların en büyüğünü, en küçüğünü
    ve toplamlarını bulan programı yazınız
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.math.BigDecimal;

class App {
    public static void main(String [] args)
    {
        FindMinMaxTotalApp.run();
    }
}

class FindMinMaxTotalApp {
    public static void run()
    {
        var val = Console.readBigDecimal("Bir sayı giriniz:");

        if (!val.equals(BigDecimal.ZERO)) {
            var min = val;
            var max = val;
            var sum = val;

            for (;;) {
                val = Console.readBigDecimal("Bir sayı giriniz:");
                if (val.equals(BigDecimal.ZERO))
                    break;

                if (val.compareTo(min) < 0)
                    min = val;

                if (max.compareTo(val) < 0)
                    max = val;

                sum = sum.add(val);
            }

            Console.writeLine("En küçük sayı:%s", min);
            Console.writeLine("En büyük sayı:%s", max);
            Console.writeLine("Toplam:%s", sum);
        }
        else
            Console.writeLine("Hiç sayı girilmedi");
    }
}
```
### Yukarıdaki örnek double türü için aşağıdaki gibi yapılabilir. Yaklaşım farkını inceleyiniz
```java
/*----------------------------------------------------------------------------------------------------------------------
    Yukarıdaki örnek double türü için aşağıdaki gibi yapılabilir. Yaklaşım farkını inceleyiniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

class App {
    public static void main(String [] args)
    {
        FindMinMaxTotalApp.run();
    }
}

class FindMinMaxTotalApp {
    public static void run()
    {
        double sum = 0;
        double min = Double.POSITIVE_INFINITY;
        double max = Double.NEGATIVE_INFINITY;
        double val = Console.readDouble("Bir sayı giriniz:");

        if (val != 0) {
            for (;;) {
                if (val < min)
                    min = val;
                if (max < val)
                    max = val;
                sum += val;
                val = Console.readDouble("Bir sayı giriniz:");

                if (val == 0)
                    break;
            }

            Console.writeLine("En küçük sayı:%.40f", min);
            Console.writeLine("En büyük sayı:%.40f", max);
            Console.writeLine("Toplam:%.20f", sum);
        }
        else
            Console.writeLine("Hiç sayı girmediniz");
    }
}
```
### Yukarıdaki BigDecimal ile yapıalm örnek double türü için aşağıdaki gibi yapılabilir. Yaklaşım farkını inceleyiniz
```java
/*----------------------------------------------------------------------------------------------------------------------
    Yukarıdaki BigDecimal ile yapıalm örnek double türü için aşağıdaki gibi yapılabilir. Yaklaşım farkını inceleyiniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

class App {
    public static void main(String [] args)
    {
        FindMinMaxTotalApp.run();
    }
}

class FindMinMaxTotalApp {
    public static void run()
    {
        double sum = 0;
        double min = Double.MAX_VALUE;
        double max = -Double.MAX_VALUE;
        double val = Console.readDouble("Bir sayı giriniz:");

        if (val != 0) {
            for (;;) {
                if (val < min)
                    min = val;
                if (max < val)
                    max = val;
                sum += val;
                val = Console.readDouble("Bir sayı giriniz:");

                if (val == 0)
                    break;
            }

            Console.writeLine("En küçük sayı:%.40f", min);
            Console.writeLine("En büyük sayı:%.40f", max);
            Console.writeLine("Toplam:%.20f", sum);
        }
        else
            Console.writeLine("Hiç sayı girmediniz");
    }
}
```
### BigDecimal sınıfının devideAndRemainder metodu
```java
/*----------------------------------------------------------------------------------------------------------------------
    BigDecimal sınıfının devideAndRemainder metodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

class App {
    public static void main(String [] args)
    {
        var bd1 = Console.readBigDecimal("Birinci sayıyı giriniz:");
        var bd2 = Console.readBigDecimal("İkinci sayıyı giriniz:");
        BigDecimal [] result = bd1.divideAndRemainder(bd2, new MathContext(10, RoundingMode.HALF_UP));

        Console.writeLine("Bölüm:%s", result[0]);
        Console.writeLine("Kalan:%s", result[1]);
    }
}
```
### BigDecimal sınıfının min ve max metotları
```java
/*----------------------------------------------------------------------------------------------------------------------
    BigDecimal sınıfının min ve max metotları
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.math.BigDecimal;

class App {
    public static void main(String [] args)
    {
        FindMinMaxTotalApp.run();
    }
}

class FindMinMaxTotalApp {
    public static void run()
    {
        var val = Console.readBigDecimal("Bir sayı giriniz:");

        if (!val.equals(BigDecimal.ZERO)) {
            var min = val;
            var max = val;
            var sum = val;

            for (;;) {
                val = Console.readBigDecimal("Bir sayı giriniz:");
                if (val.equals(BigDecimal.ZERO))
                    break;

                min = min.min(val);
                max = max.max(val);
                sum = sum.add(val);
            }

            Console.writeLine("En küçük sayı:%s", min);
            Console.writeLine("En büyük sayı:%s", max);
            Console.writeLine("Toplam:%s", sum);
        }
        else
            Console.writeLine("Hiç sayı girilmedi");
    }
}
```
### Sınıf Çalışması: Klavyeden BigDecimal türden bir değer isteyiniz. Bu işlemden sonra klavyeden sıfır girilenekadar alınan BigDecimal sayıları virgülden sonra yine klavyeden istenecek basamak olacak şekilde ilk istenen sayıya bölümlerinin toplamını bulan programı yazınız
```java
/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Klavyeden BigDecimal türden bir değer isteyiniz. Bu işlemden sonra klavyeden sıfır girilene
    kadar alınan BigDecimal sayıları virgülden sonra yine klavyeden istenecek basamak olacak şekilde ilk istenen
    sayıya bölümlerinin toplamını bulan programı yazınız
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

class App {
    public static void main(String [] args)
    {
        FindTotalApp.run();
    }
}

class FindTotalApp {
    public static void run()
    {
        var divisor = Console.readBigDecimal("Bölen sayıyı giriniz:");
        var total = BigDecimal.ZERO;

        for (;;) {
            var val = Console.readBigDecimal("Bir sayı giriniz:");

            if (val.equals(BigDecimal.ZERO))
                break;

            var precision = Console.readInt("Virgülden sonraki basamak sayısını giriniz:");

            var result = val.divide(divisor, new MathContext(precision, RoundingMode.HALF_UP));

            total = total.add(result);
        }

        Console.writeLine("Toplam:%s", total);
    }
}
```
# BigInteger sınıfı
```java
/*----------------------------------------------------------------------------------------------------------------------
    BigInteger sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.math.BigInteger;

class App {
    public static void main(String [] args)
    {
        var bi1 = new BigInteger(Console.read("Birinci sayıyı giriniz:"));
        var bi2 = new BigInteger(Console.read("İkinci sayıyı giriniz:"));

        var result = bi1.add(bi2);

        Console.writeLine(result);
    }
}
```
###  BigInteger sınıfının radix (sayı sistemi) parametreli ctor'u
```java
/*----------------------------------------------------------------------------------------------------------------------
    BigInteger sınıfının radix (sayı sistemi) parametreli ctor'u
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.math.BigInteger;

class App {
    public static void main(String [] args)
    {
        var bi = new BigInteger(Console.read("İkili sistemde bir sayı giriniz:"), 2);

        Console.writeLine(bi);
    }
}
```
### BigInteger sınıfının bitLength ve bit Count metotları
```java
/*----------------------------------------------------------------------------------------------------------------------
    BigInteger sınıfının bitLength ve bit Count metotları
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

class App {
    public static void main(String [] args)
    {
        var bi = Console.readBigInteger("Bir sayı giriniz:", "Hatalı giriş!!");

        Console.writeLine("Bit Count:%d", bi.bitCount());
        Console.writeLine("Bit Length:%d", bi.bitLength());
    }
}
```
### BigInteger sınıfının rasgele sayı üreten ctor elemanı
```java
/*----------------------------------------------------------------------------------------------------------------------
    BigInteger sınıfının rasgele sayı üreten ctor elemanı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.math.BigInteger;
import java.util.Random;

class App {
    public static void main(String [] args)
    {
        Random r = new Random();

        for (int i = 0; i < 10; ++i) {
            var randomBigInteger = new BigInteger(128, r);// [0, pow(2, 128) - 1]

            Console.writeLine(randomBigInteger);
        }
    }
}
```
### BigInteger türden rasgele sayı üretimi
```java
/*----------------------------------------------------------------------------------------------------------------------
    BigInteger türden rasgele sayı üretimi
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.math.BigInteger;
import java.util.Random;

class App {
    public static void main(String [] args)
    {
        Random r = new Random();

        for (int i = 0; i < 10; ++i) {
            var randomBigInteger = new BigInteger(128, r);// [0, pow(2, 128) - 1]

            if (r.nextBoolean())
                randomBigInteger = randomBigInteger.negate();

            Console.writeLine(randomBigInteger);
        }
    }
}
```
### Sınıf Çalışması:BigInteger türden isPrime metodunu yazınız
```java
/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Parametresi ile aldığı BigInteger türden bir sayının asal sayı
    olup olmadığını test eden isPrime metodunu Euclid'in asal sayı algoritması ile
    yazınız
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;
import org.csystem.util.NumberUtil;

import java.math.BigInteger;

class App {
    public static void main(String [] args)
    {
        for (BigInteger n = BigInteger.valueOf(-10); n.compareTo(BigInteger.valueOf(100)) <= 0; n = n.add(BigInteger.ONE))
            if (NumberUtil.isPrime(n))
                Console.write("%d ", n);

        Console.writeLine();

        Console.writeLine(NumberUtil.isPrime(BigInteger.valueOf(1_000_003)));
    }
}
```
### Sınıf Çalışması:Klavyeden girilen n sayısı kadar yine her adımda klavyeden istenen numBits değerini kullanarak asallık sınaması yapınız
```java
/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Klavyeden girilen n sayısı kadar yine her adımda klavyeden
    istenen numBits değerini kullanarak üretilen BigInteger değerlerinin asal olup
    olmadığı bilgisiyle ekrana yazdıran programı yazınız
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;
import org.csystem.util.NumberUtil;

import java.math.BigInteger;
import java.util.Random;

class App {
    public static void main(String [] args)
    {
        RandomBigIntegerGenerator.run();
    }
}

class RandomBigIntegerGenerator {
    public static void run()
    {
        var n = Console.readInt("Bir sayı giriniz:");
        Random r = new Random();

        for (int i = 0; i < n; ++i) {
            var numBits = Console.readInt("Bit sayısını (numBits) giriniz:");
            var val = new BigInteger(numBits, r);

            Console.writeLine("%s (%s)", val, NumberUtil.isPrime(val) ? "Asal" : "Asal değil");
        }

        Console.writeLine("Tekrar yapıyor musunuz?");
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Klavyeden girilen n sayısı kadar yine klavyeden
    istenen numBits değerini kullanarak üretilen BigInteger değerlerinin asal olup
    olmadığı bilgisiyle ekrana yazdıran programı yazınız
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;
import org.csystem.util.NumberUtil;

import java.math.BigInteger;
import java.util.Random;

class App {
    public static void main(String [] args)
    {
        RandomBigIntegerGenerator.run();
    }
}

class RandomBigIntegerGenerator {
    public static void run()
    {
        var n = Console.readInt("Bir sayı giriniz:");
        var numBits = Console.readInt("Bit sayısını (numBits) giriniz:");
        Random r = new Random();

        for (int i = 0; i < n; ++i) {
            var val = new BigInteger(numBits, r);

            Console.writeLine("%s (%s)", val, NumberUtil.isPrime(val) ? "Asal" : "Asal değil");
        }

        Console.writeLine("Tekrar yapıyor musunuz?");
    }
}
```
### Sınıf Çalışması: Parametresi ile aldığı BigInteger türden dizinin elemanları toplamını döndüren sum metodunu ArrayUtil sınıfı içerisinde yazınız
```java
/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Parametresi ile aldığı BigInteger türden dizinin elemanları toplamını
    döndüren sum metodunu ArrayUtil sınıfı içerisinde yazınız
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.ArrayUtil;
import org.csystem.util.Console;

import java.util.Random;

class App {
    public static void main(String [] args)
    {
        SumBigIntegersTest.run();
    }
}

class SumBigIntegersTest {
    public static void run()
    {
        Random r = new Random();

        for (;;) {
            var n = Console.readInt("Dizinin eleman sayısını giriniz:");
            if (n <= 0)
                break;
            var numBits = Console.readInt("Bit sayısını giriniz:");
            var bigIntegers = ArrayUtil.getRandomBigIntegerArray(r, n, numBits);

            ArrayUtil.display(bigIntegers);
            Console.writeLine("Toplam:%d", ArrayUtil.sum(bigIntegers));
        }

        Console.writeLine("Tekrar yapıyor musunuz?");
    }
}
```
### Sınıf Çalışması:  BigInteger türünden factorial isimli metodu NumberUtil içinde tekrar yazınız
```java
/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Parametresi ile aldığı long türden bir sayının faktoriyel değerini
    BigInteger olarak döndüren factorial isimli metodu NumberUtil sınıfı içerisinde
    yazınız
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;
import org.csystem.util.NumberUtil;

class App {
    public static void main(String [] args)
    {
        FactorialTest.run();
    }
}

class FactorialTest {
    public static void run()
    {
        for (long n = -1; n <= 50; ++n)
            Console.writeLine("%d!=%s", n, NumberUtil.factorial(n));

        Console.writeLine("Tekrar yapıyor musunuz?");
    }
}
```
# Programın komut satırı argümanları (command line argumnets):
```java
/*----------------------------------------------------------------------------------------------------------------------
    Programın komut satırı argümanları (command line argumnets):
    Bir program çalışıtırılken programa verilebilecek değerlere denir.
    Programın komut satırı argümanları Java' da main metodunun parametresi olan
    String dizi ile program içerisinde kullanılabilir. Komut satırı argümanlarında
    boşluk (whitespace) sayısının önemi yoktur. Komut satırı argümanı olarak boşlukla
    beraber yazı alınması gerekiyorsa genel olarak tüm işletim sistemlerinin desteklediği
    "" arasında yazılabilir.
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

class App {
    public static void main(String [] args)
    {
        Console.writeLine("Number of arguments:%d", args.length);

        for (var arg : args)
            Console.writeLine(arg);
    }
}
```
### Aşağıdaki örnekte komut satırı argümanı ile alınan değerlere göre işlem yapılmıştır
```java
/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte komut satırı argümanı ile alınan değerlere göre işlem yapılmıştır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.util.Random;

class App {
    public static void main(String [] args)
    {
        if (args.length != 3) {
            Console.Error.writeLine("usage:<program> <n> <min> <max>");
            System.exit(-1);
        }
        var n = Integer.parseInt(args[0]);
        var min = Integer.parseInt(args[1]);
        var max = Integer.parseInt(args[2]);
        var random = new Random();

        for (int i = 0; i < n; ++i)
            Console.writeLine(random.nextInt(max - min) + min);

        Console.writeLine("Copyleft C and System Programmers Association");
    }
}
```
### Aşağıdaki örnekte komut satırı argümanı verilmemişse klavyeden giriş yapılabilecek bir program yazılmıştır
```java
/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte komut satırı argümanı verilmemişse klavyeden giriş yapılabilecek
    bir program yazılmıştır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;
import org.csystem.util.StringUtil;

class App {
    public static void main(String [] args)
    {
        if (args.length > 1) {
            Console.Error.writeLine("Argument can not be greater than 1(one)");
            System.exit(-1);
        }

        var arg = args.length == 0 ? Console.read("Input your text:") : args[0];

        Console.writeLine(StringUtil.isPalindrome(arg) ? "Palindrome" : "Not a palindrome");
        Console.writeLine("Copyleft C and System Programmers Association");
    }
}

/*----------------------------------------------------------------------------------------------------------------------

----------------------------------------------------------------------------------------------------------------------*/
```
