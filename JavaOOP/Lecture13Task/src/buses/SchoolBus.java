package buses;

import carShops.CarShop;

public class SchoolBus extends Bus {
    private static final int departure= 7;

    public SchoolBus(CarShop carShop, String model, double maxSpeed, double price, String color, int numberOfSeats, int placeForLuggage) {
        super(carShop, model, maxSpeed, price, color, numberOfSeats, placeForLuggage);
    }

    @Override
    public void drive(){
        System.out.println("Driving to school...");
    }

    @Override
    public String toString() {
        return super.toString() + ", SchoolBus{" +
                "departure=" + SchoolBus.departure +
                "}";
    }
}