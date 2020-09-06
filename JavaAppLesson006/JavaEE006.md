### Exor operatörü boolean türü için de kullanılabilir. Şüphesiz herhangi bir kısa devre davranışı yoktur
```java
/*----------------------------------------------------------------------------------------------------------------------
    Exor operatörü boolean türü için de kullanılabilir. Şüphesiz herhangi bir kısa devre davranışı yoktur
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

public class App {
    public static void main(String[] args)
    {
        boolean result = Sample.foo() ^ Sample.bar();

        System.out.println(result);
    }
}

class Sample {
    public static boolean foo()
    {
        System.out.println("foo");

        return true;
    }

    public static boolean bar()
    {
        System.out.println("bar");

        return false;
    }
}
```
### Bir değerin kendisi ile exor işlemine sokulması durumunda sıfır değeri elde edilir
```java
/*----------------------------------------------------------------------------------------------------------------------
    Bir değerin kendisi ile exor işlemine sokulması durumunda sıfır değeri elde edilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

public class App {
    public static void main(String[] args)
    {
        var a = Console.readInt("Birinci sayıyı giriniz:");

        a ^= a;

        Console.writeLine("a=%d", a);
    }
}
```
###  "Bitsel veya" (bitwise or) operatörü operatörü
```java
/*----------------------------------------------------------------------------------------------------------------------
    "Bitsel veya" (bitwise or) operatörü operatörü, operatör öncelik tablosunun 10. seviyesinde iki operandlı
    araek durumunda bir operatördür. Öncelik yönü "soldan sağadır". Operatör, operandlarına ilişkin sayıların ,
    karşılıklı bitlerinin "veya" işlemine sokulduğunda elde edilen değeri üretir. Bu operatör soldan sağa ilişkilidir
    (left associative). Sıfır biti bitsel veya işleminde etkisiz elemandır. 1 (bir) biti bitsel veya işleminde yutan
    elemandır.
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
        BitwiseUtil.writeBits(a | b);

        Console.writeLine("Tekrar yapıyor musunuz?");
    }
}
```
### bitsel veya operatörünün boolean türden operandlar ile kullanımı
```java
/*----------------------------------------------------------------------------------------------------------------------
    Hatırlanacağı gibi bitsel veya operatörünün boolean türden operandlar ile kullanımı kısa devre davranışı olmayan
    "mantıksal veya" işlemi anlamına gelir.
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

class App {
    public static void main(String[] args)
    {
        Console.writeLine(Sample.bar() | Sample.foo());
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
###  "Bitsel değil" operatörü dışında, tüm bitsel operatörlere ilişkin işlemli atama operatörleri vardır.
```java
/*----------------------------------------------------------------------------------------------------------------------
    "Bitsel değil" operatörü dışında, tüm bitsel operatörlere ilişkin işlemli atama operatörleri vardır. Bilindiği gibi
    bitsel operatörlerin kısa devre davranışları yoktur. Bir bitsel operatörün yan etki yapması isteniyorsa hem kolay
    yazım hem de oklunabilirlik açısından bitsel işlemli atama operatörleri tercih edilmelidir.
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

        a |= b; // a = a | b;

        BitwiseUtil.writeBits(a);

        Console.writeLine("Tekrar yapıyor musunuz?");
    }
}
```
### exorswap
```java
/*----------------------------------------------------------------------------------------------------------------------
    Bitsel exor operatörü kullanılarak iki tane tamsayı türden değişkenin değerleri, üçüncü bir değişken kullanmadan
    değiştirilebilir. Bu işleme takas (swap) denir. Exor ile yapıldığı için ayrıca "exorswap" da denir.
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
        b ^= a;
        a ^= b;

        Console.writeLine("a=%d", a);
        Console.writeLine("b=%d", b);

        Console.writeLine("Tekrar yapıyor musunuz?");
    }
}
```
### Aşağıdaki örnekte aynı değişken ile takas yapılmaya çalışılmıştır. Bu durumda değer kaybedilir
```java
/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte aynı değişken ile takas yapılmaya çalışılmıştır. Bu durumda değer kaybedilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.BitwiseUtil;
import org.csystem.util.Console;

public class App {
    public static void main(String[] args)
    {
        var a = Console.readInt("Birinci sayıyı giriniz:");

        BitwiseUtil.writeBits(a);

        a ^= a;
        a ^= a;
        a ^= a;

        Console.writeLine("a=%d", a);

        Console.writeLine("Tekrar yapıyor musunuz?");
    }
}
```
### Aşağıdaki örnekte reverse metotları içerisinde çağrılan swap metotları exor kullanılarak yazılmıştır
```java
/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte reverse metotları içerisinde çağrılan swap metotları exor kullanılarak yazılmıştır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.ArrayUtil;

public class App {
    public static void main(String[] args)
    {
        int [] a = {5, 2, 3, 4, 5};
        char [] c = {'a', 'l', 'i'};

        ArrayUtil.reverse(a);
        ArrayUtil.reverse(c);
        ArrayUtil.display(a);
        ArrayUtil.display(c);
    }
}
```
###  Aşağıdaki örnekte swap metoduna aynı değişken verildiğinden değer kaybedilir. 
```java
/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte swap metoduna aynı değişken verildiğinden değer kaybedilir. İstenirse swap metodunda indeksler
    kontrol edilerek bu durum engellenebilir. Kontrol durumunda bitsel işlem kullanmak klasik swap işlemine göre
    avantaj getirmez
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.ArrayUtil;

public class App {
    public static void main(String[] args)
    {
        int [] a = {5, 2, 3, 4, 5};

        ArrayUtil.swap(a, 1, 1);

        ArrayUtil.display(a);
    }
}
```
### bitwise manipulation
```java
/*----------------------------------------------------------------------------------------------------------------------
    Özellikle aşağı seviyeli kodlarda bir tamsayının bitleri üzerinde işlemler yapılması (bitwise manipulation)
    gerekli olabilir.
    Anahtar Notlar: Bir işlemin hızlı olarak çalışması her zaman ihtiyaç duyulan bir durum değildir. Bu durumlarda
    programcılar kodun okunabilirliğini hızlı çalışmasına tercih edebilirler. Programcı bu tip durumların kararını
    verirken dikkatli olmalıdır. Yani "her zaman hızlı olsun" ya da "yavaş olsa da okunabilir olsun" cümleleri
    her zaman geçerli değildir. Bunların kararı tamamen algoritmanıza bağlıdır.
----------------------------------------------------------------------------------------------------------------------*/
```
### Bir tamsayının belirli bir bitinin birlenmesi:
```java
/*----------------------------------------------------------------------------------------------------------------------
    Bir tamsayının belirli bir bitinin birlenmesi:
    Bir tamsayının belirli bir bitinin bir yapılmasına "set" işlemi denir. Bir tamsayının belirli bir bitini birlemek
    için, ilgili biti 1 olan ve diğer tüm bitleri sıfır olan bir sayıyla "bitsel veya" işlemine sokulmalıdır. Çünkü
    "bitsel veya" işleminde 1 yutan, sıfır da etkisiz elemandır. Aşağıdaki örnekte sıfır sağdaki ilk bit numarası olmak
    üzere,  5. bit birlenmiştir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.BitwiseUtil;
import org.csystem.util.Console;

public class App {
    public static void main(String[] args)
    {
        int a = 0x00000041;
        int mask = 0x00000020;

        BitwiseUtil.writeBits(a);
        BitwiseUtil.writeBits(mask);

        a |= mask;

        BitwiseUtil.writeBits(a);

        Console.writeLine("a=%d", a);
    }
}
```
### Bir sayının belirli bitini birlemek için 1 sayısının o kadar sola kaydırılması gerekir.
```java
/*----------------------------------------------------------------------------------------------------------------------
    Bir sayının belirli bitini birlemek için 1 sayısının o kadar sola kaydırılması gerekir. Yani örneğin bir n sayısının
    k. bitininin (bit numarasının sıfırdan başladığını unutmayınız) birlenmesi için sayı 1 << k ifadeesi ile "bitsel or"
    işlemine sokulabilir. Bu tür işlemlerde kullanılan 1 << k gibi ifadelere bitsel maske (bitmask) denir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.BitwiseUtil;
import org.csystem.util.Console;

public class App {
    public static void main(String[] args)
    {
        int k = 5;
        int a = 0x00000041;
        int mask = 1 << k;

        BitwiseUtil.writeBits(a);
        BitwiseUtil.writeBits(mask);

        a |= mask;

        BitwiseUtil.writeBits(a);

        Console.writeLine("a=%d", a);
    }
}
```
### Bir sayının belirli bitini birlemek için 1 sayısının o kadar sola kaydırılması gerekir. 
```java
/*----------------------------------------------------------------------------------------------------------------------
    Bir sayının belirli bitini birlemek için 1 sayısının o kadar sola kaydırılması gerekir. Yani örneğin bir n sayısının
    k. bitininin (bit numarasının sıfırdan başladığını unutmayınız) birlenmesi için sayı 1 << k ifadeesi ile "bitsel or"
    işlemine sokulabilir. Bu tür işlemlerde kullanılan 1 << k gibi ifadelere bitsel maske (bitmask) denir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.BitwiseUtil;
import org.csystem.util.Console;

public class App {
    public static void main(String[] args)
    {
        int k = 5;
        int a = 0x00000041;

        BitwiseUtil.writeBits(a);

        a |= 1 << k;

        BitwiseUtil.writeBits(a);

        Console.writeLine("a=%d", a);
    }
}
```
### BitwiseUtil sınıfının setBit metodu
```java
/*----------------------------------------------------------------------------------------------------------------------
    BitwiseUtil sınıfının setBit metodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.BitwiseUtil;
import org.csystem.util.Console;

public class App {
    public static void main(String[] args)
    {
        int k = 5;
        int a = 0x00000041;

        BitwiseUtil.writeBits(a);

        a = BitwiseUtil.setBit(a, k);

        BitwiseUtil.writeBits(a);

        Console.writeLine("a=%d", a);
    }
}
```
### Bir tamsayının belirli bir bitinin sıfırlanması:
```java
/*----------------------------------------------------------------------------------------------------------------------
    Bir tamsayının belirli bir bitinin sıfırlanması:
    Bir tamsayının belirli bir bitinin sıfır yapılmasına "clear/reset" işlemi denir. Bu işlem için ilgili biti sıfır
    olan ve diğer bitleri 1(bir) olan bir maskeyle "bitsel ve" işlemine sokulur. Çünkü "bitsel ve" işleminde sıfır yutan,
    1(bir) ise etkisiz elemandır. Aşağıdaki örnekte 5. bit sıfırlanmıştır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.BitwiseUtil;
import org.csystem.util.Console;

public class App {
    public static void main(String[] args)
    {
        int a = 0x00000061;
        int mask = ~0x00000020;

        BitwiseUtil.writeBits(a);
        BitwiseUtil.writeBits(mask);

        a &= mask;

        BitwiseUtil.writeBits(a);

        Console.writeLine("a=%d", a);
    }
}
```
### Aşağıdaki örnekte bir bitin sıfırlanmasına yönelik maske kullanılmıştır
```java
/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte bir bitin sıfırlanmasına yönelik maske kullanılmıştır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.BitwiseUtil;
import org.csystem.util.Console;

public class App {
    public static void main(String[] args)
    {
        int k = 5;
        int a = 0x00000061;

        BitwiseUtil.writeBits(a);

        a &= ~(1 << k);

        BitwiseUtil.writeBits(a);

        Console.writeLine("a=%d", a);
    }
}
```
### BitwiseUtil sınıfının clearBit metodu
```java
/*----------------------------------------------------------------------------------------------------------------------
    BitwiseUtil sınıfının clearBit metodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.BitwiseUtil;
import org.csystem.util.Console;

public class App {
    public static void main(String[] args)
    {
        int k = 5;
        int a = 0x00000061;

        BitwiseUtil.writeBits(a);

        a = BitwiseUtil.clearBit(a, k);

        BitwiseUtil.writeBits(a);

        Console.writeLine("a=%d", a);
    }
}
```
### BitwiseUtil sınıfının setBit metodu
```java
/*----------------------------------------------------------------------------------------------------------------------
    BitwiseUtil sınıfının setBit metodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.BitwiseUtil;

public class App {
    public static void main(String[] args)
    {
        int k = 63;
        long a = 0x0000000000000061;

        BitwiseUtil.writeBits(a);

        a = BitwiseUtil.setBit(a, k);

        BitwiseUtil.writeBits(a);
    }
}
```
### Bir tamsayının belirli bir bitini değiştirmek:
```java
/*----------------------------------------------------------------------------------------------------------------------
    Bir tamsayının belirli bir bitini değiştirmek:
    Bazı kodlarda bir tamsayının belirli bir bitinin değiştirilmesi (toggle-flip) gerekebilir. Yani bitin sıfır ise 1(bir),
    1(bir) ise sıfır yapılması gerekebilir. Bu işlem için "bitsel exor" operatörü kullalınır. Bir sayının n. bitinin
    değerini değiştirmek için sayı, n. biti 1(bir), diğer bitleri sıfır olan bir maske ile "bitsel exor" işlemine sokulur.
    x bir tamsayı ise bu sayının n. bitini değiştirmek için şu ifade kullanılabilir:
            x ^= 1 << n
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.BitwiseUtil;

public class App {
    public static void main(String[] args)
    {
        int x = 0x41;
        int n = 5;

        BitwiseUtil.writeBits(x);
        BitwiseUtil.writeBits(1 << n);

        x ^= 1 << n;

        BitwiseUtil.writeBits(x);
    }
}
```
### BitwiseUtil sınıfının toggleBit metodu
```java
/*----------------------------------------------------------------------------------------------------------------------
    BitwiseUtil sınıfının toggleBit metodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.BitwiseUtil;

public class App {
    public static void main(String[] args)
    {
        int x = 0x41;
        int n = 5;

        BitwiseUtil.writeBits(x);
        BitwiseUtil.writeBits(1 << n);

        x = BitwiseUtil.toggleBit(x, n);

        BitwiseUtil.writeBits(x);
    }
}
```
### BitwiseUtil sınıfının toggleBit metodu
```java
/*----------------------------------------------------------------------------------------------------------------------
    BitwiseUtil sınıfının toggleBit metodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.BitwiseUtil;

public class App {
    public static void main(String[] args)
    {
        long x = 0x41;
        int n = 33;

        BitwiseUtil.writeBits(x);
        BitwiseUtil.writeBits(1L << n);

        x = BitwiseUtil.toggleBit(x, n);

        BitwiseUtil.writeBits(x);
    }
}
```
### Bir tamsayının belirli bir bitinin elde edilmesi:
```java
/*----------------------------------------------------------------------------------------------------------------------
    Bir tamsayının belirli bir bitinin elde edilmesi:
    Bir tamsayının belirli bir bitinin sıfır mı 1(bir) olduğunun öğrenilmesi için, tamsayı ilgili biti 1(bir), diğer
    bitleri sıfır olan bir maskeyle "bitsel ve" işlemine sokulup elde edilen değer yorumlanmalıdır. Çünkü "bitsel ve"
    işleminde sıfır yutan eleman, 1(bir) de etkisiz elemandır. İfadenin ürettiği değerin 1(bir) veya sıfır ile
    karşılaştırılması gerekir. İfade şu şekilde yazılabilir:
        if ((x & 1 << n) != 0)  // if ((x & 1 << n) == 1 << n)
            //n. bit 1(bir)
        else
            //n. bit sıfır

        Burada (x & 1 << n) == 1 ifadesinde parantezin gerektiğine dikkat ediniz.
     Bir sayının çift mi tek mi olduğu sıfırıncı bitine bakılarak anlaşılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.BitwiseUtil;
import org.csystem.util.Console;

public class App {
    public static void main(String[] args)
    {
        var x = Console.readInt("Bir sayı giriniz:");

        BitwiseUtil.writeBits(x);

        if ((x & 1) == 1)
            Console.writeLine("%d sayısı tek sayıdır", x);
        else
            Console.writeLine("%d sayısı çift sayıdır", x);
    }
}
```
### BitwiseUtil sınıfının isEven metodu
```java
/*----------------------------------------------------------------------------------------------------------------------
   BitwiseUtil sınıfının isEven metodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.BitwiseUtil;
import org.csystem.util.Console;

public class App {
    public static void main(String[] args)
    {
        var x = Console.readInt("Bir sayı giriniz:");

        BitwiseUtil.writeBits(x);

        if (BitwiseUtil.isEven(x))
            Console.writeLine("%d sayısı çift sayıdır", x);
        else
            Console.writeLine("%d sayısı tek sayıdır", x);
    }
}
```
### BitwiseUtil sınıfının isSet metodu
```java
/*----------------------------------------------------------------------------------------------------------------------
   BitwiseUtil sınıfının isSet metodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.BitwiseUtil;
import org.csystem.util.Console;

public class App {
    public static void main(String[] args)
    {
        while (true) {
            var x = Console.readInt("Bir sayı giriniz:");
            if (x == 0)
                break;
            var n = Console.readInt("Kaçıncı biti elde etmek istiyorsunuz:");

            BitwiseUtil.writeBits(x);

            Console.writeLine("%d sayısın %d. biti %d", x, n, BitwiseUtil.isSet(x, n) ? 1 : 0);
        }
    }
}
```
### BitwiseUtil sınıfının isSet metodu
```java
/*----------------------------------------------------------------------------------------------------------------------
   BitwiseUtil sınıfının isSet metodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.BitwiseUtil;
import org.csystem.util.Console;

public class App {
    public static void main(String[] args)
    {
        while (true) {
            var x = Console.readLong("Bir sayı giriniz:");
            if (x == 0)
                break;
            var n = Console.readInt("Kaçıncı biti elde etmek istiyorsunuz:");

            BitwiseUtil.writeBits(x);

            Console.writeLine("%d sayısın %d. biti %d", x, n, BitwiseUtil.isSet(x, n) ? 1 : 0);
        }
    }
}
```
### Bir sayının ikinin kuvveti olup olmadığını test eden isPowerOfTwo metodunu bitsel operatörleri kullanrak yazınız
```java
/*----------------------------------------------------------------------------------------------------------------------
    Soru: Bir sayının ikinin kuvveti olup olmadığını test eden isPowerOfTwo metodunu bitsel operatörleri kullanrak
    yazınız
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.BitwiseUtil;
import org.csystem.util.Console;

public class App {
    public static void main(String[] args)
    {
        while (true) {
            var x = Console.readInt("Bir sayı giriniz:");

            BitwiseUtil.writeBits(x);

            if (BitwiseUtil.isPowerOfTwo(x))
                Console.writeLine("%d sayısı ikinin kuvvetidir", x);
            else
                Console.writeLine("%d sayısı ikinin kuvveti değildir", x);

            if (x == 0)
                break;
        }
    }
}
```
### BitwiseUtil sınıfının writeBits metotları
```java
/*----------------------------------------------------------------------------------------------------------------------
    BitwiseUtil sınıfının writeBits metotları
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.BitwiseUtil;
import org.csystem.util.Console;

public class App {
    public static void main(String[] args)
    {
        var b = Console.readByte("Bir sayı giriniz:");
        var s = Console.readShort("Bir sayı giriniz:");
        var i = Console.readInt("Bir sayı giriniz:");
        var l = Console.readLong("Bir sayı giriniz:");

        BitwiseUtil.writeBits(b);
        BitwiseUtil.writeBits(s);
        BitwiseUtil.writeBits(i);
        BitwiseUtil.writeBits(l);
    }
}
```
### Sınıf Çalışması: Parametresi ile aldığı int türden bir değerin kaç tane bitinin 1(bir) olduğunu döndüren numberOfSetBits metodunu yazınız
```java
/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Parametresi ile aldığı int türden bir değerin kaç tane bitinin 1(bir) olduğunu döndüren
    numberOfSetBits metodunu yazınız
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.BitwiseUtil;
import org.csystem.util.Console;

public class App {
    public static void main(String[] args)
    {
        while (true) {
            var x = Console.readInt("Bir sayı giriniz:");

            BitwiseUtil.writeBits(x);
            int count = BitwiseUtil.numberOfClearBits(x);

            Console.writeLine("Number Clear Bits:%d", count);

            if (x == 0)
                break;
        }
    }
}
```
### Sınıf Çalışması: Parametresi ile aldığı int türden bir değerin kaç tane bitinin 1(bir) olduğunu döndüren numberOfSetBits metodunu yazınız
```java
/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Parametresi ile aldığı int türden bir değerin kaç tane bitinin 1(bir) olduğunu döndüren
    numberOfSetBits metodunu yazınız
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.BitwiseUtil;
import org.csystem.util.Console;

public class App {
    public static void main(String[] args)
    {
        while (true) {
            var x = Console.readShort("Bir sayı giriniz:");

            BitwiseUtil.writeBits(x);
            int count = BitwiseUtil.numberOfClearBits(x);

            Console.writeLine("Number Clear Bits:%d", count);

            if (x == 0)
                break;
        }
    }
}
```
### Sınıf Çalışması: Parametresi ile aldığı int türden bir sayının bitlerini String olarak döndüren toBitsString isimli metodu yazınız
```java
/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Parametresi ile aldığı int türden bir sayının bitlerini String olarak döndüren toBitsString
    isimli metodu yazınız
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

public class App {
    public static void main(String[] args)
    {
        var x = Console.readInt("Bir sayı giriniz:");

        var bits = Util.toBitsStr(x);

        Console.writeLine(bits);
    }
}

class Util {
    public static String toBitsStr(int val)
    {
        char [] bits = new char[32];

        for (int k = 31; k >= 0; --k)
            bits[31 - k] = (val & 1 << k) != 0 ? '1' : '0';

        return String.valueOf(bits);
    }
}
```
### Sınıf Çalışması: Parametresi ile aldığı int türden bir sayının bitlerini String olarak döndüren toBitsString isimli metodu yazınız
```java
/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Parametresi ile aldığı int türden bir sayının bitlerini String olarak döndüren toBitsString
    isimli metodu yazınız
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

public class App {
    public static void main(String[] args)
    {
        var x = Console.readInt("Bir sayı giriniz:");

        var bits = Util.toBitsStr(x);

        Console.writeLine(bits);
    }
}

class Util {
    public static String toBitsStr(int val)
    {
        StringBuilder sb = new StringBuilder(32);

        for (int k = 31; k >= 0; --k)
            sb.append((val & 1 << k) != 0 ? 1 : 0);

        return sb.toString();
    }
}
```
### Sınıf Çalışması: Parametresi ile aldığı int türden bir değerin 1(bir) olan bitlerinin index numaraların bir dizi olarak döndüren indicesOfSetBits metodunu yazınız
```java
/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Parametresi ile aldığı int türden bir değerin 1(bir) olan bitlerinin index numaralarını
    bir dizi olarak döndüren indicesOfSetBits metodunu yazınız
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.ArrayUtil;
import org.csystem.util.BitwiseUtil;
import org.csystem.util.Console;

public class App {
    public static void main(String[] args)
    {
        var x = Console.readInt("Bir sayı giriniz:");
        var bitIndices = BitwiseUtil.indicesOfSetBits(x);

        BitwiseUtil.writeBits(x);
        ArrayUtil.display(bitIndices);
    }
}
```
### BitwiseUtil sınıfı
```java
/*----------------------------------------------------------------------------------------------------------------------
    BitwiseUtil sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util;

public class BitwiseUtil {
    private BitwiseUtil()
    {}

    public static int clearBit(int val, int k) //k -> [0, 31]
    {
        return val & ~(1 << k);
    }

    public static long clearBit(long val, int k) //k -> [0, 63]
    {
        return val & ~(1L << k);
    }

    public static int [] indicesOfSetBits(char ch)
    {
        int [] bitIndices = new int[numberOfSetBits(ch)];
        int index = 0;

        for (int k = 0; k < 16; ++k)
            if ((ch & 1 << k) != 0)
                bitIndices[index++] = k;

        return bitIndices;
    }

    public static int [] indicesOfSetBits(byte val)
    {
        int [] bitIndices = new int[numberOfSetBits(val)];
        int index = 0;

        for (int k = 0; k < 8; ++k)
            if ((val & 1 << k) != 0)
                bitIndices[index++] = k;

        return bitIndices;
    }

    public static int [] indicesOfSetBits(short val)
    {
        int [] bitIndices = new int[numberOfSetBits(val)];
        int index = 0;

        for (int k = 0; k < 16; ++k)
            if ((val & 1 << k) != 0)
                bitIndices[index++] = k;

        return bitIndices;
    }

    public static int [] indicesOfSetBits(int val)
    {
        int [] bitIndices = new int[numberOfSetBits(val)];
        int index = 0;

        for (int k = 0; k < 32; ++k)
            if ((val & 1 << k) != 0)
                bitIndices[index++] = k;

        return bitIndices;
    }

    public static int [] indicesOfSetBits(long val)
    {
        int [] bitIndices = new int[numberOfSetBits(val)];
        int index = 0;

        for (int k = 0; k < 64; ++k)
            if ((val & 1L << k) != 0)
                bitIndices[index++] = k;

        return bitIndices;
    }

    public static boolean isEven(int val)
    {
        return isClear(val, 0);
    }

    public static boolean isEven(long val)
    {
        return isClear(val, 0);
    }

    public static boolean isPowerOfTwo(int val)
    {
        return val != 0 && (val & (val - 1)) == 0;
    }

    public static boolean isSet(int val, int k)
    {
        return (val & (1 << k)) != 0;
    }

    public static boolean isClear(int val, int k)
    {
        return !isSet(val, k);
    }

    public static boolean isSet(long val, int k)
    {
        return (val & 1L << k) != 1;
    }

    public static boolean isClear(long val, int k)
    {
        return !isSet(val, k);
    }

    public static int numberOfClearBits(byte val)
    {
        return 8 - numberOfSetBits(val);
    }

    public static int numberOfSetBits(byte val)
    {
        int count = 0;

        for (int k = 0; k < 8; ++k)
            if ((val & 1 << k) != 0)
                ++count;

        return count;
    }

    public static int numberOfClearBits(short val)
    {
        return 16 - numberOfSetBits(val);
    }

    public static int numberOfSetBits(short val)
    {
        int count = 0;

        for (int k = 0; k < 16; ++k)
            if ((val & 1 << k) != 0)
                ++count;

        return count;
    }

    public static int numberOfClearBits(int val)
    {
        return 32 - numberOfSetBits(val);
    }

    public static int numberOfSetBits(int val)
    {
        int count = 0;

        for (int k = 0; k < 32; ++k)
            if ((val & 1 << k) != 0)
                ++count;

        return count;
    }

    public static int numberOfClearBits(long val)
    {
        return 64 - numberOfSetBits(val);
    }

    public static int numberOfSetBits(long val)
    {
        int count = 0;

        for (int k = 0; k < 64; ++k)
            if ((val & 1L << k) != 0)
                ++count;

        return count;
    }

    public static int numberOfClearBits(char val)
    {
        return 16 - numberOfSetBits(val);
    }

    public static int numberOfSetBits(char val)
    {
        int count = 0;

        for (int k = 0; k < 16; ++k)
            if ((val & 1 << k) != 0)
                ++count;

        return count;
    }

    public static int setBit(int val, int k) //k -> [0, 31]
    {
        return val | 1 << k;
    }

    public static long setBit(long val, int k) //k -> [0, 63]
    {
        return val | 1L << k;
    }

    public static String toBitsStr(char ch)
    {
        char [] bits = new char[16];

        for (int k = 15; k >= 0; --k)
            bits[15 - k] = (ch & 1 << k) != 0 ? '1' : '0';

        return String.valueOf(bits);
    }

    public static String toBitsStr(byte val)
    {
        char [] bits = new char[8];

        for (int k = 7; k >= 0; --k)
            bits[7 - k] = (val & 1 << k) != 0 ? '1' : '0';

        return String.valueOf(bits);
    }

    public static String toBitsStr(short val)
    {
        char [] bits = new char[16];

        for (int k = 15; k >= 0; --k)
            bits[15 - k] = (val & 1 << k) != 0 ? '1' : '0';

        return String.valueOf(bits);
    }

    public static String toBitsStr(int val)
    {
        char [] bits = new char[32];

        for (int k = 31; k >= 0; --k)
            bits[31 - k] = (val & 1 << k) != 0 ? '1' : '0';

        return String.valueOf(bits);
    }

    public static String toBitsStr(long val)
    {
        char [] bits = new char[64];

        for (int k = 63; k >= 0; --k)
            bits[63 - k] = (val & 1L << k) != 0 ? '1' : '0';

        return String.valueOf(bits);
    }

    public static int toggleBit(int val, int n)
    {
        return val ^ 1 << n;
    }

    public static long toggleBit(long val, int n)
    {
        return val ^ 1L << n;
    }

    public static void writeBits(char val)
    {
        for (int k = 15; k >= 0; --k)
            Console.write((val & 1 << k) != 0 ? 1 : 0);

        Console.writeLine();
    }

    public static void writeBits(byte val)
    {
        for (int k = 7; k >= 0; --k)
            Console.write((val & 1 << k) != 0 ? 1 : 0);

        Console.writeLine();
    }

    public static void writeBits(short val)
    {
        for (int k = 15; k >= 0; --k)
            Console.write((val & 1 << k) != 0 ? 1 : 0);

        Console.writeLine();
    }

    public static void writeBits(int val)
    {
        for (int k = 31; k >= 0; --k)
            Console.write((val & 1 << k) != 0 ? 1 : 0);

        Console.writeLine();
    }

    public static void writeBits(long val)
    {
        for (int k = 63; k >= 0; --k)
            Console.write((val & 1L << k) != 0 ? 1 : 0);

        Console.writeLine();
    }
}
```
### Deprecated! Date sınıfı
```java
/*----------------------------------------------------------------------------------------------------------------------
    Java 1.0 ile eklenmiş ancak çok problemli olduğu için bir çok metodunun deprecated olduğu, bir Java
    programcısının zorunlu olmadıkça kullanmaması gereken Date sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.util.Date;

class App {
    public static void main(String[] args)
    {
        Date now = new Date();

        long ms = now.getTime();

        Console.writeLine("Time in milliseconds:%d", ms);

        Date dt = new Date(ms);

        Console.writeLine(now.toString());
        Console.writeLine(dt.toString());
    }
}
```
###  Calendar sınıfı ile sistemin o anki tarih-zaman bilgisinin elde edilmesi
```java
/*----------------------------------------------------------------------------------------------------------------------
    Calendar sınıfı ile sistemin o anki tarih-zaman bilgisinin elde edilmesi
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
    }
}
```
### Calendar sınıfı ile sistemin o anki tarih-zaman bilgisinin elde edilmesi
```java
/*----------------------------------------------------------------------------------------------------------------------
    Calendar sınıfı ile sistemin o anki tarih-zaman bilgisinin elde edilmesi
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.util.Calendar;
import java.util.GregorianCalendar;

class App {
    public static void main(String[] args)
    {
        Calendar now = new GregorianCalendar();

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
```
### Calendar sınıfı tarih-zaman bilgileri için geçerlilik kontrolü yapmaz
```java
/*----------------------------------------------------------------------------------------------------------------------
    Calendar sınıfı tarih-zaman bilgileri için geçerlilik kontrolü yapmaz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.util.Calendar;
import java.util.GregorianCalendar;

class App {
    public static void main(String[] args)
    {
        Calendar now = new GregorianCalendar(2020, 23, 78, 34, 89, 123);

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
```
### Calendar sınıfının getTimeInMillis metodu
```java
/*----------------------------------------------------------------------------------------------------------------------
    Calendar sınıfının getTimeInMillis metodu epoch time (01.01.1970 00:00:00.0) zamanından nesnenin tuttuğu zamana
    kadar olan milisaniye sayısını döndürür. Aşağıdaki örnekte yaş hesabı yapılmıştır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.util.Calendar;
import java.util.GregorianCalendar;

class App {
    public static void main(String[] args)
    {
        Calendar birthDate = new GregorianCalendar(1976, 8, 10);
        Calendar now = Calendar.getInstance();

        double age = Math.abs((now.getTimeInMillis() - birthDate.getTimeInMillis()) / (1000. * 60 * 60 * 24 * 365));

        Console.writeLine("Yaş:%f", age);
    }
}
```
### Calendar sınıfının getTimeInMillis metodu
```java
/*----------------------------------------------------------------------------------------------------------------------
    Calendar sınıfının getTimeInMillis metodu epoch time (01.01.1970 00:00:00.0) zamanından nesnenin tuttuğu zamana
    kadar olan milisaniye sayısını döndürür. Aşağıdaki örnekte yaş hesabı yapılmıştır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.util.Calendar;
import java.util.GregorianCalendar;

class App {
    public static void main(String[] args)
    {
        Calendar birthDate = new GregorianCalendar(1976, Calendar.SEPTEMBER, 10);
        Calendar now = Calendar.getInstance();

        double age = Math.abs((now.getTimeInMillis() - birthDate.getTimeInMillis()) / (1000. * 60 * 60 * 24 * 365));

        Console.writeLine("Yaş:%f", age);
    }
}
```
### Calendar sınıfının after ve before metotları
```java
/*----------------------------------------------------------------------------------------------------------------------
    Calendar sınıfının after ve before metotları
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.util.Calendar;
import java.util.GregorianCalendar;

class App {
    public static void main(String[] args)
    {
        Calendar birthDate = new GregorianCalendar(1976, Calendar.SEPTEMBER, 10);
        Calendar now = Calendar.getInstance();

        Console.writeLine(now.after(birthDate));
        Console.writeLine(now.before(birthDate));
    }
}
```
### Calendar sınıfı immutable bir sınıf değildir
```java
/*----------------------------------------------------------------------------------------------------------------------
    Calendar sınıfı immutable bir sınıf değildir
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
```
### Sınıf Çalışması: Doğum gününüz kutlu olsun
```java
/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Klavyeden alınan gün, ay ve yıl bilgilerine göre kişinin doğum günü geçmişse
    "geçmiş doğum gününü kutlu olsun", o an doğum günü ise "doğum gününüz kutlu olsun", doğum henüz gelmemişse
    "doğum gününüz şimdiden kutlu olsun" mesajlarından birini ekrana basan programı Calendar sınıfını kullanarak yazınız
----------------------------------------------------------------------------------------------------------------------*/

/*----------------------------------------------------------------------------------------------------------------------

----------------------------------------------------------------------------------------------------------------------*/
```
