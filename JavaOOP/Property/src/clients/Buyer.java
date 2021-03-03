package clients;

import agents.Agent;
import agents.View;
import main.Agency;
import main.Person;
import properties.Property;
import util.Randomizer;

import java.time.LocalTime;
import java.util.HashSet;

public class Buyer extends Person {
    private double money;
    private Agent agent;
    private HashSet<View> views;

    public Buyer(String name, double money) {
        super(name);
        this.money = money;
        views = new HashSet<>();
    }

    public void makeAResearchForProperty(Agency agency){
        this.agent = agency.getRandomAgent();
        agency.addBuyer(this);
    }

    public void makeViewOfProperty(Agency agency, Property property){
        if(agency.getCatalogue().contains(property)){
            for(Property property1 : agency.getCatalogue()){
                if(property.equals(property1)){
                    if(property.getPrice() >= this.money){
                        System.out.println("Not enough money for property " +
                                property.getPropertyType() + " - " + property.getPrice() +
                                ". " + getName() + "`s money: " + this.money);
                        return;
                    }
                    View view = new View(property, this.agent, this, LocalTime.now());
                    views.add(view);
                    this.agent.addView(view);
                    System.out.println("Viewed property: " + property.getPropertyType() +
                            " by " + getName() + " at " + view.getDate());
                }
            }
        }
    }

    public Property getRandomViewedProperty(){
        int property = Randomizer.generateInt(views.size() - 1, 0);
        int i = 0;

        for(View view : views)
        {
            if (i == property) {
                if(!view.getProperty().isSold()) {
                    return view.getProperty();
                }
                property = 0;
                property++;
                i = 0;
            }
            i++;
        }
        return null;
    }

    public boolean checkViews(){
        return views.isEmpty();
    }

    public void buyProperty(Agency agency) {
        Property property = getRandomViewedProperty();
        if(property == null){
            System.out.println("All your viewed properties are already bought! Sorry!");
            return;
        }
        double commission = property.getPrice() * 0.03;
        System.out.println("Property " + property.getPropertyType() +
                         " was bought by " + getName() + " for: " + property.getPrice());
        agency.getCommission(commission);
        this.agent.getCommission(commission);

        this.money -= property.getPrice();
        property.setSold();
    }
}