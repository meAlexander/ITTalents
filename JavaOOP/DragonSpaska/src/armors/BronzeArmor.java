package armors;

public class BronzeArmor extends Armor {

    public BronzeArmor() {
        super(25, 5);
    }

    @Override
    public String toString() {
        return "Bronze armor" + super.toString();
    }
}