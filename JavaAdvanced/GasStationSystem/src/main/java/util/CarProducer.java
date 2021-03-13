package util;

import gasStation.GasStation;
import main.Car;

public class CarProducer extends Thread{
    public static GasStation gasStation;

    @Override
    public void run() {
        while (true){
            gasStation.addCar(new Car());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}