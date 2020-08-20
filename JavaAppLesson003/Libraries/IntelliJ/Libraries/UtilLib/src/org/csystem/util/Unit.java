/*----------------------------------------------------------------------------------------------------------------------
	Unit sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util;

public final class Unit<T> {
    private final T m_t;

    public static <T> Unit<T> create(T t)
    {
        return new Unit<>(t);
    }
    public Unit(T t)
    {
        m_t = t;
    }

    public T getT()
    {
        return m_t;
    }

    public String toString()
    {
        return String.format("%s", m_t);
    }
}
