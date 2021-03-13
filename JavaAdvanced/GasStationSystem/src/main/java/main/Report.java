package main;

import enums.FuelType;

import java.time.LocalDateTime;

public class Report {
    private final int kolonkaID;
    private final FuelType fuelType;
    private final int quantity;
    private final LocalDateTime loadingTime;

    public Report(int kolonkaID, FuelType fuelType, int quantity, LocalDateTime loadingTime) {
        this.kolonkaID = kolonkaID;
        this.fuelType = fuelType;
        this.quantity = quantity;
        this.loadingTime = loadingTime;
    }

    public int getKolonkaID() {
        return kolonkaID;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDateTime getLoadingTime() {
        return loadingTime;
    }
}