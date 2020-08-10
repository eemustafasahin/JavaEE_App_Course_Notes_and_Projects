package org.csystem.app.samples.parserapp;

public class Parser {
    private ISource m_source;

    public Parser(ISource source)
    {
        //...
        m_source = source;
    }

    public ISource getSource()
    {
        return m_source;
    }

    public void setSource(ISource source)
    {
        m_source = source;
    }

    public void doParse()
    {
        int count = 0;
        int ch;

        while ((ch = m_source.getChar()) != -1)
            if (Character.isLetter((char)ch))
                ++count;

        System.out.printf("Count:%d%n", count);
    }
}
