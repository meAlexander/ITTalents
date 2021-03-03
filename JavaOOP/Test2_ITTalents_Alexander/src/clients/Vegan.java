package clients;

import orders.VeganOrder;
import restaurant.Menu;

public class Vegan extends Client{
    private VeganOrder veganOrder;
    public Vegan(String name) {
        super(name, 30);
    }

    @Override
    public void doOrder(Menu menu) {
        this.veganOrder = new VeganOrder(menu);
        this.veganOrder.makeOrder(this);
        getWaiter().addOrder(veganOrder);
    }

    @Override
    public int orderInfo() {
        return this.veganOrder.getID();
    }
}
