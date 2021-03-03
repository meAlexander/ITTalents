package clients;

import cakes.Cake;
import deliverguys.DeliverGuy;
import cakeShop.CakeShop;
import orders.Order;

import java.util.ArrayList;

public abstract class Client {
    private String name;
    private String phone;
    private static CakeShop cakeShop;

    public Client(String name, String phone, CakeShop cakeShop) {
        this.name = name;
        this.phone = phone;
        Client.cakeShop = cakeShop;
    }

    public void makeOrder(){
        DeliverGuy deliverGuy = cakeShop.getRandomDeliver();
        ArrayList<Cake> cakes = new ArrayList<>();
        for (int i = 0; i < getNumberOfCakes(); i++) {
            Cake cake = cakeShop.getCake();
            if(cake == null){
                i--;
                continue;
            }
            cakes.add(cake);
        }

        Order order = new Order(this, "Sofiq", "today", cakes);
        deliverGuy.addOrder(order);
        double price = order.getPrice();
        price = price - getDiscount(price);
        deliverGuy.receiveTip(price * giveTipPercent() / 100);
        cakeShop.receiveProfits(price);
    }

    public abstract int getNumberOfCakes();
    public abstract double getDiscount(double totalPrice);
    public abstract double giveTipPercent();
}