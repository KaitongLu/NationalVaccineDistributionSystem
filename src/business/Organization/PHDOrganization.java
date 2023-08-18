/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Organization;

import business.Role.PHDRole;
import business.Role.Role;
import java.util.ArrayList;
import java.util.List;

public class PHDOrganization extends Organization {

    private List<ProviderOrganization> providers;
    private CDCOrganization parentCDC;
    private String state;

    public PHDOrganization(String name) {
        super(Organization.Type.PHD, name);
        providers = new ArrayList<>();
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new PHDRole());
        return roles;
    }

    public List<ProviderOrganization> getProviders() {
        return providers;
    }

    public void setProviders(List<ProviderOrganization> providers) {
        this.providers = providers;
    }

    public CDCOrganization getParentCDC() {
        return parentCDC;
    }

    public void setParentCDC(CDCOrganization parentCDC) {
        this.parentCDC = parentCDC;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return super.getName();
    }

}
