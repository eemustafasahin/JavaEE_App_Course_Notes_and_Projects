package org.csystem.app.samples.parserapp;

public class ParserApp {
    public static void run()
    {
        StringSource stringSource = new StringSource("bugün hava 25 derece");
        Parser parser = new Parser(stringSource);

        parser.doParse();

        CharArraySource charArraySource = new CharArraySource("Ali Serçe");

        parser.setSource(charArraySource);

        parser.doParse();
    }
}
