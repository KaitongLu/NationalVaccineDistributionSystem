/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.Analytics;

import business.Organization.ClinicOrganization;
import business.Vaccine.Vaccine;
import business.VaccineEvents.VaccineEvent;
import business.VaccineEvents.VaccineEventDirectory;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author joyboy
 */
public class AnalysisHelper {

    private Map<Vaccine, Integer> vaccineEventCountMap;
    private Map<Vaccine, Integer> vaccineAdverseCountMap;

    public AnalysisHelper() {
        vaccineEventCountMap = new HashMap<>();
        vaccineAdverseCountMap = new HashMap<>();
    }

    public void analyzeVaccineEvents(List<ClinicOrganization> clinics) {
        for (ClinicOrganization clinic : clinics) {
            VaccineEventDirectory eventDirectory = clinic.getEventDirectory();
            for (VaccineEvent ve : eventDirectory.getEvents()) {
                Vaccine vaccine = ve.getVaccine();
                vaccineEventCountMap.put(vaccine, vaccineEventCountMap.getOrDefault(vaccine, 0) + 1);

                if (ve.getAdverseReaction().equals("YES")) {
                    vaccineAdverseCountMap.put(vaccine, vaccineAdverseCountMap.getOrDefault(vaccine, 0) + 1);
                }
            }
        }
    }

    public int getEventCountForVaccine(Vaccine vaccine) {
        return vaccineEventCountMap.getOrDefault(vaccine, 0);
    }

    public int getAdverseCountForVaccine(Vaccine vaccine) {
        return vaccineAdverseCountMap.getOrDefault(vaccine, 0);
    }

    public double calculateAdverseReactionRate(int adverseCount, int eventCount) {
        if (eventCount == 0) {
            return 0.0;
        }
        return (double) adverseCount / eventCount;
    }

    public Map<Vaccine, Integer> getVaccineEventCountMap() {
        return vaccineEventCountMap;
    }

    public void setVaccineEventCountMap(Map<Vaccine, Integer> vaccineEventCountMap) {
        this.vaccineEventCountMap = vaccineEventCountMap;
    }

    public Map<Vaccine, Integer> getVaccineAdverseCountMap() {
        return vaccineAdverseCountMap;
    }

    public void setVaccineAdverseCountMap(Map<Vaccine, Integer> vaccineAdverseCountMap) {
        this.vaccineAdverseCountMap = vaccineAdverseCountMap;
    }

}
