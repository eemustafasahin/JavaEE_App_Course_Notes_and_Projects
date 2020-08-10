/*----------------------------------------------------------------------------------------------------------------------
	NumberUtil sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util;

import java.util.Random;

import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public final class NumberUtil {
    private static final String [] MS_ONES_TR;
    private static final String [] MS_TENS_TR;

    static {
        MS_ONES_TR = new String[] {"", "bir", "iki", "üç", "dört", "beş", "altı", "yedi", "sekiz", "dokuz"};
        MS_TENS_TR = new String[] {"", "on", "yirmi", "otuz", "kırk", "elli", "altmış", "yetmiş", "seksen", "doksan"};
    }

    private static int [] getDigits(int n, long val)
    {
        val = Math.abs(val);
        int len = val == 0 ? 1 : (int)Math.log10(val) / n + 1;
        int [] digits = new int[len];
        int pow = (int)Math.pow(10, n);

        for (int i = len - 1; i >= 0; digits[i] = (int)(val % pow), val /= pow, --i)
            ;

        return digits;
    }

    private static int getSum(int val, int n)
    {
        int sum = 0;

        while (val != 0) {
            sum += pow(val % 10, n);
            val /= 10;
        }

        return sum;
    }

    private static String numToStr3DigitsTR(int val)
    {
        if (val == 0)
            return "sıfır";

        String str = val < 0 ? "eksi" : "";
        val = Math.abs(val);

        int a = val / 100;
        int b = val / 10 % 10;
        int c = val % 10;

        if (a != 0) {
            if (a != 1)
                str += MS_ONES_TR[a];

            str += "yüz";
        }
        if (b != 0)
            str += MS_TENS_TR[b];
        if (c != 0)
            str += MS_ONES_TR[c];

        return str;
    }

    private NumberUtil() {}

    public static int factorial(int n)
    {
        if (n < 0)
            return -1;

        int result = 1;

        for (int i = 2; i <= n; ++i)
            result *= i;

        return result;
    }

    public static int [] getDigits(int val)
    {
        return getDigits((long)val);
    }

    public static int [] getDigits(long val)
    {
        return getDigits(1, val);
    }

    public static int [] getDigitsInTwo(long val)
    {
        return getDigits(2, val);
    }

    public static int [] getDigitsInThree(long val)
    {
        return getDigits(3, val);
    }

    public static int getDigitsCount(int val)
    {
        return getDigitsCount((long)val);
    }

    public static int getDigitsCount(long val)
    {
        return val == 0 ? 1 : (int)Math.log10(Math.abs(val)) + 1;
    }

    public static int getDigitsSum(int val)
    {
        int sum = 0;

        while (val != 0) {
            sum += val % 10;
            val /= 10;
        }

        return abs(sum);
    }


    public static int getFibonacciNumber(int n)
    {
        if (n <= 0)
            return -1;

        if (n <= 2)
            return  n - 1;

        int prev1 = 0, prev2 = 1, val = 0;

        for (int i = 2; i < n; ++i) {
            val = prev1 + prev2;
            prev1 = prev2;
            prev2 = val;
        }

        return val;
    }

    public static int [] getFibonacciNumbers(int n)
    {
        int [] numbers = new int[n];

        if (n > 1)
            numbers[1] = 1;

        int prev1 = 0, prev2 = 1;

        for (int i = 2; i < n; ++i) {
            numbers[i] = prev1 + prev2;
            prev1 = prev2;
            prev2 = numbers[i];
        }

        return numbers;
    }

    public static String getLetters(String s)
    {
        int len = s.length();
        String str = "";

        for (int i = 0; i < len; ++i) {
            char c = s.charAt(i);

            if (Character.isLetter(c))
                str += c;
        }

        return str;
    }

    public static int getNextFibonacciNumber(int val)
    {
        int prev1 = 0, prev2 = 1, result = 0;

        for (;;) {
            result = prev1 + prev2;
            if (result > val)
                return result;

            prev1 = prev2;
            prev2 = result;
        }
    }

    public static int getPrime(int n)
    {
        if (n <= 0)
            return -1;

        int count = 0, val = 0;

        for (int i = 2; count < n; ++i)
            if (isPrime(i)) {
                ++count;
                val = i;
            }

        return val;
    }


    public static int [] getPrimes(int n)
    {
        int [] primes = new int[n];
        int count = 0;

        for (int i = 2; count < n; ++i)
            if (isPrime(i))
                primes[count++] = i;

        return primes;
    }
    public static int getRandomNumberUniqueDigits(int n)
    {
        return getRandomNumberUniqueDigits(new Random(), n);
    }

    public static int getRandomNumberUniqueDigits(Random r, int n)
    {
        //...
        boolean [] flags = new boolean[10];
        int result = 0;
        int val;

        val = r.nextInt(9) + 1;
        result +=  val * (int)Math.pow(10, n - 1);
        flags[val] = true;

        for (int i = 1; i < n; ++i) {
            for (;;) {
                val = r.nextInt(10);
                if (!flags[val])
                    break;
            }
            result += val * (int)Math.pow(10, n - 1 - i);
            flags[val] = true;
        }

        return result;
    }

    public static int getReverse(int val)
    {
        int rev = 0;

        while (val != 0) {
            rev = rev * 10 + val % 10;
            val /= 10;
        }

        return rev;
    }

    public static boolean isArmstrong(int val)
    {
        if (val < 0)
            return false;

        if (val < 10)
            return true;

        int n = getDigitsCount(val);


        return getSum(val, n) == val;
    }

    public static boolean isEven(int val)
    {
        return val % 2 == 0;
    }

    public static boolean isOdd(int val)
    {
        return !isEven(val);
    }

    public static boolean isPalindrome(String s)
    {
        String str = getLetters(s);

        if (str.isEmpty())
            return false;

        int first = 0;
        int last = str.length() - 1;

        while (first < last) {
            char chLeft = Character.toLowerCase(str.charAt(first++));
            char chRight = Character.toLowerCase(str.charAt(last--));

            if (chLeft != chRight)
                return false;
        }

        return true;

    }

    public static boolean isPrime(int val)
    {
        if (val <= 1)
            return false;

        if (val % 2 == 0)
            return val == 2;

        if (val % 3 == 0)
            return val == 3;

        if (val % 5 == 0)
            return val == 5;

        if (val % 7 == 0)
            return val == 7;

        int sqrtIntVal = (int)sqrt(val);

        for (int i = 11; i <= sqrtIntVal; i += 2)
            if (val % i == 0)
                return false;

        return true;
    }

    public static int min(int a, int b, int c)
    {
        return Math.min(Math.min(a, b), c);
    }

    public static int max(int a, int b, int c)
    {
        return Math.max(Math.max(a, b), c);
    }

    public String numToStr(long val)
    {
        //...
        return numToStr3DigitsTR((int)val);

    }
}


