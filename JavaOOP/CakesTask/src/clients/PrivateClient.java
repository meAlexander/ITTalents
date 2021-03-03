package clients;

import cakeShop.CakeShop;
import util.Randomizer;

import java.util.ArrayList;

public class PrivateClient extends Client{
    private final ArrayList<Integer> VOUCHERS;
    private final int numberOfVouchers;

    public PrivateClient(String name, String phone, CakeShop cakeShop) {
        super(name, phone, cakeShop);
        this.numberOfVouchers = getNumberOfVouchers();
        VOUCHERS = new ArrayList<>();
        saveVouchers();
    }

    private void saveVouchers(){
        for (int i = 0; i < this.numberOfVouchers; i++) {
            this.VOUCHERS.add(getValueOfVoucher());
        }
    }
    public int getNumberOfVouchers(){
        return Randomizer.randomValue(4, 1);
    }
    private int getValueOfVoucher(){
        return Randomizer.randomValue(30, 10);
    }

    @Override
    public double getDiscount(double totalPrice) {
        double discount = 0;
        for (int i = 0; i < VOUCHERS.size(); i++) {
            discount += VOUCHERS.get(i);
            VOUCHERS.remove(VOUCHERS.get(i));
            if(discount > totalPrice){
                discount = totalPrice;
                break;
            }
        }
        return discount;
    }

    @Override
    public int getNumberOfCakes() {
        return Randomizer.randomValue(3, 1);
    }
    @Override
    public double giveTipPercent(){
        return 2;
    }
}