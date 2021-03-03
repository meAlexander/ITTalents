package guns;

public class Pistol extends Gun {

    public Pistol() {
        super(25, 15);
    }

    @Override
    public String toString() {
        return "Pistol" + super.toString();
    }
}