###  CommandLineUtil sınıfı ve test kodu
```java
/*----------------------------------------------------------------------------------------------------------------------
    CommandLineUtil sınıfı ve test kodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.CommandLineUtil;
import org.csystem.util.Console;

import java.util.Random;

class App {
    public static void main(String [] args)
    {
        CommandLineUtil.checkForLengthEqual(args, 3, "usage:<program> <n> <min> <max>");

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
```java
/*----------------------------------------------------------------------------------------------------------------------
    CommandLineUtil sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.CommandLineUtil;
import org.csystem.util.Console;
import org.csystem.util.StringUtil;

class App {
    public static void main(String [] args)
    {
        var arg = CommandLineUtil.getCommandLineArgsJoin(args, "Input your text:");

        Console.writeLine(StringUtil.isPalindrome(arg) ? "Palindrome" : "Not a palindrome");
        Console.writeLine("Copyleft C and System Programmers Association");
    }
}
```
### Özyineleme (recursion), özyinelemeli algoritmalar ve özyinelemeli metotlar
```java
/*----------------------------------------------------------------------------------------------------------------------
    Özyineleme (recursion), özyinelemeli algoritmalar ve özyinelemeli metotlar:
    Bir olgunun kendisine çok benzer bir olguyu içermesi durumuna özyineleme (recursion) denir. Örneğin bir
    dizin (directory) ağacını dolaşmak isteyelim. Dizin içerisindeki bir girişin bir dizin belrttiği durumda tekrar
    o dizin için de aynı işlemlerin yapılması gerekir. Yani karşımıza benzer yapı çıkmıştır. O zaman dizin yapısı
    özyineleme içermektedir.

    Özyineleme içeren algoritmalara özyinelemeli algoritmaları (recursive algorithms) denilmektedir.
    Eğer bir algoritmayı çözmek için ilerlerken bir noktaya geldiğimizde, bu geldiğimiz noktadabaşladığımız noktaya
    çok benzer bir durumla karşılaşıyorsak muhtemelen bu algoritma özyinelemeli bir algoritmadır. Özyinelemeli
    algoritmlar tipik olarak kendi kendini çağıran metotlarla (recursive methods) gerçekleştirilmektedir. Tabi özyinelemeli
    bir algoritmanın başka biçimlerde de çözümleri olabilir.

    Yazılım dünyasında karşımıza çıkan tipik özyinelemeli algoritmalardan bazıları şunlardır:
    - Dizin ağacının dolaşılması
    - Ağaçlar ve graflar gibi veri yapılarının dolaşılması ve bu veri yapılarında arama yapılması
    - Parsing algoritmaları
    - Özel bazı problemler (örneğin 8 vezir problemi)
    - Bazı sort işlemleri (quick sort, merge sort, heap sort vb)
    - Matematiksel bazı algoritmalar
    - Bazı optimizasyon algoritmaları

    Algoritmik problemleri özyineleme bakımından üç gruba ayırabiliriz:
    1. Hem özyinelemesiz hem de özyinelemeli olarak gerçekleştirilebilecek problemler
    2. Yalnızca özyinelemeli olarak gerçekleştirilebilecek problemler
    3. Yalnızca özyinelemesiz olarak gerçekleştirilebilcek problemler

    Birinci gruptaki algoritmalarda hangisinin daha verimli olacağı probleme göre değişebilmektedir.

    Bilindiği gibi bir metodun parametre değişkenleri ve yerel değişkenler stack'de yaratılırlar. Ayrıca ayrıca aşağı
    seviyede bir metot çağrısında parametre değişkenleri ve yerel değişkenler dışında da stack'de yer ayrılması.Yani bir
    metot çağrısı stack'de belirli miktarda yer ayrılması anlamına gelir. Bu işlem çok fazla yapıldığında stack artık
    yetmez duruma gelebilir (stack overflow). Tabi bazı programlama ortamları stack taşması durumlarını mümkün
    olduğunda engellemeye yönelik çalışırlar. Örneğin Java'da diziler stack'de yaratılamaz. Dolayısıyla çok büyük
    sayıda eleman içeren diziler için stack'in taşması gibi bir durum oluşmaz.

    Aslında bir metodun kendini çağırmasıyla başka bir metodu çağırması arasında hiç bir fark yoktur. Örneğin:

    public static void bar()
    {
        int a;

        ....
    }

    public static void foo()
    {
        int a;

        ...
        bar();
        ...
    }

    Burada bar çağrıldığında bar'ın içerisinde yine a değişkeni stack'de yaratılacaktır. bar sona erdiğinde akış çağrılan
    yerden devam edecektir. Metot kendi kendini çağırması da tamamen bu biçimde gerçekleşir:

    public static void foo()
    {
        int a;

        ...
        foo();
        ...
    }

    Şüphesiz bri metodun kendi kendini çağırması durumunda belli bir noktaya kadar çağrı yapılmazsa yani çağrı
    durdurulmazsa sonsuz döngü oluşacak ve belli zaman sonra stack taşması olacaktır. Öyleyse kendi çağıran bir metodun
    belli bir noktadan sonra kendini çağırma işleminden vazgeçmesi gerekir
----------------------------------------------------------------------------------------------------------------------*/
```
### Aşağıdaki örnekte kendi kendini çağıran metot bu işlemi sürekli yaptığından StackOverflowException oluşur
```java
/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte kendi kendini çağıran metot bu işlemi sürekli yaptığından StackOverflowException oluşur
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

public class App {
    public static void main(String[] args)
    {
        Sample.foo();
    }
}

class Sample {
    public static void foo()
    {
        foo();
    }
}
```
### Recursive metotun bir incelemesi
```java
/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte metot kendini hep bir eksik değerle çağırmıştır. Parametre değişkeni olan n sıfır değerine
    geldiğinde artık kendini çağırma süreci sonlanmış ve çıkış süreci başlamıştır. Dikkat edilirse aşağıdaki
    örnekte bir tek foo(0) çağrısı return deyiminden dolayı sonlanır. Diğerleri ilgili çağrılar sonlandığından
    dolayı akışın ** ile belirtilen deyime gelmesinden dolayı sonlanma girmişlerdir. Örnekte foo(0) için
    "Çıkış:0" yazısının ekrana basılmadığına dikkat ediniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

public class App {
    public static void main(String[] args)
    {
        Sample.foo(3);
    }
}

class Sample {
    public static void foo(int n)
    {
        Console.writeLine("Giriş:%d", n);

        if (n == 0)
            return;

        foo(n - 1);
        Console.writeLine("Çıkış:%d", n); //**
    }
}
```
### Faktoriyel hesaplayan metodun özyinelemesiz biçimi
```java
/*----------------------------------------------------------------------------------------------------------------------
    Faktoriyel hesaplayan metodun özyinelemesiz biçimi
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.samples.recurison.Util;
import org.csystem.util.Console;

public class App {
    public static void main(String[] args)
    {
        FactorialTest.run();
    }
}

class FactorialTest {
    public static void run()
    {
        for (int n = 0; n < 13; ++n)
            Console.writeLine("%d!=%d", n, Util.factorial(n));
    }
}
```
### Faktoriyel hesaplayan metodun özyinelemeli biçimi
```java
/*----------------------------------------------------------------------------------------------------------------------
    Faktoriyel hesaplayan metodun özyinelemeli biçimi
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.samples.recurison.RecursionUtil;
import org.csystem.util.Console;

public class App {
    public static void main(String[] args)
    {
        FactorialTest.run();
    }
}

class FactorialTest {
    public static void run()
    {
        for (int n = -1; n < 13; ++n)
            Console.writeLine("%d!=%d", n, RecursionUtil.factorial(n));
    }
}
```
```java
package org.csystem.samples.recurison;

public class RecursionUtil {
    public static long factorial(int n)
    {
        long result;

        if (n <= 0)
            return 1;

        result = n * factorial(n - 1);

        return result;
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Faktoriyel hesaplayan metodun özyinelemeli biçimi
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.samples.recurison.RecursionUtil;
import org.csystem.util.Console;

public class App {
    public static void main(String[] args)
    {
        FactorialTest.run();
    }
}

class FactorialTest {
    public static void run()
    {
        for (int n = -1; n < 13; ++n)
            Console.writeLine("%d!=%d", n, RecursionUtil.factorial(n));
    }
}
```
### Bir yazıyı tersten yazdırma algoritmasının özyinelemesiz biçimi
```java
/*----------------------------------------------------------------------------------------------------------------------
    Bir yazıyı tersten yazdırma algoritmasının özyinelemesiz biçimi
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.samples.recurison.Util;
import org.csystem.util.Console;

public class App {
    public static void main(String[] args)
    {
        WriteReverseTest.run();
    }
}

class WriteReverseTest {
    public static void run()
    {
        for (;;) {
            var s = Console.read("Bir yazı giriniz:");

            Util.writeReverse(s);
            Console.writeLine();

            if (s.equals("quit"))
                break;
        }
    }
}
```
### Bir yazıyı tersten yazdırma algoritmasının özyinelemeli biçimi
```java
/*----------------------------------------------------------------------------------------------------------------------
    Bir yazıyı tersten yazdırma algoritmasının özyinelemeli biçimi
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.samples.recurison.RecursionUtil;
import org.csystem.util.Console;

public class App {
    public static void main(String[] args)
    {
        WriteReverseTest.run();
    }
}

class WriteReverseTest {
    public static void run()
    {
        for (;;) {
            var s = Console.read("Bir yazı giriniz:");

            RecursionUtil.writeReverse(s);
            Console.writeLine();

            if (s.equals("quit"))
                break;
        }
    }
}
```
### Bir yazıyı tersyüz etme yazdırma algoritmasının özyinelemeli biçimi
```java
/*----------------------------------------------------------------------------------------------------------------------
    Bir yazıyı tersyüz etme yazdırma algoritmasının özyinelemeli biçimi
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.samples.recurison.RecursionUtil;
import org.csystem.util.Console;

public class App {
    public static void main(String[] args)
    {
        GetReverseTest.run();
    }
}

class GetReverseTest {
    public static void run()
    {
        for (;;) {
            var s = Console.read("Bir yazı giriniz:");

            var revStr = RecursionUtil.getReverse(s);

            Console.writeLine(revStr);

            if (s.equals("quit"))
                break;
        }
    }
}

/*----------------------------------------------------------------------------------------------------------------------

----------------------------------------------------------------------------------------------------------------------*/
```
