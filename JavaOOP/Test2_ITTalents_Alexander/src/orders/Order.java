package orders;

import clients.Client;
import dishes.Dish;
import drinks.Drink;
import restaurant.Menu;
import util.Randomizer;

import java.util.ArrayList;
import java.util.Iterator;

public class Order {
    private final ArrayList<Drink> drinks;
    private final ArrayList<Dish> dishes;
    private double bill;
    private final Menu menu;
    private final int ID;
    private static int IDCounter = 1;

    public Order(Menu menu) {
        this.drinks = new ArrayList<>();
        this.dishes = new ArrayList<>();
        this.menu = menu;
        this.ID = Order.IDCounter++;
    }

    public ArrayList<Dish> getDishes() {
        return dishes;
    }

    public ArrayList<Drink> getDrinks() {
        return drinks;
    }

    public Menu getMenu() {
        return menu;
    }

    public int getID() {
        return ID;
    }

    public double getBill() {
        return bill;
    }

    public void setBill(double bill) {
        this.bill = bill;
    }

    public void dishOrder(Client client){
        int i = 0;
        int item = Randomizer.generateInt(this.menu.getDishes().size() - 1, 0);
        Iterator<Dish> iterator = this.menu.getDishes().iterator();
        while (iterator.hasNext()) {
            Dish dish = iterator.next();
            if (i == item) {
                addDish(dish);
                this.bill += dish.getPrice();

                drinkOrder(client);
                if(checkTheBill(client)){
                    setBill(0);
                    return;
                }
                iterator.remove();
                return;
            }
            i++;
        }
        drinkOrder(client);
    }

    public void drinkOrder(Client client){
        int i = 0;
        int item = Randomizer.generateInt(this.menu.getDishes().size() - 1, 0);
        Iterator<Drink> iterator2 = this.menu.getDrinks().iterator();
        while (iterator2.hasNext()) {
            Drink drink = iterator2.next();
            if (i == item) {
                addDrink(drink);
                this.bill += drink.getPrice();

                if(checkTheBill(client)){
                    return;
                }
                iterator2.remove();
                return;
            }
            i++;
        }
    }

    public boolean checkTheBill(Client client){
        return this.bill > (90 * client.getMoney()) / 100;
    }

    public void makeOrder(Client client) {
        dishOrder(client);
        //drinkOrder(client);
    }

    public void addDish(Dish dish) {
        this.dishes.add(dish);
    }

    public void addDrink(Drink drink) {
        this.drinks.add(drink);
    }
}