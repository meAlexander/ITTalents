package dishes;

import enums.DishType;

public abstract class Dish {
    private final DishType name;
    private final double price;
    private double weight;

    public Dish(DishType name, double price, double weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public DishType getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name=" + name +
                ", price=" + price +
                ", weight=" + weight +
                '}';
    }
}