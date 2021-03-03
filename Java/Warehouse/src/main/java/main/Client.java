package main;

import java.util.Random;

public class Client extends Thread{
    private final Shop shop;

    public Client(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        while (true){
            int productsVariety = ProductNames.values().length;
            int randomProductIdx = new Random().nextInt(productsVariety);
            ProductNames name = ProductNames.values()[randomProductIdx];
            shop.zemi(name);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}