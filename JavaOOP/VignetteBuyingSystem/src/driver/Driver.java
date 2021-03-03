package driver;

import main.GasStation;
import util.Randomizer;
import vehicle.Vehicle;
import vignettes.Vignette;
import vignettes.VignettePeriod;

import java.util.HashSet;
import java.util.TreeSet;

public class Driver {
    private final String name;
    private final HashSet<Vehicle> vehicles;
    private double money;
    private final GasStation gasStation;

    public Driver(String name, double money, GasStation gasStation) {
        vehicles = new HashSet<>();
        this.name = name;
        this.money = money;
        this.gasStation = gasStation;
    }

    public void viewVehicles() {
        System.out.println("Name: " + this.name);
        vehicles.stream()
                .filter(Vehicle::hasVignette)
                .forEach(e -> System.out.print(e.getVehicleType() + ", " + e.getVignettePeriod() + "\n"));
        System.out.println();
    }

    public void addCar(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void buyVignetteForAllVehicles() {
        for (Vehicle v : vehicles) {
            int price = gasStation.soldVignette(v, VignettePeriod.values()[Randomizer
                    .generateInt(VignettePeriod.values().length - 1, 0)]);
            this.money -= price;
            v.stickVignette();
        }
    }

    public void buyVignetteForConcreteVehicle(int vehicleNumberID, VignettePeriod vignettePeriod) {
        for (Vehicle v : vehicles) {
            if (v.getID() == vehicleNumberID && !v.hasVignette()) {
                int price = gasStation.soldVignette(v, vignettePeriod);
                this.money -= price;
                v.stickVignette();
            }
        }
    }

    public void viewAllVehiclesWithExpiryVignette() {
        for(Vehicle v : vehicles){
            if(!v.hasVignette()){
                System.out.println(this.name);
                System.out.println(v.getVehicleType() + " has no vignette!");
            }
        }
    }
}