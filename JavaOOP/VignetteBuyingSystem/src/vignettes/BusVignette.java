package vignettes;

import vehicle.VehicleType;

import java.time.LocalDate;

public class BusVignette extends Vignette{
    public BusVignette(LocalDate date) {
        super(date, 7, "yellow", VehicleType.автобус);
    }

    @Override
    public String stickToTheGlass() {
        return "Stick to the glass takes 20 seconds!";
    }
}