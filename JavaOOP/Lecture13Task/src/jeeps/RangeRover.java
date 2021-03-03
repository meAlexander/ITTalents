package jeeps;

import carShops.CarShop;

public class RangeRover extends Jeep{
    private final boolean isSUV;

    public RangeRover(CarShop carShop, String model, double maxSpeed, double price, String color, boolean isSUV) {
        super(carShop, model, maxSpeed, price, color);
        this.isSUV = isSUV;
    }

    @Override
    public String toString() {
        return super.toString() + ", RangeRover{" +
                "isSUV=" + this.isSUV +
                '}';
    }
}