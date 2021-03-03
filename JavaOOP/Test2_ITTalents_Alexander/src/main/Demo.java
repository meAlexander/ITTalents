package main;

import clients.Client;
import clients.Mutra;
import clients.Student;
import clients.Vegan;
import restaurant.Restaurant;
import util.Randomizer;

import java.util.HashSet;

public class Demo {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant("При Пешо Таланта", 1000, "Sofia");

        HashSet<Client> clientHashSet = new HashSet<>();
        for (int i = 0; i < 15; i++) {
            int client = Randomizer.generateInt(100, 0);
            if (client <= 50) {
                clientHashSet.add(new Mutra("Mutra " + (i + 1)));
            } else if (client <= 80) {
                clientHashSet.add(new Student("Student " + (i + 1)));
            } else {
                clientHashSet.add(new Vegan("Vegan " + (i + 1)));
            }
        }
        System.out.println("Restaurant: " + restaurant.getName() +
                ", Address: " + restaurant.getAddress());
        restaurant.startRestaurant(clientHashSet);

        System.out.println("View product: ");
        restaurant.viewUnsoldProducts();

        System.out.println("=========Orders==========");
        for (Client client : clientHashSet) {
            client.doOrder(restaurant.getMenu());
            System.out.print(client.getName() + ", money - " + client.getMoney() + ": ");
            client.askForBill(client.getWaiter());
            client.payTheBill();
        }

        System.out.println("==============");
        restaurant.viewMoneyBalanceAfterClientsGone();
        System.out.println("=====Unsold Products for the night=========");
        restaurant.viewUnsoldProducts();

        System.out.println("======Waiter with most tip`s money for the night=======");
        restaurant.waiterWithMostReceivedMoneyTips();

        System.out.println("======Ordered waiter tip`s money for the night=======");
        restaurant.allWaiterTips();

        System.out.println("======Biggest tip for the night=======");
        restaurant.viewBiggestTipForTheNight();

        System.out.println("======Biggest ordered tips for the night=======");
        restaurant.viewBiggestOrderedTipsForTheNight();
    }
}