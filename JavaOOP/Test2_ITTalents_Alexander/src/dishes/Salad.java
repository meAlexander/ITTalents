package dishes;

import enums.DishType;

public class Salad extends Dish{
    public Salad(double weight) {
        super(DishType.Salad, 5, weight);
    }
}