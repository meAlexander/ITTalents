package products;

public class ProductPerKilo extends Product{
    private final ProductPerKiloType type;

    public ProductPerKilo(ProductPerKiloType type, double price, int kilo) {
        super(price, kilo);
        this.type = type;
    }

    @Override
    public ProductPerKiloType getTypeKilo() {
        return type;
    }

    @Override
    public String toString() {
        return "type=" + type +
                ", kilo=" + getKilos() +
                ", price=" + getPrice() +
                '}';
    }
}