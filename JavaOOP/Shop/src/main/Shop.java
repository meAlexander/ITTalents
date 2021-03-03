package main;

import products.*;
import util.Randomizer;

import java.util.*;

public class Shop {
    private final String name;
    private String address;
    private double moneyInCash;
    private final HashSet<Queue<Product>> productHashSet;

    public Shop(String name) {
        this.name = name;
        this.moneyInCash = 0;
        productHashSet = new HashSet<>();
        addProducts();
    }

    public double getMoneyInCash() {
        return moneyInCash;
    }

    public HashSet<Queue<Product>> getProductHashSet() {
        return productHashSet;
    }

    public ArrayList<Product> getProducts() {
        ArrayList<Product> a = new ArrayList<>();
        for (Queue<Product> p : productHashSet) {
            a.addAll(p);
        }
        return a;
    }

    public void viewProducts() {
        productHashSet
                .forEach(e -> e.forEach(System.out::println));
    }

    public void addProducts() {
        for (int i = 0; i < ProductPerKiloType.values().length; i++) {
            Queue<Product> productArrayList = new LinkedList<>();
            Product p1 = new ProductPerKilo(ProductPerKiloType.values()[i],
                    Randomizer.generateDouble(10, 2),
                    Randomizer.generateInt(20, 10));
            for (int j = 0; j < p1.getKilos(); j++) {
                productArrayList.add(p1);
            }
            productHashSet.add(productArrayList);
        }

        for (int i = 0; i < ProductPerNumberType.values().length; i++) {
            Queue<Product> productArrayList2 = new LinkedList<>();
            Product p2 = new ProductPerNumber(ProductPerNumberType.values()[i],
                    Randomizer.generateDouble(10, 2),
                    Randomizer.generateInt(20, 10));
            for (int j = 0; j < p2.getNumber(); j++) {
                productArrayList2.add(p2);
            }
            productHashSet.add(productArrayList2);
        }
    }

    public void setMoneyInCash(double moneyInCash) {
        this.moneyInCash += moneyInCash;
    }

    public void sellProductPerKilo(Product product, int kilos) {
        Iterator<Queue<Product>> setIterator = productHashSet.iterator();

        while (setIterator.hasNext()) {
            Queue<Product> listIterator = setIterator.next();
            Iterator<Product> productIterator = listIterator.iterator();

            while (productIterator.hasNext()) {
                Product a = productIterator.next();
                if (a.getTypeKilo() == product.getTypeKilo()) {
                    if (listIterator.size() > kilos) {
                        a.setKilos(1);
                        productIterator.remove();
                        return;
                    }
                }
                break;
            }
        }
    }

    public void sellProductPerNumber(Product product, int number) {
        Iterator<Queue<Product>> setIterator = productHashSet.iterator();
        Queue<Product> listIterator = setIterator.next();

        while (setIterator.hasNext()) {
            Iterator<Product> productIterator = listIterator.iterator();
            while (productIterator.hasNext()) {
                Product a = productIterator.next();
                if (a.getTypeNumber() == product.getTypeNumber()) {
                    if (listIterator.size() > number) {
                        a.setNumber(1);
                        productIterator.remove();
                        return;
                    }
                }
                break;
            }
            listIterator = setIterator.next();
        }
    }
}