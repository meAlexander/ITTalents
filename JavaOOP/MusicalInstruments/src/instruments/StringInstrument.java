package instruments;

public class StringInstrument extends Instrument {
    public enum StringType {
        violin, viola, doubleBass, harp, guitar, reed
    }

    public StringInstrument(String name, String type, double price, int quantity) {
        super(name, type, price, quantity);
    }
}
