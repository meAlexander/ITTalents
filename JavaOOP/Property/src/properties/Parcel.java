package properties;

import agents.Agent;
import util.Randomizer;

enum ParcelType{
    нива, поляна, гора;
}

public class Parcel extends Property{
    private ParcelType parcelType;
    private boolean regulated;

    public Parcel(String address, double price, Agent agent) {
        super(address, price, agent);
        createParcelType();
    }

    @Override
    public String getPropertyType() {
        return parcelType.toString();
    }
    public ParcelType getParcelType() {
        return parcelType;
    }

    private void createParcelType(){
        ParcelType[] parcelTypes = ParcelType.values();
        this.parcelType = parcelTypes[Randomizer
                .generateInt(parcelTypes.length - 1, 0)];
    }

    private void makeRegulation(){
        this.regulated = Randomizer.generateInt(1, 0) == 1;
    }
}