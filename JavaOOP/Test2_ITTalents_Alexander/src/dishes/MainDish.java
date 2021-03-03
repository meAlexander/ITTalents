package dishes;

import enums.DishType;

public class MainDish extends Dish {
    public MainDish( double weight) {
        super(DishType.MainDish, 9, weight);
    }
}
