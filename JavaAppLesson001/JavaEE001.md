### Aşağıdaki örnekte changeCase metodu içerisinde sürekli String nesnesi yaratılmaktadır
```java
/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte changeCase metodu içerisinde sürekli String nesnesi yaratılmaktadır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Scanner;

class App {
    public static void main(String [] args)
    {
        Scanner kb = new Scanner(System.in);
        System.out.print("Bir yazı giriniz:");
        String s = kb.nextLine();

        System.out.println(Util.changeCase(s));

    }
}

class Util {
    public static String changeCase(String s)
    {
        int length = s.length();
        String str = "";

        for (int i = 0; i < length; ++i) {
            char ch = s.charAt(i);

            if (Character.isUpperCase(ch))
                ch = Character.toLowerCase(ch);
            else if (Character.isLowerCase(ch))
                ch = Character.toUpperCase(ch);

            str += ch; //str = str + ch;
        }

        return str;
    }
}
```
### Yukarıdaki örnekte metot dizi kullanarak daha etkin bir biçimde yazılabilir
```java
/*----------------------------------------------------------------------------------------------------------------------
    Yukarıdaki örnekte metot dizi kullanarak daha etkin bir biçimde yazılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Scanner;

class App {
    public static void main(String [] args)
    {
        Scanner kb = new Scanner(System.in);
        System.out.print("Bir yazı giriniz:");
        String s = kb.nextLine();

        System.out.println(Util.changeCase(s));

    }
}

class Util {
    public static String changeCase(String s)
    {
        char [] c = s.toCharArray();

        for (int i = 0; i < c.length; ++i) {
            if (!Character.isLetter(c[i]))
                continue;

            c[i] = Character.isUpperCase(c[i]) ? Character.toLowerCase(c[i]) : Character.toUpperCase(c[i]);
        }

        return new String(c);
    }
}
```
### StringBuilder sınıfının default ctor'u capacity değerini 16'ya çeker
```java
/*----------------------------------------------------------------------------------------------------------------------
    StringBuilder sınıfının default ctor'u capacity değerini 16'ya çeker
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        StringBuilder sb = new StringBuilder();

        System.out.printf("Capacity:%d%n", sb.capacity());
        System.out.printf("Length:%d%n", sb.length());
    }
}
```
### StringBuilder sınıfının capacity parametreli ctor'u
```java
/*----------------------------------------------------------------------------------------------------------------------
    StringBuilder sınıfının capacity parametreli ctor'u
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        StringBuilder sb = new StringBuilder(100);

        System.out.printf("Capacity:%d%n", sb.capacity());
        System.out.printf("Length:%d%n", sb.length());
    }
}
```
### StringBuilder sınıfının String parametreli ctor'u
```java
/*----------------------------------------------------------------------------------------------------------------------
    StringBuilder sınıfının String parametreli ctor'u
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        StringBuilder sb = new StringBuilder("ankara");

        System.out.printf("Capacity:%d%n", sb.capacity());
        System.out.printf("Length:%d%n", sb.length());
    }
}
```
### StringBuilder sınıfının append ve toString metotları
```java
/*----------------------------------------------------------------------------------------------------------------------
    StringBuilder sınıfının append ve toString metotları
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        StringBuilder sb = new StringBuilder("ankara");

        sb.append('-').append("istanbul");

        String str = sb.toString();

        System.out.println(str);
    }
}
```
### Sınıf Çalışması: Klavyeden quit girilene kadar alınan yazıların birleşiminden bir String elde eden programı yazınız
```java
/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Klavyeden quit girilene kadar alınan yazıların birleşiminden
    bir String elde eden programı yazınız
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

class App {
    public static void main(String [] args)
    {
        Console.writeLine("Yazıları girmeye başlayınız:");
        StringBuilder sb = new StringBuilder();

        for (;;) {
            String s = Console.readString("Bir yazı giriniz:");

            if (s.equals("quit"))
                break;

            sb.append(s);
        }

        String str = sb.toString();

        Console.writeLine("Yazı:%s", str);
    }
}
```
###  StringBuilder sınıfının charAt metodu
```java
/*----------------------------------------------------------------------------------------------------------------------
    StringBuilder sınıfının charAt metodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

class App {
    public static void main(String [] args)
    {
        StringBuilder sb = new StringBuilder("ankara");
        int length = sb.length();

        for (int i = 0; i < length; ++i)
            Console.write("%c ", sb.charAt(i));
    }
}
```
### StringBuilder kullanılarak addAllCharsWith ve subtractAllCharsWith metotları
```java
/*----------------------------------------------------------------------------------------------------------------------
    StringBuilder kullanılarak addAllCharsWith ve subtractAllCharsWith metotları
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;
import org.csystem.util.StringUtil;

class App {
    public static void main(String [] args)
    {
        String str = Console.readString("Bir yazı giriniz:");
        int n = Console.readInt("n değerini giriniz:", "Hatalı giriş yaptınız:");

        String newStr = StringUtil.addAllCharsWith(str, n);
        String oldStr = StringUtil.subtractAllCharsWith(newStr, n);

        Console.writeLine("New String:%s", newStr);
        Console.writeLine("Old String:%s", oldStr);
    }
}
```
### StringBuilder sınıfının delete metodu
```java
/*----------------------------------------------------------------------------------------------------------------------
    StringBuilder sınıfının delete metodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;
import org.csystem.util.StringUtil;

class App {
    public static void main(String [] args)
    {
        String str = "ankara";
        int start = 1;
        int end = 3;

        StringBuilder sb = new StringBuilder(str); //[start, end)

        str = sb.delete(start, end).toString();

        Console.writeLine("%s", str);
    }
}
```
### StringBuilder sınıfının reverse metodu kullanarak yazılan StringUtil sınıfının reverse metodu
```java
/*----------------------------------------------------------------------------------------------------------------------
    StringBuilder sınıfının reverse metodu kullanarak yazılan StringUtil
    sınıfının reverse metodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;
import org.csystem.util.StringUtil;

class App {
    public static void main(String [] args)
    {
        String s = Console.readString("Bir yazı giriniz:");

        Console.writeLine("%s", StringUtil.reverse(s));
    }
}
```
### StringUtil sınıfının changeCase metodu
```java
/*----------------------------------------------------------------------------------------------------------------------
    StringUtil sınıfının changeCase metodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;
import org.csystem.util.StringUtil;

class App {
    public static void main(String [] args)
    {
        String s = Console.readString("Bir yazı giriniz:");

        System.out.println(StringUtil.changeCase(s));
    }
}
```
### StringUtil sınıfının getRandomText metodu
```java
/*----------------------------------------------------------------------------------------------------------------------
    StringUtil sınıfının getRandomText metodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;
import org.csystem.util.StringUtil;

import java.util.Random;

class App {
    public static void main(String [] args)
    {
        int n = Console.readInt("Bir sayı giriniz:");
        Random r = new Random();

        Console.writeLine(StringUtil.getRandomTextTR(r, n));
        Console.writeLine(StringUtil.getRandomTextEN(r, n));
    }
}

/*----------------------------------------------------------------------------------------------------------------------

----------------------------------------------------------------------------------------------------------------------*/
```
```java
