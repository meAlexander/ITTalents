package main;

import musicalShop.Shop;

public class Demo {
    public static void main(String[] args) {
        Shop shop = new Shop(500);
        System.out.println("=======View instruments by Type=======");
        shop.viewInstrumentsByType();

        System.out.println("=======View all kind instruments sorted by Type=======");
        shop.viewInstrumentsByName();

        System.out.println("=======View instruments sorted by Price=======");
        shop.viewInstrumentsByPrice();

        System.out.println("=======View all available instruments=======");
        shop.viewAvailableInstruments();

        System.out.println("=======Sell instruments=======");
        shop.sellInstrument("Electronic", "synthesizer", 6);
        shop.sellInstrument("Keyboard", "organ", 3);
        shop.sellInstrument("Percussion", "drum", 5);
        shop.sellInstrument("Spirit", "trombone", 7);
        shop.sellInstrument("Spirit", "trumpet", 4);
        shop.sellInstrument("Electronic", "synthesizer", 3);
        shop.sellInstrument("Keyboard", "organ", 2);
        shop.sellInstrument("Percussion", "drum", 8);
        shop.sellInstrument("Spirit", "trombone", 4);
        shop.sellInstrument("Spirit", "trumpet", 5);

        System.out.println("=======Accept instrument=======");
        shop.acceptInstrument("Electronic", "bassGuitar", 5);

        System.out.println("=======View instruments after Accept and Sell=======");
        shop.viewInstrumentsByName();

        System.out.println("=======View sold instruments=======");
        shop.viewSoldInstrument();

        System.out.println("=======View money in shop=======");
        shop.viewMoneyFromSell();

        System.out.println("=======Most sold instruments=======");
        shop.mostSoldInstruments();

        System.out.println("=======Most unsold instruments=======");
        shop.mostUnsoldInstrument();

        System.out.println("=======Most sold instruments by Type=======");
        shop.mostSoldInstrumentByType();
    }
}