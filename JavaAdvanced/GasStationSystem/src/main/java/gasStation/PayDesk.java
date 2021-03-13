package gasStation;

import gasStation.employees.Cashier;
import main.Owner;

import java.util.concurrent.ConcurrentLinkedQueue;

public class PayDesk {
    private final ConcurrentLinkedQueue<Owner> owners;
    private final int ID;

    public PayDesk(int ID) {
        this.owners = new ConcurrentLinkedQueue<>();
        this.ID = ID;
        new Cashier("Cashier " + this.ID, this).start();
    }

    public void addCarOwner(Owner owner) {
        this.owners.offer(owner);
        synchronized (this) {
            notifyAll();
        }
        System.out.println("Нов клиент на опашката на каса " + this.ID + "!(" + owner.getName() + ")");
    }

    private Owner getNextOwner() {
        return this.owners.peek();
    }

    public void removeOwner() {
        this.owners.poll();
    }

    public synchronized void obslujiKlient(Cashier cashier) {
        while (this.owners.isEmpty()) {
            try {
                wait();
                System.out.println("Няма клиент за обслужване на каса " + this.ID + "(" + cashier.getName() + ")");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Owner owner = getNextOwner();
        System.out.println("Обслужване на клиент - " + owner.getName() + ".......");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        removeOwner();
        System.out.println("Клиентът " + owner.getName() + " беше обслужен!");
    }
}