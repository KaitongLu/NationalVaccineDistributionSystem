/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.VaccineEvents;

import business.Patient.Patient;
import business.Vaccine.Vaccine;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joyboy
 */
public class VaccineEventDirectory {

    List<VaccineEvent> events;

    public VaccineEventDirectory() {
        events = new ArrayList<>();
    }

    public List<VaccineEvent> getEvents() {
        return events;
    }

    public void setEvents(List<VaccineEvent> events) {
        this.events = events;
    }

    public VaccineEvent addEvent(Patient patient, Vaccine vaccine) {
        VaccineEvent event = new VaccineEvent(patient, vaccine);
        events.add(event);
        return event;
    }
}
