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


