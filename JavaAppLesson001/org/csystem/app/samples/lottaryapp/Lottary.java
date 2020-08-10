package org.csystem.app.samples.lottaryapp;

import java.util.Random;

public class Lottary {
    private Random m_random;

    private static int [] getNumbers(boolean [] flags)
    {
        int [] numbers = new int[6];

        int index = 0;

        for (int i = 1; i < 50; ++i)
            if (flags[i])
                numbers[index++] = i;

        return numbers;
    }

    private boolean [] getFlags()
    {
        boolean [] flags = new boolean[50];
        int val;

        for (int i = 0; i < 6; ++i) {
            for (;;) {
                val = m_random.nextInt(49) + 1;
                if (!flags[val])
                    break;
            }
            flags[val] = true;
        }

        return flags;
    }

    public Lottary()
    {
        this(new Random());
    }

    public Lottary(Random r)
    {
        m_random = r;
    }

    public int [] getNumbers()
    {
        return getNumbers(getFlags());
    }

    public int [][] getNumbers(int n)
    {
        int [][] a = new int[n][];

        for (int i = 0; i < n; ++i)
            a[i] = getNumbers();

        return a;
    }
}
