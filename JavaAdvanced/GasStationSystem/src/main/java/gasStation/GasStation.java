package gasStation;

import gasStation.employees.GasStationAttendant;
import main.Car;
import main.Report;
import util.DBConnector;
import util.Randomizer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

public class GasStation {
    private final String name;
    private final List<GasPump> gasPumps;
    private final PayDesk payDesk1;
    private final PayDesk payDesk2;
    private final HashSet<Report> reports;

    public GasStation(String name) {
        this.name = name;
        this.reports = new HashSet<>();
        this.payDesk1 = new PayDesk(1);
        this.payDesk2 = new PayDesk(2);
        this.gasPumps = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            this.gasPumps.add(new GasPump(i));
        }
    }

    private boolean isEmpty() {
        for (GasPump gasPump : this.gasPumps) {
            if (!gasPump.isEmptyGasPump() && !gasPump.isNowLoading()) {
                return false;
            }
        }
        return true;
    }

    public synchronized void addCar(Car car) {
        this.gasPumps.get(Randomizer.generateInt(gasPumps.size() - 1, 0)).addCar(car);
        notifyAll();
    }

    private GasPump getGasPump() throws Exception {
        Collections.shuffle(this.gasPumps);
        for (GasPump gasPump : this.gasPumps) {
            if (!gasPump.isEmptyGasPump() && !gasPump.isNowLoading()) {
                return gasPump;
            }
        }
        throw new Exception("Trying to get dock for unloading from empty port!");
    }

    public void loadFuel(GasStationAttendant attendant) throws Exception {
        GasPump gasPump;
        Car car;
        synchronized (this) {
            while (isEmpty()) {
                try {
                    System.out.println(attendant.getName() + ": Няма коли за зареждане. Изчаквам...");
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            gasPump = getGasPump();
            gasPump.setNowLoading(true);
            car = gasPump.getNextCar();
        }
        System.out.println("Колата на " + car.getOwner().getName() +
                " се зарежда.... от " + attendant.getName() + " на колонка " + gasPump.getKolonkaID());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        car.setQuantity(Randomizer.generateInt(40, 10));
        System.out.println("Колата на " + car.getOwner().getName() + " бе заредена с " + car.getQuantity() + " литра " + car.getFuelType());

        gasPump.removeCar();
        gasPump.setNowLoading(false);
        System.out.println("Колата на клиент " + car.getOwner().getName() + " е преместена от колонката и клиентът отива да плаща..");
        getRandomPayDesk().addCarOwner(car.getOwner());

        logInformation(gasPump.getKolonkaID(), attendant.getGasStationAttendantID(), car);
    }

    private PayDesk getRandomPayDesk() {
        Random random = new Random();
        if (random.nextBoolean()) {
            return this.payDesk1;
        }
        return this.payDesk2;
    }

    private void logInformation(int kolonka_id, int attendantID, Car car) {
        this.reports
                .add(new Report(kolonka_id, car.getFuelType(), car.getQuantity(), LocalDateTime.now()));
        saveToDB(kolonka_id, attendantID, car);
    }

    private void saveToDB(int kolonka_id, int attendantID, Car car) {
        String insertQuery = "INSERT INTO station_loadings (kolonka_id, fuel_type, " +
                "fuel_quantity, loading_time, " +
                "owner_id, benzindjiq_id) " +
                "VALUES (?,?,?,?,?,?)";
        Connection c = DBConnector.getInstance().getConnection();
        try (PreparedStatement ps = c.prepareStatement(insertQuery)) {
            ps.setInt(1, kolonka_id);
            ps.setString(2, car.getFuelType().toString());
            ps.setInt(3, car.getQuantity());
            ps.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            ps.setInt(5, car.getOwner().getOwnerID());
            ps.setInt(6, attendantID);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Invalid INSERTION TO DB. Reason - " + e.getMessage());
        }
    }
}