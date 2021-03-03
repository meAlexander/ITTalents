package vignettes;

import vehicle.VehicleType;

import java.time.LocalDate;

public abstract class Vignette implements Comparable<Vignette>{
    private final LocalDate date;
    private final String color;
    private int price;
    private VignettePeriod vignettePeriod;
    private final VehicleType vehicleType;

    public Vignette(LocalDate date, int price, String color, VehicleType vehicleType) {
        this.date = date;
        this.price = price;
        this.color = color;
        this.vehicleType = vehicleType;
    }

    public abstract String stickToTheGlass();
    public void setVignettePeriod(VignettePeriod vignettePeriod) {
        this.vignettePeriod = vignettePeriod;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getColor() {
        return color;
    }
    public VignettePeriod getVignettePeriod() {
        return vignettePeriod;
    }
    public VehicleType getVehicleType(){
        return this.vehicleType;
    }

    @Override
    public int compareTo(Vignette o) {
        if(this.price > o.price){
            return 1;
        }
        return -1;
    }
}