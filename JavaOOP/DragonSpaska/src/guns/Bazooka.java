package guns;

public class Bazooka extends Gun {

    public Bazooka() {
        super(100, 50);
    }

    @Override
    public String toString() {
        return "Bazooka" + super.toString();
    }
}
