/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.Vaccine;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joyboy
 */
public class VaccineCatalog {

    List<Vaccine> vaccines;

    public VaccineCatalog() {
        vaccines = new ArrayList<>();
    }

    public List<Vaccine> getVaccineList() {
        return vaccines;
    }

    public void setVaccineList(List<Vaccine> vaccines) {
        this.vaccines = vaccines;
    }

    public Vaccine addVaccine(String name, double price, String manufacturerCode) {
        Vaccine vaccine = new Vaccine(name, price, manufacturerCode);
        vaccines.add(vaccine);
        return vaccine;
    }

}
