package gasStation.employees;

import gasStation.PayDesk;

public class Cashier extends Thread{
    private final PayDesk payDesk;

    public Cashier(String name, PayDesk payDesk) {
        super(name);
        this.payDesk = payDesk;
    }

    @Override
    public void run() {
        while (true){
            this.payDesk.obslujiKlient(this);
        }
    }
}