package properties;

import agents.Agent;
import util.Randomizer;

enum HouseType{
    етажOтKъща,
    цялаKъща;
}

public class House extends Property{
    private HouseType houseType;
    private int parkingSpace;
    private double gardenArea;

    public House(String address, double price, Agent agent) {
        super(address, price, agent);
        createHoseType();
        generateParkingSpace();
        generateGardenArea();
    }

    @Override
    public String getPropertyType() {
        return houseType.toString();
    }
    public HouseType getHouseType() {
        return houseType;
    }

    private void createHoseType(){
        HouseType[] houseTypes = HouseType.values();
        this.houseType = houseTypes[Randomizer
                .generateInt(houseTypes.length - 1, 0)];
    }

    private void generateParkingSpace(){
        this.parkingSpace = Randomizer.generateInt(10,2);
    }

    private void generateGardenArea(){
        this.gardenArea = Randomizer.generateDouble(250,50);
    }
}