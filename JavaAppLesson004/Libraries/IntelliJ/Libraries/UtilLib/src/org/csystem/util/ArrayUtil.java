/*----------------------------------------------------------------------------------------------------------------------
	ArrayUtil sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;

public final class ArrayUtil {
    private ArrayUtil()
    {
    }

    public static void addBy(int[] a, int val)
    {
        for (int i = 0; i < a.length; ++i)
            a[i] += val;
    }

    public static void addBy(int[][] a, int val)
    {
        for (int i = 0; i < a.length; ++i)
            for (int j = 0; j < a[i].length; ++j)
                a[i][j] += val;
    }

    public static int[][] addMatrices(int[][] m1, int[][] m2)
    {
        if (!isMatrix(m1) || !isMatrix(m2) || m1.length != m2.length || m1[0].length != m2[0].length)
            throw new IllegalArgumentException("add not supported for arguments");

        int row = m1.length;
        int col = m1[0].length;
        int[][] m = new int[row][col];

        for (int i = 0; i < row; ++i)
            for (int j = 0; j < col; ++j)
                m[i][j] = m1[i][j] + m2[i][j];

        return m;
    }

    public static double average(int[] a)
    {
        return (double) sum(a) / a.length;
    }

    public static void bubbleSort(int[] a) //ascending (natural sort order)
    {
        bubbleSort(a, false);
    }

    public static void bubbleSort(int[] a, boolean desc)
    {
        if (desc) {
            for (int i = 0; i < a.length - 1; ++i)
                for (int k = 0; k < a.length - 1 - i; ++k)
                    if (a[k] < a[k + 1]) {
                        int temp = a[k];
                        a[k] = a[k + 1];
                        a[k + 1] = temp;
                    }
        } else {
            for (int i = 0; i < a.length - 1; ++i)
                for (int k = 0; k < a.length - 1 - i; ++k)
                    if (a[k] > a[k + 1]) {
                        int temp = a[k];
                        a[k] = a[k + 1];
                        a[k + 1] = temp;
                    }
        }
    }

    public static void bubbleSort(char[] a) //ascending (natural sort order)
    {
        bubbleSort(a, false);
    }

    public static void bubbleSort(char[] a, boolean desc)
    {
        if (desc) {
            for (int i = 0; i < a.length - 1; ++i)
                for (int k = 0; k < a.length - 1 - i; ++k)
                    if (a[k] < a[k + 1]) {
                        char temp = a[k];
                        a[k] = a[k + 1];
                        a[k + 1] = temp;
                    }
        } else {
            for (int i = 0; i < a.length - 1; ++i)
                for (int k = 0; k < a.length - 1 - i; ++k)
                    if (a[k] > a[k + 1]) {
                        char temp = a[k];
                        a[k] = a[k + 1];
                        a[k + 1] = temp;
                    }
        }
    }

    public static void display(int n, int... a)
    {
        display(n, a.length, a);
    }

    public static void display(int n, int count, int... a)
    {
        String fmt = String.format("%%0%dd ", n);

        for (int i = 0; i < count; ++i)
            System.out.printf(fmt, a[i]);

        System.out.println();
    }

    public static void display(int... a)
    {
        display(1, a.length, a);
    }

    public static void display(int[]...a)
    {
        display(1, a);
    }

    public static void display(int n, int[]...a)
    {
        for (int[] array : a)
            display(n, array);
    }

    public static void display(char...c)
    {
        for (char ch : c)
            System.out.printf("%c ", ch);

        System.out.println();
    }

    public static void display(BigInteger...bigIntegers)
    {
        for (var val : bigIntegers)
            Console.writeLine(val);
    }

    public static void drawHistogram(int[] data, int n, char ch)
    {
        int maxVal = max(data);

        for (int value : data) {
            int val = (int) Math.round(value * n / (double) maxVal);

            System.out.println(StringUtil.repeat(val, ch));
        }
    }

    public static int[] enlarge(int[] a, int newLength)
    {
        if (newLength <= a.length)
            return a;

        return Arrays.copyOf(a, newLength);
    }

    public static boolean equals(int [][] a, int [][] b)
    {
        if (a.length != b.length)
            return false;

        for (int i = 0; i < a.length; ++i)
            if (!Arrays.equals(a[i], b[i]))
                return false;

        return true;
    }

    public static void fillArrayRandom(int[] a, int min, int max)
    {
        fillArrayRandom(new Random(), a, min, max);
    }

    public static void fillArrayRandom(Random r, int[] a, int min, int max)
    {
        for (int i = 0; i < a.length; ++i)
            a[i] = r.nextInt(max - min) + min;
    }

    public static int[] getHistogramData(int[] a, int n) //[0, n]
    {
        int[] counts = new int[n + 1];

        for (int val : a)
            ++counts[val];

        return counts;
    }

    public static int[] getRandomUniqueDigitsArray(int n)
    {
        return getRandomUniqueDigitsArray(new Random(), n);
    }

    public static int[] getRandomUniqueDigitsArray(Random r, int n)
    {
        boolean[] flags = new boolean[10];
        int[] a = new int[n];
        int val;

        a[0] = r.nextInt(9) + 1;
        flags[a[0]] = true;

        for (int i = 1; i < n; ++i) {
            for (; ; ) {
                val = r.nextInt(10);
                if (!flags[val])
                    break;
            }
            a[i] = val;
            flags[val] = true;
        }

        return a;
    }

    public static int[] getRandomArray(int n, int min, int max) //[min, max)
    {
        return getRandomArray(new Random(), n, min, max);
    }

    public static int[] getRandomArray(Random r, int n, int min, int max) //[min, max)
    {
        int[] a = new int[n];

        fillArrayRandom(r, a, min, max);

        return a;
    }

    public static BigInteger[] getRandomBigIntegerArray(int n, int numbits)
    {
        return getRandomBigIntegerArray(new Random(), n, numbits);
    }

    public static BigInteger[] getRandomBigIntegerArray(Random r, int n, int numbits)
    {
        var result = new BigInteger[n];

        for (int i = 0; i < n; ++i) {
            var val = new BigInteger(numbits, r);
            result[i] = r.nextBoolean() ? val : val.negate();
        }

        return result;
    }

    public static int[][] getRandomMatrix(int m, int n, int min, int max) //[min, max)
    {
        return getRandomMatrix(new Random(), m, n, min, max);
    }

    public static int[][] getRandomMatrix(Random r, int m, int n, int min, int max) //[min, max)
    {
        int[][] a = new int[m][];

        for (int i = 0; i < m; ++i)
            a[i] = getRandomArray(r, n, min, max);

        return a;
    }

    public static int[][] getRandomSquareMatrix(int n, int min, int max) //[min, max)
    {
        return getRandomSquareMatrix(new Random(), n, min, max);
    }

    public static int[][] getRandomSquareMatrix(Random r, int n, int min, int max) //[min, max)
    {
        return getRandomMatrix(r, n, n, min, max);
    }

    public static int[][] getTranspose(int[][] a)
    {
        int row = a.length;
        int col = a[0].length;

        int[][] t = new int[col][row];

        for (int i = 0; i < row; ++i)
            for (int j = 0; j < col; ++j)
                t[j][i] = a[i][j];

        return t;
    }

    public static boolean isEmpty(int[] a)
    {
        return a.length == 0;
    }

    public static boolean isNotEmpty(int[] a)
    {
        return !isEmpty(a);
    }

    public static boolean isEmpty(double[] a)
    {
        return a.length == 0;
    }

    public static boolean isNotEmpty(double[] a)
    {
        return !isEmpty(a);
    }

    public static boolean isMatrix(int[][] a)
    {
        int n = a[0].length;

        for (int i = 1; i < a.length; ++i)
            if (a[i].length != n)
                return false;

        return true;
    }

    public static boolean isSquareMatrix(int[][] a)
    {
        return isMatrix(a) && a.length == a[0].length;
    }

    public static String join(String[] s, char delim)
    {
        return join(s, delim + "");
    }

    public static String join(String[] s, int startIndex, char delim)
    {
        return join(s, startIndex, delim + "");
    }

    public static String join(String[] s, String delim)
    {
        return join(s, 0, delim);
    }

    public static String join(String[] s, int startIndex, String delim)
    {
        StringBuilder str = new StringBuilder();

        for (int i = startIndex; i < s.length; ++i)
            str.append(s[i]).append(delim);

        return str.substring(0, str.length() - delim.length());
    }

    public static int max(int[] a)
    {
        int maxVal = a[0];

        for (int i = 1; i < a.length; ++i)
            if (maxVal < a[i])
                maxVal = a[i];

        return maxVal;
    }

    public static int min(int[] a)
    {
        int minVal = a[0];

        for (int i = 1; i < a.length; ++i)
            if (minVal > a[i])
                minVal = a[i];

        return minVal;
    }

    public static int mod(int[] a)
    {
        int modCount = 0;
        int modVal = a[0];

        //...

        return modVal;
    }

    public static void multiplyBy(int[] a, int val)
    {
        for (int i = 0; i < a.length; ++i)
            a[i] *= val;
    }

    public static void multiplyBy(int[][] a, int val)
    {
        for (int i = 0; i < a.length; ++i)
            for (int j = 0; j < a[i].length; ++j)
                a[i][j] *= val;
    }

    public static void reverse(int[] a)
    {
        int halfLen = a.length / 2;

        for (int i = 0; i < halfLen; ++i) {
            int temp = a[i];
            a[i] = a[a.length - 1 - i];
            a[a.length - 1 - i] = temp;
        }
    }

    public static int[] resize(int[] a, int newLength)
    {
        if (a.length == newLength)
            return a;

        int[] newArray = new int[newLength];
        int length = Math.min(a.length, newLength);

        for (int i = 0; i < length; ++i)
            newArray[i] = a[i];

        return newArray;
    }

    public static void reverse(char[] c)
    {
        int halfLen = c.length / 2;

        for (int i = 0; i < halfLen; ++i) {
            char temp = c[i];
            c[i] = c[c.length - 1 - i];
            c[c.length - 1 - i] = temp;
        }
    }

    public static void selectionSort(int[] a) //natural sort
    {
        selectionSort(a, false);
    }

    public static void selectionSort(int[] a, boolean desc)
    {
        if (desc) {
            int max, maxIndex;

            for (int i = 0; i < a.length - 1; ++i) {
                max = a[i];
                maxIndex = i;

                for (int k = i + 1; k < a.length; ++k)
                    if (a[k] > max) {
                        max = a[k];
                        maxIndex = k;
                    }

                a[maxIndex] = a[i];
                a[i] = max;
            }
        } else {
            int min, minIndex;

            for (int i = 0; i < a.length - 1; ++i) {
                min = a[i];
                minIndex = i;

                for (int k = i + 1; k < a.length; ++k)
                    if (a[k] < min) {
                        min = a[k];
                        minIndex = k;
                    }

                a[minIndex] = a[i];
                a[i] = min;
            }
        }
    }

    public static void subtractBy(int[] a, int val)
    {
        addBy(a, -val);
    }

    public static void subtractBy(int[][] a, int val)
    {
        addBy(a, -val);
    }

    public static int sum(int[] a)
    {
        int total = 0;

        for (var val : a)
            total += val;

        return total;
    }

    public static BigInteger sum(BigInteger[] bigIntegers)
    {
        BigInteger total = BigInteger.ZERO;


        for (var val : bigIntegers)
            total = total.add(val);

        return total;
    }

    public static int sumEvens(int[] a)
    {
        int total = 0;

        for (var val : a)
            if (val % 2 == 0)
                total += val;

        return total;
    }

    public static int sumDiagonal(int[][] a)
    {
        int total = 0;

        for (int i = 0; i < a.length; ++i)
            total += a[i][i];

        return total;
    }

    public static int sumOdds(int[] a)
    {
        int total = 0;

        for (int val : a)
            if (val % 2 != 0)
                total += val;

        return total;
    }

    public static long toNumber(int[] a)
    {
        //...
        int val = 0;
        int lenm1 = a.length - 1;

        for (int i = 0; i < a.length; ++i)
            val += a[i] * (int) Math.pow(10, lenm1 - i);

        return val;
    }
}
