package instruments;

public class SpiritInstrument extends Instrument{
    public enum SpiritType{
        trumpet, trombone, tuba, flute, clarinet
    }

    public SpiritInstrument(String name, String type, double price, int quantity) {
        super(name, type, price, quantity);
    }
}
