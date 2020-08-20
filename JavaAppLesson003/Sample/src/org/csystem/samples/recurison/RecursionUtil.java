package org.csystem.samples.recurison;

import org.csystem.util.Console;

public class RecursionUtil {
    private static void getReverse(char [] c, int left, int right)
    {
        if (left >= right)
            return;

        char temp;

        temp = c[left];
        c[left] = c[right];
        c[right] = temp;

        getReverse(c, left + 1, right - 1);
    }

    private static void writeReverse(String s, int i)
    {
        if (i == s.length())
            return;

        writeReverse(s, i + 1);
        Console.write(s.charAt(i));
    }

    public static long factorial(int n)
    {
        if (n <= 0)
            return 1;

        return n * factorial(n - 1);
    }

    public static String getReverse(String s)
    {
        char [] c = s.toCharArray();

        getReverse(c, 0, c.length - 1);

        return String.valueOf(c);
    }

    public static void writeReverse(String s)
    {
        writeReverse(s, 0);
    }
}
