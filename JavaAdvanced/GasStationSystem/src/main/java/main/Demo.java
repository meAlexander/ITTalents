package main;

import gasStation.GasStation;
import gasStation.employees.GasStationAttendant;
import util.CarProducer;

public class Demo {
    public static void main(String[] args) {
        GasStation gasStation = new GasStation("Lukoil");
        CarProducer.gasStation = gasStation;

        GasStationAttendant attendant1 = new GasStationAttendant("Бензинджия 1", gasStation, 1);
        GasStationAttendant attendant2 = new GasStationAttendant("Бензинджия 2", gasStation, 2);

        attendant1.start();
        attendant2.start();

        new CarProducer().start();
        new StatisticsThread().start();
    }
}