package restaurant;

import dishes.Dish;
import drinks.Drink;

import java.util.ArrayList;

public class Menu {
    private final ArrayList<Dish> dishes;
    private final ArrayList<Drink> drinks;

    public Menu(){
        this.dishes = new ArrayList<>();
        this.drinks = new ArrayList<>();
    }

    public void addDish(Dish dish){
        this.dishes.add(dish);
    }

    public void addDrink(Drink drink){
        this.drinks.add(drink);
    }

    public ArrayList<Dish> getDishes() {
        return dishes;
    }

    public ArrayList<Drink> getDrinks() {
        return drinks;
    }
}