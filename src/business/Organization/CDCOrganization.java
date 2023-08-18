/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Organization;

import business.Role.CDCRole;
import business.Role.Role;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author raunak
 */
public class CDCOrganization extends Organization {

    private List<PHDOrganization> phdOrganizations;

    public CDCOrganization(String name) {
        super(Organization.Type.CDC, name);
        phdOrganizations = new ArrayList<>();
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new CDCRole());
        return roles;
    }

    public List<PHDOrganization> getPhdOrganizations() {
        return phdOrganizations;
    }

    public void setPhdOrganizations(List<PHDOrganization> phdOrganizations) {
        this.phdOrganizations = phdOrganizations;
    }

}
