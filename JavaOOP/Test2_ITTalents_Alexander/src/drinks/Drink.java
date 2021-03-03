package drinks;

import enums.DrinkType;

public abstract class Drink {
    private final DrinkType name;
    private final double price;

    public Drink(DrinkType name, double price) {
        this.name = name;
        this.price = price;
    }

    public DrinkType getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "name=" + name +
                ", price=" + price +
                '}';
    }
}