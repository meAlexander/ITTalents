package client;

import products.Product;

import java.util.ArrayList;
import java.util.HashMap;

public class ShoppingBag {
    private ArrayList<Product> bagProducts;
    private HashMap<Product, Integer> map;

    public ShoppingBag() {
        this.bagProducts = new ArrayList<>();
        this.map = new HashMap<>();
    }

    public HashMap<Product, Integer> getMap() {
        return map;
    }

    public void viewBagProducts(){
        bagProducts
                .forEach(System.out::println);
    }

    public ArrayList<Product> getBagProducts() {
        return bagProducts;
    }

    public void addProductToBag(Product product) {
         bagProducts.add(product);
    }

    public void addProductToMapBag(Product product, int number) {
        map.put(product, number-1);
    }
}