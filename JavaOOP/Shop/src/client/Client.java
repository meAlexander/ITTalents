package client;

import main.Shop;
import products.Product;
import products.ProductPerKilo;
import products.ProductPerNumber;

public class Client {
    private double money;
    private final int maxItems;
    private final Shop shop;
    private final ShoppingBag shoppingBag;

    public Client(double money, int maxItems, Shop shop) {
        this.money = money;
        this.maxItems = maxItems;
        this.shop = shop;
        shoppingBag = new ShoppingBag();
    }

    public double getMoney() {
        return money;
    }

    public int getMaxItems() {
        return maxItems;
    }

    public void addProductPerKiloToShoppingBag(Product product, int kilos) {
        for (int i = 0; i < kilos; i++) {
            shoppingBag.addProductToBag(product);
        }
        shoppingBag.addProductToMapBag(product, kilos);
    }

    public void addProductPerNumberToShoppingBag(Product product, int number) {
        for (int i = 0; i < number; i++) {
            shoppingBag.addProductToBag(product);
        }
        shoppingBag.addProductToMapBag(product, number);
    }

    public void removeProductPerKiloToShoppingBag(ProductPerKilo product, int kilos) {
        for (int i = 0; i < kilos; i++) {
            shoppingBag
                    .getBagProducts()
                    .removeIf(p -> product.getTypeKilo() == p.getTypeKilo());
        }
    }

    public void removeProductPerNumberToShoppingBag(ProductPerNumber product, int number) {
        for (int i = 0; i < number; i++) {
            shoppingBag
                    .getBagProducts()
                    .removeIf(p -> product.getTypeNumber() == p.getTypeNumber());
        }
    }

    public void buyProducts() {
        double sum = 0;
        for (Product p : shoppingBag.getBagProducts()) {
            sum += p.getPrice();
        }
        if (this.money >= sum) {
            for (Product p : shoppingBag.getBagProducts()){
                if(p.getTypeNumber() == null) {
                    shop.sellProductPerKilo(p, shoppingBag.getMap().get(p));
                }else{
                    shop.sellProductPerNumber(p, shoppingBag.getMap().get(p));
                }
                shoppingBag.addProductToMapBag(p, shoppingBag.getMap().get(p));
            }

            this.money -= sum;
            shop.setMoneyInCash(sum);
            System.out.println("Products were bought!");
            shoppingBag.viewBagProducts();
        } else {
            System.out.println("Not enough money to buy products");
        }
    }
}