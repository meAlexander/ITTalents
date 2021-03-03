package cakeShop;

import cakes.*;
import deliverguys.DeliverGuy;
import util.Randomizer;

import java.util.*;

public class CakeShop {
    private final String name;
    private final String address;
    private final String phone;
    private TreeSet<DeliverGuy> deliverGuys;
    private double profits;
    private Catalogue catalogue;

    public CakeShop(String name, String address, String phone, int numOfDeliverGuys, int numOfCakes) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.catalogue = new Catalogue();
        this.deliverGuys = new TreeSet<>();
        for (int i = 0; i < numOfDeliverGuys; i++) {
            this.deliverGuys.add(new DeliverGuy("Delivery guy " + (i + 1)));
        }
        for (int i = 0; i < numOfCakes; i++) {
            generateRandomCakeForFillingCatalogueIn();
        }
        this.catalogue.fillInCatalogue();
    }

    private Cake generateRandomCakeFromCatalogue() {
        int type = Randomizer.randomValue(4, 1);
        switch (type) {
            case 1 -> {
                getKindOfSpecialCake().increaseSold();
                return getKindOfSpecialCake();
            }
            case 2 -> {
                getKindOfWeddingCake().increaseSold();
                return getKindOfWeddingCake();
            }
            case 3 -> {
                getKindOKidCake().increaseSold();
                return getKindOKidCake();
            }
            default -> {
                getKindOfStandardCake().increaseSold();
                return getKindOfStandardCake();
            }
        }
    }

    private void generateRandomCakeForFillingCatalogueIn() {
        int type = Randomizer.randomValue(4, 1);
        switch (type) {
            case 1:
                Catalogue.addStandardCakes(getKindOfStandardCake());
            case 2:
                Catalogue.addWeddingCakes(getKindOfWeddingCake());
            case 3:
                Catalogue.addSpecialCakes(getKindOfSpecialCake());
            default:
                Catalogue.addKidCakes(getKindOKidCake());
        }
    }

    private SpecialCake getKindOfSpecialCake() {
        int kindOfSpecialCake = Randomizer.randomValue(3, 1);
        return switch (kindOfSpecialCake) {
            case 1 -> new SpecialCake("Special", "brutalna", 22.99, 14, "company", "banket");
            case 2 -> new SpecialCake("Special", "pruska", 38.99, 12, "anniversary", "banket");
            default -> new SpecialCake("Special", "biva", 16.99, 10, "advertising", "banket");
        };
    }

    private WeddingCake getKindOfWeddingCake() {
        int kindOfWeddingCake = Randomizer.randomValue(3, 1);
        return switch (kindOfWeddingCake) {
            case 1 -> new WeddingCake("Wedding", "mnogo dobra", 322.99, 64, "large", 18);
            case 2 -> new WeddingCake("Wedding", "dobra", 222.99, 46, "medium", 14);
            default -> new WeddingCake("Wedding", "stava", 122.99, 32, "small", 10);
        };
    }

    private KidCake getKindOKidCake() {
        int kindOKidCake = Randomizer.randomValue(3, 1);
        return switch (kindOKidCake) {
            case 1 -> new KidCake("Kid", "sladka", 9.99, 8, "birthday", "Mitko");
            case 2 -> new KidCake("Kid", "kisela", 18.99, 18, "baptism", "Sashko");
            default -> new KidCake("Kid", "solena", 13.99, 16, "forerunner", "Vasko");
        };
    }

    private StandardCake getKindOfStandardCake() {
        int kindOfStandardCake = Randomizer.randomValue(4, 1);
        return switch (kindOfStandardCake) {
            case 1 -> new StandardCake("Standard", "normalna", 8.99, 8, "biscuit", true);
            case 2 -> new StandardCake("Standard", "skuchna", 25.99, 18, "eclair", false);
            case 3 -> new StandardCake("Standard", "kalorichna", 20.99, 16, "eclair", false);
            default -> new StandardCake("Standard", "interesna", 20.99, 14, "chocolate", true);
        };
    }

    public Cake getCake() {
        Cake cake = generateRandomCakeFromCatalogue();
        for (Iterator<Map.Entry<Cake, TreeMap<String, ArrayList<Cake>>>> i = Catalogue.getCatalogue().entrySet().iterator(); i.hasNext(); ) {
            Map.Entry<Cake, TreeMap<String, ArrayList<Cake>>> a = i.next();

            if (a.getKey().getName().equals(cake.getName()) /*&& a.getKey().getType().equals(cake.getType())*/) {
                for (Iterator<Map.Entry<String, ArrayList<Cake>>> b = a.getValue().entrySet().iterator(); b.hasNext(); ) {
                    Map.Entry<String, ArrayList<Cake>> c = b.next();

                    Cake cake1 = c.getValue().get(0);
                    c.getValue().remove(0);
                    if (c.getValue().size() == 0) {
                        b.remove();
                        if (a.getValue() == null || a.getValue().size() == 0) {
                            i.remove();
                        }
                    }
                    return cake1;
                }
            }
        }
        return null;
    }

    public void mostSoldCake() {
        int max = 0;
        Cake mostSoldCake = null;
        for (Map.Entry<Cake, TreeMap<String, ArrayList<Cake>>> e : Catalogue.getCatalogue().entrySet()) {
            for (Map.Entry<String, ArrayList<Cake>> a : e.getValue().entrySet()) {
                for (Cake b : a.getValue()) {
                    if(b.getSold() > max){
                        mostSoldCake = b;
                        max = b.getSold();
                    }
                }
            }
        }
        System.out.println("Most sold cake is: " + mostSoldCake.getName() + " Type: " +mostSoldCake.getType() + " Sold: " + mostSoldCake.getSold());
    }


    public DeliverGuy getRandomDeliver() {
        int size = deliverGuys.size();
        int item = new Random().nextInt(size); // In real life, the Random object should be rather more shared than this
        int i = 0;
        for(DeliverGuy guy : deliverGuys)
        {
            if (i == item)
                return guy;
            i++;
        }
        return null;
    }

    public void receiveProfits(double profits) {
        this.profits += profits;
    }

    public double getProfits() {
        return profits;
    }

    public void printCatalogue() {
        for (Map.Entry<Cake, TreeMap<String, ArrayList<Cake>>> e : Catalogue.getCatalogue().entrySet()) {
            for (Map.Entry<String, ArrayList<Cake>> a : e.getValue().entrySet()) {
                System.out.print(" Key 2: " + a.getKey());
                for (Cake b : a.getValue()) {
                    System.out.print(" Cake: " + b.getName());
                    System.out.print(" Price: " + b.getPrice());
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public void printDeliveryGuyWithMostOrders(){
        int maxOrders = 0;
        DeliverGuy winner = null;
        for (DeliverGuy guy : deliverGuys){
            if(guy.getOrders().size() > maxOrders){
                winner = guy;
                maxOrders = guy.getOrders().size();
            }
        }
        System.out.println("Delivery guy with most orders is: " + winner.getName() + " with " + maxOrders + " orders");
    }
}