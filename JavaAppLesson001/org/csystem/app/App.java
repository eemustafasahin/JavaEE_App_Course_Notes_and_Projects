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

