package interfaces;

import products.ProductPerKiloType;

public interface IProductPerKilo {

    ProductPerKiloType getTypeKilo();
    int getKilos();
    void setKilos(double kilos);
}