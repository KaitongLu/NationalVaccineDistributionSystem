/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.VaccineEvents;

import business.Patient.Patient;
import business.Vaccine.Vaccine;
import java.time.LocalDate;

/**
 *
 * @author joyboy
 */
public class VaccineEvent {

    private LocalDate eventDate;
    private Patient patient;
    private Vaccine vaccine; // Reference to the corresponding vaccine
    private String adverseReaction;

    public VaccineEvent(Patient patient, Vaccine vaccine) {
        this.eventDate = LocalDate.now();
        this.patient = patient;
        this.vaccine = vaccine;
        this.adverseReaction = "NO";
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public String getAdverseReaction() {
        return adverseReaction;
    }

    public void setAdverseReaction(String adverseReaction) {
        this.adverseReaction = adverseReaction;
    }

    @Override
    public String toString() {
        return adverseReaction;
    }

}
