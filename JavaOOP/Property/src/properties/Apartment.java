package properties;

import agents.Agent;
import util.Randomizer;

enum ConstructionType{
    ЕПК, Тухла,
    Панел, Кирпич;
}

enum ApartmentType{
    студио, гарсониера,
    двустаен, тристаен, мезонет;
}

public class Apartment extends Property{
    private ConstructionType constructionType;
    private ApartmentType apartmentType;

    public Apartment(String address, double price, Agent agent) {
        super(address, price, agent);
        createApartmentType();
        createConstructionType();
    }

    @Override
    public String getPropertyType() {
        return apartmentType.toString();
    }
    public ApartmentType getApartmentType() {
        return apartmentType;
    }

    private void createConstructionType(){
        ConstructionType[] constructionTypes = ConstructionType.values();
        this.constructionType = constructionTypes[Randomizer
                .generateInt(constructionTypes.length - 1, 0)];
    }

    private void createApartmentType(){
        ApartmentType[] apartmentTypes = ApartmentType.values();
        this.apartmentType = apartmentTypes[Randomizer
                .generateInt(apartmentTypes.length - 1, 0)];
    }
}