package main;

import enums.FuelType;
import util.Randomizer;

public class Car {
    private final Owner owner;
    private int quantity;
    private final FuelType fuelType;

    public Car() {
        this.owner = new Owner();
        this.fuelType = generateFuelType();
    }

    private FuelType generateFuelType(){
        FuelType[] type = FuelType.values();
        return type[Randomizer.generateInt(type.length-1, 0)];
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public Owner getOwner() {
        return owner;
    }

    public int getQuantity() {
        return quantity;
    }

    public FuelType getFuelType() {
        return fuelType;
    }
}