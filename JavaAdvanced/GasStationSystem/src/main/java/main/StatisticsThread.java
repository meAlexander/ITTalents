package main;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import enums.FuelType;
import util.DBConnector;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.*;

public class StatisticsThread extends Thread {
    private static int stats1Counter = 1;

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("----------------------------------");
            listOfAllFuelLoadings();
            System.out.println("----------------------------------");
            listOfAllLoadedCarsByGasPump();
            System.out.println("----------------------------------");
            listOfAllLoadedFuelsByType();
            System.out.println("----------------------------------");
            listOfSumsReceivedFromFuels();
            System.out.println("----------------------------------");
        }
    }

    private void saveToFile2(Map<Integer, HashSet<Report>> stats) {
        try (PrintWriter pr = new PrintWriter("report-" + stats1Counter++ + "-"
                + LocalDateTime.now().toString().replace(":", "-").replace("\\.", "-") + ".txt")) {
            for (Map.Entry<Integer, HashSet<Report>> e : stats.entrySet()) {
                pr.println("Колонка " + e.getKey() + ":");
                for (Report report : e.getValue()) {
                    pr.println("\t" + report.getFuelType() + ", " + report.getQuantity() + " литра, " +
                            report.getLoadingTime());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Invalid INSERTION TO .TXT file. Reason - " + e.getMessage());
        }
    }

    private void saveToFile(Map<Integer, HashSet<Report>> stats) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter report = new FileWriter("report-" + stats1Counter++ + "-"
                + LocalDateTime.now().toString().replace(":", "-").replace("\\.", "-") + ".json")) {
            gson.toJson(stats, report);
        } catch (IOException e) {
            System.out.println("Invalid INSERTION TO .JSON file. Reason - " + e.getMessage());
        }
    }

    private void listOfAllFuelLoadings() {
        Map<Integer, HashSet<Report>> stats = new HashMap<>();

        String sqlQuery = "SELECT kolonka_id, fuel_type, fuel_quantity, loading_time " +
                "FROM station_loadings " +
                "ORDER BY kolonka_id, loading_time ASC;";

        Connection c = DBConnector.getInstance().getConnection();
        try (PreparedStatement ps = c.prepareStatement(sqlQuery);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Report report = new Report(
                        rs.getInt("kolonka_id"),
                        FuelType.valueOf(rs.getString("fuel_type")),
                        rs.getInt("fuel_quantity"),
                        rs.getTimestamp("loading_time").toLocalDateTime()
                );
                if (!stats.containsKey(report.getKolonkaID())) {
                    stats.put(report.getKolonkaID(), new HashSet<>());
                }
                stats.get(report.getKolonkaID()).add(report);
            }

            for (Map.Entry<Integer, HashSet<Report>> map : stats.entrySet()) {
                System.out.println("Колонка " + map.getKey() + ":");
                for (Report report : map.getValue()) {
                    System.out.println("\t" + report.getFuelType() + ", " + report.getQuantity() + " литра, " +
                            report.getLoadingTime());
                }
            }
            saveToFile(stats);
            saveToFile2(stats);
        } catch (SQLException e) {
            System.out.println("Invalid SELECT operation. Reason - " + e.getMessage());
        }
    }

    private void listOfAllLoadedCarsByGasPump() {
        Map<Integer, Integer> stats = new HashMap<>();

        String sqlQuery = "SELECT kolonka_id, COUNT(order_id) as car_quantity " +
                "FROM station_loadings " +
                "GROUP BY kolonka_id " +
                "ORDER BY kolonka_id;";

        Connection c = DBConnector.getInstance().getConnection();
        try (PreparedStatement ps = c.prepareStatement(sqlQuery);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                stats.put(rs.getInt("kolonka_id"), rs.getInt("car_quantity"));
            }
            for (Map.Entry<Integer, Integer> map : stats.entrySet()) {
                System.out.println("Колонка " + map.getKey() + ": " + map.getValue() + " автомобила");
            }
        } catch (SQLException e) {
            System.out.println("Invalid SELECT operation. Reason - " + e.getMessage());
        }
    }

    private void listOfAllLoadedFuelsByType() {
        Map<String, Integer> stats = new HashMap<>();

        String sqlQuery = "SELECT fuel_type, SUM(fuel_quantity) AS fuel_quantity " +
                "FROM station_loadings " +
                "GROUP BY fuel_type;";

        Connection c = DBConnector.getInstance().getConnection();
        try (PreparedStatement ps = c.prepareStatement(sqlQuery);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                stats.put(rs.getString("fuel_type"), rs.getInt("fuel_quantity"));
            }
            for (Map.Entry<String, Integer> map : stats.entrySet()) {
                System.out.println(map.getKey() + ": " + map.getValue() + " литра");
            }
        } catch (SQLException e) {
            System.out.println("Invalid SELECT operation. Reason - " + e.getMessage());
        }
    }

    private void listOfSumsReceivedFromFuels() {
        String sqlQuery = "SELECT fuel_type, SUM(fuel_quantity) as fuel_quantity, " +
                "CASE fuel_type " +
                "WHEN \"petrol\" THEN SUM(fuel_quantity) * 2.40 " +
                "WHEN \"gas\" THEN SUM(fuel_quantity) * 1.60 " +
                "ELSE SUM(fuel_quantity) * 2 " +
                "END AS price " +
                "FROM station_loadings " +
                "GROUP BY fuel_type;";

        Connection c = DBConnector.getInstance().getConnection();
        try (PreparedStatement ps = c.prepareStatement(sqlQuery);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                System.out.println(
                        rs.getString("fuel_type") + ": " +
                                rs.getString("fuel_quantity") + " литра, " +
                                rs.getDouble("price") + " лева");
            }
        } catch (SQLException e) {
            System.out.println("Invalid SELECT operation. Reason - " + e.getMessage());
        }
    }
}