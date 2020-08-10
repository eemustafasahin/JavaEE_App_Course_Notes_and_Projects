/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Aşağıdaki gibi çalışan bir komut yorumlayıcı program yazınız.
    Açıklamalar:
    - Program bir komut yorumlayıcı olarak aşağıdaki komutlar kabul edecektir.
        - stat <cümle>
        - quit
    - stat komutundan sonra bir cümle gelmelidir. Cümlenn isogram, değilse pangram değilse hiçbiri olarak
    sonucu elde edilecektir

    > stat abcdefghijklm        nopqrstuwxvyz
        isogram
    > stat abcdefghijklmno    ......pqrsatuwxvyz
        pangram
    > stat abcdefghijklmnopqrtuw      ....xvyz
        nothing
    - Sadece İngilizce alfabedeki karakterler gözönüne alınacaktır 
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app.samples.sentenceterminalapp;

import org.csystem.util.ArrayUtil;

import java.util.Scanner;

public class SentenceTerminal {
    private final String m_prompt;
    private String m_cmd;

    private void fillCounts(int [] counts, String sentence)
    {
        int len = sentence.length();

        for (int i = 0; i < len; ++i) {
            char c = Character.toLowerCase(sentence.charAt(i));
            if (c < 'a' || c > 'z')
                continue;

            ++counts[c - 'a'];
        }
    }

    private  void displayStatus(int [] counts)
    {
        boolean isPangram = false;

        for (int val : counts) {
            if (val == 0) {
                System.out.println("Nothing");
                return;
            }
            if (val > 1)
                isPangram = true;
        }

        System.out.println(isPangram ? "pangram" : "isogram");
    }

    private void doWorkForSentence(String sentence)
    {
        int [] counts = new int[26];

        fillCounts(counts, sentence);
        displayStatus(counts);
    }

    private void parseCommand()
    {
        String [] cmdInfo = m_cmd.split("[ \t]+");

        if (!cmdInfo[0].equals("stat")) {
            System.out.println("Invalid command");
            return;
        }

        if (cmdInfo.length == 1) {
            System.out.println("stat must have a sentence");
            return;
        }

        String sentence = ArrayUtil.join(cmdInfo, 1, "");

        doWorkForSentence(sentence);
    }

    public SentenceTerminal(String prompt)
    {
        m_prompt = prompt;
    }

    public void run()
    {
        Scanner kb = new Scanner(System.in);

        for (;;) {
            System.out.print(m_prompt + "> ");
            m_cmd = kb.nextLine().trim();

            if (m_cmd.equals("quit"))
                break;

            parseCommand();
        }

        System.out.println("Tekrar yapıyor musunuz?");
    }
}
