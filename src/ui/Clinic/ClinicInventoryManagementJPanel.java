/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.Clinic;

import business.Business;
import business.Organization.ClinicOrganization;
import business.UserAccount.UserAccount;
import business.Vaccine.Vaccine;
import java.awt.CardLayout;
import java.util.Map;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author joyboy
 */
public class ClinicInventoryManagementJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount account;
    private ClinicOrganization clinicOrganization;
    private Business business;

    /**
     * Creates new form ClinicInventoryManagementJPanel
     */
    public ClinicInventoryManagementJPanel(JPanel userProcessContainer, UserAccount account, ClinicOrganization clinicOrganization, Business business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.clinicOrganization = clinicOrganization;
        this.business = business;
        populateTbl();
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
        tblClinicInventory = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnRequestVaccine = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1024, 768));

        tblClinicInventory.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tblClinicInventory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vaccine ID", "Vaccine Name", "Stock Qty", "Manufacturer"
            }
        ));
        tblClinicInventory.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblClinicInventory);
        if (tblClinicInventory.getColumnModel().getColumnCount() > 0) {
            tblClinicInventory.getColumnModel().getColumn(2).setPreferredWidth(12);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Clinic Vaccine Inventory Management");

        btnRequestVaccine.setBackground(new java.awt.Color(255, 255, 204));
        btnRequestVaccine.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        btnRequestVaccine.setText("Request Vaccine");
        btnRequestVaccine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestVaccineActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        btnBack.setText("<<Back");
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
                .addComponent(btnBack)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRequestVaccine)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 744, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(99, 99, 99))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBack)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(79, 79, 79)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRequestVaccine)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnRequestVaccineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestVaccineActionPerformed
        // TODO add your handling code here:
        ClinicVaccineRequestJPanel clinicVaccineRequestJPanel = new ClinicVaccineRequestJPanel(userProcessContainer, account, clinicOrganization, business);
        userProcessContainer.add("clinicVaccineRequestJPanel", clinicVaccineRequestJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnRequestVaccineActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRequestVaccine;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblClinicInventory;
    // End of variables declaration//GEN-END:variables

    private void populateTbl() {

        DefaultTableModel dtm = (DefaultTableModel) tblClinicInventory.getModel();
        dtm.setRowCount(0);
        Map<Vaccine, Integer> vaccineStock = clinicOrganization.getVaccineInventory().getVaccineStock();
        for (Vaccine v : clinicOrganization.getVaccineInventory().getVaccineStock().keySet()) {
            Object[] row = new Object[4];
            row[0] = v.getVaccineId();
            row[1] = v.getVaccineName();
            row[2] = vaccineStock.get(v);
            row[3] = v.getManufacturer();
            dtm.addRow(row);
        }
    }
}
