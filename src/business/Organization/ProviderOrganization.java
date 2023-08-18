/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.Organization;

import business.Inventory.Inventory;
import business.Role.ProviderRole;
import business.Role.Role;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joyboy
 */
public class ProviderOrganization extends Organization {

    private Inventory vaccineInventory;
    private PHDOrganization parentPHD;
    private List<ClinicOrganization> clinics;

    public ProviderOrganization(String name) {
        super(Organization.Type.Provider, name);
        vaccineInventory = new Inventory();
        clinics = new ArrayList<>();
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new ProviderRole());
        return roles;
    }

    public Inventory getVaccineInventory() {
        return vaccineInventory;
    }

    public void setVaccineInventory(Inventory vaccineInventory) {
        this.vaccineInventory = vaccineInventory;
    }

    public PHDOrganization getParentPHD() {
        return parentPHD;
    }

    public void setParentPHD(PHDOrganization parentPHD) {
        this.parentPHD = parentPHD;
    }

    public List<ClinicOrganization> getClinics() {
        return clinics;
    }

    public void setClinics(List<ClinicOrganization> clinics) {
        this.clinics = clinics;
    }

    @Override
    public String toString() {
        return super.getName();
    }

}
