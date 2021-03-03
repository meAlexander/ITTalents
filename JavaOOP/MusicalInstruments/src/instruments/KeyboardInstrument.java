package instruments;

public class KeyboardInstrument extends Instrument{
    public enum KeyboardType{
        organ, piano, accordion
    }

    public KeyboardInstrument(String name, String type, double price, int quantity) {
        super(name, type, price, quantity);
    }
}
