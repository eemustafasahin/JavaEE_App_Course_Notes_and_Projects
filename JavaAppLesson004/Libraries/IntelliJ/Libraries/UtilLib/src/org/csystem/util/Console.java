package org.csystem.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public final class Console {
    private static final Scanner ms_kb;

    static {
        ms_kb = new Scanner(System.in);
    }
    private Console() {}

    public static class Error {
        private Error() {}
        public static void write(boolean b)
        {
            write("%b", b);
        }

        public static void write(int val)
        {
            write("%d", val);
        }

        public static void write(long val)
        {
            write("%d", val);
        }

        public static void write(char ch)
        {
            write("%c", ch);
        }

        public static void write(double val)
        {
            write("%f", val);
        }

        public static void write(float val)
        {
            write("%d", val);
        }

        public static void write(String s)
        {
            write("%s", s);
        }

        public static void write(char [] c)
        {
            for (char ch : c)
                write(ch);
        }

        public static void write(Object obj)
        {
            write("%s", obj);
        }

        public static void write(String fmt, Object...objects)
        {
            System.err.printf(fmt, objects);
        }

        public static void writeLine()
        {
            write("\n");
        }

        public static void writeLine(boolean b)
        {
            writeLine("%b", b);
        }

        public static void writeLine(int val)
        {
            writeLine("%d", val);
        }

        public static void writeLine(long val)
        {
            writeLine("%d", val);
        }

        public static void writeLine(char ch)
        {
            writeLine("%c", ch);
        }

        public static void writeLine(double val)
        {
            writeLine("%f", val);
        }

        public static void writeLine(float val)
        {
            writeLine("%d", val);
        }

        public static void writeLine(String s)
        {
            writeLine("%s", s);
        }

        public static void writeLine(char [] c)
        {
            for (char ch : c)
                writeLine(ch);
        }

        public static void writeLine(Object obj)
        {
            writeLine("%s", obj);
        }

        public static void writeLine(String fmt, Object...objects)
        {
            write(fmt + "\n", objects);
        }
    }
    public static double readDouble()
    {
        return readDouble("");
    }

    public static double readDouble(String msg)
    {
        return readDouble(msg, "");
    }

    public static double readDouble(String msg, String errMsg)
    {

        for (;;) {
            try {
                System.out.print(msg);

                return Double.parseDouble(ms_kb.nextLine());
            }
            catch (NumberFormatException ex) {
                System.out.print(errMsg);
            }
        }
    }

    public static double readDoubleLine(String msg)
    {
        return readDouble(msg + "\n", "");
    }

    public static double readDoubleLine(String msg, String errMsg)
    {
        return readDouble(msg + "\n", errMsg + "\n");
    }

    public static float readFloat()
    {
        return readFloat("");
    }

    public static float readFloat(String msg)
    {
        return readFloat(msg, "");
    }

    public static float readFloat(String msg, String errMsg)
    {
        for (;;) {
            try {
                System.out.print(msg);

                return Float.parseFloat(ms_kb.nextLine());
            }
            catch (NumberFormatException ex) {
                System.out.print(errMsg);
            }
        }
    }

    public static float readFloatLine(String msg)
    {
        return readFloat(msg + "\n", "");
    }

    public static float readFloatLine(String msg, String errMsg)
    {
        return readFloat(msg + "\n", errMsg + "\n");
    }


    public static int readInt()
    {
        return readInt("");
    }

    public static int readInt(String msg)
    {
        return readInt(msg, "");
    }

    public static int readInt(String msg, String errMsg)
    {
    	for (;;) {
            try {
                System.out.print(msg);

                return Integer.parseInt(ms_kb.nextLine());
            }
            catch (NumberFormatException ex) {
                System.out.print(errMsg);
            }
        }
    }

    public static int readIntLine(String msg)
    {
        return readInt(msg + "\n", "");
    }

    public static int readIntLine(String msg, String errMsg)
    {
        return readInt(msg + "\n", errMsg + "\n");
    }

    public static int readUInt()
    {
        return readUInt("");
    }

    public static int readUInt(String msg)
    {
        return readUInt(msg, "");
    }

    public static int readUInt(String msg, String errMsg)
    {
        for (;;) {
            try {
                System.out.print(msg);

                return Integer.parseUnsignedInt(ms_kb.nextLine());
            }
            catch (NumberFormatException ex) {
                System.out.print(errMsg);
            }
        }
    }

    public static int readUIntLine(String msg)
    {
        return readUInt(msg + "\n", "");
    }

    public static int readUIntLine(String msg, String errMsg)
    {
        return readUInt(msg + "\n", errMsg + "\n");
    }

    public static long readLong()
    {
        return readLong("");
    }

    public static long readLong(String msg)
    {
        return readLong(msg, "");
    }

    public static long readLong(String msg, String errMsg)
    {
        for (;;) {
            try {
                System.out.print(msg);

                return Long.parseLong(ms_kb.nextLine());
            }
            catch (NumberFormatException ex) {
                System.out.print(errMsg);
            }
        }
    }

    public static long readLongLine(String msg)
    {
        return readLong(msg + "\n", "");
    }

    public static long readLongLine(String msg, String errMsg)
    {
        return readLong(msg + "\n", errMsg + "\n");
    }

    public static long readULong()
    {
        return readULong("");
    }

    public static long readULong(String msg)
    {
        return readULong(msg, "");
    }

    public static long readULong(String msg, String errMsg)
    {
        for (;;) {
            try {
                System.out.print(msg);

                return Long.parseUnsignedLong(ms_kb.nextLine());
            }
            catch (NumberFormatException ex) {
                System.out.print(errMsg);
            }
        }
    }

    public static long readULongLine(String msg)
    {
        return readULong(msg + "\n", "");
    }

    public static long readULongLine(String msg, String errMsg)
    {
        return readULong(msg + "\n", errMsg + "\n");
    }


    public static String read(String msg)
    {
        System.out.print(msg);

        return ms_kb.nextLine();
    }

    public static String readLine()
    {
        return read("");
    }

    public static String readLine(String msg)
    {
        return read(msg + "\n");
    }

    public static BigDecimal readBigDecimal()
    {
        return readBigDecimal("");
    }

    public static BigDecimal readBigDecimal(String msg)
    {
        return readBigDecimal(msg, "");
    }

    public static BigDecimal readBigDecimal(String msg, String errMsg)
    {
        for (;;) {
            try {
                System.out.print(msg);

                return new BigDecimal(ms_kb.nextLine());
            }
            catch (NumberFormatException ex) {
                System.out.print(errMsg);
            }
        }
    }

    public static BigDecimal readBigDecimalLine(String msg)
    {
        return readBigDecimal(msg + "\n", "");
    }

    public static BigDecimal readBigDecimalLine(String msg, String errMsg)
    {
        return readBigDecimal(msg + "\n", errMsg + "\n");
    }

    public static BigInteger readBigInteger()
    {
        return readBigInteger("");
    }

    public static BigInteger readBigInteger(String msg)
    {
        return readBigInteger(msg, "");
    }

    public static BigInteger readBigInteger(String msg, String errMsg)
    {
        for (;;) {
            try {
                System.out.print(msg);

                return new BigInteger(ms_kb.nextLine());
            }
            catch (NumberFormatException ex) {
                System.out.print(errMsg);
            }
        }
    }

    public static BigInteger readBigIntegerLine(String msg)
    {
        return readBigInteger(msg + "\n", "");
    }

    public static BigInteger readBigIntegerLine(String msg, String errMsg)
    {
        return readBigInteger(msg + "\n", errMsg + "\n");
    }

    public static void write(boolean b)
    {
        write("%b", b);
    }

    public static void write(int val)
    {
        write("%d", val);
    }

    public static void write(long val)
    {
        write("%d", val);
    }

    public static void write(char ch)
    {
        write("%c", ch);
    }

    public static void write(double val)
    {
        write("%f", val);
    }

    public static void write(float val)
    {
        write("%d", val);
    }

    public static void write(String s)
    {
        write("%s", s);
    }

    public static void write(char [] c)
    {
        for (char ch : c)
            write(ch);
    }

    public static void write(Object obj)
    {
        write("%s", obj);
    }

    public static void write(String fmt, Object...objects)
    {
        System.out.printf(fmt, objects);
    }

    public static void writeLine()
    {
        write("\n");
    }

    public static void writeLine(boolean b)
    {
        writeLine("%b", b);
    }

    public static void writeLine(int val)
    {
        writeLine("%d", val);
    }

    public static void writeLine(long val)
    {
        writeLine("%d", val);
    }

    public static void writeLine(char ch)
    {
        writeLine("%c", ch);
    }

    public static void writeLine(double val)
    {
        writeLine("%f", val);
    }

    public static void writeLine(float val)
    {
        writeLine("%d", val);
    }

    public static void writeLine(String s)
    {
        writeLine("%s", s);
    }

    public static void writeLine(char [] c)
    {
        for (char ch : c)
            writeLine(ch);
    }

    public static void writeLine(Object obj)
    {
        writeLine("%s", obj);
    }

    public static void writeLine(String fmt, Object...objects)
    {
        write(fmt + "\n", objects);
    }
}
