package dishes;

import enums.DishType;

public class Dessert extends Dish {
    public Dessert(double weight) {
        super(DishType.Dessert, 4, weight);
    }
}
