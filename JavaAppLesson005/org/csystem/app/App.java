/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte çok basit bir şifreleme algoritması yazılmıştır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.BitwiseUtil;
import org.csystem.util.Console;

public class App {
    public static void main(String[] args)
    {
        BitwiseUtil.writeBits((int)'a');
        BitwiseUtil.writeBits(3);
        BitwiseUtil.writeBits('a' ^ 3);
        Console.writeLine('a' ^ 3);
        Console.writeLine((char)('a' ^ 3));
    }
}

