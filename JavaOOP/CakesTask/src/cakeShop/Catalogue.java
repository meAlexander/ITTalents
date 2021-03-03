package cakeShop;

import cakes.*;

import java.util.ArrayList;
import java.util.TreeMap;

public class Catalogue {
    private static final TreeMap<Cake, TreeMap<String, ArrayList<Cake>>> catalogue = new TreeMap<>();
    protected static ArrayList<StandardCake> standardCakes = new ArrayList<>();
    protected static ArrayList<WeddingCake> weddingCakes = new ArrayList<>();
    protected static ArrayList<SpecialCake> specialCakes = new ArrayList<>();
    protected static ArrayList<KidCake> kidCakes = new ArrayList<>();

    public void fillInCatalogue(){
        addStandard();
        addWedding();
        addSpecial();
        addKid();
    }

    private void addKid() {
        TreeMap<String, ArrayList<Cake>> kid = new TreeMap<>();
        ArrayList<Cake> kidBirthdayCakes = new ArrayList<>();
        ArrayList<Cake> kidBaptismCakes = new ArrayList<>();
        ArrayList<Cake> kidForerunnerCakes = new ArrayList<>();
        Cake cake = null;
        for (KidCake standardCake : kidCakes) {
            cake = standardCake;
            switch (cake.getType()) {
                case "birthday":
                    kidBirthdayCakes.add(cake);
                case "baptism":
                    kidBaptismCakes.add(cake);
                case "forerunner":
                    kidForerunnerCakes.add(cake);
            }
        }
        kid.put("birthday", kidBirthdayCakes);
        kid.put("baptism", kidBaptismCakes);
        kid.put("forerunner", kidForerunnerCakes);
        Catalogue.catalogue.put(cake, kid);
    }

    private void addSpecial() {
        TreeMap<String, ArrayList<Cake>> special = new TreeMap<>();
        ArrayList<Cake> specialAnniversaryCakes = new ArrayList<>();
        ArrayList<Cake> specialCompanyCakes = new ArrayList<>();
        ArrayList<Cake> specialAdvertisingCakes = new ArrayList<>();
        Cake cake = null;
        for (SpecialCake standardCake : specialCakes) {
            cake = standardCake;
            switch (cake.getType()) {
                case "anniversary":
                    specialAnniversaryCakes.add(cake);
                case "company":
                    specialCompanyCakes.add(cake);
                case "advertising":
                    specialAdvertisingCakes.add(cake);
            }
        }
        special.put("anniversary", specialAnniversaryCakes);
        special.put("company", specialCompanyCakes);
        special.put("advertising", specialAdvertisingCakes);
        Catalogue.catalogue.put(cake, special);
    }

    private void addWedding() {
        TreeMap<String, ArrayList<Cake>> wedding = new TreeMap<>();
        ArrayList<Cake> weddingLargeCakes = new ArrayList<>();
        ArrayList<Cake> weddingMediumCakes = new ArrayList<>();
        ArrayList<Cake> weddingSmallCakes = new ArrayList<>();
        Cake cake = null;
        for (WeddingCake standardCake : weddingCakes) {
            cake = standardCake;
            switch (cake.getType()) {
                case "large":
                    weddingLargeCakes.add(cake);
                case "medium":
                    weddingMediumCakes.add(cake);
                case "small":
                    weddingSmallCakes.add(cake);
            }
        }
        wedding.put("large", weddingLargeCakes);
        wedding.put("medium", weddingMediumCakes);
        wedding.put("small", weddingSmallCakes);
        Catalogue.catalogue.put(cake, wedding);
    }

    private void addStandard() {
        TreeMap<String, ArrayList<Cake>> standard = new TreeMap<>();
        ArrayList<Cake> standardBiscuitCakes = new ArrayList<>();
        ArrayList<Cake> standardChocolateCakes = new ArrayList<>();
        ArrayList<Cake> standardFruitCakes = new ArrayList<>();
        ArrayList<Cake> standardEclairCakes = new ArrayList<>();
        Cake cake = null;
        for (StandardCake standardCake : standardCakes) {
            cake = standardCake;
            switch (cake.getType()) {
                case "biscuit":
                    standardBiscuitCakes.add(cake);
                case "chocolate":
                    standardChocolateCakes.add(cake);
                case "fruit":
                    standardFruitCakes.add(cake);
                case "eclair":
                    standardEclairCakes.add(cake);
            }
        }
        standard.put("biscuit", standardBiscuitCakes);
        standard.put("chocolate", standardChocolateCakes);
        standard.put("fruit", standardFruitCakes);
        standard.put("eclair", standardEclairCakes);
        Catalogue.catalogue.put(cake, standard);
    }

    public static TreeMap<Cake, TreeMap<String, ArrayList<Cake>>> getCatalogue(){
        return Catalogue.catalogue;
    }

    public static void addStandardCakes(StandardCake standardCake){
        standardCakes.add(standardCake);
    }

    public static void addWeddingCakes(WeddingCake weddingCake){
        weddingCakes.add(weddingCake);
    }

    public static void addSpecialCakes(SpecialCake specialCake){
        specialCakes.add(specialCake);
    }

    public static void addKidCakes(KidCake kidCake){
        kidCakes.add(kidCake);
    }
}