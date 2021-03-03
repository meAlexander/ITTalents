package clients;

import orders.MutraOrder;
import restaurant.Menu;

public class Mutra extends Client{
    private MutraOrder mutraOrder;
    public Mutra(String name) {
        super(name, 50);
    }

    @Override
    public void doOrder(Menu menu) {
        this.mutraOrder = new MutraOrder(menu);
        this.mutraOrder.makeOrder(this);
        getWaiter().addOrder(mutraOrder);
    }

    @Override
    public int orderInfo() {
        return this.mutraOrder.getID();
    }
}