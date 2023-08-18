/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Role;

import business.Business;
import business.Organization.CDCOrganization;
import business.Organization.Organization;
import business.UserAccount.UserAccount;
import javax.swing.JPanel;
import ui.CDC.CDCWorkAreaJPanel;

/**
 *
 * @author raunak
 */
public class CDCRole extends Role {

    public CDCRole() {
        this.type = RoleType.CDCRole;
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Business business) {
        this.type = RoleType.CDCRole;
        return new CDCWorkAreaJPanel(userProcessContainer, account, (CDCOrganization) organization, business);
    }

}
