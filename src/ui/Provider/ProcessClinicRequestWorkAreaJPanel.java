package ui.Provider;

import business.Business;
import business.Inventory.Inventory;
import business.Organization.ClinicOrganization;
import business.Organization.Organization;
import business.Organization.ProviderOrganization;
import business.UserAccount.UserAccount;
import business.Vaccine.Vaccine;
import business.WorkQueue.ClinicWorkRequest;
import business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class ProcessClinicRequestWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount account;
    private ProviderOrganization providerOrganization;
    private Business business;

    public ProcessClinicRequestWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, ProviderOrganization providerOrganization, Business business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.providerOrganization = providerOrganization;
        this.business = business;
        populateVaccineRequestTable();
        populateAssignedVaccineRequestTable();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVaccineRequest = new javax.swing.JTable();
        btnAccept = new javax.swing.JButton();
        btnReject = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblAssignedVaccineRequest = new javax.swing.JTable();
        btnApprove = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1024, 768));

        btnBack.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        btnBack.setText("<<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Vaccine Request From Clinics");

        tblVaccineRequest.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tblVaccineRequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vaccine ID", "Vaccine Name", "Qty", "Status", "Sender", "RequestDate"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblVaccineRequest);

        btnAccept.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnAccept.setText("Assign to me");
        btnAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptActionPerformed(evt);
            }
        });

        btnReject.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnReject.setText("Reject");
        btnReject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRejectActionPerformed(evt);
            }
        });

        tblAssignedVaccineRequest.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tblAssignedVaccineRequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vaccine ID", "Vaccine Name", "Qty", "Status", "Sender", "RequestDate"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblAssignedVaccineRequest);

        btnApprove.setBackground(new java.awt.Color(255, 255, 204));
        btnApprove.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        btnApprove.setText("Approve");
        btnApprove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApproveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAccept, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 975, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(716, 716, 716)
                                .addComponent(btnApprove, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnReject, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)))
                        .addGap(34, 34, 34))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnBack))
                .addGap(57, 57, 57)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAccept)
                .addGap(85, 85, 85)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReject)
                    .addComponent(btnApprove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(254, 254, 254))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblVaccineRequest.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select the row to assign the Clinic Request", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            ClinicWorkRequest c = (ClinicWorkRequest) tblVaccineRequest.getValueAt(selectedRow, 3);
            c.setStatus("Processing");
            c.setReceiver(account);
            populateVaccineRequestTable();
            populateAssignedVaccineRequestTable();
            JOptionPane.showMessageDialog(null, "Request assigned successfully.", "Information", JOptionPane.INFORMATION_MESSAGE);

        }
    }//GEN-LAST:event_btnAcceptActionPerformed

    private void btnRejectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRejectActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblAssignedVaccineRequest.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select the row to Reject the Clinic Request", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            ClinicWorkRequest c = (ClinicWorkRequest) tblAssignedVaccineRequest.getValueAt(selectedRow, 3);
            //check if this task has been processed already
            if (!c.getStatus().equals("Processing")) {
                JOptionPane.showMessageDialog(null, "This request has already been precessed, choose another one!", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }
            c.setStatus("Rejected");
            populateAssignedVaccineRequestTable();
            JOptionPane.showMessageDialog(null, "Request rejected successfully.", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnRejectActionPerformed

    private void btnApproveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApproveActionPerformed
        // TODO add your handling code here:

        int selectedRow = tblAssignedVaccineRequest.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select the row to Approve", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            ClinicWorkRequest c = (ClinicWorkRequest) tblAssignedVaccineRequest.getValueAt(selectedRow, 3);
            //check if this task has been processed already
            if (!c.getStatus().equals("Processing")) {
                JOptionPane.showMessageDialog(null, "Failed. This request has already been processed", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }
            //check if provider has enough vaccine for the clinic
            Vaccine vaccine = c.getVaccine();
            Inventory providerInventory = providerOrganization.getVaccineInventory();// get provider inverntory
            int providerStock = providerInventory.getStockForVaccine(vaccine);
            int approvedQuantity = c.getRequestedQty();
            //if there is not enough stock then return
            if (providerStock < approvedQuantity) {
                JOptionPane.showMessageDialog(null, "Insufficient vaccine stocks!", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }
            //update clinic inventory and provider inventory   
            Organization senderorganization = business.findOrganizationForUserAccount(c.getSender());
            Inventory clinicInventory = ((ClinicOrganization) senderorganization).getVaccineInventory(); // get clinic inventory
            clinicInventory.increaseVaccineStock(c.getVaccine(), approvedQuantity);
            providerInventory.decreaseVaccineStock(c.getVaccine(), approvedQuantity);

            c.setStatus("Approved");
            c.setResolveDate(new Date());
            populateAssignedVaccineRequestTable();
            JOptionPane.showMessageDialog(null, "Request Approved successfully.", "Information", JOptionPane.INFORMATION_MESSAGE);

        }
    }//GEN-LAST:event_btnApproveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccept;
    private javax.swing.JButton btnApprove;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnReject;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblAssignedVaccineRequest;
    private javax.swing.JTable tblVaccineRequest;
    // End of variables declaration//GEN-END:variables

    private void populateVaccineRequestTable() {

        DefaultTableModel model = (DefaultTableModel) tblVaccineRequest.getModel();
        model.setRowCount(0);
        for (ClinicOrganization clinic : providerOrganization.getClinics()) {
            for (WorkRequest work : clinic.getWorkQueue().getWorkRequestList()) {
                if (work.getStatus().equals("Sent to Provider")) {
                    Object[] row = new Object[6];
                    row[0] = work.getVaccine().getVaccineId();
                    row[1] = work.getVaccine().getVaccineName();
                    row[2] = ((ClinicWorkRequest) work).getRequestedQty();
                    row[3] = work;
                    row[4] = work.getSender();
                    row[5] = work.getRequestDate();
                    model.addRow(row);
                }
            }
        }
    }

    private void populateAssignedVaccineRequestTable() {
        DefaultTableModel model = (DefaultTableModel) tblAssignedVaccineRequest.getModel();
        model.setRowCount(0);
        for (ClinicOrganization clinic : providerOrganization.getClinics()) {
            for (WorkRequest work : clinic.getWorkQueue().getWorkRequestList()) {
                if (work.getReceiver() == account) {
                    Object[] row = new Object[6];
                    row[0] = work.getVaccine().getVaccineId();
                    row[1] = work.getVaccine().getVaccineName();
                    row[2] = ((ClinicWorkRequest) work).getRequestedQty();
                    row[3] = work;
                    row[4] = work.getSender();
                    row[5] = work.getRequestDate();
                    model.addRow(row);
                }
            }
        }
    }
}
