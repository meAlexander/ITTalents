package main;

import cakeShop.CakeShop;
import clients.Client;
import clients.CorporateClient;

import java.util.ArrayList;

public class CakeDemo {
    public static void main(String[] args) {
        CakeShop cakeShop = new CakeShop("Nedelq", "Sofiq", "666666", 5, 30);

        ArrayList<Client> clients = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Client client1 = new CorporateClient("Corporate client" + (i+1), "098456465", cakeShop);
            Client client2 = new CorporateClient("Private client" + (i+1), "0898454613", cakeShop);
            clients.add(client1);
            clients.add(client2);
        }
        System.out.println("======Catalogue before========");
        cakeShop.printCatalogue();
        cakeShop.getRandomDeliver();
        for (int i = 0; i < clients.size(); i++) {
            clients.get(i).makeOrder();
        }
        System.out.println("======Catalogue after========");
        cakeShop.printCatalogue();

        System.out.println("============");
        System.out.println("Profits: " + cakeShop.getProfits());

        System.out.println("=============");
        cakeShop.mostSoldCake();
//        Cake cake = new StandardCake("Standard", "normalna", 22.99, 12, "biscuit", true);
//        Cake cake2 = new SpecialCake("Special", "brutalna", 33.99, 14, "company", "banket");
//        Cake cake3 = new WeddingCake("Wedding", "stava", 322.99, 64, "large", 8);
//        Cake cake4 = new KidCake("Kid", "sladka", 13.99, 8, "birthday", "Mitko");
//
//        TreeMap<Cake, TreeMap<String, ArrayList<Cake>>> catalogue = new TreeMap<>();
//
//        TreeMap<String, ArrayList<Cake>> map = new TreeMap<>();
//        ArrayList<Cake> arr = new ArrayList<>();
//        arr.add(cake);
//        map.put("biscuit", arr);
//
//        TreeMap<String, ArrayList<Cake>> map2 = new TreeMap<>();
//        ArrayList<Cake> arr2 = new ArrayList<>();
//        arr2.add(cake2);
//        map2.put("company", arr2);
//
//        TreeMap<String, ArrayList<Cake>> map3 = new TreeMap<>();
//        ArrayList<Cake> arr3 = new ArrayList<>();
//        arr3.add(cake3);
//        map3.put("large", arr3);
//
//        TreeMap<String, ArrayList<Cake>> map4 = new TreeMap<>();
//        ArrayList<Cake> arr4 = new ArrayList<>();
//        arr4.add(cake4);
//        map4.put("birthday", arr4);
//
//        catalogue.put(cake, map);
//        catalogue.put(cake2, map2);
//        catalogue.put(cake3, map3);
//        catalogue.put(cake4, map4);
    }
}