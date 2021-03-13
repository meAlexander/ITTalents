package gasStation.employees;

import gasStation.GasStation;

public class GasStationAttendant extends Thread{
    private final GasStation gasStation;
    private final int gasStationAttendantID;

    public GasStationAttendant(String name, GasStation gasStation, int ID) {
        super(name);
        this.gasStation = gasStation;
        this.gasStationAttendantID = ID;
    }

    public int getGasStationAttendantID() {
        return gasStationAttendantID;
    }

    @Override
    public void run() {
        while (true){
            try {
                gasStation.loadFuel(this);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}