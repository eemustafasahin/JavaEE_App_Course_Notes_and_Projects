package org.csystem.app.samples.randomobjectsgeneratorapp;

import org.csystem.util.IntValue;
import org.csystem.util.datetime.Date;
import org.csystem.util.datetime.Time;

import java.util.Random;
import java.util.Scanner;

public class RandomObjectsGeneratorApp {
    private static void dateProc(Date date)
    {
        System.out.println("Date:");
        System.out.println(date.toLongDateStringEN());
        System.out.println(date.toLongDateStringTR());

    }
    private static void timeProc(Time time)
    {
        System.out.println("Time:");
        System.out.println(time.toLongTimeString());
    }

    private static void intValueProc(IntValue intValue)
    {
        System.out.println("IntValue:");
        System.out.println(intValue.getVal());
        System.out.println(intValue.inc(5).getVal());
    }

    private static void stringProc(String str)
    {
        System.out.println("String:");
        System.out.println(str);
        System.out.println(str.toUpperCase());
    }

    private static void integerProc(int val)
    {
        System.out.println("Integer:");
        System.out.printf("%d * %d = %d%n", val, val, val * val);
    }

    private static void doubleProc(double val)
    {
        System.out.println("Double:");

        System.out.println(val);
    }

    private static void doWork(RandomObjectsGenerator randomObjectsGenerator)
    {
        randomObjectsGenerator.generate();
        for (Object object : randomObjectsGenerator.getObjects()) {
            if (object instanceof Date)
                dateProc((Date)object);
            else if (object instanceof Time)
                timeProc((Time)object);
            else if (object instanceof IntValue)
                intValueProc((IntValue)object);
            else if (object instanceof String)
                stringProc((String)object);
            else if (object instanceof Integer)
                integerProc((int)object);
            else
                doubleProc((double)object);
        }
    }

    public static void run()
    {
        Scanner kb = new Scanner(System.in);
        System.out.print("Dizinin eleman sayısını giriniz");
        int count = Integer.parseInt(kb.nextLine());
        Random r = new Random();
        RandomObjectsGenerator randomObjectsGenerator = new RandomObjectsGenerator(r, count);

        doWork(randomObjectsGenerator);
    }
}
