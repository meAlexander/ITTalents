package cakes;

enum Wedding{
    large,
    small,
    medium
}
public class WeddingCake extends Cake implements Comparable<Cake>{
    private int floors;

    public WeddingCake(String name, String description, double price, int pieces, String type, int floors) {
        super(name, description, price, pieces, type);
        this.floors = floors;
    }


    @Override
    public int compareTo(Cake o) {
        return getPieces() - o.getPieces();
    }
}