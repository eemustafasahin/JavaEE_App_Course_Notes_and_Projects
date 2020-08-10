package org.csystem.app.samples.companyapp;

public class Manager extends Employee {
    private String m_department;
    private double m_salary;

    public Manager(String citizenId, String name, String address, String department, double salary)
    {
        super(citizenId, name, address);
        m_department = department;
        m_salary = salary;
    }

    public String getDepartment()
    {
        return m_department;
    }

    public void setDepartment(String department)
    {
        m_department = department;
    }

    public double getSalary()
    {
        return m_salary;
    }

    public void setSalary(double salary)
    {
        m_salary = salary;
    }
    public double calculatePayment()
    {
        return m_salary * m_salary * 0.5;
    }
}
