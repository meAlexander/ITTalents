package sportCars;

import main.Car;
import carShops.CarShop;

public class SportCar extends Car {
    private final boolean isCabriolet;

    public SportCar(CarShop carShop, String model, double maxSpeed, double price, String color, boolean isCabriolet) {
        super(carShop, model, maxSpeed, price, color);
        this.isCabriolet = isCabriolet;
    }

    public void switchTurbo(){
        System.out.println("Turbo is turned on!");
    }

    @Override
    public double calculateCarPriceForScrap(double metalPrice) {
        double coefficient = 0.2;

        if (super.getColor().equals("black") || super.getColor().equals("white")) {
            coefficient += 0.05;
        }

        //because it is a sport car
        coefficient += 0.05;

        return metalPrice * coefficient;
    }

    @Override
    public String toString() {
        return super.toString() + ", SportCar{" +
                "isCabriolet=" + isCabriolet;
    }
}
