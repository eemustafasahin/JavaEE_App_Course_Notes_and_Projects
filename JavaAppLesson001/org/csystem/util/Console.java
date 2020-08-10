/*----------------------------------------------------------------------------------------------------------------------
	Console sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util;

import java.util.Scanner;

public final class Console {
    private static final Scanner KB = new Scanner(System.in);

    private Console()
    {}

    //read methods

    public static int readInt()
    {
        return readInt("");
    }

    public static int readInt(String message)
    {
        return readInt(message, "");
    }

    public static int readInt(String message, String errMessage)
    {
        for (;;) {
            try {
                System.out.print(message);

                return Integer.parseInt(KB.nextLine());
            }
            catch (NumberFormatException ex) {
                System.out.print(errMessage);
            }
        }
    }

    public static int readIntLine(String message)
    {
        return readInt(message, "");
    }

    public static int readIntLine(String message, String errMessage)
    {
        return readInt(message + "\n", errMessage + "\n");
    }

    public static double readDouble()
    {
        return readDouble("");
    }

    public static double readDouble(String message)
    {
        return readDouble(message, "");
    }

    public static double readDouble(String message, String errMessage)
    {
        for (;;) {
            try {
                System.out.print(message);

                return Double.parseDouble(KB.nextLine());
            }
            catch (NumberFormatException ex) {
                System.out.print(errMessage);
            }
        }
    }

    public static double readDoubleLine(String message)
    {
        return readDouble(message, "");
    }

    public static double readDoubleLine(String message, String errMessage)
    {
        return readDouble(message + "\n", errMessage + "\n");
    }

    public static String readString(String message)
    {
        System.out.print(message);

        return KB.nextLine();
    }

    public static String readStringLine(String message)
    {
        return readString(message + "\n");
    }


    //write methods

    public static void writeChars(int n, char ch)
    {
        for (int i = 0; i < n; ++i)
            System.out.print(ch);
    }

    public static void writeCharsLine(int n, char ch)
    {
        writeChars(n, ch);
        System.out.println();
    }

    public static void writeLine()
    {
        System.out.println();
    }

    public static void writeLine(double val)
    {
        System.out.println(val);
    }

    public static void writeLine(int val)
    {
        System.out.println(val);
    }

    public static void writeLine(String format, Object...objects)
    {
        write(format + "\n", objects);
    }

    public static void write(String format, Object...objects)
    {
        System.out.printf(format, objects);
    }
    //...
}
