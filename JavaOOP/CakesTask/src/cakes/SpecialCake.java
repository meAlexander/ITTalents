package cakes;

enum Special{
    anniversary,
    company,
    advertising
}

public class SpecialCake extends Cake implements Comparable<Cake>{
    private String event;

    public SpecialCake(String name, String description, double price, int pieces, String type, String event) {
        super(name, description, price, pieces, type);
        this.event = event;
    }


    @Override
    public int compareTo(Cake o) {
        if(getPrice() >= o.getPrice()){
            return -1;
        }
        return 1;
    }
}