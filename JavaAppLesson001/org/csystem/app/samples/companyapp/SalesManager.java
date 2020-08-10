package org.csystem.app.samples.companyapp;

public class SalesManager extends Manager {
    private double m_extra;

    public SalesManager(String citizenId, String name, String address, String department, double salary, double extra)
    {
        super(citizenId, name, address, department, salary);
        m_extra = extra;
    }

    public double getExtra()
    {
        return m_extra;
    }

    public void setExtra(double extra)
    {
        m_extra = extra;
    }

    public double calculatePayment()
    {
        return super.calculatePayment() + m_extra;
    }
}
