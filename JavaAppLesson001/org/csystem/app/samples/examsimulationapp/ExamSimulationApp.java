package org.csystem.app.samples.examsimulationapp;

public class ExamSimulationApp {
    private ExamSimulationApp() {}
    public static void run()
    {
        ExamSimulation [] examSimulations = {new ExamSimulation("Matematik"), new ExamSimulation("Kimya")};

        for (int i = 0; i < examSimulations.length; ++i)
            examSimulations[i].run();

        for (int i = 0; i < examSimulations.length; ++i)
            examSimulations[i].displayReport();
    }
}
