/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.Inventory;

import business.Vaccine.Vaccine;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author joyboy
 */
public class Inventory {

    private Map<Vaccine, Integer> vaccineStock;

    public Inventory() {
        vaccineStock = new HashMap<>();
    }

    public void addVaccine(Vaccine vaccine, int quantity) {
        vaccineStock.put(vaccine, vaccineStock.getOrDefault(vaccine, 0) + quantity);
    }

    public Map<Vaccine, Integer> getVaccineStock() {
        return vaccineStock;
    }

    public void setVaccineStock(Map<Vaccine, Integer> vaccineStock) {
        this.vaccineStock = vaccineStock;
    }

    public int getStockForVaccine(Vaccine vaccine) {
        return vaccineStock.getOrDefault(vaccine, 0);
    }

    public void increaseVaccineStock(Vaccine vaccine, int approvedQuantity) {
        int currentStock = vaccineStock.getOrDefault(vaccine, 0);
        vaccineStock.put(vaccine, currentStock + approvedQuantity);
    }

    public void decreaseVaccineStock(Vaccine vaccine, int usedQuantity) {
        int currentStock = vaccineStock.get(vaccine);
        int newStock = currentStock - usedQuantity;
        vaccineStock.put(vaccine, newStock);
    }

}
