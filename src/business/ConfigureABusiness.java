package business;

import business.Employee.Employee;
import business.Employee.EmployeeDirectory;
import business.Inventory.Inventory;
import business.Organization.AdminOrganization;
import business.Organization.CDCOrganization;
import business.Organization.ClinicOrganization;
import business.Organization.DistributorOrganization;
import business.Organization.Organization;
import business.Organization.PHDOrganization;
import business.Organization.ProviderOrganization;
import business.Patient.PatientDirectory;
import business.Role.AdminRole;
import business.Role.CDCRole;
import business.Role.ClinicRole;
import business.Role.DistributorRole;
import business.Role.PHDRole;
import business.Role.ProviderRole;
import business.UserAccount.UserAccountDirectory;
import business.Vaccine.Vaccine;
import business.Vaccine.VaccineCatalog;

public class ConfigureABusiness {

    public static Business configure() {

        Business business = Business.getInstance();
        //create admin organization
        AdminOrganization adminOrganization = new AdminOrganization("admin");
        business.getOrganizationDirectory().getOrganizationList().add(adminOrganization);
        EmployeeDirectory adminEmployeeDirectory = adminOrganization.getEmployeeDirectory();
        Employee adminEmployee = adminEmployeeDirectory.createEmployee("AdminEmployee");
        UserAccountDirectory adminUserAccountDirectory = adminOrganization.getUserAccountDirectory();
        adminUserAccountDirectory.createUserAccount("admin", "admin", adminEmployee, new AdminRole());

        //create cdc organization and employee
        CDCOrganization cdcOrganization = (CDCOrganization) business.getOrganizationDirectory().createOrganization(Organization.Type.CDC, "CDC");
        EmployeeDirectory cdcEmployeeDirectory = cdcOrganization.getEmployeeDirectory();
        Employee cdcEmployee = cdcEmployeeDirectory.createEmployee("CDCEmployee");
        UserAccountDirectory cdcUserAccountDirectory = cdcOrganization.getUserAccountDirectory();
        cdcUserAccountDirectory.createUserAccount("cdc", "cdc", cdcEmployee, new CDCRole());

        //create PHD organization and employee
        PHDOrganization phdOrganization1 = (PHDOrganization) business.getOrganizationDirectory().createOrganization(Organization.Type.PHD, cdcOrganization, "PHD-WA");
        EmployeeDirectory phdEmployeeDirectory = phdOrganization1.getEmployeeDirectory();
        Employee phdEmployee = phdEmployeeDirectory.createEmployee("PHDEmployee");
        UserAccountDirectory phdUserAccountDirectory = phdOrganization1.getUserAccountDirectory();
        phdUserAccountDirectory.createUserAccount("phd", "phd", phdEmployee, new PHDRole());
        phdOrganization1.setState("WA");

        //create Provider organization and employee
        ProviderOrganization providerOrganization = (ProviderOrganization) business.getOrganizationDirectory().createOrganization(Organization.Type.Provider, phdOrganization1, "Seattle Hospital");
        EmployeeDirectory providerEmployeeDirectory = providerOrganization.getEmployeeDirectory();
        Employee providerEmployee = providerEmployeeDirectory.createEmployee("ProviderEmployee");
        UserAccountDirectory providerUserAccountDirectory = providerOrganization.getUserAccountDirectory();
        providerUserAccountDirectory.createUserAccount("provider", "provider", providerEmployee, new ProviderRole());

        //create clinic organization and employee
        ClinicOrganization clinicOrganization = (ClinicOrganization) business.getOrganizationDirectory().createOrganization(Organization.Type.Clinic, providerOrganization, "Slu csv");
        EmployeeDirectory clinicEmployeeDirectory = clinicOrganization.getEmployeeDirectory();
        Employee clinicEmployee = clinicEmployeeDirectory.createEmployee("ClinicEmployee");
        UserAccountDirectory clinicUserAccountDirectory = clinicOrganization.getUserAccountDirectory();
        clinicUserAccountDirectory.createUserAccount("clinic", "clinic", clinicEmployee, new ClinicRole());

        //create Distributor organization and employee
        DistributorOrganization distributorOrganization = (DistributorOrganization) business.getOrganizationDirectory().createOrganization(Organization.Type.Distributor, "Distributor");
        EmployeeDirectory distributorEmployeeDirectory = distributorOrganization.getEmployeeDirectory();
        Employee distributorEmployee = distributorEmployeeDirectory.createEmployee("DistributorEmployee");
        UserAccountDirectory distributorUserAccountDirectory = distributorOrganization.getUserAccountDirectory();
        distributorUserAccountDirectory.createUserAccount("distributor", "distributor", distributorEmployee, new DistributorRole());

        //create vaccine 
        VaccineCatalog vaccineCatalog = business.getVaccineCatalog();
        Vaccine vaccineFlue = vaccineCatalog.addVaccine("FlueVaccine", 20.0, "Mfr.A");
        Vaccine vaccineCovid = vaccineCatalog.addVaccine("CovidVaccine", 50.0, "Mfr.B");

        //create clinie inventroy
        Inventory clinicInventroy = clinicOrganization.getVaccineInventory();
        clinicInventroy.getVaccineStock().put(vaccineFlue, 5);
        clinicInventroy.getVaccineStock().put(vaccineCovid, 10);

        //create provider inventroy
        Inventory providerInventroy = providerOrganization.getVaccineInventory();
        providerInventroy.getVaccineStock().put(vaccineFlue, 50);
        providerInventroy.getVaccineStock().put(vaccineCovid, 100);
        
        //create patients and vaccine events
        PatientDirectory patientDirectory = business.getPatientDirectory();
        patientDirectory.newPatient("PatientA", "20", "WDL123");
        patientDirectory.newPatient("PatientB", "21", "WDL234");

        return business;
    }

}
