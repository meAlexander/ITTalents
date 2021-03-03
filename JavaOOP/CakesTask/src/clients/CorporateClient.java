package clients;

import cakeShop.CakeShop;
import util.Randomizer;

public class CorporateClient extends Client{
    private static final double DISCOUNT = 10;

    public CorporateClient(String name, String phone, CakeShop cakeShop) {
        super(name, phone, cakeShop);
    }

    @Override
    public double getDiscount(double totalPrice) {
        return totalPrice * DISCOUNT / 100;
    }
    @Override
    public int getNumberOfCakes(){
        return Randomizer.randomValue(5, 3);
    }
    @Override
    public double giveTipPercent(){
        return 5;
    }
}