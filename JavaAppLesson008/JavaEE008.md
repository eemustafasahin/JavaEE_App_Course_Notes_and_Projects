### Aşağıdaki örnekte immutable olmayan IntValue sınıfı zincir çağırmaya uygun olarak yazılmıştır.
```java
/*----------------------------------------------------------------------------------------------------------------------
    Tekrar: Aşağıdaki örnekte immutable olmayan IntValue sınıfı zincir çağırmaya uygun olarak yazılmıştır.
    Örnekte this zorunludur. Çünkü bu metotlar içerisinde metodu çağıran referansa dönülmesi gerekmektedir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

class App {
    public static void main(String[] args)
    {
        var intValue = new IntValue(10);

        intValue.multiply(2).minus(3).multiply(5);

        Console.writeLine(intValue.getVal());
    }
}


class IntValue {
    private int m_val;

    public IntValue()
    {
    }

    public IntValue(int val)
    {
        m_val = val;
    }

    public int getVal()
    {
        return m_val;
    }

    public void setVal(int val)
    {
        m_val = val;
    }

    public IntValue plus(int val)
    {
        m_val += val;

        return this;
    }

    public IntValue plus(IntValue intValue)
    {
        plus(intValue.m_val);

        return this;
    }

    public IntValue minus(int val)
    {
        plus(-val);

        return this;
    }

    public IntValue minus(IntValue intValue)
    {
        minus(intValue.m_val);

        return this;
    }

    public IntValue multiply(int val)
    {
        m_val *= val;

        return this;
    }

    public IntValue multiply(IntValue intValue)
    {
        multiply(intValue.m_val);

        return this;
    }
}
```
###  Aşağıdaki örnekte alartDailog nesnesinin yaratılması onun içerisinde bulunan Builder isimli bir sınıf kullanılarak yapılmıştır.
```java
/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte alartDailog nesnesinin yaratılması onun içerisinde bulunan Builder isimli bir sınıf kullanılarak
    yapılmıştır. Böylece AlertDialog sınıfını kullanan programcı (client code) daha yalın bir şekilde istediği kadar
    özelliği set edebilmektedir. Builder sınıfı zincir biçiminde çağrılara uygun şekilde yazılmıştır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String[] args)
    {
        var builder = new AlertDialog.Builder();

        var dialog = builder
                //.setTitle("Uyarı")
                .setMessage("Çıkmak istediğinize emin misiniz?")
                .setButton(AlertDialogButton.YES_NO)
                .setIcon(AlertDialogIcon.QUESTION)
                .build();

        dialog.show();
    }
}

package org.csystem.app;

class App {
    public static void main(String[] args)
    {
        new AlertDialog.Builder()
                .setMessage("Çıkmak istediğinize emin misiniz?")
                .setButton(AlertDialogButton.YES_NO)
                .build()
                .show();
    }
}


enum AlertDialogButton {OK, YES_NO, YES_NO_CANCEL,}
enum AlertDialogIcon {INFORMATION, QUESTION, ALERT, WARNING,}


class AlertDialog {
    private String m_title;
    private String m_message;
    private AlertDialogButton m_alertDialogButton;
    private AlertDialogIcon m_alertDialogIcon;
    //...

    private AlertDialog()
    {
        m_title = "";
        m_message = "";
        m_alertDialogButton = AlertDialogButton.OK;
        m_alertDialogIcon = AlertDialogIcon.INFORMATION;
    }

    public static class Builder {
        private final AlertDialog m_alertDialog = new AlertDialog();

        public Builder setTitle(String title)
        {
            m_alertDialog.m_title = title;

            return this;
        }

        public Builder setMessage(String message)
        {
            m_alertDialog.m_message = message;

            return this;
        }

        public Builder setButton(AlertDialogButton alertDialogButton)
        {
            m_alertDialog.m_alertDialogButton = alertDialogButton;

            return this;
        }

        public Builder setIcon(AlertDialogIcon alertDialogIcon)
        {
            m_alertDialog.m_alertDialogIcon = alertDialogIcon;

            return this;
        }

        public AlertDialog build()
        {
            return m_alertDialog;
        }
    }

    public void show()
    {
        System.out.printf("Title:%s%n", m_title);
        System.out.printf("Message:%s%n", m_message);
        System.out.printf("Button:%s%n", m_alertDialogButton);
        System.out.printf("Icon:%s%n", m_alertDialogIcon);
    }
}
```
### enum içerisinde non-static sınıf bildirimi geçerlidir
```java
/*----------------------------------------------------------------------------------------------------------------------
    enum içerisinde non-static sınıf bildirimi geçerlidir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String[] args)
    {
        var a = Sample.X.new A();

        //..
    }
}

enum Sample {
    X, Y;
    public class A {
        //...
    }
}
```
### enum içerisinde static sınıf bildirimi geçerlidir
```java
/*----------------------------------------------------------------------------------------------------------------------
    enum içerisinde static sınıf bildirimi geçerlidir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String[] args)
    {
        var a = new Sample.A();

        //..
    }
}

enum Sample {
    X, Y;
    public static class A {
        //...
    }
}
```
### Sınıf içerisine non-static enum bildirimi yapılabilir
```java
/*----------------------------------------------------------------------------------------------------------------------
    Sınıf içerisine non-static enum bildirimi yapılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String[] args)
    {
        var s = new Sample();

        s.foo(2);

        //..
    }
}

class Sample {
    private enum Color {RED, GREEN, BLUE}

    public void foo(int val)
    {
        Color c = val < 0 || val > 2 ? Color.RED : Color.values()[val];

        System.out.println(c.toString());
    }

}
```
### Sınıf içerisinde enum bildirimlerinin static veya non-static olmasının bir farklı yoktur.
```java
/*----------------------------------------------------------------------------------------------------------------------
    Sınıf içerisinde enum bildirimlerinin static veya non-static olmasının bir farklı yoktur. Çünkü
    hatırlanacağı gibi enum türünden nesne new operatörü ile hiç bir şekilde ve hiç bir yerde yaratılamaz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String[] args)
    {
        var s = new Sample();

        s.foo(2);

        //..
    }
}

class Sample {
    private static enum Color {RED, GREEN, BLUE} //static yazılmasa da aynı şey

    public void foo(int val)
    {
        Color c = val < 0 || val > 2 ? Color.RED : Color.values()[val];

        System.out.println(c.toString());
    }
}
```
### Aşağıdaki örnekte Figther sınıfına int türden yeni bir yetenek eklendiğinde sumOfAbilities ve averageOfAbilities metotları da değiştirilmek zorundadır.
```java
/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte Figther sınıfına int türden yeni bir yetenek eklendiğinde sumOfAbilities ve averageOfAbilities
    metotları da değiştirilmek zorundadır. Şüphesiz ctor'da aşağıdaki örnekte değiştirilmelidir ancak gerekirse bir
    AlertDialog örneğindeki gibi static bir sınıf ile bu durum kodları değişse bile bu sınıfı kullanan programcıya
    farkettirilmez.

    Problem: Aşağıdaki sınıfa yeni bir yetenek eklendiğinde sumOfAbilities ve averageOfAbilities metotlarını
    değiştirmek zorunda kalmayacak şekilde sınıfı yeniden yazınız. Bu problemde ctor önemli değildir. İstenirse
    sadece default ctor da bırakılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String[] args)
    {
        //...

    }
}

class Fighter {
    private String m_name;
    private int m_health;
    private int m_agility;
    private int m_intelligence;

    public Fighter(String name, int health, int agility, int intelligence)
    {
        m_name = name;
        m_health = health;
        m_agility = agility;
        m_intelligence = intelligence;
    }

    public String getName()
    {
        return m_name;
    }

    public void setName(String name)
    {
        m_name = name;
    }

    public int getHealth()
    {
        return m_health;
    }

    public void setHealth(int health)
    {
        m_health = health;
    }

    public int getAgility()
    {
        return m_agility;
    }

    public void setAgility(int agility)
    {
        m_agility = agility;
    }

    public int getIntelligence()
    {
        return m_intelligence;
    }

    public void setIntelligence(int intelligence)
    {
        m_intelligence = intelligence;
    }

    public int sumOfAbilities()
    {
        return m_agility + m_health + m_intelligence;
    }

    public double averageOfAbilities()
    {
        return sumOfAbilities() / 3.;
    }
}
```
### Problem: Aşağıdaki sınıfa yeni bir yetenek eklendiğinde sumOfAbilities ve averageOfAbilities metotlarını değiştirmek zorunda kalmayacak şekilde sınıfı yeniden yazınız.
```java
/*----------------------------------------------------------------------------------------------------------------------
    Problem: Aşağıdaki sınıfa yeni bir yetenek eklendiğinde sumOfAbilities ve averageOfAbilities metotlarını
    değiştirmek zorunda kalmayacak şekilde sınıfı yeniden yazınız. Bu problemde ctor önemli değildir. İstenirse
    sadece default ctor da bırakılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String[] args)
    {
        Fighter fighter = new Fighter("Ali", 78, 90, 100, 67);

        System.out.printf("Sum of Abilities:%d%n", fighter.sumOfAbilities());
        System.out.printf("Average of Abilities:%f%n", fighter.averageOfAbilities());
    }
}

class Fighter {
    private String m_name;
    private final int [] m_abilities;
    private enum ABILITY {HEALTH, STRENGTH, AGILITY, INTELLIGENCE}

    public Fighter(String name, int health, int agility, int intelligence, int strength)
    {
        m_name = name;
        m_abilities = new int[ABILITY.values().length];
        setHealth(health);
        setAgility(agility);
        setIntelligence(intelligence);
        setStrength(strength);
    }

    public String getName()
    {
        return m_name;
    }

    public void setName(String name)
    {
        m_name = name;
    }

    public int getHealth()
    {
        return m_abilities[ABILITY.HEALTH.ordinal()];
    }

    public void setHealth(int health)
    {
        m_abilities[ABILITY.HEALTH.ordinal()] = health;
    }

    public int getAgility()
    {
        return m_abilities[ABILITY.AGILITY.ordinal()];
    }

    public void setAgility(int agility)
    {
        m_abilities[ABILITY.AGILITY.ordinal()] = agility;
    }

    public int getIntelligence()
    {
        return m_abilities[ABILITY.INTELLIGENCE.ordinal()];
    }

    public void setIntelligence(int intelligence)
    {
        m_abilities[ABILITY.INTELLIGENCE.ordinal()] = intelligence;
    }

    public int getStrength()
    {
        return m_abilities[ABILITY.STRENGTH.ordinal()];
    }

    public void setStrength(int strength)
    {
        m_abilities[ABILITY.STRENGTH.ordinal()] = strength;
    }

    public int sumOfAbilities()
    {
        int sum = 0;

        for (var val : m_abilities)
            sum += val;

        return sum;
    }

    public double averageOfAbilities()
    {
        return (double)sumOfAbilities() / m_abilities.length;
    }
}
```
### Problem: Aşağıdaki sınıfa yeni bir yetenek eklendiğinde sumOfAbilities ve averageOfAbilities metotlarını değiştirmek zorunda kalmayacak şekilde sınıfı yeniden yazınız.
```java
/*----------------------------------------------------------------------------------------------------------------------
    Problem: Aşağıdaki sınıfa yeni bir yetenek eklendiğinde sumOfAbilities ve averageOfAbilities metotlarını
    değiştirmek zorunda kalmayacak şekilde sınıfı yeniden yazınız. Bu problemde ctor önemli değildir. İstenirse
    sadece default ctor da bırakılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String[] args)
    {
        Fighter fighter = new Fighter("Ali", 78, 90, 100, 67);

        System.out.printf("Sum of Abilities:%d%n", fighter.sumOfAbilities());
        System.out.printf("Average of Abilities:%f%n", fighter.averageOfAbilities());
    }
}

class Fighter {
    private String m_name;
    private final int [] m_abilities;
    private enum ABILITY {HEALTH, STRENGTH, AGILITY, INTELLIGENCE, COUNT}

    public Fighter(String name, int health, int agility, int intelligence, int strength)
    {
        m_name = name;
        m_abilities = new int[ABILITY.COUNT.ordinal()];
        setHealth(health);
        setAgility(agility);
        setIntelligence(intelligence);
        setStrength(strength);
    }

    public String getName()
    {
        return m_name;
    }

    public void setName(String name)
    {
        m_name = name;
    }

    public int getHealth()
    {
        return m_abilities[ABILITY.HEALTH.ordinal()];
    }

    public void setHealth(int health)
    {
        m_abilities[ABILITY.HEALTH.ordinal()] = health;
    }

    public int getAgility()
    {
        return m_abilities[ABILITY.AGILITY.ordinal()];
    }

    public void setAgility(int agility)
    {
        m_abilities[ABILITY.AGILITY.ordinal()] = agility;
    }

    public int getIntelligence()
    {
        return m_abilities[ABILITY.INTELLIGENCE.ordinal()];
    }

    public void setIntelligence(int intelligence)
    {
        m_abilities[ABILITY.INTELLIGENCE.ordinal()] = intelligence;
    }

    public int getStrength()
    {
        return m_abilities[ABILITY.STRENGTH.ordinal()];
    }

    public void setStrength(int strength)
    {
        m_abilities[ABILITY.STRENGTH.ordinal()] = strength;
    }

    public int sumOfAbilities()
    {
        int sum = 0;

        for (var val : m_abilities)
            sum += val;

        return sum;
    }

    public double averageOfAbilities()
    {
        return (double)sumOfAbilities() / m_abilities.length;
    }
}
```
### Problem: Aşağıdaki sınıfa yeni bir yetenek eklendiğinde sumOfAbilities ve averageOfAbilities metotlarını değiştirmek zorunda kalmayacak şekilde sınıfı yeniden yazınız.
```java
/*----------------------------------------------------------------------------------------------------------------------
    Problem: Aşağıdaki sınıfa yeni bir yetenek eklendiğinde sumOfAbilities ve averageOfAbilities metotlarını
    değiştirmek zorunda kalmayacak şekilde sınıfı yeniden yazınız.
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String[] args)
    {
        Fighter fighter = new Fighter("Ali");

        fighter.setStrength(67).setIntelligence(100).setAgility(90).setHealth(100).setVersatility(56);

        System.out.printf("Sum of Abilities:%d%n", fighter.sumOfAbilities());
        System.out.printf("Average of Abilities:%f%n", fighter.averageOfAbilities());
    }
}

class Fighter {
    private String m_name;
    private final int [] m_abilities;
    private enum ABILITY {HEALTH, STRENGTH, AGILITY, INTELLIGENCE, VERSATILITY, COUNT}

    public Fighter(String name)
    {
        m_name = name;
        m_abilities = new int[ABILITY.COUNT.ordinal()];
    }

    public String getName()
    {
        return m_name;
    }

    public Fighter setName(String name)
    {
        m_name = name;

        return this;
    }

    public int getHealth()
    {
        return m_abilities[ABILITY.HEALTH.ordinal()];
    }

    public Fighter setHealth(int health)
    {
        m_abilities[ABILITY.HEALTH.ordinal()] = health;

        return this;
    }

    public int getAgility()
    {
        return m_abilities[ABILITY.AGILITY.ordinal()];
    }

    public Fighter setAgility(int agility)
    {
        m_abilities[ABILITY.AGILITY.ordinal()] = agility;

        return this;
    }

    public int getIntelligence()
    {
        return m_abilities[ABILITY.INTELLIGENCE.ordinal()];
    }

    public Fighter setIntelligence(int intelligence)
    {
        m_abilities[ABILITY.INTELLIGENCE.ordinal()] = intelligence;

        return this;
    }

    public int getStrength()
    {
        return m_abilities[ABILITY.STRENGTH.ordinal()];
    }

    public Fighter setStrength(int strength)
    {
        m_abilities[ABILITY.STRENGTH.ordinal()] = strength;

        return this;
    }

    public int getVesatility()
    {
        return m_abilities[ABILITY.VERSATILITY.ordinal()];
    }

    public Fighter setVersatility(int versatility)
    {
        m_abilities[ABILITY.VERSATILITY.ordinal()] = versatility;

        return this;
    }

    public int sumOfAbilities()
    {
        int sum = 0;

        for (var val : m_abilities)
            sum += val;

        return sum;
    }

    public double averageOfAbilities()
    {
        return (double)sumOfAbilities() / m_abilities.length;
    }
}
```
### Yerel sınıflar (local classes)
```java
/*----------------------------------------------------------------------------------------------------------------------
    Bir metot içerisinde bildirilen sınıflara yerel sınıflar (local classes) denir. Farklı metotlar içerisinde
    aynı isimde yerel sınıf bildirimi geçerlidir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String[] args)
    {

    }
}

class Sample {
    public void foo()
    {
        class A {
            //...
        }

        class B {
            //...
        }

        class C {
            //...
        }
    }

    public void bar()
    {
        class A {
            //...
        }

        class B {
            //...
        }

        class C {
            //...
        }
    }

    public void tar()
    {
        class A {
            //...
        }

        class B {
            //...
        }

        class C {
            //...
        }
    }
}
```
### Yerel sınıf isimleri faaliyet alanı bakımından yerel değişkenler ile aynıdır
```java
/*----------------------------------------------------------------------------------------------------------------------
    Yerel sınıf isimleri faaliyet alanı bakımından yerel değişkenler ile aynıdır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String[] args)
    {

    }
}

class Sample {
    public void foo()
    {
        class A {
            //...
        }

        A a = new A();

        class B {
            public void foo()
            {

            }
        }
        B b = new B();

        b.foo();
    }
}
```
### Aynı faaliyet alanı içerisinde aynı isimde yerel sınıf bildirimi geçersizdir
```java
/*----------------------------------------------------------------------------------------------------------------------
    Aynı faaliyet alanı içerisinde aynı isimde yerel sınıf bildirimi geçersizdir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String[] args)
    {

    }
}

class Sample {
    public void foo()
    {
        class A {
            //...
        }

        A a = new A();

        class B {
            public void foo()
            {

            }
        }
        B b = new B();

        b.foo();

        class A { //error

        }
    }
}
```
### Yerel sınıflar herhangi bir blok içerisinde bildirilebilir
```java
/*----------------------------------------------------------------------------------------------------------------------
    Yerel sınıflar herhangi bir blok içerisinde bildirilebilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String[] args)
    {
        Sample s = new Sample();

        s.foo(5);

    }
}

class Sample {
    public void foo(int n)
    {
        for (int i = 0; i < n; ++i) {
            class A {
                public void foo()
                {
                    System.out.println("A.foo");
                }
            }

            A x = new A();

            x.foo();
        }
    }
}
```
### Yerel sınıfların erişim belirleyicisi olamaz
```java
/*----------------------------------------------------------------------------------------------------------------------
    Yerel sınıfların erişim belirleyicisi olamaz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String[] args)
    {
        Sample s = new Sample();

        s.foo(5);

    }
}

class Sample {
    public void foo(int n)
    {
        for (int i = 0; i < n; ++i) {
            public class A { //error
                public void foo()
                {
                    System.out.println("A.foo");
                }
            }

            A x = new A();

            x.foo();
        }
    }
}
```
### Yerel sınıflar static olarak bildirilemez
```java
/*----------------------------------------------------------------------------------------------------------------------
    Yerel sınıflar static olarak bildirilemez
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String[] args)
    {
        Sample s = new Sample();

        s.foo(5);
    }
}

class Sample {
    public void foo(int n)
    {
        for (int i = 0; i < n; ++i) {
            static class A { //error
                public void foo()
                {
                    System.out.println("A.foo");
                }
            }

            A x = new A();

            x.foo();
        }
    }
}
```
### non-static, static ve yerel sınıflar başka bir sınıftan türetilebilir
```java
/*----------------------------------------------------------------------------------------------------------------------
    non-static, static ve yerel sınıflar başka bir sınıftan türetilebilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String[] args)
    {

    }
}


class A {

}

class Sample {
    public class C extends A {
        //...
    }

    private static class D extends A {
        //...
    }

    public void foo(int n)
    {
        class B extends A {

        }
    }
}
```
### erel bir sınıf başka bir yerel sınıftan türetilebilir. Şüphesiz taban sınıfın türemiş sınıfın bildirildiği yerde görülebilir olması gerekir
```java
/*----------------------------------------------------------------------------------------------------------------------
    Yerel bir sınıf başka bir yerel sınıftan türetilebilir. Şüphesiz taban sınıfın türemiş sınıfın bildirildiği
    yerde görülebilir olması gerekir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String[] args)
    {

    }
}

class Sample {
    public void foo(int n)
    {
        class A {

        }

        //...

        class B extends A {

        }
    }
}
```
### Yerel bir sınıf içerisinde kendisinden önce bildirilen yerel değişkenler ve parametre değişkenleri kullanılabilir (capture)
```java
/*----------------------------------------------------------------------------------------------------------------------
    Yerel bir sınıf içerisinde kendisinden önce bildirilen yerel değişkenler ve parametre değişkenleri kullanılabilir
    (capture)
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

class App {
    public static void main(String[] args)
    {
        Sample s = new Sample();

        s.foo(20);
    }
}

class Sample {
    public void foo(int val)
    {
        int a = Console.readInt("Bir sayı giriniz:");

        class A {
            public void bar(int b)
            {
                Console.writeLine(a + b + val);
            }
        }

        A x = new A();

        x.bar(10);
    }
}
```
### Yerel bir sınıf içerisinde kendisinden önce bildirilen yerel değişkenler ve parametre değişkenleri kullanılabilir (capture)
```java
/*----------------------------------------------------------------------------------------------------------------------
    Yerel bir sınıf içerisinde kendisinden önce bildirilen yerel değişkenler ve parametre değişkenleri kullanılabilir
    (capture)
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

class App {
    public static void main(String[] args)
    {
        Sample s = new Sample();

        s.foo(20);
    }
}

class Sample {
    public void foo(int val)
    {
        class Util {
            private final int m_value;

            public Util(int value)
            {
                m_value = value;
            }

            public boolean isEven()
            {
                return val % 2 == 0;
            }

            public int getTotal()
            {
                return m_value + val;
            }
        }

        Util util = new Util(10);

        Console.writeLine(util.isEven() ? "Çift" : "Tek");
        Console.writeLine("Toplam:%d", util.getTotal());

    }
}
```
### yerel ya da parametre değişkeni ya yakalandığında değiştirilemez, ya da değiştirilse yakalanamaz
```java
/*----------------------------------------------------------------------------------------------------------------------
    Yerel sınıflar içerisinde yakalanan yerel veya parametre değişkenleri faaliyet alanı içerisinde tek bir değer
    alabilirler. Yani yakalanmış değişkenlerin değerleri faaliyet alanları içerisinde hiçbiryerde değiştirilemez.
    Java 8 ile birlikte yakalanmış olan yerel veya parametre değişkenlerine "effectively final" değişkenler denir.
    Yani bu değişkenler yakalandıklarında final bildirilmiş kabul edilirler. Java8 öncesinde yakalanan yerel veya
    parametre değişkenlerinin final olarak bildirilmesi zorunluydu

    Yani özetle, yerel ya da parametre değişkeni ya yakalandığında değiştirilemez, ya da değiştirilse yakalanamaz

    Anahtar Notlar: Yerel değişkenlerin yakalanabilmesi yalnızca yerel sınıflara özgü değildir. Anonim sınıflarda
    ve Lambda ifadelerinde de yakalanabilir. Yukarıdaki anlatılan durumlar tamamen aynıdır. Anonim sınıflar ve Lambda
    ifadeleri ileride ele alınacaktır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

class App {
    public static void main(String[] args)
    {
        Sample s = new Sample();

        s.foo(20);
    }
}

class Sample {
    public void foo(int val)
    {
        int a = Console.readInt("Birinci sayı giriniz:");
        int b = Console.readInt("İkinci sayı giriniz:");

        b++;

        class Util {
            public boolean isEven() {return (val + a++) % 2 == 0;} //error
            public boolean isOdd() {return (val + b) % 2 == 0;} //error
            //...
        }

        b = 10;

        var util = new Util();

        Console.writeLine(util.isEven() ? "Çift" : "Tek");
    }
}
```
### Yerel sınıflar içerisinde (anonim sınıflar ve lambda ifadelerinde de) sınıf veri elemanları yakalanablir ve değiştirilebilir!
```java
/*----------------------------------------------------------------------------------------------------------------------
    Yerel sınıflar içerisinde (anonim sınıflar ve lambda ifadelerinde de) sınıf veri elemanları yakalanablir ve
    değiştirilebilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

class App {
    public static void main(String[] args)
    {
        Sample.foo();

        Console.writeLine("value:%d", Sample.getVal());
    }
}

class Sample {
    private static int ms_val;

    public static int getVal()
    {
        return ms_val;
    }

    public static void foo()
    {
        ms_val = Console.readInt("Bir sayı giriniz:");
        class Util {
            public boolean isEven() {return ms_val++ % 2 == 0;}
            //...
        }

        var util = new Util();

        Console.writeLine(util.isEven() ? "Çift" : "Tek");
    }
}
```
### Yerel sınıflar içerisinde (anonim sınıflar ve lambda ifadelerinde de) sınıf veri elemanları yakalanablir ve değiştirilebilir
```java
/*----------------------------------------------------------------------------------------------------------------------
    Yerel sınıflar içerisinde (anonim sınıflar ve lambda ifadelerinde de) sınıf veri elemanları yakalanablir ve
    değiştirilebilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

class App {
    public static void main(String[] args)
    {
        Sample s = new Sample();

        s.foo();

        Console.writeLine("value:%d", s.getVal());
    }
}

class Sample {
    private int m_val;

    public int getVal()
    {
        return m_val;
    }

    public void foo()
    {
        m_val = Console.readInt("Bir sayı giriniz:");
        class Util {
            public boolean isEven() {return m_val++ % 2 == 0;}
            //...
        }

        var util = new Util();

        Console.writeLine(util.isEven() ? "Çift" : "Tek");
    }
}
```
### Yerel sınıflar aşağıdaki gibi basit testlerde kullanılabilir. 
```java
/*----------------------------------------------------------------------------------------------------------------------
    Yerel sınıflar aşağıdaki gibi basit testlerde kullanılabilir. Şüphesiz aşağıdaki testi daha iyi yapabilecek araçlar
    vardır. Bunlar ileride ele alınacaktır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

class App {
    public static void main(String[] args)
    {
        Sample sample = new Sample(10);

        sample.displayResult(10);
    }
}

class SampleTest {
    public static void test(int val)
    {
        class TestUtil {
            public boolean isNegative()
            {
                return val < 0;
            }
        }

        var testUtil = new TestUtil();

        if (testUtil.isNegative()) {
            Console.Error.writeLine("Invalid value");
            System.exit(-1);
        }

        Console.writeLine("OK...");
    }
}

class Sample {
    private static final boolean TEST = false;
    private static int m_val;

    public Sample(int val)
    {
        m_val = val;
    }

    private void displayPow(int n)
    {
        if (TEST)
            SampleTest.test(n);

        Console.writeLine(Math.pow(m_val, n));
    }

    public void displayResult(int n)
    {
        if (n >= 0)
            displayPow(n);
        else
            System.out.println("Geçersiz değer");
    }
}
```
### Yerel sınıflar aşağıdaki gibi basit testlerde kullanılabilir.
```java
/*----------------------------------------------------------------------------------------------------------------------
    Yerel sınıflar aşağıdaki gibi basit testlerde kullanılabilir. Şüphesiz aşağıdaki testi daha iyi yapabilecek araçlar
    vardır. Bunlar ileride ele alınacaktır.
    Aşağıdaki kodu açıklanan biçimlerde derleyip üretilen veya üretilmeyen byte code'ları gözlemleyiniz:
    1. TEST == true ve final ise
    2. TEST == false ve final ise
    3. TEST == true ve final değilse
    4. TEST == false ve final değilse

    Burada TEST == false ve final ise TestUtil sınıfı için arakod üretilmeyecektir. Çünkü TEST her zaman
    false olacak ve final olduğu için de TEST hiç bir zaman değiştirilemeyecektir. Bu durumda
    if (TEST) {
    //...
    }
    kodunun arakoda dahil edilmesi gereksiz olacaktır. Derleyici de bu gereksiz kodu dahil etmeyecektir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

class App {
    public static void main(String[] args)
    {
        Sample sample = new Sample(10);

        sample.displayResult(10);
    }
}

class Sample {
    private static final boolean TEST = false;
    private static int m_val;

    public Sample(int val)
    {
        m_val = val;
    }

    private void displayPow(int n)
    {
        if (TEST) {
            class TestUtil {
                public boolean isNegative()
                {
                    return n < 0;
                }
            }

            var testUtil = new TestUtil();

            if (testUtil.isNegative()) {
                Console.Error.writeLine("Invalid value");
                System.exit(-1);
            }

            Console.writeLine("OK...");
        }

        Console.writeLine(Math.pow(m_val, n));
    }

    public void displayResult(int n)
    {
        if (n >= 0)
            displayPow(n);
        else
            System.out.println("Geçersiz değer");
    }
}
```
