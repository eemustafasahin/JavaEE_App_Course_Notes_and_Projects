/*----------------------------------------------------------------------------------------------------------------------

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


