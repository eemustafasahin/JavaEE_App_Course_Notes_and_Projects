/*----------------------------------------------------------------------------------------------------------------------
	IntValue sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util;

public final class IntValue {
    private final int m_val;
    private static final IntValue [] MS_CACHE = new IntValue[256];

    private IntValue(int val)
    {
        m_val = val;
    }

    public static final IntValue ONE = of(1);
    public static final IntValue ZERO = of(0);
    public static final IntValue TEN = of(10);

    public static IntValue of(int val)
    {
        if (val < -128 || val > 127)
            return new IntValue(val);

        if (MS_CACHE[val + 128] == null) //ön bellekte var mı? Yoksa nesneyi yarat
            MS_CACHE[val + 128] = new IntValue(val);

        return MS_CACHE[val + 128];
    }

    public int getVal()
    {
        return m_val;
    }

    public int compareTo(IntValue other)
    {
        return m_val - other.m_val;
    }

    public IntValue inc()
    {
        return inc(1);
    }

    public IntValue inc(int val)
    {
        return of(m_val + val);
    }

    public String toString()
    {
        return m_val + "";
    }
}
