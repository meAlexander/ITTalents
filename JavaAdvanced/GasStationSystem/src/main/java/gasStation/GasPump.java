package gasStation;

import main.Car;

import java.util.LinkedList;
import java.util.Queue;

public class GasPump {
    private final int kolonkaID;
    private boolean nowLoading;
    private final Queue<Car> cars;

    public GasPump(int kolonkaID) {
        this.kolonkaID = kolonkaID;
        this.cars = new LinkedList<>();
    }

    public int getKolonkaID() {
        return kolonkaID;
    }

    public void addCar(Car car) {
        cars.offer(car);
    }

    public boolean isEmptyGasPump() {
        return this.cars.isEmpty();
    }

    public boolean isNowLoading() {
        return this.nowLoading;
    }

    public void setNowLoading(boolean nowLoading) {
        this.nowLoading = nowLoading;
    }

    public Car getNextCar() {
        return this.cars.peek();
    }

    public void removeCar() {
        this.cars.poll();
    }
}