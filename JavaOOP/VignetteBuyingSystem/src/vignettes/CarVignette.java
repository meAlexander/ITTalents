package vignettes;

import vehicle.VehicleType;

import java.time.LocalDate;

public class CarVignette extends Vignette {
    public CarVignette(LocalDate date) {
        super(date, 5, "green", VehicleType.кола);
    }

    @Override
    public String stickToTheGlass() {
        return "Stick to the glass takes 5 seconds!";
    }
}