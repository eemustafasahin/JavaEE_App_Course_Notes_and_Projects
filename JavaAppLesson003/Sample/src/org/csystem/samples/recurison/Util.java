package org.csystem.samples.recurison;

import org.csystem.util.Console;

public class Util {
    public static long factorial(int n)
    {
        long result = 1;

        for (; n > 1; --n)
            result *= n;

        return result;
    }

    public static void writeReverse(String s)
    {
        for (int i = s.length() - 1; i >= 0; --i)
            Console.write(s.charAt(i));
    }
}
