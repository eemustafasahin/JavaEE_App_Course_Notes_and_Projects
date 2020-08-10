package org.csystem.app.samples.parserapp;

public class CharArraySource implements ISource {
    private final char[] m_chars;
    private int m_index;

    public CharArraySource(String string)
    {
        m_chars = string.toCharArray();
    }

    public int getChar()
    {
        return m_index == m_chars.length ? -1 : m_chars[m_index++];
    }
}
