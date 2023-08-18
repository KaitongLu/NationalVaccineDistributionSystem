/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.Organization;

import business.Role.DistributorRole;
import business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author joyboy
 */
public class DistributorOrganization extends Organization {

    public DistributorOrganization(String name) {
        super(Organization.Type.Distributor, name);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new DistributorRole());
        return roles;
    }

}
