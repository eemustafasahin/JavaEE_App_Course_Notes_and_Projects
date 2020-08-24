```java
/*----------------------------------------------------------------------------------------------------------------------
    Aslında bilgisayar sistemlerinde ekrana sayı yazdırmak diye birşey yoktur. Ekrana yalnızca karakterler
    yazdırılabilir. Örneğin System.out.printf metodu int türden bir tamsayıyı yazdırırken sayıyı basamaklarına
    ayrıştırıp onlara karşılık gelen karakterleri ekrana basmaktadır veya bu işlemi yapan bir metodu çağırmaktadır.

    Java'da ekrana basma işlemi yüksek seviyelibir işlemdir. Burada PrintStream sınıfının int paramatreli write metodu
    kullanılarak anlatılan algoritma gerçekleştirilecektir. Bu metot bir karakteri ekrana basmak için kullanılır. Tüm
    diğer ekrana basma yapan metotlar "bu metodu doğrudan ya da dolaylı olarak çağırır" biçiminde düşünülebilir. Buradaki
    parametrenin int türden olması sizi yanıltmasın. write metodu parametresi ile aldığı int türden bir sayıyı karakter
    sıra numarası kabul ederek karşılık gelen karakteri ekrana basar.

    Anahtar Notlar: Ekrana basma işlemi write metodunda genel olarak "satır tamponlama (line bufferred)" ile yapılır.
    Satır tamponlama bir bilginin ekrana (ekran olması zorunlu değil) basılabilmesi için ya tamponun dolması ya da
    "line feed (ters bölü n)" karakterinin görülmesi gerekir. Bu işlem ayrıntılı ve aşağı seviyeli bir işlemdir.
    Burada bu kadarı ele alınacaktır. Yani kısacası örneğin tek bir write çağrısı ekrana ilgili karakteri basmayabilir. Bu işlemin
    hemen yapılması için line feed karaterinin de ekrana basılması gerekebilir. Ya da bu işlem tamponu boşaltma
    işlemini yapan flush metodu çağrısıyla da gerçekleştirilebilir.

    Anahtar Notlar: Aslında PrintStream sınıfının autoFlush özellliği nesne yaratırken belirlenebilmektedir.
    Ancak System.out referansının bunu autoFlush yapıp yapmadığı belirtilmemiştir.
----------------------------------------------------------------------------------------------------------------------*/
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Yalnızca bir karakteri ekrana basan metot ve dizi veri yapısı kullanılarak int türden bir sayıyı ekrana
    bastıran metot. Metot içerisindeki flush işlemi tamamen tamponu boşaltmak için kullanılmaktadır. Gerekirse
    kaldırılıp metodu çağırana bırakılabilir yada yazma soununda line feed karakteri de ekrana basılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.samples.recurison.Util;
import org.csystem.util.Console;

public class App {
    public static void main(String[] args)
    {
        WriteNumberTest.run();
    }
}

class WriteNumberTest {
    public static void run()
    {
        for (;;) {
            var val = Console.readInt("Bir sayı giriniz:");

            Util.writeNumber(val);
            System.out.println();

            if (val == 0)
                break;
        }
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Yukarıdaki işlemin özyinelemeli versiyonu. Bu versiyon daha etkindir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.samples.recurison.RecursionUtil;
import org.csystem.util.Console;

public class App {
    public static void main(String[] args)
    {
        WriteNumberTest.run();
    }
}

class WriteNumberTest {
    public static void run()
    {
        for (;;) {
            var val = Console.readInt("Bir sayı giriniz:");

            RecursionUtil.writeNumber(val);
            System.out.println();

            if (val == 0)
                break;
        }
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Bir sayıyı basamaklarına ayırarak karakter karakter ekrana sayı sistemine göre bastıran metodun özyinelemeli
    versiyonu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.samples.recurison.RecursionUtil;
import org.csystem.util.Console;

public class App {
    public static void main(String[] args)
    {
        WriteNumberRadixTest.run();
    }
}

class WriteNumberRadixTest {
    public static void run()
    {
        for (;;) {
            var val = Console.readInt("Bir sayı giriniz:");
            var radix = Console.readInt("Sayı sistemini giriniz:");

            if (radix <= 0)
                break;

            RecursionUtil.writeNumber(val, radix);
            Console.writeLine();

            if (val == 0)
                break;
        }
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    n-inci Fibonannci sayısını döndüren metodun özyinelemesiz biçimi
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.samples.recurison.Util;
import org.csystem.util.Console;

public class App {
    public static void main(String[] args)
    {
        GetFibonacciTest.run();
    }
}

class GetFibonacciTest {
    public static void run()
    {
        for (;;) {
            var n = Console.readInt("Kaçıncı Fibonacci sayısını istiyorsunuz?");

            if (n <= 0)
                break;

            Console.writeLine(Util.getFibonacciNumber(n));
        }
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    n-inci Fibonannci sayısını döndüren metodun özyinelemesiz biçimi
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.samples.recurison.RecursionUtil;
import org.csystem.util.Console;

public class App {
    public static void main(String[] args)
    {
        GetFibonacciTest.run();
    }
}

class GetFibonacciTest {
    public static void run()
    {
        for (;;) {
            var n = Console.readInt("Kaçıncı Fibonacci sayısını istiyorsunuz?");

            if (n <= 0)
                break;

            Console.writeLine(RecursionUtil.getFibonacciNumber(n));
        }
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Yukarıdaki metotların özyinelemesiz versiyonları. Bazı detaylar gözardı edilmiştir. Bazı kodlar açık olması
    açısından tekrarlanmıştır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.samples.recurison;

public class Util {

    public static long factorial(int n)
    {
        long result = 1;

        for (; n > 1; --n)
            result *= n;

        return result;
    }

    public static int getFibonacciNumber(int n)
    {
        if (n <= 0)
            return -1;

        if (n <= 2)
            return  n - 1;

        int prev1 = 0, prev2 = 1, val = 0;

        for (int i = 2; i < n; ++i) {
            val = prev1 + prev2;
            prev1 = prev2;
            prev2 = val;
        }

        return val;
    }

    public static String getReverse(String s)
    {
        return new StringBuilder(s).reverse().toString();
    }

    public static void writeNumber(int val)
    {
        if (val == 0) {
            System.out.write('0');
            return;
        }

        char [] s = new char[11];
        int i;
        boolean isNegative;
        isNegative = false;

        if (val < 0) {
            isNegative = true;
            val = -val;
        }

        for (i = 0; val != 0; ++i) {
            s[i] = (char)(val % 10 + '0');
            val /= 10;
        }
        if (isNegative)
            s[i++] = '-';

        for (--i; i >= 0; --i)
            System.out.write(s[i]);

        System.out.flush();
    }

    public static void writeReverse(String s)
    {
        for (int i = s.length() - 1; i >= 0; --i)
            System.out.write(s.charAt(i));

        System.out.flush();
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Yukarıdaki metotların özyinelemeli versiyonları. Bazı detaylar gözardı edilmiştir. Bazı kodlar açık olması
    açısından tekrarlanmıştır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.samples.recurison;

public class RecursionUtil {
    private static int getFibonacciNumberRecur(int n)
    {
        if (n <= 2)
            return n - 1;

        return getFibonacciNumberRecur(n - 1) + getFibonacciNumberRecur(n - 2);
    }

    private static void getReverse(char [] c, int left, int right)
    {
        if (left >= right)
            return;

        char temp;

        temp = c[left];
        c[left] = c[right];
        c[right] = temp;

        getReverse(c, left + 1, right - 1);
    }

    private static void writeNumberRecur(int val)
    {
        if (val / 10 != 0)
            writeNumber(val / 10);

        System.out.write((char)(val % 10 + '0'));
    }

    private static void writeNumberRecur(int val, int radix)
    {
        if (val / radix != 0)
            writeNumberRecur(val / radix, radix);

        //System.out.write((char)(val % radix >= 10 ? val % radix - 10 + 'A' : val % radix + '0'));
        System.out.write((char)((val % radix >= 10 ? - 10 + 'A' : '0') + val % radix));
    }

    private static void writeReverse(String s, int i)
    {
        if (i == s.length())
            return;

        writeReverse(s, i + 1);
        System.out.write(s.charAt(i));
    }

    public static long factorial(int n)
    {
        if (n <= 0)
            return 1;

        return n * factorial(n - 1);
    }

    public static int getFibonacciNumber(int n)
    {
        if (n <= 0)
            return -1;

        return getFibonacciNumberRecur(n);
    }

    public static String getReverse(String s)
    {
        char [] c = s.toCharArray();

        getReverse(c, 0, c.length - 1);

        return String.valueOf(c);
    }

    public static void writeNumber(int val)
    {
        if (val < 0) {
            System.out.write('-');
            val = -val;
        }
        writeNumberRecur(val);
        System.out.flush();
    }

    public static void writeNumber(int val, int radix)
    {
        if (val < 0) {
            System.out.write('-');
            val = -val;
        }

        writeNumberRecur(val, radix);
        System.out.flush();
    }

    public static void writeReverse(String s)
    {
        writeReverse(s, 0);
        System.out.flush();
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Bilindiği gibi aşağıdaki örnekte sum metodu dizi referansı aldığından son iki çağrıda ilkdeğer verme zorunludur
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

public class App {
    public static void main(String[] args)
    {
        int [] a = {10, 20, 30};

        Console.writeLine(Util.sum(a));
        Console.writeLine(Util.sum(new int[] {10, 20, 30}));
        Console.writeLine(Util.sum(new int[] {10, 20}));
    }
}

class Util {
    public static int sum(int [] a)
    {
        int total = 0;

        for (int val : a)
            total += val;

        return total;
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Değişken sayıda argüman alan metotlar (varargs methods) "... (elipsis)" parametreler ile yazılır. Elipsis
    parametresi metot açısıından bir dizi referansıdır. Çağıran açısından ise hem dizi referansı olarak hem de değişken
    sayıda argüman geçmek için kullanılabilir. Metotlar varargs parametresi için argüman olarak dizi referansı
    verilmiyorsa derleyici diziyi kendisi yaratmaktadır. varrags rapamatresine hiç argüman geçilmezse derleyici
    sıfır elemanlı dizi yaratır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

public class App {
    public static void main(String[] args)
    {
        int [] a = {10, 20, 30};

        Console.writeLine(Util.sum(a));
        Console.writeLine(Util.sum(10, 20, 30));
        Console.writeLine(Util.sum(10, 20));
        Console.writeLine(Util.sum());
    }
}

class Util {
    public static int sum(int...a)
    {
        int total = 0;

        for (int val : a)
            total += val;

        return total;
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Bir metodun varags parametresi son parametre olmak zorundadır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

public class App {
    public static void main(String[] args)
    {

    }
}

class Util {
    public static void display(int...a, int n) //error
    {
        String fmt = String.format("%%%dd ", n);

        for (int val : a)
            System.out.printf(fmt, val);

        System.out.println();
    }

}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Bir metodun varags parametresi son parametre olmak zorundadır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

public class App {
    public static void main(String[] args)
    {
        int [] a = {10, 20, 30};
        int val = 45;

        Util.display(2, a);
        Util.display(2, val);
    }
}

class Util {
    public static void display(int n, int...a)
    {
        String fmt = String.format("%%%dd ", n);

        for (int val : a)
            System.out.printf(fmt, val);

        System.out.println();
    }

}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Bir metodun varags parametresi son parametre olmak zorunda olduğundan metodun bir fazla varargs parametresi olamaz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

public class App {
    public static void main(String[] args)
    {
        int [] a = {10, 20, 30, 40};

            ArrayUtil.display(2, Util.join(a, 50, 60, 70, 80));    }

    }
}

class Util {
    public static int [] join(int...a, int...b) //error
    {
        int [] result = new int[a.length + b.length];

        int index = 0;

        for (int i = 0; i < a.length; ++i, ++index)
            result[index] = a[i];

        for (int i = 0; i < b.length; ++i, ++index)
            result[index] = b[i];

        return result;
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Bir metodun varags parametresi son parametre olmak zorunda olduğundan metodun bir fazla varargs parametresi olamaz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.ArrayUtil;

public class App {
    public static void main(String[] args)
    {
        int [] a = {10, 20, 30, 40};

        ArrayUtil.display(2, Util.join(a, 50, 60, 70, 80));
    }
}

class Util {
    public static int [] join(int[]a, int...b)
    {
        int [] result = new int[a.length + b.length];

        int index = 0;

        for (int i = 0; i < a.length; ++i, ++index)
            result[index] = a[i];

        for (int i = 0; i < b.length; ++i, ++index)
            result[index] = b[i];

        return result;
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Dizi dizileri de varrags paramatreli olabilir. Şüphesiz sadece ana dizi varargs parametreli olabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

public class App {
    public static void main(String[] args)
    {
        int [] a = {10, 20, 30, 40, 23};
        int [] b = {50, 78, 90, 30};
        int [] c = {30, 68, 80, 30};

        Util.display(2, a, b, c);
    }
}

class Util {
    public static void display(int n, int[]...a)
    {
        String fmt = String.format("%%0%dd ", n);

        for (int [] array : a) {
            for (int val : array)
                System.out.printf(fmt, val);

            System.out.println();
        }
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    varargs parametresi ilgili dizi parametresine göre imzayı değiştirmez. Aşağıdaki örnek error oluşturur
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

public class App {
    public static void main(String[] args)
    {

    }
}

class Util {
    public static void display(int n, int...a) //error
    {
        String fmt = String.format("%%0%dd ", n);

        for (int val : a)
            System.out.printf(fmt, val);

        System.out.println();
    }

    public static void display(int n, int[] a) //error
    {
        String fmt = String.format("%%0%dd ", n);

        for (int val : a)
            System.out.printf(fmt, val);

        System.out.println();

    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte tam uyum olduğundan int parametreli display metodu çağrılır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

public class App {
    public static void main(String[] args)
    {
        int a = 10;

        Util.display(a);
    }
}

class Util {
    public static void display(int val)
    {
        System.out.println("display(int)");
        System.out.println(val);
    }

    public static void display(int...a)
    {
        System.out.println("display(int...)");
        for (int val : a)
            System.out.printf("%d ", val);

        System.out.println();
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Temel türler arasında dönüşüm olduğundan aşağıdaki örnekte long parametreli metot çağrılır.
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

public class App {
    public static void main(String[] args)
    {
        int a = 10;

        Util.display(a);
    }
}

class Util {
    public static void display(long val)
    {
        System.out.println("display(long)");
        System.out.println(val);
    }

    public static void display(int...a)
    {
        System.out.println("display(int...)");
        for (int val : a)
            System.out.printf("%d ", val);

        System.out.println();
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Arrays sınıfının fill metodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.ArrayUtil;

import java.util.Arrays;

public class App {
    public static void main(String[] args)
    {
        int [] a = new int[10];

        Arrays.fill(a, 67);

        ArrayUtil.display(a);
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Arrays sınıfının fill metodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.util.Arrays;

public class App {
    public static void main(String[] args)
    {
        boolean [] flags = new boolean[30];
        Arrays.fill(flags, true);

        for (var flag : flags)
            Console.writeLine(flag);
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Arrays sınıfının fill metodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.util.Arrays;

public class App {
    public static void main(String[] args)
    {
        boolean [] flags = new boolean[20];
        Arrays.fill(flags, 2, 10, true); //[2, 10)

        for (var flag : flags)
            Console.writeLine(flag);
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Arrays sınıfının copyOf metodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.ArrayUtil;

import java.util.Arrays;

public class App {
    public static void main(String[] args)
    {
        int [] a = ArrayUtil.getRandomArray(10, 1, 100);

        ArrayUtil.display(2, a);

        int []newArray = Arrays.copyOf(a, 20);

        ArrayUtil.display(2, newArray);
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Arrays sınıfının copyOf metodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.ArrayUtil;

import java.util.Arrays;

public class App {
    public static void main(String[] args)
    {
        int [] a = ArrayUtil.getRandomArray(10, 1, 100);

        ArrayUtil.display(2, a);

        a = Arrays.copyOf(a, 20);

        ArrayUtil.display(2, a);
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Arrays sınıfının copyOf metotları eleman sayısı orjinal diziden az olan dizi de döndürebilir. Şüphesiz bu durumda
    geri kalan elemanları kopyalamayacaktır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.ArrayUtil;

import java.util.Arrays;

public class App {
    public static void main(String[] args)
    {
        int [] a = ArrayUtil.getRandomArray(10, 1, 100);

        ArrayUtil.display(2, a);

        a = Arrays.copyOf(a, 5);

        ArrayUtil.display(2, a);
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Arrays sınıfının copyOf metot ile bir dizinin kpyasının çıkartılması
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.ArrayUtil;

import java.util.Arrays;

public class App {
    public static void main(String[] args)
    {
        int [] a = ArrayUtil.getRandomArray(10, 1, 100);

        ArrayUtil.display(2, a);

        int [] b = Arrays.copyOf(a, a.length);

        ArrayUtil.display(2, b);
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Arrays sınıfının copyOfRange metodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.ArrayUtil;

import java.util.Arrays;

public class App {
    public static void main(String[] args)
    {
        int [] a = ArrayUtil.getRandomArray(10, 1, 100);

        ArrayUtil.display(2, a);

        int [] b = Arrays.copyOfRange(a, 2, 5); //[2, 5)

        ArrayUtil.display(2, b);
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Arrays sınıfının equals metodu iki dizinin karşılıklı elemanlarının eşit olup olmadığın test etmek için
    kullanılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Arrays;

public class App {
    public static void main(String[] args)
    {
        int [] a = {1, 2, 3, 4, 5};
        int [] b = {1, 2, 3, 4, 5};

        System.out.println(Arrays.equals(a, b));
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: int türden iki dizi dizisinin eşit olup olmadığını test eden equals isimli metodu yazınız
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Arrays;

public class App {
    public static void main(String[] args)
    {
       int [][]a = {{1, 2, 3}, {4, 5, 6, 7}, {8, 9}};
       int [][]b = {{1, 2, 3}, {4, 5, 6, 7}, {8, 9}};

       System.out.println(Util.equals(a, b));
    }
}


class Util {
    public static boolean equals(int [][] a, int [][] b)
    {
        if (a.length != b.length)
            return false;

        for (int i = 0; i < a.length; ++i)
            if (!Arrays.equals(a[i], b[i]))
                return false;

        return true;
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Arrays sınıfının sort metodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.ArrayUtil;

import java.util.Arrays;

public class App {
    public static void main(String[] args)
    {
        int [] a = ArrayUtil.getRandomArray(10, 1, 100);

        ArrayUtil.display(2, a);

        Arrays.sort(a);

        ArrayUtil.display(2, a);
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Arrays sınıfının sort metodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.ArrayUtil;

import java.util.Arrays;

public class App {
    public static void main(String[] args)
    {
        int [] a = ArrayUtil.getRandomArray(10, 1, 100);

        ArrayUtil.display(2, a);

        Arrays.sort(a, 3, 6); //[3, 6)

        ArrayUtil.display(2, a);
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Arrays sınıfının toString metodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.ArrayUtil;
import org.csystem.util.Console;

import java.util.Arrays;

public class App {
    public static void main(String[] args)
    {
        int [] a = ArrayUtil.getRandomArray(10, 1, 100);

        ArrayUtil.display(2, a);

        Console.writeLine(Arrays.toString(a));
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Arrays sınıfının metotlarının kullanımı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.util.Arrays;

public class App {
    public static void main(String[] args)
    {
        var device = new DeviceInfo("weathersensor", "192.168.1.234", 50500, 1234, 7890, 3030, 8900);

        Console.writeLine(device.toString());
    }
}


class DeviceInfo {
    private String m_name;
    private String m_host;
    private int [] m_ports;

    public DeviceInfo(String name, String host, int...ports)
    {
        //...
        m_name = name;
        m_host = host;
        m_ports = Arrays.copyOf(ports, ports.length);
        Arrays.sort(m_ports);
    }

    //...

    public String toString()
    {
        return String.format("%s:%s:%s", m_name, m_host, Arrays.toString(m_ports));
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Arrays sınıfının compare metodu dizileri karşılaştırmak için kullanılır. Birinci parametresi ile aldığı
    dizi ikinci parametresi ile aldığı diziden küçükse yani ilk faklı elemanlar elde edildiğinda ilgili elemanı
    küçükse negatif, büyükse pozitif eğer diziler eşitse sıfır değerini döndürür
    Bu metot Java 9 ile eklenmiştir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.util.Arrays;

public class App {
    public static void main(String[] args)
    {
        int [] a = {1, -6, 3, 4, 9, 8, 6};
        int [] b = {1, 4};

        Console.writeLine(Arrays.compare(a, b));
    }
}


class DeviceInfo {
    private String m_name;
    private String m_host;
    private int [] m_ports;

    public DeviceInfo(String name, String host, int...ports)
    {
        //...
        m_name = name;
        m_host = host;
        m_ports = Arrays.copyOf(ports, ports.length);
        Arrays.sort(m_ports);
    }

    //...

    public String toString()
    {
        return String.format("%s:%s:%s", m_name, m_host, Arrays.toString(m_ports));
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Arrays sınıfının compare metodu dizileri karşılaştırmak için kullanılır. Birinci parametresi ile aldığı
    dizi ikinci parametresi ile aldığı diziden küçükse yani ilk faklı elemanlar elde edildiğinda ilgili elemanı
    küçükse negatif, büyükse pozitif eğer diziler eşitse sıfır değerini döndürür
    Bu metot Java 9 ile eklenmiştir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.util.Arrays;

public class App {
    public static void main(String[] args)
    {
        int [] a = {1, 4, -3, 4, 9, 8, 6};
        int [] b = {1, 4};

        Console.writeLine(Arrays.compare(a, b));
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Integer sınıfının parseUnsignedInt metodu ile yazı işaretsi olarak int türüne çevrilebilir. Negatif bir değer
    için exception fırlatılır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Scanner;

public class App {
    public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in);
        System.out.print("İşaretsiz Bir sayı giriniz:");
        int val = Integer.parseUnsignedInt(kb.nextLine());

        System.out.println(val);
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Integer sınıfının compareUnsigned metodu ile karşılaştırma işaretsiz olarak yapılabilir. Yani artık sayının
    yüksek anlamlı bit (the most significant bit) değerinin önemi yoktur. Bu metot Java 8 ile eklenmiştir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

public class App {
    public static void main(String[] args)
    {
        int a = 0x80000B00;
        int b = 0x00000B00;

        Console.writeLine("a=%d", a);
        Console.writeLine("b=%d", b);

        Console.writeLine(Integer.compare(a, b));
        Console.writeLine(Integer.compareUnsigned(a, b));
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Console sınıfında tamsayı türleri için işaretsi okuma yapan metotlar bulunmaktadır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

public class App {
    public static void main(String[] args)
    {
        int val = Console.readUInt("Bir sayı giriniz:", "Hatalı giriş yaptınız");

        System.out.println(val * val);
    }
}

/*----------------------------------------------------------------------------------------------------------------------

----------------------------------------------------------------------------------------------------------------------*/
```
