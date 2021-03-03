package main;

import client.Client;
import util.Randomizer;

import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        Shop shop = new Shop("CBA");
        ArrayList<Client> clients = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Client client = new Client(Randomizer.generateInt(10000, 5000), 12, shop);
            clients.add(client);
        }

        System.out.println("Products: ");
        shop.viewProducts();

        for(Client c : clients){
            for (int i = 0; i < c.getMaxItems(); i++) {
                c.addProductPerKiloToShoppingBag(shop
                                .getProducts().get(Randomizer.generateInt(shop
                                                .getProducts().size() - 1, 0)),
                        Randomizer.generateInt(2, 1));

                c.addProductPerNumberToShoppingBag(shop
                                .getProducts().get(Randomizer.generateInt(shop
                                                .getProducts().size() - 1, 0)),
                        Randomizer.generateInt(2, 1));
            }
            c.buyProducts();
        }
        System.out.println("========================");
        shop.viewProducts();
        System.out.println(shop.getMoneyInCash());
    }
}