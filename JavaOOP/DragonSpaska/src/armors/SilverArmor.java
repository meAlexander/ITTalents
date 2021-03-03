package armors;

public class SilverArmor extends Armor {

    public SilverArmor() {
        super(50, 10);
    }

    @Override
    public String toString() {
        return "Silver armor" + super.toString();
    }
}