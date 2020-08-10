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

