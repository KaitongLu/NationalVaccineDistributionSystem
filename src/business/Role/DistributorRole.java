/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.Role;

import business.Business;
import business.Organization.DistributorOrganization;
import business.Organization.Organization;
import business.UserAccount.UserAccount;
import javax.swing.JPanel;
import ui.Distributor.DistributorWorkAreaJPanel;

/**
 *
 * @author joyboy
 */
public class DistributorRole extends Role {

    public DistributorRole() {
        this.type = RoleType.DistributorRole;
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Business business) {
        this.type = Role.RoleType.DistributorRole;
        return new DistributorWorkAreaJPanel(userProcessContainer, account, (DistributorOrganization) organization, business);
    }

}
