package org.csystem.app.samples.lottaryapp;

import org.csystem.util.ArrayUtil;

import java.util.Scanner;

public class LottaryTest {
    private LottaryTest() {}
    public static void run()
    {
        Scanner kb = new Scanner(System.in);
        System.out.print("Kaç kupon oynamak istiyorsunuz?");
        int n = Integer.parseInt(kb.nextLine());

        Lottary lottary = new Lottary();

        ArrayUtil.display(2, lottary.getNumbers(n));
    }
}
