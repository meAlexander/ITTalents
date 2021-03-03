package clients;

import restaurant.Menu;
import restaurant.Restaurant;
import restaurant.Waiter;
import util.Randomizer;

import java.util.Objects;

public abstract class Client {
    private final String name;
    private double money;
    private Waiter waiter;
    private Restaurant restaurant;

    public Client(String name, double money) {
        this.name = name;
        this.money = money;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public abstract void doOrder(Menu menu);

    public String getName() {
        return name;
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }

    public abstract int orderInfo();

    public Waiter getWaiter() {
        return waiter;
    }

    public double getMoney() {
        return money;
    }

    public void askForBill(Waiter waiter) {
        double bill = waiter.giveBill(orderInfo());
        if (bill == 0) {
            System.out.println("You didn't make an order because of lacking enough money!");
            return;
        }
        System.out.print("Your bill: " + bill);
        waiter.getOrder(orderInfo());
    }

    public void payTheBill() {
        double bill = this.waiter.giveBill(orderInfo());
        if (bill > 0) {
            this.money -= bill;
            this.restaurant.updateMoney(bill);
            System.out.println("Bill paid!");

            int tip = Randomizer.generateInt(100, 0);
            if (tip <= 80) {
                int count = Randomizer.generateInt(10, 5);
                double waiterTip = (bill * count) / 100;
                this.waiter.setTips(waiterTip);
                this.money -= waiterTip;
                System.out.println("Tip given! - " + waiterTip);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return Objects.equals(this.name, client.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}