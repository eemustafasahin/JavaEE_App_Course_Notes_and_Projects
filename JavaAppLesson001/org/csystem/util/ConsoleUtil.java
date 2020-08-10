/*----------------------------------------------------------------------------------------------------------------------
	ConsoleUtil sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util;

public final class ConsoleUtil {
    private ConsoleUtil() {}
    public static void putChars(int n, char ch)
    {
        for (int i = 0; i < n; ++i)
            System.out.print(ch);
    }

    public static void putCharsLine(int n, char ch)
    {
        putChars(n, ch);
        System.out.println();
    }
}
