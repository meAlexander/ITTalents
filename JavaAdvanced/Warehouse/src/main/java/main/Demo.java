package main;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        Sklad sklad = new Sklad("sklad");
        Shop.sklad = sklad;

        Supplier supplier = new Supplier(sklad);
        supplier.start();

        Shop shop1 = new Shop("Shop 1");
        Shop shop2 = new Shop("Shop 2");
        Shop shop3 = new Shop("Shop 3");
        new Thread(shop1, "Shop 1").start();
        new Thread(shop2, "Shop 2").start();
        new Thread(shop3, "Shop 3").start();

        Client c1 = new Client(shop1);
        Client c2 = new Client(shop1);
        Client c3 = new Client(shop1);
        Client c4 = new Client(shop2);
        Client c5 = new Client(shop2);
        Client c6 = new Client(shop2);
        Client c7 = new Client(shop3);
        Client c8 = new Client(shop3);
        Client c9 = new Client(shop3);

        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();
        c6.start();
        c7.start();
        c8.start();
        c9.start();

        Thread archiver = new Thread(() -> {
            while (true) {
                File f1 = new File("SKLAD.json");
                File f2 = new File("SHOP1.json");
                File f3 = new File("SHOP2.json");
                File f4 = new File("SHOP3.json");
                try {
                    Thread.sleep(3000);
                    Gson gson = new GsonBuilder().setPrettyPrinting().create();

                    saveStatsInFile(sklad, f1, new FileReader(f1), gson);
                    saveStatsInFile(shop1, f2, new FileReader(f2), gson);
                    saveStatsInFile(shop2, f3, new FileReader(f3), gson);
                    saveStatsInFile(shop3, f4, new FileReader(f4), gson);
                } catch (InterruptedException | IOException e) {
                    e.printStackTrace();
                }
            }
        });
        archiver.setDaemon(true);
        archiver.start();
    }

    public static void saveStatsInFile(Sklad sklad, File file, FileReader fileReader, Gson gson) throws IOException {
        JsonObject[] statsArray = gson.fromJson(fileReader, JsonObject[].class);
        fileReader.close();

        List<Stats> statsList = new ArrayList<>();
        //if file is empty(only first time)
        if(statsArray != null) {
            for (JsonObject object : statsArray) {
                Stats stats = gson.fromJson(object.getAsJsonObject(), Stats.class);
                statsList.add(stats);
            }
        }
        Stats statsSklad = sklad.getStats();
        statsList.add(statsSklad);

        PrintWriter printWriter = new PrintWriter(file);
        gson.toJson(statsList, printWriter);

        printWriter.flush();
        printWriter.close();
    }
}