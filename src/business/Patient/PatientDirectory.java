/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.Patient;

import java.util.ArrayList;

/**
 *
 * @author joyboy
 */
public class PatientDirectory {

    ArrayList<Patient> patientList;

    public PatientDirectory() {

        patientList = new ArrayList<>();
    }

    public ArrayList<Patient> getPatientList() {
        return patientList;
    }

    public Patient newPatient(String name, String age, String ID) {
        Patient p = new Patient(name, age, ID);
        patientList.add(p);
        return p;
    }

    public Patient findPatientByName(String name) {
        for (Patient p : patientList) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }

}
