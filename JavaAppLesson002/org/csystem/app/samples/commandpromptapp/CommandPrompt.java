package org.csystem.app.samples.commandpromptapp;

import org.csystem.util.ArrayUtil;
import org.csystem.util.StringUtil;

import java.util.Scanner;

public class CommandPrompt {
    private String m_prompt;
    private static final String [] MS_COMMANDS = {"length", "reverse", "upper", "lower", "prompt", "clear", "quit"};

    private void doWorkForCommand(int i, String [] cmds)
    {
        switch (MS_COMMANDS[i]) {
            case "length":
                lengthProc(cmds);
                break;
            case "reverse":
                reverseProc(cmds);
                break;
            case "upper":
                upperProc(cmds);
                break;
            case "lower":
                lowerProc(cmds);
                break;
            case "prompt":
                promptProc(cmds);
                break;
            case "clear":
                clearProc(cmds);
                break;
            case "quit":
                quitProc(cmds);
                break;
        }
    }

    private void doWorkForCommands(String [] cmds)
    {
        if (cmds[0].length() < 3) {
            System.out.println("Komut en az 3 karakterli olmalıdır");
            return;
        }
        int i;

        for (i = 0; i < MS_COMMANDS.length; ++i)
            if (MS_COMMANDS[i].startsWith(cmds[0])) {
                doWorkForCommand(i, cmds);
                break;
            }

        if (i == MS_COMMANDS.length)
            System.out.println("Geçersiz komut");
    }

    private void lengthProc(String [] cmds)
    {
        String s = ArrayUtil.join(cmds, 1, ' ');

        System.out.println(s.length());
    }

    private void reverseProc(String [] cmds)
    {
        String s = ArrayUtil.join(cmds, 1, ' ');

        System.out.println(StringUtil.reverse(s));
    }

    private void upperProc(String [] cmds)
    {
        String s = ArrayUtil.join(cmds, 1, ' ');

        System.out.println(s.toUpperCase());
    }

    private void lowerProc(String [] cmds)
    {
        String s = ArrayUtil.join(cmds, 1, ' ');

        System.out.println(s.toLowerCase());
    }

    private void promptProc(String [] cmds)
    {
        String s = ArrayUtil.join(cmds, 1, ' ');

        m_prompt = s;
    }

    private void clearProc(String [] cmds)
    {
        if (cmds.length > 1) {
            System.out.println("clear komutu tek başına kullanılmalıdır");
            return;
        }

        for (int i = 0; i < 30; ++i)
            System.out.println();
    }

    private void quitProc(String [] cmds)
    {
        if (cmds.length > 1) {
            System.out.println("quit komutu tek başına yazılmalıdır");
            return;
        }
        System.out.println("Copyleft @ C ve Sistem Programcıları Derneği");
        System.out.println("Tekrar yapıyor musunuz?");
        System.exit(0);
    }

    public CommandPrompt(String prompt)
    {
        m_prompt = prompt;
    }

    public void run()
    {
        Scanner kb = new Scanner(System.in);

        for (;;) {
            System.out.print(m_prompt + ">");
            String cmdStr = kb.nextLine();

            String [] cmds = cmdStr.split("[ \t]+");

            doWorkForCommands(cmds);
        }
    }
}
