package instruments;

public class PercussionInstrument extends Instrument {
    public enum PercussionType {
        drums, tarambuka, drum, tambourine
    }

    public PercussionInstrument(String name, String type, double price, int quantity) {
        super(name, type, price, quantity);
    }
}