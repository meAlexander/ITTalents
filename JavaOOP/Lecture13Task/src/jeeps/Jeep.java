package jeeps;

import main.Car;
import carShops.CarShop;

public class Jeep extends Car {
    public Jeep(CarShop carShop, String model, double maxSpeed, double price, String color) {
        super(carShop, model, maxSpeed, price, color);
    }

    public void switch4x4(){
        System.out.println("4x4 is turned on!");
    }

    public void driveOffRoad(){
        System.out.println("Driving offRoad!");
    }

    @Override
    public String toString() {
        return super.toString() + ", Jeep{4x4";
    }
}