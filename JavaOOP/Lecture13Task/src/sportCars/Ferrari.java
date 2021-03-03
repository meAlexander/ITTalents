package sportCars;

import carShops.CarShop;

public class Ferrari extends SportCar{
    private static final int doors = 2;
    private static final String emblem = "Horse";

    public Ferrari(CarShop carShop, String model, double maxSpeed, double price, String color, boolean isCabriolet) {
        super(carShop, model, maxSpeed, price, color, isCabriolet);
    }

    @Override
    public String toString() {
        return super.toString() + ", Ferrari{" +
                "doors=" + Ferrari.doors +
                ", emblem=" + Ferrari.emblem +
                '}';
    }
}