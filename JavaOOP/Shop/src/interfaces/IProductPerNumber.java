package interfaces;

import products.ProductPerNumberType;

public interface IProductPerNumber {

    ProductPerNumberType getTypeNumber();
    int getNumber();
    void setNumber(int number);
}