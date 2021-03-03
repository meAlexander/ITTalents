package main;

import util.Randomizer;
import vehicle.Vehicle;
import vehicle.VehicleType;
import vignettes.*;

import java.time.LocalDate;
import java.util.*;

public class GasStation {
    private double dailyMoney;
    private final HashMap<VignettePeriod, HashMap<VehicleType, ArrayList<Vignette>>> listOfVignettes;

    public GasStation() {
        listOfVignettes = new HashMap<>();
        for (int i = 0; i < 500; i++) {
            generateVignetteVehicleType();
        }
    }

    public HashMap<VignettePeriod, HashMap<VehicleType, ArrayList<Vignette>>> getListOfVignettes() {
        return listOfVignettes;
    }

    public void viewAllAvailableVignettes() {
        TreeSet<Vignette> vignetteTreeSet = new TreeSet<>((e1,e2)->{
            if(e1.getPrice() > e2.getPrice()){
                return 1;
            }
            return -1;
        });
        for (HashMap<VehicleType, ArrayList<Vignette>> a : listOfVignettes.values()) {
            for (ArrayList<Vignette> b : a.values()) {
                vignetteTreeSet.addAll(b);
            }
        }
        vignetteTreeSet.forEach(c -> System.out.println(c.getVehicleType() + ", " +
                c.getVignettePeriod() + ", " + c.getPrice() + ", " +
                c.getColor()));
        System.out.println(vignetteTreeSet.size());
    }

    private void generateVignetteVehicleType() {
        VehicleType[] types = VehicleType.values();
        VehicleType vehicleType = types[Randomizer
                .generateInt(types.length - 1, 0)];

        Vignette vignette;
        switch (vehicleType) {
            case кола:
                vignette = new CarVignette(LocalDate.now());
                break;
            case автобус:
                vignette = new BusVignette(LocalDate.now());
                break;
            default:
                vignette = new TruckVignette(LocalDate.now());
        }
        generateVignettePeriod(vignette);
    }

    private void generateVignettePeriod(Vignette vignette) {
        VignettePeriod[] typePeriods = VignettePeriod.values();
        VignettePeriod period = typePeriods[Randomizer
                .generateInt(typePeriods.length - 1, 0)];
        switch (period) {
            case месечна -> vignette.setPrice(vignette.getPrice() * 10);
            case годишна -> vignette.setPrice(vignette.getPrice() * 60);
        }
        vignette.setVignettePeriod(period);
        addVignette(vignette);
    }

    private void addVignette(Vignette vignette) {
        if (!listOfVignettes.containsKey(vignette.getVignettePeriod())) {
            listOfVignettes.put(vignette.getVignettePeriod(), new HashMap<>());
        }
        if (!listOfVignettes.get(vignette.getVignettePeriod()).containsKey(vignette.getVehicleType())) {
            listOfVignettes.get(vignette.getVignettePeriod()).put(vignette.getVehicleType(), new ArrayList<>());
        }

        listOfVignettes.get(vignette.getVignettePeriod())
                .get(vignette.getVehicleType()).add(vignette);
    }

    public int soldVignette(Vehicle vehicle, VignettePeriod vignettePeriod){
        if (listOfVignettes.containsKey(vignettePeriod)) {
            if (listOfVignettes.get(vignettePeriod).containsKey(vehicle.getVehicleType())) {
                Vignette vignette = listOfVignettes.get(vignettePeriod)
                        .get(vehicle.getVehicleType()).get(listOfVignettes.get(vignettePeriod)
                                .get(vehicle.getVehicleType()).size()-1);
                vehicle.setVignette(vignette);

                listOfVignettes.get(vignettePeriod)
                        .get(vehicle.getVehicleType()).remove(vignette);
                return vignette.getPrice();
            }else{
                System.out.println("No available vignette for this vehicle!");
            }
        }else{
            System.out.println("No available vignette for this period!");
        }
        return 0;
    }
}