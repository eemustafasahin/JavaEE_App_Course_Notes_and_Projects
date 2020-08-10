/*----------------------------------------------------------------------------------------------------------------------
    CentralLimitTheoremSimulation sınıfı
----------------------------------------------------------------------------------------------------------------------*/

package org.csystem.app.samples.centrallimittheorem;

import org.csystem.util.ArrayUtil;

import java.util.Random;

public class CentralLimitTheoremSimulation {
    private final int m_max;
    private final int m_sampleCount;
    private final int m_count;
    private final int m_divisor;
    private final int [] m_counts;
    private final Random m_random;

    private double getSamplesAverage()
    {
        double sum = 0;

        for (int i = 0; i < m_sampleCount; ++i)
            sum += m_random.nextInt(m_max + 1);

        return sum / m_sampleCount;
    }

    private void start()
    {
        for (int i = 0; i <  m_count; ++i) {
            double avg = getSamplesAverage();

            ++m_counts[(int)avg / m_divisor];
        }
    }

    public CentralLimitTheoremSimulation(int max, int sampleCount, int count, int n)
    {
        //...
        m_max = max;
        m_sampleCount = sampleCount;
        m_count = count;
        m_counts = new int[n];
        m_random = new Random();
        m_divisor = m_max / m_counts.length;
    }

    public void run(int n, char ch)
    {
        start();
        ArrayUtil.display(m_counts);
        ArrayUtil.drawHistogram(m_counts, n, ch);
    }
}
