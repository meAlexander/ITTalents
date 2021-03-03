package orders;

import clients.Client;
import dishes.Dish;
import enums.DishType;
import drinks.Drink;
import enums.DrinkType;
import restaurant.Menu;

import java.util.Iterator;

public class MutraOrder extends Order {
    public MutraOrder(Menu menu) {
        super(menu);
    }

    @Override
    public void dishOrder(Client client) {
        Iterator<Dish> dishIterator = getMenu().getDishes().iterator();
        while (dishIterator.hasNext()) {
            Dish dish = dishIterator.next();
            if (dish.getName() == DishType.MainDish) {
                addDish(dish);
                super.setBill(dish.getPrice() + getBill());

                drinkOrder(client);
                if (super.checkTheBill(client)) {
                    super.setBill(0);
                    return;
                }
                dishIterator.remove();
                return;
            }
        }
        drinkOrder(client);
    }

    @Override
    public void drinkOrder(Client client) {
        Iterator<Drink> drinkIterator = getMenu().getDrinks().iterator();
        while (drinkIterator.hasNext()) {
            Drink drink = drinkIterator.next();
            if (drink.getName() == DrinkType.Alcohol) {
                addDrink(drink);
                super.setBill(drink.getPrice() + getBill());

                if (super.checkTheBill(client)) {
                    return;
                }
                drinkIterator.remove();
                return;
            }
        }
    }
}