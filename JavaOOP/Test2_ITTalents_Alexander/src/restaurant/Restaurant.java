package restaurant;

import clients.Client;
import dishes.*;
import drinks.Alcohol;
import drinks.Drink;
import enums.DrinkType;
import drinks.NonAlcohol;
import enums.DishType;
import util.Randomizer;

import java.util.*;
import java.util.stream.Collectors;

public class Restaurant {
    private final String name;
    private final String address;
    private double moneyInCash;
    private final Menu menu;
    private final HashSet<Waiter> waiters;
    private final HashSet<Client> clients;
    private final HashMap<DishType, Long> unsoldDishMap;
    private final HashMap<DrinkType, Long> unsoldDrinkMap;
    private final TreeSet<Waiter> waitersOrderedByBiggestTips;
    private final TreeSet<Waiter> waitersOrderedByTips;

    public Restaurant(String name, double moneyInCash, String address) {
        this.name = name;
        this.moneyInCash = moneyInCash;
        this.address = address;
        this.menu = new Menu();
        this.clients = new HashSet<>();
        this.waiters = new HashSet<>();
        this.unsoldDishMap = new HashMap<>();
        this.unsoldDrinkMap = new HashMap<>();
        this.waitersOrderedByTips = new TreeSet<>(this.waiters);

        this.waitersOrderedByBiggestTips = new TreeSet<>((e1, e2) ->{
            if(e1.getBiggestTip() <= e2.getBiggestTip()){
                return 1;
            }
            return -1;
        });

        for (int i = 0; i < 10; i++) {
            this.menu.addDish(new Salad(Randomizer.generateInt(600, 300)));
            this.menu.addDish(new MainDish(Randomizer.generateInt(800, 400)));
            this.menu.addDish(new Dessert(Randomizer.generateInt(300, 200)));
        }

        for (int i = 0; i < 20; i++) {
            this.menu.addDrink(new Alcohol());
            this.menu.addDrink(new NonAlcohol());
        }

        for (int i = 0; i < 5; i++) {
            this.waiters.add(new Waiter("Waiter " + (i + 1)));
        }
    }

    public void startRestaurant(HashSet<Client> clients) {
        this.clients.addAll(clients);

        for (Client client : this.clients) {
            int size = this.waiters.size();
            int item = new Random().nextInt(size);
            int i = 0;
            for (Waiter waiter : this.waiters) {
                if (i == item) {
                    client.setWaiter(waiter);
                    client.setRestaurant(this);
                }
                i++;
            }
        }
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Menu getMenu() {
        return menu;
    }

    public void updateMoney(double moneyInCash) {
        this.moneyInCash += moneyInCash;
    }

    public void viewMoneyBalanceAfterClientsGone() {
        System.out.println("Money balance after clients gone: " + this.moneyInCash);
    }

    private void getUnsoldDishes() {
        long saladsCount = this.menu.getDishes().stream()
                .filter(e -> e.getName() == DishType.Salad)
                .count();
        this.unsoldDishMap.put(DishType.Salad, saladsCount);

        long mainDishesCount = this.menu.getDishes().stream()
                .filter(e -> e.getName() == DishType.MainDish)
                .count();
        this.unsoldDishMap.put(DishType.MainDish, mainDishesCount);

        long dessertCount = this.menu.getDishes().stream()
                .filter(e -> e.getName() == DishType.Dessert)
                .count();
        this.unsoldDishMap.put(DishType.Dessert, dessertCount);
    }

    private void getUnsoldDrinks() {
        long alcoholsCount = this.menu.getDrinks().stream()
                .filter(e -> e.getName() == DrinkType.Alcohol)
                .count();
        this.unsoldDrinkMap.put(DrinkType.Alcohol, alcoholsCount);

        long nonAlcoholsCount = this.menu.getDrinks().stream()
                .filter(e -> e.getName() == DrinkType.NonAlcohol)
                .count();
        this.unsoldDrinkMap.put(DrinkType.NonAlcohol, nonAlcoholsCount);
    }

    public void viewUnsoldProducts() {
        getUnsoldDishes();
        getUnsoldDrinks();

        System.out.println("Dishes:");
        this.unsoldDishMap
                .forEach((key, value) -> System.out.println("\t" + key + " - " + value));

        System.out.println("Drinks:");
        this.unsoldDrinkMap
                .forEach((key, value) -> System.out.println("\t" + key + " - " + value));
    }

    public void waiterWithMostReceivedMoneyTips(){
        this.waitersOrderedByTips.clear();

        this.waitersOrderedByTips.addAll(this.waiters);
        this.waitersOrderedByTips.stream()
                .limit(1)
                .forEach(e-> System.out.println(e.getName() + " - " + e.getTips()));
    }

    public void allWaiterTips(){
        this.waitersOrderedByTips.clear();

        this.waitersOrderedByTips.addAll(this.waiters);
        this.waitersOrderedByTips
                .forEach(e-> System.out.println(e.getName() + " - " + e.getTips()));
    }

    public void viewBiggestTipForTheNight(){
        this.waitersOrderedByBiggestTips.clear();

        this.waitersOrderedByBiggestTips.addAll(this.waiters);
        this.waitersOrderedByBiggestTips
                .stream()
                .limit(1)
                .forEach(e-> System.out.println(e.getName() + " - " + e.getBiggestTip()));
    }

    public void viewBiggestOrderedTipsForTheNight(){
        this.waitersOrderedByBiggestTips.clear();

        this.waitersOrderedByBiggestTips.addAll(this.waiters);
        this.waitersOrderedByBiggestTips
                .forEach(e-> System.out.println(e.getName() + " - " + e.getBiggestTip()));
    }
}