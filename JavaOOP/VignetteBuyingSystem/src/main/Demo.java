package main;

import driver.Driver;
import util.Randomizer;
import vehicle.Vehicle;
import vehicle.VehicleType;
import vignettes.VignettePeriod;

import java.time.LocalDate;
import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        GasStation station = new GasStation();
        ArrayList<Driver> drivers = new ArrayList<>();
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        //station.viewAllAvailableVignettes();

        for (int i = 0; i < 20; i++) {
            Driver driver = new Driver("Driver " + (i + 1),
                    Randomizer.generateInt(4000, 1500), station);
            drivers.add(driver);
        }

        for (int i = 0; i < 200; i++) {
            Vehicle vehicle = new Vehicle(VehicleType
                    .values()[Randomizer.generateInt(VehicleType.values().length - 1, 0)], LocalDate.now()
                    .minusYears(Randomizer.generateInt(20, 1)));
            vehicles.add(vehicle);
        }

        for (int i = 0; i < 20; i++) {
            for (int j = i * 10; j < i * 10 + 10; j++) {
                drivers.get(i).addCar(vehicles.get(j));
            }
        }
        int counter2 = 0;
        int counter = 2;
        for (int i = 0; i < drivers.size(); i++) {
            if (counter == i) {
                for (int j = 0; j < 5; j++) {
                    drivers.get(i).buyVignetteForConcreteVehicle(
                            Randomizer
                                    .generateInt(i * 10 + 10, i * 10 - 1),
                            VignettePeriod.values()[Randomizer
                                    .generateInt(VignettePeriod.values().length - 1, 0)]);
                    counter2++;
                }
                counter += 3;
                continue;
            }
            counter2 += 10;
            drivers.get(i).buyVignetteForAllVehicles();
        }
        drivers.forEach(Driver::viewVehicles);
        drivers.forEach(Driver::viewAllVehiclesWithExpiryVignette);
        //station.viewAllAvailableVignettes();
    }
}