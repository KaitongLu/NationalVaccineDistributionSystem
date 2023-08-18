/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.Role;

import business.Business;
import business.Organization.Organization;
import business.Organization.PHDOrganization;
import business.UserAccount.UserAccount;
import javax.swing.JPanel;
import ui.PHD.PHDWorkAreaJPanel;

/**
 *
 * @author joyboy
 */
public class PHDRole extends Role {

    public PHDRole() {
        this.type = RoleType.PHDRole;
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Business business) {
        this.type = RoleType.PHDRole;
        return new PHDWorkAreaJPanel(userProcessContainer, account, (PHDOrganization) organization, business);
    }
}
