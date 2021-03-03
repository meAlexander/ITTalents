package carShops;

import main.Car;
import main.Person;

import java.util.Arrays;

public class CarShop {
    private String shopName;
    private Car[] cars;
    private int savePosition = 0;
    private int showPosition = -1;
    private double money;

    public CarShop(int capacity) {
        shopName = "Cars Auto";
        this.money = 0;
        cars = new Car[capacity];
    }

    public CarShop(String shopName, int capacity) {
        this(capacity);
        this.shopName = shopName;
    }

    public String getShopName() {
        return shopName;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void setCars(Car[] cars) {
        this.cars = cars;
    }

    public void addCar(Car car) {
        if (Arrays.asList(cars).contains(car)) {
            System.out.println("The shop already has this car model " + car.getModel());
            return;
        } else if (car.getPerson() != null) {
            System.out.println("The car model: " + car.getModel() + " already has an owner: " +
                                    car.getPerson().getName() + " and can`t be added to the shop!");
            return;
        }else if(car.getIsAddedForScrap()){
            System.out.println("The car was added for scrap and can't be added to the shop list!");
            return;
        }
        cars[savePosition] = car;
        money += cars[savePosition].getPrice();

        car.setCarShop(this);

        System.out.println("The car model " + car.getModel() + " is added to the shop!");
        savePosition++;
    }

    public Car getNextCar() {
        boolean hasAvailableCars = false;
        for (int i = 0; i < cars.length; i++) {
            if(cars[i] != null){
                hasAvailableCars = true;
                break;
            }
        }
        if(hasAvailableCars) {
            showPosition++;
            if (showPosition == cars.length) {
                showPosition = -1;
                showPosition++;
            }

            if (cars[showPosition] != null) {
                return cars[showPosition];
            }
            return getNextCar();
        }else{
            return null;
        }
    }

    public void sellNextCar(Person buyer) {
        Car car = getNextCar();
        if(car != null) {
            if (buyer.getCar() == null) {
                if (car.getPerson() == null) {
                    if (buyer.getMoney() >= car.getPrice()) {
                        buyer.buyCar(car);
                    } else {
                        System.out.println("Not enough money for this car model " + car.getModel());
                    }
                } else {
                    //stop if all cars were checked
                    if (showPosition == savePosition - 1) {
                        System.out.println("No available cars at the moment. Sorry!");
                        return;
                    }
                    sellNextCar(buyer);
                }
            } else {
                System.out.println("Buyer " + buyer.getName() + " already has a car model " + buyer.getCar().getModel());
            }
        }else{
            System.out.println("No cars available!");
        }
    }

    public void removeCar(Car car) {
        for (int i = 0; i < cars.length; i++) {
            if (cars[i] != null && cars[i].equals(car)) {
                cars[i] = null;
                System.out.println("The car model " + car.getModel() + " was removed from the shop!");
                savePosition--;
                money -= car.getPrice();
                break;
            }
        }
    }

    public void showAllCars() {
        boolean isEmptyCarList = true;
        for (Car car : cars) {
            if (car == null) {
                continue;
            }
            isEmptyCarList = false;
            System.out.println(car.toString());
        }

        if(isEmptyCarList){
            System.out.println("main.Car shop is empty!");
        }
    }
}