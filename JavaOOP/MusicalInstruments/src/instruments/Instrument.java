package instruments;

import java.util.Objects;

public class Instrument {
    private final String name;
    private final String type;
    private final double price;
    private int quantity;
    private int sold = 0;

    public Instrument(String name, String type, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getSold() {
        return sold;
    }

    public void setQuantity(int quantity) {
        this.quantity -= quantity;
        sold += quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instrument that = (Instrument) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }

    @Override
    public String toString() {
        return "\nInstrument{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", sold=" + sold +
                '}';
    }
}