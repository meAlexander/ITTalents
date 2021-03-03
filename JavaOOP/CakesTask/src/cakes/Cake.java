package cakes;

public abstract class Cake implements Comparable<Cake>{
    private String name;
    private String description;
    private double price;
    private int pieces;
    private String type;
    private int sold = 0;

    public Cake(String name, String description, double price, int pieces, String type) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.pieces = pieces;
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public int getPieces() {
        return pieces;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void increaseSold(){
        this.sold++;
    }

    public int getSold() {
        return sold;
    }
}