package vignettes;

import vehicle.VehicleType;

import java.time.LocalDate;

public class TruckVignette extends Vignette{
    public TruckVignette(LocalDate date) {
        super(date, 9, "red", VehicleType.камион);
    }

    @Override
    public String stickToTheGlass() {
        return "Stick to the glass takes 10 seconds!";
    }
}