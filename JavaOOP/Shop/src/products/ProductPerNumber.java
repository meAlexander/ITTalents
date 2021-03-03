package products;

public class ProductPerNumber extends Product{
    private final ProductPerNumberType type;

    public ProductPerNumber(ProductPerNumberType type, double price, int number) {
        super(price, number);
        this.type = type;
    }

    @Override
    public ProductPerNumberType getTypeNumber() {
        return type;
    }

    @Override
    public String toString() {
        return "type=" + type +
                ", number=" + getNumber() +
                ", price=" + getPrice() +
                '}';
    }
}