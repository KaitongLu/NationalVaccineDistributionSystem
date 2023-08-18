package ui.Provider;

import business.Business;
import business.Organization.ProviderOrganization;
import business.UserAccount.UserAccount;
import business.WorkQueue.DistributorBillingRequest;
import business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mac
 */
public class ProviderBillingWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form BillingWorkAreaJPanel
     */
    private JPanel userProcessContainer;
    private UserAccount account;
    private ProviderOrganization providerOrganization;
    private Business business;

    public ProviderBillingWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, ProviderOrganization providerOrganization, Business business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.providerOrganization = providerOrganization;
        this.business = business;
        populateTblDistBill();
    }

    public void populateTblDistBill() {
        DefaultTableModel model = (DefaultTableModel) tblDistBill.getModel();
        model.setRowCount(0);

        for (WorkRequest work : business.getWorkQueue().getWorkRequestList()) {
            if (work instanceof DistributorBillingRequest && work.getStatus().equals("Pending payment") && work.getReceiver().equals(account)) {
                Object row[] = new Object[7];
                row[0] = work.getVaccine().getVaccineId();
                row[1] = work.getVaccine().getVaccineName();
                row[2] = ((DistributorBillingRequest) work).getTotalPrice();
                row[3] = work;
                row[4] = work.getSender();
                model.addRow(row);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        distBillsJTbl = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnPay = new javax.swing.JButton();
        btnReject = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblDistBill = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();

        distBillsJTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vaccine", "Quantity", "Price", "Status", "Receiver", "Sender"
            }
        ));
        jScrollPane3.setViewportView(distBillsJTbl);

        setPreferredSize(new java.awt.Dimension(1024, 768));

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Billing Work Area");

        btnPay.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        btnPay.setText("Pay");
        btnPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayActionPerformed(evt);
            }
        });

        btnReject.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        btnReject.setText("Reject");
        btnReject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRejectActionPerformed(evt);
            }
        });

        tblDistBill.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vacc_ID", "Vaccine Name", "Price", "Status", "Sender"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblDistBill);
        if (tblDistBill.getColumnModel().getColumnCount() > 0) {
            tblDistBill.getColumnModel().getColumn(0).setPreferredWidth(9);
            tblDistBill.getColumnModel().getColumn(2).setPreferredWidth(9);
        }

        btnBack.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnReject, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 902, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBack)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReject, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRejectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRejectActionPerformed
        // TODO add your handling code here:
//        int selectedRow = tblDistBill.getSelectedRow();
//        if (selectedRow < 0) {
//            JOptionPane.showMessageDialog(null, "Please select bill to accept", "Warning", JOptionPane.WARNING_MESSAGE);
//        } else {
//            ProviderWorkRequest p = (ProviderWorkRequest) tblDistBill.getValueAt(selectedRow, 4);
//            p.setStatus("Payment Rejected");
//            populateTblDistBill();
//            JOptionPane.showMessageDialog(null, "Payment has been rejected!", "Warning", JOptionPane.INFORMATION_MESSAGE);           
//        }
    }//GEN-LAST:event_btnRejectActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblDistBill.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select the row to accept", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            DistributorBillingRequest dbr = (DistributorBillingRequest) tblDistBill.getValueAt(selectedRow, 3);
            dbr.setStatus("Bill Paid");
            populateTblDistBill();
            JOptionPane.showMessageDialog(null, "Payment completed!", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnPayActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnPay;
    private javax.swing.JButton btnReject;
    private javax.swing.JTable distBillsJTbl;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tblDistBill;
    // End of variables declaration//GEN-END:variables
}
