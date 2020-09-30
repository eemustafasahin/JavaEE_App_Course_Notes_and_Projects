```java
/*----------------------------------------------------------------------------------------------------------------------
    Anonim sınıflar: Bu sınıflar bildirimleri sırasında programcının isimlendirmediği sınıflardır.
    Anonim sınıf bildiriminin genel biçimi:

    new <tür>([argümanlar]) {
        //...
    }

    Anonim sınıf bildirimi hem bir türemiş sınıf bildirimi hem de türemiş sınıf türünden nesne yaratma işlemidir.
    Yani sınıf bildirimi new operatörüne yazılan türden türetilmiş (eğer inteface ise implemente edilmiş) olan bir
    sınıfın hem bildirimi hem de o sınıf türünden nesne yaratılması anlamına gelir. Şüphesiz derleyici anonim sınıfa
    da bir isim verecektir. Bu işlem bir türetme ilemi olduğundan anonim sınıfa ilişkin yaratılan nesnenin referansı
    taban sınıf türünden (veya interface) bir referansa atanmalıdır
----------------------------------------------------------------------------------------------------------------------*/
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte iki farklı anonim sınıf bildirimi yapılmıştır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String[] args)
    {
        Sample s = new Sample() {/*...*/};
        Sample k = new Sample() {/*...*/};

        System.out.println(s.getClass().getName());
        System.out.println(k.getClass().getName());
    }
}

class Sample {
    //...
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte iki farklı anonim sınıf bildirimi yapılmıştır. Ekran çıktılarını inceleyiniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String[] args)
    {
        Sample s = new Sample() {/*...*/};
        Sample k = new Sample() {/*...*/};

        System.out.println(s.getClass().getName());
        System.out.println(k.getClass().getName());
        System.out.println(s instanceof Sample);
        System.out.println(k instanceof Sample);
    }
}

class Sample {
    //...
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    final olarak bildirilmiş sınıflar türetme işlemine kapaıl olduğundan anonim sınıf bildirimi de
    yapılamaz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String[] args)
    {
        Sample s = new Sample() {/*...*/}; //error
    }
}


final class Sample {
    //...
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Anonim sınıf bildiriminde taban sınıfın non-static olan ve final olarak bildirilmemiş bir metodu
    aynı geri dönüş değeri ve aynı imza ile (public erişimciye sahipse public olarak) yazılabilir (override)
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String[] args)
    {
        Sample s = new Sample() {
            public void foo() //override
            {
                System.out.println("Anonim foo");
            }
        };

        s.foo();
    }
}


class Sample {
    public void foo()
    {
        System.out.println("Sample.foo");
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte Sample türünden bir referans dolaylı da olsa Mample sınıfına bağlandığından referans sayacı
    bir artırılmış olur. Örnekteki ikinci Sample nesnesi yaratıldığında ilki kopartılıp ikincisi bağlanmış olur.
    Bu durumda ilk Sample nesnesi "garbage collected" duruma gelir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String[] args)
    {
        Mample mample = new Mample();

        new Sample().foo(mample);
        new Sample().foo(mample);
    }
}

class Mample {
    private Sample m_sample;

    public void setSample(Sample s)
    {
        m_sample = s;
    }
}

class Sample {
    public void foo(Mample mample)
    {
        mample.setSample(this);
        System.out.println("Sample.foo");
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte Sample türünden bir referans dolaylı da olsa Mample sınıfına bağlandığından referans sayacı
    bir artırılmış olur. Örnekteki ikinci Sample nesnesi yaratıldığında ilki kopartılıp ikincisi bağlanmış olur.
    Bu durumda ilk Sample nesnesi "garbage collected" duruma gelir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String[] args)
    {
        Mample mample = new Mample();

        new Sample().foo(mample);

        //...

        new Sample().foo(mample);
    }
}

class Mample {
    private Sample m_sample;

    public void setSample(Sample s)
    {
        //...
        m_sample = s;
    }
    //...
}

class Sample {
    public void foo(Mample mample)
    {
        mample.setSample(this);
        System.out.println("Sample.foo");
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte anonim sınıf nesneleri Mample sınıfına bağlanmıştır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String[] args)
    {
        Mample mample = new Mample();

        new Sample() {}.foo(mample);

        //...

        new Sample() {}.foo(mample);
    }
}

class Mample {
    private Sample m_sample;

    public void setSample(Sample s)
    {
        //...
        m_sample = s;
    }
    //...
}

class Sample {
    public void foo(Mample mample)
    {
        mample.setSample(this);
        System.out.println("Sample.foo");
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte Sample sınıfı static sınıf haline getirilip yalnızca içeride kullanılacak durumdadır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String[] args)
    {

    }
}

class Mample {
    private Sample m_sample;

    static class Sample {
        private final int m_x;

        public Sample(int x)
        {
            m_x = x;
        }

        public int getX() {return m_x;}

        //...

        public void set(Mample mample)
        {
            mample.setSample(this);
        }
    }

    public static class Factory {
        //...
        public Mample createMample(int x)
        {
            Mample mample = new Mample();

            new Sample(x).set(mample);

            return mample;
        }
    }

    private void setSample(Sample s)
    {
        //...
        m_sample = s;
    }

    public void display()
    {
        System.out.printf("Value:%d%n", m_sample.getX());
    }
    //...
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Yukarıdaki örneğin Sample ve Mample sınıflarının ayrılmış biçimi
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import test.Mample;

class App {
    public static void main(String[] args)
    {
        Mample.Factory factory = new Mample.Factory();
        Mample mample = factory.createMample(10);

        mample.display();
    }
}

package test;

class Sample {
    private final int m_x;

    public Sample(int x)
    {
        m_x = x;
    }

    public int getX() {return m_x;}

    //...

    public void set(Mample mample)
    {
        mample.setSample(this);
    }
}

package test;

public class Mample {
    private Sample m_sample;

    public static class Factory {
        //...
        public Mample createMample(int x)
        {
            Mample mample = new Mample();

            new Sample(x).set(mample);

            return mample;
        }
    }

    void setSample(Sample s)
    {
        //...
        m_sample = s;
    }

    public void display()
    {
        System.out.printf("Value:%d%n", m_sample.getX());
    }
}
```
```java

/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki masum örnekte bellek sızıntısına dikkat ediniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String[] args)
    {
        new Sample().foo();
        new Sample().foo();
        //...
    }
}

class Sample {
    private Sample m_sample;

    public void foo()
    {
        m_sample = this;
    }
    //...
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Anonim sınıflar içerisinde kendisinden önce bildirilen yerel ve parametre değişkenleri kullanılabilir (capture)
    Yine burada yakalanan yerel değişkenler ve parametre değişkenleri final kabul edilir (effectively final)
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String[] args)
    {
        Mample mample = new Mample();

        mample.bar(30, 10);
    }
}

class Mample {
    public void bar(int a, int b)
    {
        Sample s = new Sample() {
            public void foo(int x)
            {
                System.out.println(x * a);
            }
        };

        s.foo(b);
    }
}

class Sample {
    public void foo(int x)
    {
        //...
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Anonim sınıflar içerisinde içerisinde bildirildikleri metodun ait olduğu sınıfın veri elemanlarına doğrudan
    erişilebilir. Bu elemanlar erişim durumunda final bildirilmediklerinde final kabul edilmez
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String[] args)
    {
        Mample mample = new Mample(10);

        mample.bar(30);
    }
}

class Mample {
    private int m_b;

    public Mample(int b)
    {
        m_b = b;
    }

    public void bar(int a)
    {
        Sample s = new Sample() {
            public void foo(int x)
            {
                System.out.println(x * m_b++);
            }
        };

        s.foo(a);
    }
}

class Sample {
    public void foo(int x)
    {
        //...
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Timer sınıfı timer periyodik işlerin yapılmasında kullanılan temel sınıflardan biridir. Bu sınıfın scheduleXXX
    metotları ile ayrı bir akış oluşturulur (thread) ve verilen periyoda göre TimerTask referansı ile verilen referansa
    ilişkin run metodu çağrılır. Yani aslında Timer sınıfı TimerTask ile verilen periyotta yapılacak işi
    programcıdan almaktadır. Bu kavrama genel olarak "callback" denir. Timer sınıfına ilişkin diğer detaylar
    ileride ele alınacaktır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.util.Timer;
import java.util.TimerTask;

class App {
    public static void main(String[] args)
    {
        var t = new Timer();

        t.schedule(new TimerTask() {
            public void run()
            {
                Console.write(".");
            }
        }, 0, 1000);
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    scheduleXXX metotlarının delay parametresi ile timer istenilen zamanda başlatılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.util.Timer;
import java.util.TimerTask;

class App {
    public static void main(String[] args)
    {
        var t = new Timer();

        t.schedule(new TimerTask() {
            public void run()
            {
                Console.write(".");
            }
        }, 2000, 1000);

        System.out.println("Tekrar yapıyor musunuz?");
    }
}

```
```java
/*----------------------------------------------------------------------------------------------------------------------
    scheduleXXX metotlarının Date paramtreli versiyonları
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;
import org.csystem.util.datetime.DateTimeUtil;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

class App {
    public static void main(String[] args)
    {
        var t = new Timer();
        var delayMillis = DateTimeUtil.toMilliseconds(LocalDate.now().atTime(LocalTime.of(10, 36, 45)));

        t.schedule(new TimerTask() {
            public void run()
            {
                Console.write(".");
            }
        }, new Date(delayMillis),  1000);

        System.out.println("Tekrar yapıyor musunuz?");
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Timer sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.util.Timer;
import java.util.TimerTask;

class App {
    public static void main(String[] args)
    {
        var t = new Timer();
        var text = Console.read("Bir yazı giriniz:");

        t.schedule(new TimerTask() {
            public void run()
            {
                Console.write(text);
            }
        }, 0,  1000);

        System.out.println("Tekrar yapıyor musunuz?");
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Timer sınıfı ile basit bir dijital saat uygulaması: Kodu işletim sisteminin komut yorumlayıcısı ile
    çalıştırınız
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

class App {
    public static void main(String[] args)
    {
        SampleDigitalClock.run();
    }
}

class SampleDigitalClock {
    public static void run()
    {
        var timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            public void run()
            {
                var now = LocalDateTime.now();

                Console.write("%02d/%02d/%04d %02d:%02d:%02d\r", now.getDayOfMonth(), now.getMonthValue(), now.getYear(),
                        now.getHour(), now.getMinute(), now.getSecond());
            }
        }, 0, 1000);
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Anonim sınıf içerisinde veri elemanı bildirimi veya metot bildirimi yapılabilir. Şüphesiz bu bildirilen metotlara
    anonim sınıf nesnesinin adresini tutan referans ile erişilemez
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

class App {
    public static void main(String[] args)
    {
        Sample s = new Sample() {
            private int m_val;
            private void incValue(int val)
            {
                m_val += val;
            }

            public void foo(int val)
            {
                incValue(val);
                Console.writeLine("m_val=%d", m_val);
            }
        };

        for (int i = 0; i < 10; ++i)
            s.foo(i);
    }
}

class Sample {
    public void foo(int a)
    {}
}
```
```java

/*----------------------------------------------------------------------------------------------------------------------
    Timer sınıfının cancel metodu timer durdurulabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.util.Timer;
import java.util.TimerTask;

class App {
    public static void main(String[] args)
    {
        var count = Console.readInt("Kaç tane nokta basmak istiyorsunuz:");

        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            private int m_count;

            public void run()
            {
                if (m_count == count) {
                    timer.cancel();
                    return;
                }
                ++m_count;
                Console.write(".");
            }
        }, 0, 1000);
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Timer sınıfının cancel metodu timer durdurulabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.util.Timer;
import java.util.TimerTask;

class App {
    public static void main(String[] args)
    {
        var count = Console.readInt("Kaç tane nokta basmak istiyorsunuz:");

        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            private int m_count;

            public void run()
            {
                ++m_count;
                Console.write(".");
                if (m_count == count)
                    timer.cancel();
            }
        }, 0, 1000);
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Klavyeden girilen saat ve dakika bilgisine göre o zaman geldiğinde ekrana "Artık uyan"
    şeklinde bir mesaj veren ve alarmı kapatan, zaman gelene kadar ise ekranda sürekli nokta basan programı yazınız.
    (İleride Alarm ve AlarmTask sınıfları daha iyi hale getirilecektir)
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.samples.alarmapp.AlarmWithoutSecondApp;

class App {
    public static void main(String[] args)
    {
        AlarmWithoutSecondApp.run();
    }
}

package org.csystem.samples.alarmapp;

import org.csystem.util.Console;
import org.csystem.util.alam.Alarm;
import org.csystem.util.alam.AlarmTask;

public class AlarmWithoutSecondApp {
    private AlarmWithoutSecondApp() {}

    public static void run()
    {
        var hour = Console.readInt("Saati giriniz:");
        var minute = Console.readInt("Dakikayı giriniz:");

        Alarm alarm = new Alarm(hour, minute);

        var periodTask = new AlarmTask() {
            public void run()
            {
                Console.write(".");
            }
        };

        var alarmTask = new AlarmTask() {
            public void run()
            {
                Console.writeLine("\nArtık uyan");
            }
        };

        alarm.run(periodTask, alarmTask);
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Alarm sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util.alam;

import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;

public class Alarm {
    private final Timer m_timer;
    private final LocalTime m_time;

    public Alarm(int hour, int minute)
    {
        this(hour, minute, 0);
    }

    public Alarm(int hour, int minute, int second)
    {
        //...
        m_time = LocalTime.of(hour, minute, second);
        m_timer = new Timer();
    }
    public void run(AlarmTask alarmTask)
    {
        run(null, alarmTask);
    }

    public void run(AlarmTask periodTask, AlarmTask alarmTask)
    {
        m_timer.scheduleAtFixedRate(new TimerTask() {
            public void run()
            {
                if (periodTask != null)
                    periodTask.run();

                LocalTime now = LocalTime.now();

                if (m_time.compareTo(now) <= 0) {
                    alarmTask.run();
                    m_timer.cancel();
                }
            }
        }, 0, 1000);
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    AlarmTask sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util.alam;

public class AlarmTask {
    public void run()
    {
        //...
    }
    //...
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    TimeUnit enum sınıfı ile zamana ilişkin birim dönüşümleri yapılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

class App {
    public static void main(String[] args)
    {
        var delayInSeconds = Console.readInt("Timer kaç saniye sonra başlasın?");
        var periodIOnSeconds = Console.readInt("Timer'ın periyodu kaç olsun?");

        var delayInMilliseconds = TimeUnit.MILLISECONDS.convert(delayInSeconds, TimeUnit.SECONDS);
        var periodInMilliseconds = TimeUnit.MILLISECONDS.convert(periodIOnSeconds, TimeUnit.SECONDS);

        var timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            public void run()
            {
                Console.write(".");
            }
        }, delayInMilliseconds, periodInMilliseconds);
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    ScheduleUtil sınıfı ve test kodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;
import org.csystem.util.ScheduleUtil;

import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

class App {
    public static void main(String[] args)
    {
        var delayInSeconds = Console.readInt("Timer kaç saniye sonra başlasın?");
        var periodIOnSeconds = Console.readInt("Timer'ın periyodu kaç olsun?");

        ScheduleUtil.schedule(new TimerTask() {
            public void run()
            {
                Console.write(".");
            }
        }, delayInSeconds, periodIOnSeconds, TimeUnit.SECONDS);
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    ScheduleUtil sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class ScheduleUtil {
    private ScheduleUtil()
    {}

    public static void schedule(TimerTask timerTask, int delay, long period, TimeUnit timeUnit)
    {
        long delayInMs = TimeUnit.MILLISECONDS.convert(delay, timeUnit);
        long periodInMs = TimeUnit.MILLISECONDS.convert(period, timeUnit);

        var timer = new Timer();

        timer.scheduleAtFixedRate(timerTask, delayInMs, periodInMs);
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Anonim sınıf nesneleri yaratılırken kullanılan ctor ile super ctor sentaksı kullanılmış olur. Yani aşağıdaki
    örnekte A sınıfı ile anonim bildirimi neredeyse aynıdır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String[] args)
    {
        Sample sample = new Sample(10) {/*...*/};
        Sample sampleA = new A();
    }
}

class A extends Sample {
    public A()
    {
        super(10);
        //...
    }
}

class Sample {
    //...
    protected Sample(int val)
    {
        System.out.println("Sample.Sample(int)");
    }

    //...
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Aşağıda açıklanan Scheduler isimli sınıfı yazınız.
    Açıklamalar:
        - Sınıf Timer sınıfına benzemekle birlikte gecikme ve periyod elemanlarını TimeUnit ile birlikte
        alacaktır
        - Sınıf her periyota ne yapacağını yine TimerTask sınıfı ile alacaktır.
        - Sınıf ayrıca başka bir TimerTask ile timer sonlandrırılsa ne yapacağı bilgisini de alabilecektir
        - Sınıf ile tek bir schedule işlemi yapılabilecektir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;
import org.csystem.util.Scheduler;

import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

class App {
    public static void main(String[] args)
    {
        var scheduler = new Scheduler(2, 1, TimeUnit.SECONDS);

        var count = 5;

        var timerTask = new TimerTask() {
            private int m_count;
            public void run()
            {
                ++m_count;
                Console.write(".");
                if (m_count == count)
                    scheduler.cancel();
            }
        };

        var cancelTask = new TimerTask() {
            public void run()
            {
                Console.writeLine("\nCancelled");
            }
        };
        scheduler.schedule(timerTask, cancelTask);
    }
}


package org.csystem.app;

import org.csystem.util.Console;
import org.csystem.util.Scheduler;

import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

class App {
    public static void main(String[] args)
    {
        var scheduler = new Scheduler(1, TimeUnit.SECONDS);

        var timerTask = new TimerTask() {

            public void run()
            {
                Console.write(".");
            }
        };

        scheduler.schedule(timerTask);
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Scheduler sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public final class Scheduler {
    private final Timer m_timer;
    private final long m_delay;
    private final long m_period;
    private TimerTask m_cancelTask;

    public Scheduler(long period)
    {
        this(0, period, TimeUnit.MILLISECONDS);
    }

    public Scheduler(long delay, long period)
    {
        this(delay, period, TimeUnit.MILLISECONDS);
    }

    public Scheduler(long period, TimeUnit timeUnit)
    {
        this(0, period, timeUnit);
    }

    public Scheduler(long delay, long period, TimeUnit timeUnit)
    {
        m_timer = new Timer();

        m_delay = timeUnit != TimeUnit.MILLISECONDS ? TimeUnit.MILLISECONDS.convert(delay, timeUnit) : delay;
        m_period = timeUnit != TimeUnit.MILLISECONDS ? TimeUnit.MILLISECONDS.convert(period, timeUnit) : period;
    }

    public void schedule(TimerTask timerTask)
    {
        schedule(timerTask, null);
    }

    public void schedule(TimerTask timerTask, TimerTask cancelTask)
    {
        m_cancelTask = cancelTask;
        m_timer.scheduleAtFixedRate(timerTask, m_delay, m_period);
    }

    public void cancel()
    {
        if (m_cancelTask != null)
            m_cancelTask.run();

        m_timer.cancel();
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Aşağıda açıklanan sınıfı yazınız:
        - Sınıfın ismi CountDownScheduler olacaktır
        - Sınıfın ctor'u milisaniye cinsinden toplam zamanı ve periyot değerini paramatre olarak alacaktır. Örneğin:
        new CountDownScheduler(10000, 1000) {...}
        - Sınıfın onTick ve onFinish isimli şimdilik içi boş gövdeli olan iki adet metodu bulunacaktır. onTick metodu
        her periyotta çağrılan, onFinish metodu ise geri sayım bittiğinde çağrılam metot olacaktır.
        - onTick metodunun kalan zamanı milisaniye cinsinden veren bir parametresi olacaktır. Örneğin:

        new CountDownScheduler(20000, 1000) {
            public void onTick(long millisUntilFinished)
            {
                //Her adımda yapılacak iş. milliUntilFuture kalan zamanı verecek
            }

            public void onFinish()
            {
                //Geri sayım bittiğinde yapılacak iş
            }
        }

        - Sınıfın start isimili metodu ile scheduler başlatılacaktır.
        - Sınıfın cance isimli metodu geri sayımı durdurmak için kullanılır.
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;
import org.csystem.util.CountDownScheduler;

class App {
    public static void main(String[] args)
    {
        var countDownScheduler = new CountDownScheduler(10000, 1000) {
            private int m_count;
            public void onTick(long millisUntilFinished)
            {
                ++m_count;
                Console.write("%02d\r", millisUntilFinished / 1000);
            }

            public void onFinish()
            {
                Console.writeLine("Count:%d", m_count);
                Console.writeLine("Geri sayım tamamlandı");
            }
        };

        countDownScheduler.start();
    }
}

package org.csystem.app;

import org.csystem.util.CountDownScheduler;

import java.util.concurrent.TimeUnit;

class App {
    public static void main(String[] args)
    {
        var countDownScheduler = new CountDownScheduler(10, 1, TimeUnit.SECONDS) {
            private int m_count;
            public void onTick(long millisUntilFinished)
            {
                ++m_count;
                System.out.printf("%02d\r", millisUntilFinished / 1000);
            }

            public void onFinish()
            {
                System.out.printf("Count:%d", m_count);
                System.out.println("Geri sayım tamamlandı");
            }
        };

        countDownScheduler.start();
    }
}

package org.csystem.app;

import org.csystem.util.CountDownScheduler;

import java.util.concurrent.TimeUnit;

class App {
    public static void main(String[] args)
    {
        CountDownScheduler countDownScheduler = new MyCountDownScheduler();

        countDownScheduler.start();
    }
}

class MyCountDownScheduler extends CountDownScheduler {
    private int m_count;

    public MyCountDownScheduler()
    {
        super(10, 1, TimeUnit.SECONDS);
    }

    public void onTick(long millisUntilFinished)
    {
        ++m_count;
        System.out.printf("%02d\r", millisUntilFinished / 1000);
    }

    public void onFinish()
    {
        System.out.printf("Count:%d%n", m_count);
        System.out.println("Geri sayım tamamlandı");
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    CountDownScheduler sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util;

import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public abstract class CountDownScheduler {
    private final Scheduler m_scheduler;
    private final long m_millisInFuture;
    private final long m_interval;
    private final TimerTask m_timerTask;

    private TimerTask createTimerTask()
    {
        return new TimerTask() {
            private long m_value;

            public void run()
            {
                var millisUntilFinished = m_millisInFuture - m_value;

                onTick(millisUntilFinished);
                m_value += m_interval;
                if (m_value < m_millisInFuture)
                    return;

                onFinish();
                m_scheduler.cancel();
            }
        };
    }

    protected CountDownScheduler(long millisInFuture, long interval)
    {
        this(millisInFuture, interval, TimeUnit.MILLISECONDS);
    }

    protected CountDownScheduler(long millisFuture, long interval, TimeUnit timeUnit)
    {
        m_millisInFuture = timeUnit != TimeUnit.MILLISECONDS ? TimeUnit.MILLISECONDS.convert(millisFuture, timeUnit) : millisFuture;
        m_interval = timeUnit != TimeUnit.MILLISECONDS ? TimeUnit.MILLISECONDS.convert(interval, timeUnit) : interval;
        m_scheduler = new Scheduler(m_interval);
        m_timerTask = createTimerTask();
    }

    public abstract void onTick(long millisUntilFinished);

    public abstract void onFinish();

    public final void start()
    {
        m_scheduler.schedule(m_timerTask);
    }

    public final void cancel()
    {
        m_scheduler.cancel();
    }
}

```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: CountDownScheduler sınıfını genişletecek şekilde başlangıçta da bir iş yapılabilmsini sağlayan onStart
    metodunun eklendği CountDownSchedulerEx isimli sınıfı yazınız
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;
import org.csystem.util.CountDownSchedulerEx;

import java.util.concurrent.TimeUnit;

class App {
    public static void main(String[] args)
    {
        var schedulerEx = new CountDownSchedulerEx(10, 1, TimeUnit.SECONDS) {
            private int m_count;

            public void onStart()
            {
                Console.writeLine("Geri sayım başladı");
            }

            public void onTick(long millisUntilFinished)
            {
                ++m_count;
                System.out.printf("%02d\r", millisUntilFinished / 1000);
            }

            public void onFinish()
            {
                System.out.printf("Count:%d%n", m_count);
                System.out.println("Geri sayım tamamlandı");
            }
        };

        schedulerEx.startScheduler();
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    CountDownSchedulerEx sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util;

import java.util.concurrent.TimeUnit;

public abstract class CountDownSchedulerEx extends CountDownScheduler {
    protected CountDownSchedulerEx(long millisInFuture, long interval)
    {
        this(millisInFuture, interval, TimeUnit.MILLISECONDS);
    }

    protected CountDownSchedulerEx(long millisFuture, long interval, TimeUnit timeUnit)
    {
        super(millisFuture, interval, timeUnit);
    }

    public void startScheduler()
    {
        onStart();
        start();
    }

    public abstract void onStart();
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte anonim sınıf kullanılarak adeta nesneye ilkdeğer verme biçiminde kod yazılmıştır. Bu sentaks
    kesinlikle nesneye ilkdeğer verme sentaksı değildir. Anonim sınıf yaratma sentaksıdır. Yani p referansının
    gösterdiği nesnenin türü Person değildir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class App {
    public static void main(String[] args)
    {
        Person p = new Person() {{setName("Oğuz"); setCitizenId("12345678122"); setBirthDate(LocalDate.of(1976, 9, 10));}};

        System.out.println(p.getClass().getName());
        System.out.println(p.toString());

        Person p1 = new MyPerson();

        System.out.println(p1.getClass().getName());
        System.out.println(p1.toString());
    }
}

class MyPerson extends Person {
    {
        setName("Oğuz"); setCitizenId("12345678122"); setBirthDate(LocalDate.of(1976, 9, 10));
    }
}

class Person {
    private String m_name;
    private String m_citizenId;
    private LocalDate m_birthDate;
    //...
    public String getName()
    {
        return m_name;
    }

    public String getCitizenId()
    {
        return m_citizenId;
    }

    public LocalDate getBirthDate()
    {
        return m_birthDate;
    }

    public void setName(String name)
    {
        m_name = name;
    }

    public void setCitizenId(String citizenId)
    {
        m_citizenId = citizenId;
    }

    public void setBirthDate(LocalDate birthDate)
    {
        m_birthDate = birthDate;
    }

    public String toString()
    {
        var age = ChronoUnit.DAYS.between(m_birthDate, LocalDate.now()) / 365.;
        return String.format("[%s]%s:%.2f", m_citizenId, m_name, age);
    }
}

/*----------------------------------------------------------------------------------------------------------------------

----------------------------------------------------------------------------------------------------------------------*/
```
