/*----------------------------------------------------------------------------------------------------------------------
    BitwiseUtil sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util;

public class BitwiseUtil {
    private BitwiseUtil()
    {}

    private static void writeBits(String bitsStr, int bitsLength)
    {
        int lengthZeros = bitsLength - bitsStr.length();

        Console.writeLine(lengthZeros != 0 ? String.format("%0" + lengthZeros + "d%s", 0, bitsStr) : bitsStr);
    }

    public static void writeBits(char val)
    {
        writeBits(Integer.toBinaryString(val), 16);
    }

    public static void writeBits(byte val)
    {
        writeBits(Integer.toBinaryString(val), 8);
    }

    public static void writeBits(short val)
    {
        writeBits(Integer.toBinaryString(val), 16);
    }

    public static void writeBits(int val)
    {
        writeBits(Integer.toBinaryString(val), 32);
    }

    public static void writeBits(long val)
    {
        writeBits(Long.toBinaryString(val), 64);
    }
}
