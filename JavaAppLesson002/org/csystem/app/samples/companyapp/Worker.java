package org.csystem.app.samples.companyapp;

public class Worker extends Employee {
    private double m_feePerHour;
    private int m_hourPerDay;

    public Worker(String citizenId, String name, String address, double feePerHour, int hourPerDay)
    {
        super(citizenId, name, address);
        //...
        m_feePerHour = feePerHour;
        m_hourPerDay = hourPerDay;
    }

    public double getFeePerHour()
    {
        return m_feePerHour;
    }

    public void setFeePerHour(double feePerHour)
    {
        m_feePerHour = feePerHour;
    }

    public int getHourPerDay()
    {
        return m_hourPerDay;
    }

    public void setHourPerDay(int hourPerDay)
    {
        m_hourPerDay = hourPerDay;
    }

    public double calculatePayment()
    {
        return m_feePerHour * m_hourPerDay * 30;
    }
}
