/*----------------------------------------------------------------------------------------------------------------------
    CentralLimitTheoremSimulationApp sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app.samples.centrallimittheorem;

public class CentralLimitTheoremSimulationApp {
    public static void run()
    {
        CentralLimitTheoremSimulation clt = new CentralLimitTheoremSimulation(10000, 5, 100_000_000, 10);

        clt.run(20, 'X');
    }
}
