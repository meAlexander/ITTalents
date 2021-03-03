package guns;

public class Rifle extends Gun {

    public Rifle() {
        super(50, 25);
    }

    @Override
    public String toString() {
        return "Riffle" + super.toString();
    }
}