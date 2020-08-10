package org.csystem.app.samples.sentenceterminalapp;

public class SentenceTerminalApp {
    private SentenceTerminalApp()
    {}

    public static void run()
    {
        SentenceTerminal sentenceTerminal = new SentenceTerminal("CSD");

        sentenceTerminal.run();
    }
}
