package cakes;

enum Kid{
    birthday,
    baptism,
    forerunner
}

public class KidCake extends Cake implements Comparable<Cake>{
    private String kidName;

    public KidCake(String name, String description, double price, int pieces, String type, String kidName) {
        super(name, description, price, pieces, type);
        this.kidName = kidName;
    }

    @Override
    public int compareTo(Cake o) {
        return getPieces() - o.getPieces();
    }
}