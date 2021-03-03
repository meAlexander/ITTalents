package deliverguys;

import orders.Order;

import java.util.HashSet;

public class DeliverGuy implements Comparable<DeliverGuy>{
    private String name;
    private String phone;
    private double tip;
    private HashSet<Order> orders;

    public DeliverGuy(String name) {
        this.name = name;
        this.orders = new HashSet<>();
    }

    public void receiveTip(double tip){
        this.tip = tip;
    }

    @Override
    public int compareTo(DeliverGuy o) {
        if(this.tip > o.tip) {
            return 1;
        }
        return -1;
    }

    public void addOrder(Order newOrder){
        orders.add(newOrder);
    }

    public HashSet<Order> getOrders() {
        return orders;
    }

    public String getName() {
        return this.name;
    }
}