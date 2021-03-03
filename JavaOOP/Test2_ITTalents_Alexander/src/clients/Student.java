package clients;

import orders.Order;
import restaurant.Menu;

public class Student extends Client{
    private Order studentOrder;

    public Student(String name) {
        super(name, 10);
    }

    @Override
    public void doOrder(Menu menu) {
        this.studentOrder = new Order(menu);
        this.studentOrder.makeOrder(this);
        getWaiter().addOrder(studentOrder);
    }

    public int orderInfo(){
        return this.studentOrder.getID();
    }
}