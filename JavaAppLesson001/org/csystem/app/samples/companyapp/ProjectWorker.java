package org.csystem.app.samples.companyapp;

public class ProjectWorker extends Worker {
    private String m_project;

    public ProjectWorker(String citizenId, String name, String address, double feePerHour, int hourPerDay, String project)
    {
        super(citizenId, name, address, feePerHour, hourPerDay);
        m_project = project;
    }

    public String getProject()
    {
        return m_project;
    }

    public void setProject(String project)
    {
        m_project = project;
    }

    public double calculatePayment()
    {
        return super.calculatePayment()  + 1.5;
    }
}
