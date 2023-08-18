package ui.Provider;

import business.Business;
import business.Organization.ProviderOrganization;
import business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

public class ProviderWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount account;
    private ProviderOrganization providerOrganization;
    private Business business;

    public ProviderWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, ProviderOrganization providerOrganization, Business business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.providerOrganization = providerOrganization;
        this.business = business;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnInventoryManagement = new javax.swing.JButton();
        btnVaccineRequest = new javax.swing.JButton();
        btnDistributorBill = new javax.swing.JButton();
        btnVaccineInventoryManagement = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1024, 768));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Provider Workarea");

        btnInventoryManagement.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnInventoryManagement.setText("Vaccine Event Management");
        btnInventoryManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventoryManagementActionPerformed(evt);
            }
        });

        btnVaccineRequest.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnVaccineRequest.setText("Vaccine Request Management");
        btnVaccineRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVaccineRequestActionPerformed(evt);
            }
        });

        btnDistributorBill.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDistributorBill.setText("Distributor Bills");
        btnDistributorBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDistributorBillActionPerformed(evt);
            }
        });

        btnVaccineInventoryManagement.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnVaccineInventoryManagement.setText("Vaccine Inventory Management");
        btnVaccineInventoryManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVaccineInventoryManagementActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(344, 344, 344)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVaccineInventoryManagement, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDistributorBill, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVaccineRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInventoryManagement, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(365, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106)
                .addComponent(btnVaccineRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(btnVaccineInventoryManagement, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnInventoryManagement, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDistributorBill, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(366, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnInventoryManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventoryManagementActionPerformed
        // TODO add your handling code here:
        ProviderVaccineEventReportJPanel eventReportJPanel = new ProviderVaccineEventReportJPanel(userProcessContainer, account, providerOrganization, business);
        userProcessContainer.add("eventReportJPanel", eventReportJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);

    }//GEN-LAST:event_btnInventoryManagementActionPerformed

    private void btnVaccineRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVaccineRequestActionPerformed
        // TODO add your handling code here:
        ProcessClinicRequestWorkAreaJPanel providerVaccineRequestWorkAreaJPanel = new ProcessClinicRequestWorkAreaJPanel(userProcessContainer, account, providerOrganization, business);
        userProcessContainer.add("ProviderVaccineRequestWorkAreaJPanel", providerVaccineRequestWorkAreaJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);

    }//GEN-LAST:event_btnVaccineRequestActionPerformed

    private void btnDistributorBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDistributorBillActionPerformed
        // TODO add your handling code here:
        ProviderBillingWorkAreaJPanel providerBillingWorkAreaJPanel = new ProviderBillingWorkAreaJPanel(userProcessContainer, account, providerOrganization, business);
        userProcessContainer.add("ProviderBillingWorkAreaJPanel", providerBillingWorkAreaJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnDistributorBillActionPerformed

    private void btnVaccineInventoryManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVaccineInventoryManagementActionPerformed
        // TODO add your handling code here:
        ProviderInventoryManagementJPanel inventoryManagementJPanel = new ProviderInventoryManagementJPanel(userProcessContainer, account, providerOrganization, business);
        userProcessContainer.add("inventoryManagementJPanel", inventoryManagementJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);

    }//GEN-LAST:event_btnVaccineInventoryManagementActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDistributorBill;
    private javax.swing.JButton btnInventoryManagement;
    private javax.swing.JButton btnVaccineInventoryManagement;
    private javax.swing.JButton btnVaccineRequest;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
