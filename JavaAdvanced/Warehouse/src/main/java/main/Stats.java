package main;

import java.util.Collection;
import java.util.HashMap;

public class Stats {
    private String name;
    private Collection<HashMap<ProductNames, Integer>> products;

    public Stats(String name, Collection<HashMap<ProductNames, Integer>> products) {
        this.name = name;
        this.products = products;
    }
}