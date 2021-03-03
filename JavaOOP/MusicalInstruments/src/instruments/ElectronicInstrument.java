package instruments;

public class ElectronicInstrument extends Instrument {
    public enum ElectronicType {
        synthesizer, bassGuitar, electricViolin
    }

    public ElectronicInstrument(String name, String type, double price, int quantity) {
        super(name, type, price, quantity);
    }
}
