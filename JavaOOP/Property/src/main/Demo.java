package main;

import agents.Agent;
import clients.Buyer;
import clients.Seller;
import properties.Apartment;
import properties.House;
import properties.Parcel;
import properties.Property;
import util.Randomizer;

import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        Agency agency = new Agency("Talents Estate");
        ArrayList<Seller> sellers = new ArrayList<>();
        ArrayList<Buyer> buyers = new ArrayList<>();
        ArrayList<Property> properties = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            int chance = Randomizer.generateInt(3, 1);
            Property property = switch (chance) {
                case 1 -> new Apartment("Sofiq", Randomizer.generateDouble(150000, 70000), agency.getRandomAgent());
                case 2 -> new House("Sofiq", Randomizer.generateDouble(80000, 50000), agency.getRandomAgent());
                default -> new Parcel("Sofiq", Randomizer.generateDouble(85000, 30000), agency.getRandomAgent());
            };
            Seller seller = new Seller("Seller" + (i + 1), property);
            sellers.add(seller);

            seller.registerProperty(agency);
            agency.addSeller(seller);
            properties.add(property);
        }

        for (int i = 0; i < 10; i++) {
            Buyer buyer = new Buyer("Buyer" + (i + 1), Randomizer.generateDouble(150000, 30000));
            buyers.add(buyer);
            buyer.makeAResearchForProperty(agency);
        }

        for (Buyer buyer : buyers) {
            for (int i = 0; i < 3; i++) {
                buyer.makeViewOfProperty(agency, agency.getRandomProperty());
            }
            System.out.println("----------");
        }

        System.out.println("=======Buy property=======");
        for (Buyer buyer : buyers) {
            if (!buyer.checkViews())
                buyer.buyProperty(agency);
        }
        System.out.println("=================");
        agency.viewMoneyBalance();
        System.out.println("=================");
        agency.getAgents()
                .stream()
                .sorted(Agent::compareTo)
                .forEach(Agent::viewMoneyBalance);

        System.out.println("=================");
        agency.viewSoldProperties();
    }
}