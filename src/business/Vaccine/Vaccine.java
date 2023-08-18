package business.Vaccine;

/**
 *
 *
 */
public class Vaccine {

    private String vaccineId;
    private static int vCount;
    private String vaccineName;
    private String manufacturer;
    private double price;

    public Vaccine(String vaccineName, double price, String manufacturer) {
        this.vaccineId = String.valueOf(++vCount); //auto-generate id
        this.vaccineName = vaccineName;
        this.manufacturer = manufacturer;
        this.price = price;

    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getVaccineId() {
        return vaccineId;
    }

    public void setVaccineId(String vaccineId) {
        this.vaccineId = vaccineId;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturerCode) {
        this.manufacturer = manufacturerCode;
    }

    @Override
    public String toString() {
        return vaccineName + " " + manufacturer;
    }

}
