package clients;

import main.Agency;
import main.Person;
import properties.Property;

public class Seller extends Person {
    private Property property;
    private double money = 0;

    public Seller(String name, Property property) {
        super(name);
        this.property = property;
        property.setOwner(this);
    }

    public void registerProperty(Agency agency){
        agency.addPropertyToCatalogue(this.property);
    }
}