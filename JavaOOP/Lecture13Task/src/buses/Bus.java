package buses;

import main.Car;
import carShops.CarShop;

public class Bus extends Car {
    private final int numberOfSeats;
    private final int placeForLuggage;

    public Bus(CarShop carShop, String model, double maxSpeed, double price, String color, int numberOfSeats, int placeForLuggage) {
        super(carShop, model, maxSpeed, price, color);
        this.numberOfSeats = numberOfSeats;
        this.placeForLuggage = placeForLuggage;
    }

    public void drive(){
        System.out.println("Driving...");
    }

    @Override
    public String toString() {
        return super.toString() + ", Bus{" +
                "numberOfSeats=" + this.numberOfSeats +
                ", placeForLuggage=" + this.placeForLuggage +
                '}';
    }
}