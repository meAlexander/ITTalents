package main;

public class Supplier extends Thread {
    private final Sklad sklad;

    public Supplier(Sklad sklad) {
        super("Supplier");
        this.sklad = sklad;
    }

    @Override
    public void run() {
        while (true){
            sklad.sipi();
        }
    }
}