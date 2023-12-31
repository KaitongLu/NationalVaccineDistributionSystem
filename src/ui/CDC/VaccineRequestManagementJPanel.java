/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.CDC;

import business.Business;
import business.Organization.CDCOrganization;
import business.UserAccount.UserAccount;
import business.WorkQueue.ProviderWorkRequest;
import business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author joyboy
 */
public class VaccineRequestManagementJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Business business;
    private UserAccount account;
    private CDCOrganization cdcOrganization;

    public VaccineRequestManagementJPanel(JPanel userProcessContainer, UserAccount account, CDCOrganization cdcOrganization, Business business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.business = business;
        this.cdcOrganization = cdcOrganization;

        populateVaccineRequestTable();
        populateAssignedVaccineRequestTable();
    }

    private void populateVaccineRequestTable() {
        DefaultTableModel model = (DefaultTableModel) tblVaccineRequest.getModel();
        model.setRowCount(0);
        for (WorkRequest work : business.getWorkQueue().getWorkRequestList()) {
            if (work instanceof ProviderWorkRequest && work.getStatus().equals("Forwarded to CDC")) {
                Object[] row = new Object[7];
                row[0] = work.getVaccine().getVaccineId();
                row[1] = work.getVaccine();
                row[2] = ((ProviderWorkRequest) work).getRequestedQty();
                row[3] = work;
                row[4] = work.getReceiver();
                row[5] = work.getSender();
                row[6] = work.getSender(); // need to replace with state later
                model.addRow(row);
            }
        }
    }

    private void populateAssignedVaccineRequestTable() {
        DefaultTableModel model = (DefaultTableModel) tblAssignedVaccineRequest.getModel();
        model.setRowCount(0);
        for (WorkRequest work : business.getWorkQueue().getWorkRequestList()) {
            if (work instanceof ProviderWorkRequest && work.getReceiver() == account) {
                Object[] row = new Object[7];
                row[0] = work.getVaccine().getVaccineId();
                row[1] = work.getVaccine();
                row[2] = ((ProviderWorkRequest) work).getRequestedQty();
                row[3] = work;
                row[4] = work.getReceiver();
                row[5] = work.getSender();
                row[6] = work.getSender(); // need to replace with state later
                model.addRow(row);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tblVaccineRequest = new javax.swing.JTable();
        btnAgree = new javax.swing.JButton();
        tblReject = new javax.swing.JButton();
        backjButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        bntAccept = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblAssignedVaccineRequest = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1024, 768));

        tblVaccineRequest.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tblVaccineRequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vaccine ID", "Vaccine Name", "Qty", "Status", "Receiver", "Sender", "PHDState"
            }
        ));
        jScrollPane2.setViewportView(tblVaccineRequest);
        if (tblVaccineRequest.getColumnModel().getColumnCount() > 0) {
            tblVaccineRequest.getColumnModel().getColumn(2).setPreferredWidth(9);
            tblVaccineRequest.getColumnModel().getColumn(4).setPreferredWidth(12);
            tblVaccineRequest.getColumnModel().getColumn(5).setPreferredWidth(12);
        }

        btnAgree.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnAgree.setText("Agree");
        btnAgree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgreeActionPerformed(evt);
            }
        });

        tblReject.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        tblReject.setText("Reject");
        tblReject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tblRejectActionPerformed(evt);
            }
        });

        backjButton1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        backjButton1.setText("<< Back");
        backjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CDC Vaccine Request");

        bntAccept.setText("Assign to me");
        bntAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntAcceptActionPerformed(evt);
            }
        });

        tblAssignedVaccineRequest.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tblAssignedVaccineRequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vaccine ID", "Vaccine Name", "Qty", "Status", "Receiver", "Sender", "PHDState"
            }
        ));
        jScrollPane3.setViewportView(tblAssignedVaccineRequest);
        if (tblAssignedVaccineRequest.getColumnModel().getColumnCount() > 0) {
            tblAssignedVaccineRequest.getColumnModel().getColumn(2).setPreferredWidth(9);
            tblAssignedVaccineRequest.getColumnModel().getColumn(4).setPreferredWidth(12);
            tblAssignedVaccineRequest.getColumnModel().getColumn(5).setPreferredWidth(12);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAgree, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tblReject, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bntAccept)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(backjButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(backjButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bntAccept)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgree)
                    .addComponent(tblReject))
                .addContainerGap(333, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgreeActionPerformed

        int selectedRow = tblAssignedVaccineRequest.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select the row to Forward request to Distributor", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            ProviderWorkRequest p = (ProviderWorkRequest) tblAssignedVaccineRequest.getValueAt(selectedRow, 3);
            if (!p.getStatus().equals("Processing")) {
                JOptionPane.showMessageDialog(null, "Failed. This request has already been precessed", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }
            p.setStatus("Forwarded to Distributor");
            p.setReceiver(account);
            populateAssignedVaccineRequestTable();
            JOptionPane.showMessageDialog(null, "Request Forwarded to Distributor successfully.", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnAgreeActionPerformed

    private void tblRejectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tblRejectActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblAssignedVaccineRequest.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select the row to Forward request to Distributor", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            ProviderWorkRequest p = (ProviderWorkRequest) tblAssignedVaccineRequest.getValueAt(selectedRow, 3);
            if (!p.getStatus().equals("Processing")) {
                JOptionPane.showMessageDialog(null, "Failed. This request has already been precessed", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }
            p.setStatus("Rejected");
            populateAssignedVaccineRequestTable();
            JOptionPane.showMessageDialog(null, "Request Forwarded to Distributor successfully.", "Warning", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_tblRejectActionPerformed

    private void backjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButton1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);

    }//GEN-LAST:event_backjButton1ActionPerformed

    private void bntAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntAcceptActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblVaccineRequest.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select the row to assign the PHD Request", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            ProviderWorkRequest p = (ProviderWorkRequest) tblVaccineRequest.getValueAt(selectedRow, 3);
            p.setStatus("Processing");
            p.setReceiver(account);
            populateVaccineRequestTable();
            populateAssignedVaccineRequestTable();
            JOptionPane.showMessageDialog(null, "Request assigned successfully.", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_bntAcceptActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backjButton1;
    private javax.swing.JButton bntAccept;
    private javax.swing.JButton btnAgree;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblAssignedVaccineRequest;
    private javax.swing.JButton tblReject;
    private javax.swing.JTable tblVaccineRequest;
    // End of variables declaration//GEN-END:variables
}
