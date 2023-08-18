/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.Organization;

import business.Inventory.Inventory;
import business.Patient.PatientDirectory;
import business.Role.ClinicRole;
import business.Role.Role;
import business.VaccineEvents.VaccineEventDirectory;
import java.util.ArrayList;

/**
 *
 * @author joyboy
 */
public class ClinicOrganization extends Organization {

    private ProviderOrganization parentProvider;
    private Inventory vaccineInventory;
    private PatientDirectory clinicPatientDirectory;
    private VaccineEventDirectory eventDirectory;

    public ClinicOrganization(String name) {
        super(Organization.Type.Clinic, name);
        vaccineInventory = new Inventory();
        clinicPatientDirectory = new PatientDirectory();
        eventDirectory = new VaccineEventDirectory();
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new ClinicRole());
        return roles;
    }

    public Inventory getVaccineInventory() {
        return vaccineInventory;
    }

    public void setVaccineInventory(Inventory vaccineInventory) {
        this.vaccineInventory = vaccineInventory;
    }

    public PatientDirectory getClinicPatientDirectory() {
        return clinicPatientDirectory;
    }

    public void setClinicPatientDirectory(PatientDirectory clinicPatientDirectory) {
        this.clinicPatientDirectory = clinicPatientDirectory;
    }

    public VaccineEventDirectory getEventDirectory() {
        return eventDirectory;
    }

    public void setEventDirectory(VaccineEventDirectory eventDirectory) {
        this.eventDirectory = eventDirectory;
    }

    public ProviderOrganization getParentProvider() {
        return parentProvider;
    }

    public void setParentProvider(ProviderOrganization parentProvider) {
        this.parentProvider = parentProvider;
    }

    @Override
    public String toString() {
        return super.getName();
    }

}
