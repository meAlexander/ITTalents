package agents;

import clients.Buyer;
import clients.Seller;
import main.Person;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;

public class Agent extends Person implements Comparable<Agent>{
    private HashSet<Seller> sellers;
    private HashSet<Buyer> buyers;
    private ArrayList<View> views;
    private double moneyBalance;
    private int ID;
    private static int IDCounter = 1;

    public Agent(String name) {
        super(name);
        this.ID = IDCounter++;
        sellers = new HashSet<>();
        buyers = new HashSet<>();
        views = new ArrayList<>();
    }

    public void addView(View view){
        views.add(view);
    }
    public void getCommission(double commission){
        this.moneyBalance += commission;
    }
    public void viewMoneyBalance(){
        this.moneyBalance = Double.parseDouble(new DecimalFormat("#.##")
                .format(this.moneyBalance).replace(',', '.'));
        System.out.println(getName() + "`s money balance: " +
                this.moneyBalance + " euro");
    }

    @Override
    public int compareTo(Agent o) {
        if(this.ID == o.ID){
            return 0;
        }
        if(this.moneyBalance >= o.moneyBalance){
            return 1;
        }
        return -1;
    }
}