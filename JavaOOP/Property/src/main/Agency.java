package main;

import agents.Agent;
import clients.Buyer;
import clients.Seller;
import properties.Property;
import util.Randomizer;

import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.TreeSet;

public class Agency {
    private String name;
    private String address;
    private String phone;
    private double moneyBalance;
    private TreeSet<Agent> agents;
    private HashSet<Buyer> buyers;
    private HashSet<Seller> sellers;
    private TreeSet<Property> catalogue;

    public Agency(String name) {
        this.name = name;
        agents = new TreeSet<>();
        buyers = new HashSet<>();
        sellers = new HashSet<>();
        catalogue = new TreeSet<>();

        for (int i = 0; i < 5; i++) {
            agents.add(new Agent("Agent" + (i + 1)));
        }
    }

    public TreeSet<Agent> getAgents() {
        return agents;
    }

    public void addBuyer(Buyer buyer) {
        buyers.add(buyer);
    }

    public void addSeller(Seller seller) {
        sellers.add(seller);
    }

    public TreeSet<Property> getCatalogue() {
        return catalogue;
    }

    public void addPropertyToCatalogue(Property property) {
        catalogue.add(property);
    }

    public void getCommission(double commission) {
        this.moneyBalance += commission;
    }

    public void viewMoneyBalance() {
        this.moneyBalance = Double.parseDouble(new DecimalFormat("#.##")
                .format(this.moneyBalance).replace(',', '.'));
        System.out.println(this.name + " agency money balance: " + this.moneyBalance + " euro");
    }

    public Property getRandomProperty(){
        int item = Randomizer.generateInt(agents.size() - 1, 0);
        int i = 0;

        for (Property property : catalogue) {
            if (i == item)
                return property;
            i++;
        }
        return null;
    }

    public Agent getRandomAgent() {
        int item = Randomizer.generateInt(agents.size() - 1, 0);
        int i = 0;

        for (Agent agent : agents) {
            if (i == item)
                return agent;
            i++;
        }
        return null;
    }

    public void viewSoldProperties(){
        catalogue.stream()
                .filter(e->e.isSold())
                .forEach(e-> System.out.println(e.getPropertyType()));
    }
}