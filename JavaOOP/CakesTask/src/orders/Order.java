package orders;

import cakes.Cake;
import clients.Client;

import java.util.ArrayList;

public class Order {
    private final Client client;
    private double price;
    private String address;
    private String date;
    private ArrayList<Cake> cakes;

    public Order(Client client, String address, String date, ArrayList<Cake> cakes) {
        this.client = client;
        this.address = address;
        this.date = date;
        this.cakes = cakes;
        int price = 0;

        for (Cake cake : cakes) {
            price += cake.getPrice();
        }
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}