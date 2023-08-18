/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.Role;

import business.Business;
import business.Organization.Organization;
import business.Organization.ProviderOrganization;
import business.UserAccount.UserAccount;
import javax.swing.JPanel;
import ui.Provider.ProviderWorkAreaJPanel;

/**
 *
 * @author joyboy
 */
public class ProviderRole extends Role {

    public ProviderRole() {
        this.type = RoleType.ProviderRole;
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Business business) {
        this.type = RoleType.ProviderRole;
        return new ProviderWorkAreaJPanel(userProcessContainer, account, (ProviderOrganization) organization, business);
    }

}
