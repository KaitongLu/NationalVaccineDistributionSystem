package ui.Clinic;

import business.Business;
import business.Organization.ClinicOrganization;
import business.Organization.Organization;
import business.Patient.Patient;
import business.UserAccount.UserAccount;
import business.VaccineEvents.VaccineEvent;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 */
public class PatientHistoryJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount account;
    private ClinicOrganization clinicOrganization;
    private Business business;

    public PatientHistoryJPanel(JPanel userProcessContainer, UserAccount account, ClinicOrganization clinicOrganization, Business business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.clinicOrganization = clinicOrganization;
        this.business = business;
        populatePatientTable("", "");
    }

    void populatePatientTable(String patientID, String patientName) {
        DefaultTableModel dtm_ = (DefaultTableModel) tblPatients.getModel();
        dtm_.setRowCount(0);
        for (Patient p : business.getPatientDirectory().getPatientList()) {
            Object[] row = new Object[2];
            row[0] = p;
            row[1] = p.getID();

            boolean nameMatch = patientName.isEmpty() || p.getName().equals(patientName);
            boolean idMatch = patientID.isEmpty() || p.getID().equals(patientID);

            if (nameMatch && idMatch) {
                dtm_.addRow(row);
            }
        }

    }

    void populatePatientHistoryTable(Patient patient) {

        DefaultTableModel dtm_ = (DefaultTableModel) tblPatientHistory.getModel();
        dtm_.setRowCount(0);
        ArrayList<VaccineEvent> veList = new ArrayList();
        Map<VaccineEvent, ClinicOrganization> vaccineEventClinicMap = new HashMap<>();
        for (Organization organization : business.getOrganizationDirectory().getOrganizationList()) {
            if (organization instanceof ClinicOrganization) {
                ClinicOrganization clinic = (ClinicOrganization) organization;
                for (VaccineEvent event : clinic.getEventDirectory().getEvents()) {
                    if (event.getPatient().getID().equals(patient.getID())) {
                        veList.add(event);
                        vaccineEventClinicMap.put(event, clinic);
                    }
                }
            }
        }
        for (VaccineEvent event : veList) {
            Object[] row = new Object[6];
            row[0] = event.getEventDate();
            row[1] = event.getPatient();
            row[2] = event.getPatient().getAge();
            row[3] = event.getVaccine();
            row[4] = event;
            ClinicOrganization clinicForEvent = vaccineEventClinicMap.get(event);
            row[5] = (clinicForEvent != null) ? clinicForEvent.getName() : "N/A";
            dtm_.addRow(row);
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

        jLabel1 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        Scroll = new javax.swing.JScrollPane();
        tblPatientHistory = new javax.swing.JTable();
        btnViewHistory = new javax.swing.JButton();
        Scroll1 = new javax.swing.JScrollPane();
        tblPatients = new javax.swing.JTable();
        btnSearchOverNetwork = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPatientName = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1024, 768));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Patient History");

        btnBack.setFont(new java.awt.Font("Helvetica Neue", 3, 14)); // NOI18N
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        tblPatientHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Injection Date", "Patient Name", "Patient Age", "Vaccine Name", "Adverse Reaction", "Clinic"
            }
        ));
        Scroll.setViewportView(tblPatientHistory);
        if (tblPatientHistory.getColumnModel().getColumnCount() > 0) {
            tblPatientHistory.getColumnModel().getColumn(0).setPreferredWidth(10);
            tblPatientHistory.getColumnModel().getColumn(1).setPreferredWidth(9);
            tblPatientHistory.getColumnModel().getColumn(2).setPreferredWidth(9);
            tblPatientHistory.getColumnModel().getColumn(4).setPreferredWidth(15);
        }

        btnViewHistory.setText("View Patient Vaccine History");
        btnViewHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewHistoryActionPerformed(evt);
            }
        });

        tblPatients.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Patient Name", "Patient ID"
            }
        ));
        Scroll1.setViewportView(tblPatients);
        if (tblPatients.getColumnModel().getColumnCount() > 0) {
            tblPatients.getColumnModel().getColumn(0).setPreferredWidth(10);
            tblPatients.getColumnModel().getColumn(1).setPreferredWidth(9);
        }

        btnSearchOverNetwork.setText("Search Over the NetWork");
        btnSearchOverNetwork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchOverNetworkActionPerformed(evt);
            }
        });

        jLabel2.setText("Patient Name:");

        jLabel3.setText("Patient ID:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(139, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 771, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Scroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPatientName)
                                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnSearchOverNetwork, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(btnViewHistory))
                .addGap(114, 114, 114))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtPatientName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addComponent(btnSearchOverNetwork))
                    .addComponent(Scroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnViewHistory)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(177, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnViewHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewHistoryActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblPatients.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a patient first", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            Patient patient = (Patient) tblPatients.getValueAt(selectedRow, 0);
            populatePatientHistoryTable(patient);
        }
    }//GEN-LAST:event_btnViewHistoryActionPerformed

    private void btnSearchOverNetworkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchOverNetworkActionPerformed
        // TODO add your handling code here:
        String patientID = txtID.getText();
        String patientName = txtPatientName.getText();
        populatePatientTable(patientID, patientName);

    }//GEN-LAST:event_btnSearchOverNetworkActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane Scroll;
    private javax.swing.JScrollPane Scroll1;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSearchOverNetwork;
    private javax.swing.JButton btnViewHistory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTable tblPatientHistory;
    private javax.swing.JTable tblPatients;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtPatientName;
    // End of variables declaration//GEN-END:variables
}
