/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import business.Organization.Organization;
import business.Organization.OrganizationDirectory;
import business.Patient.PatientDirectory;
import business.UserAccount.UserAccount;
import business.Vaccine.VaccineCatalog;
import business.WorkQueue.WorkQueue;

/**
 *
 * @author Administrator
 */
public class Business {

    private static Business business;
    private OrganizationDirectory organizationDirectory;
    private VaccineCatalog vaccineCatalog;
    private WorkQueue workQueue;
    private PatientDirectory patientDirectory;

    public static Business getInstance() {
        if (business == null) {
            business = new Business();
        }
        return business;
    }

    private Business() {
        organizationDirectory = new OrganizationDirectory();
        vaccineCatalog = new VaccineCatalog();
        patientDirectory = new PatientDirectory();
        workQueue = new WorkQueue();
    }

    public PatientDirectory getPatientDirectory() {
        return patientDirectory;
    }

    public void setPatientDirectory(PatientDirectory patientDirectory) {
        this.patientDirectory = patientDirectory;
    }

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public VaccineCatalog getVaccineCatalog() {
        return vaccineCatalog;
    }

    public void setVaccineCatalog(VaccineCatalog vaccineCatalog) {
        this.vaccineCatalog = vaccineCatalog;
    }

    public Organization findOrganizationForUserAccount(UserAccount userAccount) {
        for (Organization organization : organizationDirectory.getOrganizationList()) {
            if (organization.getUserAccountDirectory().hasUserAccount(userAccount)) {
                return organization;
            }
        }
        return null;
    }
}
