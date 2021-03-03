package restaurant;

import orders.Order;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Objects;

public class Waiter implements Comparable<Waiter> {
    private final String name;
    private double tips;
    private double biggestTip;
    private final ArrayList<Order> orders;

    public Waiter(String name) {
        this.orders = new ArrayList<>();
        this.name = name;
        this.tips = 0;
        this.biggestTip = 0;
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }

    public String getName() {
        return name;
    }

    public double getBiggestTip() {
        return biggestTip;
    }

    public double getTips() {
        return tips;
    }

    public void getOrder(int orderID) {
        for (Order o : this.orders) {
            if (o.getID() == orderID) {
                System.out.println(" (" + o.getDishes() + "; " + o.getDrinks());
            }
        }
    }

    public void setTips(double sum) {
        this.tips += sum;

        this.tips = Double.parseDouble(new DecimalFormat(".##")
                .format(this.tips).replace(',', '.'));
        if (this.biggestTip < sum) {
            this.biggestTip = sum;
        }
    }

    public double giveBill(int orderID) {
        for (Order o : this.orders) {
            if (o.getID() == orderID) {
                return o.getBill();
            }
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Waiter)) return false;
        Waiter waiter = (Waiter) o;
        return Objects.equals(this.name, waiter.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }

    @Override
    public int compareTo(Waiter o) {
        if (this.getTips() < o.getTips()) {
            return 1;
        }
        return -1;
    }
}