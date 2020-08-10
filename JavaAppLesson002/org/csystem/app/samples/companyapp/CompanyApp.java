package org.csystem.app.samples.companyapp;

public class CompanyApp {
    public static void run()
    {
        HumanResources humanResources = new HumanResources();
        Worker worker = new Worker("12345678912", "Ali", "mecidiyeköy", 60.5, 8);

        humanResources.payInsurance(worker);

        Manager manager = new Manager("12345676542", "Veli", "Fatih", "yazılım", 200000);

        humanResources.payInsurance(manager);

        ProjectWorker projectWorker = new ProjectWorker("12356789348", "Selami", "şişli", 60.5, 8, "Okul otomasyonu");

        humanResources.payInsurance(projectWorker);

        SalesManager salesManager = new SalesManager("12345676548", "Ayşe", "Beylikdüzü", "yazılım", 10000, 3000);

        humanResources.payInsurance(salesManager);
    }
}
