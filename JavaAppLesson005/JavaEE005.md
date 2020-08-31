### int türden bir değerin çeşitli sistemlerde karşılığının String olarak elde edilmesi
```java
/*----------------------------------------------------------------------------------------------------------------------
    int türden bir değerin çeşitli sistemlerde karşılığının String olarak elde edilmesi
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

public class App {
    public static void main(String[] args)
    {
        int val = 10;

        Console.writeLine(Integer.toString(val));
        Console.writeLine(Integer.toString(val, 2));
        Console.writeLine(Integer.toHexString(val));
        Console.writeLine(Integer.toBinaryString(val));
        Console.writeLine(Integer.toOctalString(val));
    }
}
```
### long türden bir değerin çeşitli sistemlerde karşılığının String olarak elde edilmesi
```java
/*----------------------------------------------------------------------------------------------------------------------
    long türden bir değerin çeşitli sistemlerde karşılığının String olarak elde edilmesi
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

public class App {
    public static void main(String[] args)
    {
        long val = 4000000000L;

        Console.writeLine(Long.toString(val));
        Console.writeLine(Long.toString(val, 2));
        Console.writeLine(Long.toHexString(val));
        Console.writeLine(Long.toBinaryString(val));
        Console.writeLine(Long.toOctalString(val));
    }
}
```
# Bitsel İşlemler 
```java
/*----------------------------------------------------------------------------------------------------------------------
    Bitsel İşlemler
    Bitsel işlemlerin daha iyi anlaşılabilmesi için öncelikle bir tamsayının (short, byte, int, long ve char) bitlerini
    ekrana basan metotlar yazıp kullanacağız. Metotların kodlarını aşağıda bulabilirsiniz.
----------------------------------------------------------------------------------------------------------------------*/
```
###  Bir sayının bitlerini ekrana bastıran metodun bitsel operatör kullanmadan yazımı
```java
/*----------------------------------------------------------------------------------------------------------------------
    Bir sayının bitlerini ekrana bastıran metodun bitsel operatör kullanmadan yazımı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.util.Arrays;

public class App {
    public static void main(String[] args)
    {
        for (;;) {
            int val = Console.readInt("Bir sayı giriniz:");

            Util.writeBits(val);

            if (val == 0)
                break;
        }
    }
}

class Util {
    public static void writeBits(int val)
    {
        String valStr = Integer.toBinaryString(val);

        char [] c = new char[32 - valStr.length()];

        Arrays.fill(c, '0');

        Console.writeLine(new StringBuilder().append(c).append(valStr).toString());
    }
}
```
### Bir sayının bitlerini ekrana bastıran metodun bitsel operatör kullanmadan yazımı
```java
/*----------------------------------------------------------------------------------------------------------------------
    Bir sayının bitlerini ekrana bastıran metodun bitsel operatör kullanmadan yazımı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.util.Arrays;

public class App {
    public static void main(String[] args)
    {
        for (;;) {
            int val = Console.readInt("Bir sayı giriniz:");

            Util.writeBits(val);

            if (val == 0)
                break;
        }
    }
}

class Util {
    public static void writeBits(int val)
    {
        String valStr = Integer.toBinaryString(val);

        char [] c = new char[32 - valStr.length()];

        Arrays.fill(c, '0');

        Console.writeLine(String.valueOf(c) + valStr);
    }
}
```
###  Bir sayının bitlerini ekrana bastıran metodun bitsel operatör kullanmadan yazımı
```java
/*----------------------------------------------------------------------------------------------------------------------
    Bir sayının bitlerini ekrana bastıran metodun bitsel operatör kullanmadan yazımı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

public class App {
    public static void main(String[] args)
    {
        for (;;) {
            int val = Console.readInt("Bir sayı giriniz:");

            Util.writeBits(val);

            if (val == 0)
                break;
        }
    }
}

class Util {
    public static void writeBits(int val)
    {
        String valStr = Integer.toBinaryString(val);

        int lengthZeros = 32 - valStr.length();

        Console.writeLine(lengthZeros != 0 ? String.format("%0" + lengthZeros + "d%s", 0, valStr) : valStr);
    }
}
```
### Bir sayının bitlerini ekrana bastıran metotların bitsel operatör kullanmadan yazımı
```java
/*----------------------------------------------------------------------------------------------------------------------
    Bir sayının bitlerini ekrana bastıran metotların bitsel operatör kullanmadan yazımı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

public class App {
    public static void main(String[] args)
    {
        for (;;) {
            long val = Console.readLong("Bir sayı giriniz:");

            Util.writeBits(val);

            if (val == 0)
                break;
        }
    }
}

class Util {
    private static void writeBits(String bitsStr, int bitsLength)
    {
        int lengthZeros = bitsLength - bitsStr.length();

        Console.writeLine(lengthZeros != 0 ? String.format("%0" + lengthZeros + "d%s", 0, bitsStr) : bitsStr);
    }

    public static void writeBits(char val)
    {
        writeBits(Integer.toBinaryString(val), 16);
    }

    public static void writeBits(byte val)
    {
        writeBits(Integer.toBinaryString(val), 8);
    }

    public static void writeBits(short val)
    {
        writeBits(Integer.toBinaryString(val), 16);
    }

    public static void writeBits(int val)
    {
        writeBits(Integer.toBinaryString(val), 32);
    }

    public static void writeBits(long val)
    {
        writeBits(Long.toBinaryString(val), 64);
    }
}
```
### Java'da bir tamsayının bitleri üzerinde işlem yapan operatörler
```java
/*----------------------------------------------------------------------------------------------------------------------
    Java'da bir tamsayının bitleri üzerinde işlem yapan bir grup operatör vardır:
    ~                           ----> bitwise not
    <<                          ----> left shift
    >>                          ----> right shift (signed)
    >>>                         ----> unsigned right shift
    &                           ----> bitwise and
    ^                           ----> bitwise xor
    |                           ----> bitwise or
    >>=, <<=, >>>=, &=, |=, ^=  ----> augmented assignment bitwise operators

    Burada operatörler öncelik sıralarına göre yazılmıştır.

    Bu operatörler gerçek sayı türleri ile kullanılamaz. Bir kaç istisnası dışında boolean türü ile de kullanılamaz
----------------------------------------------------------------------------------------------------------------------*/
```
### Bitsel değil (not) operatörü tek operandlı (unary) önek (prefix) durumunda operatördür.
```java
/*----------------------------------------------------------------------------------------------------------------------
    Bitsel değil (not) operatörü tek operandlı (unary) önek (prefix) durumunda operatördür. Operatör öncelik tablosunun
    ikinci seviyesinde bulunur. Bu operatör operandı olan tam sayının bitleri üzerinde 1'e tümleme (one's complement)
    yaparak bir değer elde eder. Yani operandı olan sayının 1(bir) olan bitlerini 0(sıfır), 0(sıfır) olan bitlerini
    1(bir) yapar. Bu operatörün yan etkisi yoktur
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.BitwiseUtil;
import org.csystem.util.Console;

public class App {
    public static void main(String[] args)
    {
        while (true) {
            var val = Console.readInt("Bir sayı giriniz:");
            var result = ~val;

            Console.write(val + "->");
            BitwiseUtil.writeBits(val);
            Console.write(result + "->");
            BitwiseUtil.writeBits(result);

            if (val == 0)
                break;
        }

        Console.writeLine("Tekrar yapıyor musunuz?");
    }
}
```
###  Bir tamsayıyı, sola bitsel olarak 1 pozisyon kaydırmak o sayıyı iki çarpmak demektir
```java
/*----------------------------------------------------------------------------------------------------------------------
    Bir tamsayıyı, sola bitsel olarak 1 pozisyon kaydırmak o sayıyı iki çarpmak demektir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

public class App {
    public static void main(String[] args)
    {
        while (true) {
            var val = Console.readInt("Bir sayı giriniz:");

            Console.writeLine(val);
            Console.writeLine(val << 1);

            if (val == 0)
                break;
        }

        Console.writeLine("Tekrar yapıyor musunuz?");
    }
}
```
###  Bitsel kaydırma operatörleri iki operandlı araek durumunda operatörlerdir.
```java
/*----------------------------------------------------------------------------------------------------------------------
    Bitsel kaydırma operatörleri iki operandlı araek durumunda operatörlerdir. Operatörlerin yan etkisi yoktur.
    Bu operatörler operatör öncelik tablosunun beşinci seviyesinde bulunurlar. Bu operatörler soldan sağa önceliklidir.
    Bu operatörler aritmetik operatörlerden düşük, karşılaştırma operatörlerinden yüksek önceliktedir. Bu operatörlerin
    ikinci oparandlarının negatif olması durumu ayrıca incelenecektir.
----------------------------------------------------------------------------------------------------------------------*/
```
### Bitsel kaydırma operatörleri ve özellikleri
```java
/*----------------------------------------------------------------------------------------------------------------------
    Bitsel sola kaydırma operatörü, birinci operandına ilişkin tamsayının bitlerinin, ikinci operandına ilişkin tamsayı
    kadar pozisyon sola kaydırılmasından elde edilen değeri üretir. Sınır dışına çıkan bitler için 0(sıfır) biti ile
    besleme yapılır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.BitwiseUtil;

public class App {
    public static void main(String[] args)
    {
        int x = 1;

        while (x != 0) {
            BitwiseUtil.writeBits(x);
            x <<= 1;
        }
    }
}
```
### Bir tamsayıyı bitsel olarak sola 1 kaydırmakla, o sayının iki ile çarpılmış değeri elde edilir
```java
/*----------------------------------------------------------------------------------------------------------------------
    Bir tamsayıyı bitsel olarak sola 1 kaydırmakla, o sayının iki ile çarpılmış değeri elde edilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

public class App {
    public static void main(String[] args)
    {
        int val = Console.readInt("Bir sayı giriniz:");

        Console.writeLine(val);
        Console.writeLine(val << 1);

        Console.writeLine("Tekrar yapıyor musunuz?");
    }
}
```
### Bitsel sağa kaydırma işlemi için iki tane operatör vardır: ">> ve >>>."
```java
/*----------------------------------------------------------------------------------------------------------------------
    Bitsel sağa kaydırma işlemi için iki tane operatör vardır:>>, >>>. Bu operatörlerde iki operandlı araek durumunda
    operatörlerdir. Operatörlerin yan etkisi yoktur.
    >> operatörü birinci operandı olan tam sayınının, ikinci operandı olan tamsayı kadar pozisyon sağa kaydırılmış
    değerini üretir. Bu operatör taşan bitler için sayı negatifse 1, pozitifse sıfır ile besleme yapar
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.BitwiseUtil;
import org.csystem.util.Console;

public class App {
    public static void main(String[] args)
    {
        while (true) {
            var val = Console.readInt("Bir sayı girinz:");
            var n = Console.readUInt("Ne kadar sağa kaydırmak istiyorsunuz?");

            BitwiseUtil.writeBits(val);
            BitwiseUtil.writeBits(val >> n);

            if (val == 0)
                break;
        }

        Console.writeLine("Tekrar yapıyor musunuz?");
    }
}
```
### Bir tamsayıyı bitsel olarak sola 1 kaydırmakla, o sayının ikiye bölünmüş değeri elde edilir
```java
/*----------------------------------------------------------------------------------------------------------------------
    Bir tamsayıyı bitsel olarak sola 1 kaydırmakla, o sayının ikiye bölünmüş değeri elde edilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

public class App {
    public static void main(String[] args)
    {
        int val = Console.readInt("Bir sayı giriniz:");

        Console.writeLine(val);
        Console.writeLine(val >> 1);

        Console.writeLine("Tekrar yapıyor musunuz?");
    }
}
```
### Bitsel işaretsiz sağa kaydırma operatörü sayıyı soldan hep sıfır değeri ile besler.
```java
/*----------------------------------------------------------------------------------------------------------------------
    Bitsel işaretsiz sağa kaydırma operatörü sayıyı soldan hep sıfır değeri ile besler. Yani negatif bir sayıdan bu
    şekilde kaydırma ile pozitif bir değer elde edilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.BitwiseUtil;
import org.csystem.util.Console;

public class App {
    public static void main(String[] args)
    {
        while (true) {
            var val = Console.readInt("Bir sayı girinz:");
            var n = Console.readUInt("Ne kadar sağa kaydırmak istiyorsunuz?");

            BitwiseUtil.writeBits(val);
            BitwiseUtil.writeBits(val >>> n);

            if (val == 0)
                break;
        }

        Console.writeLine("Tekrar yapıyor musunuz?");
    }
}
```
###  ~(~0 >>> 1) ifadesi
```java
/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte ~(~0 >>> 1) ifadesiyle en yüksek anlamlı biti bir, diğer tüm bitleri sıfır olan
    32 bitlik bir sayı elde edilmiştir. Sağa kaydırma işlemi işaraetsiz yapılmasaydı aynı sonuç elde edilemezdi
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.BitwiseUtil;
import org.csystem.util.Console;

public class App {
    public static void main(String[] args)
    {
        int x = ~(~0 >>> 1);

        while (x != 0) {
            BitwiseUtil.writeBits(x);
            x >>>= 1;
        }

        Console.writeLine("Tekrar yapıyor musunuz?");
    }
}
```
###  ~(~0 >>> 1) ifadesi
```java
/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte ~(~0L >>> 1) ifadesiyle en yüksek anlamlı biti bir, diğer tüm bitleri sıfır olan
    64 bitlik bir sayı elde edilmiştir. Sabit L soneki koyulması gerektiğine dikkat ediniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.BitwiseUtil;
import org.csystem.util.Console;

public class App {
    public static void main(String[] args)
    {
        long x = ~(~0L >>> 1);

        while (x != 0) {
            BitwiseUtil.writeBits(x);
            x >>>= 1;
        }

        Console.writeLine("Tekrar yapıyor musunuz?");
    }
}
```
### Bitsel ve" operatörü operatör öncelik 8. seviyesinde bulunan iki operandlı araek bir operatördür.
```java
/*----------------------------------------------------------------------------------------------------------------------
    "Bitsel ve" operatörü operatör öncelik 8. seviyesinde bulunan iki operandlı araek bir operatördür. Bu operatörün de
    yan etkisi yoktur. Operatör, operandlarına ilişkin sayıların karşılıklı bitlerini "ve" işlemine sokulduğunda elde
    edilen değeri üretir. Bu operatörün soldan sağa ilişkilidir (left associative)
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.BitwiseUtil;
import org.csystem.util.Console;

public class App {
    public static void main(String[] args)
    {
        var a = Console.readInt("Birinci sayıyı giriniz:");
        var b = Console.readInt("İkinci sayıyı giriniz:");

        BitwiseUtil.writeBits(a);
        BitwiseUtil.writeBits(b);
        BitwiseUtil.writeBits(a & b);

        Console.writeLine("Tekrar yapıyor musunuz?");
    }
}
```
### bitsel ve operatörünün boolean türden operandlar ile kullanımı kısa devre davranışı olmayan "mantıksal ve" işlemi anlamına gelir.
```java
/*----------------------------------------------------------------------------------------------------------------------
    Hatırlanacağı gibi bitsel ve operatörünün boolean türden operandlar ile kullanımı kısa devre davranışı olmayan
    "mantıksal ve" işlemi anlamına gelir.
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

class App {
    public static void main(String[] args)
    {
        Console.writeLine(Sample.foo() & Sample.bar());
    }
}

class Sample {
    public static boolean foo()
    {
        Console.writeLine("foo");

        return false;
    }

    public static boolean bar()
    {
        Console.writeLine("bar");

        return true;
    }
}
```
### Bitsel özel veya" (bitwise xor) operatörü
```java
/*----------------------------------------------------------------------------------------------------------------------
    "Bitsel özel veya" (bitwise xor) operatörğ operatör öncelik tablosunun 9. seviyesindedir. İki operandlı araek
    durumunda yan etkisi olmayan soldan sağa öncelikli bir operatördür. Bu operatörün işlem tablosu şu şekildedir:

    x       y       x ^ y
    0       0         0
    0       1         1
    1       0         1
    1       1         0
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.BitwiseUtil;
import org.csystem.util.Console;

public class App {
    public static void main(String[] args)
    {
        var a = Console.readInt("Birinci sayıyı giriniz:");
        var b = Console.readInt("İkinci sayıyı giriniz:");

        BitwiseUtil.writeBits(a);
        BitwiseUtil.writeBits(b);
        BitwiseUtil.writeBits(a ^ b);

        Console.writeLine("Tekrar yapıyor musunuz?");
    }
}
```
### Bir tamsayı arka arkaya aynı değerle bitsel exor işlemine sokulursa tamsayının kendisi elde edilir.
```java
/*----------------------------------------------------------------------------------------------------------------------
    Bir tamsayı arka arkaya aynı değerle bitsel exor işlemine sokulursa tamsayının kendisi elde edilir.
    Bu özelliği dolayısıyla bu operatör birçok şifreleme algoritmasında kullanılmaktadır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.BitwiseUtil;
import org.csystem.util.Console;

public class App {
    public static void main(String[] args)
    {
        var a = Console.readInt("Birinci sayıyı giriniz:");
        var b = Console.readInt("İkinci sayıyı giriniz:");

        BitwiseUtil.writeBits(a);
        BitwiseUtil.writeBits(b);
        a ^= b;
        BitwiseUtil.writeBits(a);

        a ^= b;

        BitwiseUtil.writeBits(a);
        Console.writeLine("Tekrar yapıyor musunuz?");
    }
}
```
### Aşağıdaki örnekte sayı kendisi ile exor işlemine sokulduğu için sıfırlanmıştır
```java
/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte sayı kendisi ile exor işlemine sokulduğu için sıfırlanmıştır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

public class App {
    public static void main(String[] args)
    {
        var a = Console.readInt("Bir sayıyı giriniz:");

        Console.writeLine(a);

        a ^= a;

        Console.writeLine(a);
        Console.writeLine("Tekrar yapıyor musunuz?");
    }
}
```
### Aşağıdaki örnekte çok basit bir şifreleme algoritması yazılmıştır
```java
/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte çok basit bir şifreleme algoritması yazılmıştır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

public class App {
    public static void main(String[] args)
    {
        var str = Console.read("Bir yazı giriniz:");
        var n = Console.readInt("n değerini giriniz:");

        String newStr = Util.encryptDecrypt(str, n);

        Console.writeLine(newStr);

        Console.writeLine(Util.encryptDecrypt(newStr, n));
    }
}

class Util {
    public static String encryptDecrypt(String s, int n)
    {
        //...
        int length = s.length();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; ++i)
            sb.append((char)(s.charAt(i) ^ n));

        return sb.toString();
    }
}
/*----------------------------------------------------------------------------------------------------------------------

----------------------------------------------------------------------------------------------------------------------*/
```
