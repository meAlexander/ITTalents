package main;

import enums.FruitType;
import util.Randomizer;

public class RakiaTank{
    private FruitType type;
    private int producedRakia;
    private int quantity;
    private final int tankID;
    private boolean boilingStatus;

    public RakiaTank(int i) {
        emptyTank();
        this.type = null;
        this.tankID = i;
    }

    public int getTankID() {
        return this.tankID;
    }

    public boolean getBoilingStatus() {
        return this.boilingStatus;
    }

    public void setBoilingStatus(boolean boiling) {
        this.boilingStatus = boiling;
    }

    public FruitType getType() {
        return this.type;
    }

    public void setType(FruitType type) {
        this.type = type;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void increaseTankQuantity(){
        this.quantity++;
    }

    public void emptyTank(){
        this.quantity = 0;
    }

    public void calculateProducedRakia(){
        this.producedRakia = Randomizer.generateInt(10, 1);
    }

    public int getProducedRakia() {
        return this.producedRakia;
    }
}