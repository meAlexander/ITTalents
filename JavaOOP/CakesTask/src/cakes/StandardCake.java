package cakes;

enum StandardCakes{
    biscuit,
    eclair,
    fruit,
    chocolate
}

public class StandardCake extends Cake implements Comparable<Cake>{
    private boolean isSyruped;

    public StandardCake(String name, String description, double price, int pieces, String type, boolean isSyruped) {
        super(name, description, price, pieces, type);
        this.isSyruped = isSyruped;
    }

    @Override
    public int compareTo(Cake o) {
        if(getPrice() >= o.getPrice()){
            return -1;
        }
        return 1;
    }
}