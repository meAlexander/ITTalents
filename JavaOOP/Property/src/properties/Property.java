package properties;

import agents.Agent;
import main.Person;

public abstract class Property implements Comparable<Property> {
    private String description;
    private String address;
    private double price;
    private double area;
    private int ID;
    private Agent agent;
    private Person owner;
    private static int IDCounter = 1;
    private boolean isSold = false;

    public Property(String address, double price, Agent agent) {
        this.address = address;
        this.price = price;
        this.agent = agent;
        this.ID = IDCounter++;
    }

    public void setSold(){
        this.isSold = true;
    }
    public boolean isSold() {
        return isSold;
    }
    public abstract String getPropertyType();
    public void setOwner(Person person){
        this.owner = owner;
    }
    public double getPrice() {
        return price;
    }

    @Override
    public int compareTo(Property o){
        if(this.ID == o.ID){
            return 0;
        }
        if(this.price - o.price > 0){
            return 1;
        }
        return -1;
    }
}