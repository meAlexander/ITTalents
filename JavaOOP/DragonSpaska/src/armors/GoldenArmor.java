package armors;

public class GoldenArmor extends Armor {

    public GoldenArmor() {
        super(100, 20);
    }

    @Override
    public String toString() {
        return "Golden armor" + super.toString();
    }
}