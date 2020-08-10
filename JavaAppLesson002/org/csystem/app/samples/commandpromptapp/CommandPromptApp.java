/*----------------------------------------------------------------------------------------------------------------------
    CommandPromptApp sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app.samples.commandpromptapp;

public class CommandPromptApp {
    private CommandPromptApp() {}
    public static void run()
    {
        CommandPrompt cp = new CommandPrompt("CSD");

        cp.run();
    }
}
