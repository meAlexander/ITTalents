package products;

import interfaces.IProductPerKilo;
import interfaces.IProductPerNumber;

public abstract class Product implements IProductPerKilo, IProductPerNumber {
    private double price;
    private int quantity;

    public Product(double price, int quantity) {
        this.price = price;
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public ProductPerNumberType getTypeNumber() {
        return null;
    }

    @Override
    public int getNumber() {
        return quantity;
    }

    @Override
    public void setNumber(int number) {
        this.quantity -= number;
    }

    @Override
    public ProductPerKiloType getTypeKilo() {
        return null;
    }

    @Override
    public int getKilos() {
        return quantity;
    }

    @Override
    public void setKilos(double kilos) {
        this.quantity -= kilos;
    }
}