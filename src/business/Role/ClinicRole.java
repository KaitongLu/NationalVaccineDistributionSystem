/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Role;

import business.Business;
import business.Organization.ClinicOrganization;
import business.Organization.Organization;
import business.UserAccount.UserAccount;
import javax.swing.JPanel;
import ui.Clinic.ClinicWorkAreaJPanel;

/**
 *
 * @author raunak
 */
public class ClinicRole extends Role {

    public ClinicRole() {
        this.type = RoleType.ClinicRole;
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Business business) {
        this.type = RoleType.ClinicRole;
        return new ClinicWorkAreaJPanel(userProcessContainer, account, (ClinicOrganization) organization, business);
    }

}
