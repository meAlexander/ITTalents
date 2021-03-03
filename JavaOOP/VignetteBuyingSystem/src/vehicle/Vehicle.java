package vehicle;

import vignettes.Vignette;
import vignettes.VignettePeriod;

import java.time.LocalDate;

public class Vehicle {
    private final VehicleType vehicleType;
    private Vignette vignette;
    private LocalDate yearOfManufacture;
    private int ID = 0;
    private static int IDCounter = 1;

    public Vehicle(VehicleType vehicleType, LocalDate yearOfManufacture) {
        this.vehicleType = vehicleType;
        this.yearOfManufacture = yearOfManufacture;
        this.ID = IDCounter++;
    }

    public void stickVignette(){
        System.out.println(vignette.stickToTheGlass());
    }

    public VignettePeriod getVignettePeriod() {
        return vignette.getVignettePeriod();
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public int getID() {
        return ID;
    }

    public void setVignette(Vignette vignette) {
        this.vignette = vignette;
    }

    public boolean hasVignette() {
        return vignette != null;
    }
}