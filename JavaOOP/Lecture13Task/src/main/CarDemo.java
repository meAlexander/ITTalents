package main;

import buses.Bus;
import buses.SchoolBus;
import jeeps.Jeep;
import jeeps.RangeRover;
import carShops.CarShop;
import sportCars.Ferrari;
import sportCars.SportCar;

public class CarDemo {
    public static void main(String[] args) {
        Person person1 = new Person("Ivan Petrov", 19, 12000, "123456", 'M', 78);
        Person person2 = new Person("Georgi Ivanov", 28, 15000, "654321", 'M', 60);
        Person person3 = new Person("Todor Todorov", 35, 30000, "456789", 'M', 56);
        Person person4 = new Person("Petar Shopov", 42, 55000, "987654", 'M', 80);
        Person person5 = new Person("Martin Stoqnov", 50, 45000, "159753", 'M', 67);
        Person person6 = new Person("Vasil Petkov", 39, 85000, "185468", 'M', 36);

        //create car shop
        CarShop shop1 = new CarShop(10);

        //create cars and set a car to person or carShop in constructor
        Car audi = new Car(person1, "A8", 280, 12000, "blue");
        Car mercedes = new Car(person2, "Benz", 320, 18000, "black");
        Car ford = new Car(shop1,"Fiesta", 200, 8000, "white");
        Car bmw = new Car(shop1,"X5", 260, 15000,"green", 0, 1);
        //add more cars and uncomment lines to test more cases and functionalities

        //add cars to car shop
        shop1.addCar(audi);
        shop1.addCar(mercedes);
        shop1.addCar(bmw);

        //set person to car(we can`t set more than 1 car or car different from above
        person1.setCar(audi);
        person2.setCar(mercedes);

        //test cant set a car to different owner if it already has
        System.out.println("------------");
        person1.setCar(mercedes);

        increaseAcceleration(audi);
        reduceAcceleration(audi);

        //compare two cars by price
        System.out.println(mercedes.isMoreExpensive(audi));

        //show how much money a car model costs for scrap
        System.out.println("------------");
        System.out.println(mercedes.getModel() + "`s price for scrap: " + mercedes.calculateCarPriceForScrap(4500));
        System.out.println(audi.getModel() + "`s price for scrap: " + audi.calculateCarPriceForScrap(4500));

        //scrap deal - before and after
        System.out.println("------------");
        System.out.println(person2.getName() + "`s money before sell the car model " + person2.getCar().getModel() + " for scrap: " + person2.getMoney());
        double scrapPriceForCar = mercedes.sellCarForScrap(4500);
        System.out.println(person2.getName() + "`s money after sell the car model " + mercedes.getModel() + " for scrap for " + scrapPriceForCar + ": " + person2.getMoney());

        //buy a car that it has noy got a owner and buyer has not got a car
        System.out.println("------------");
        person3.buyCar(ford);
        System.out.println(person3.toString());

        //test buy a car that is already bought
        System.out.println("------------");
        //System.out.println(ford.toString());
        person4.buyCar(ford);
        System.out.println(person4.toString());

//        System.out.println("-------------");
//        System.out.println("Get next two car:");
//        System.out.println(shop1.getNextCar());
//        System.out.println(shop1.getNextCar());

        //remove a car if exists from shop list and show the rest cars
        System.out.println("-------------");
        shop1.removeCar(bmw);
        System.out.println("Shop now:");
        shop1.showAllCars();

        //add car to the shop if it does not exist and sell next car(if next car has on owner get next ... while find a car without owner..)
        System.out.println("-------------");
        shop1.addCar(bmw);
        shop1.sellNextCar(person4);
        System.out.println(person4.toString());

        //test sell a car
        System.out.println("-------------");
        shop1.sellNextCar(person5);

        //test to sell a new car to person who already has a car
        shop1.sellNextCar(person5);

        //test to sell a car but shop has no available cars
        System.out.println("-------------");
        shop1.sellNextCar(person6);

        //change owner if car is free and new owner does not have a car and change color
        System.out.println("-------------");
        bmw.changeOwner(person5);
        person5.getCar().changeColor("white");
        System.out.println(person5.toString());

        //add car which already exists in the shop
        System.out.println("-------------");
        shop1.addCar(mercedes);
        shop1.addCar(ford);

        System.out.println("---------------");
        testSubClasses();
    }

    private static void reduceAcceleration(Car audi) {
        //reduce acceleration and show results
        System.out.println("------------");
        audi.reduceGear();
        audi.reduceGear();
        audi.reduceCurrentSpeed(40);
        audi.reduceCurrentSpeed(20);
        audi.increaseCurrentSpeed(250);
        audi.increaseGear();
        audi.increaseGear();
        audi.increaseGear();
        System.out.println(audi.toString());
    }

    private static void increaseAcceleration(Car audi) {
        //increase acceleration and show result
        System.out.println("------------");
        audi.increaseGear();
        audi.increaseGear();
        audi.increaseGear();
        audi.increaseGear();
        audi.increaseCurrentSpeed(50);
        audi.increaseCurrentSpeed(40);
        System.out.println(audi.toString());
    }

    public static void testSubClasses(){
        CarShop carShop2 = new CarShop("Most Auto", 5);

        SportCar sportCar = new Ferrari(carShop2, "5000",350, 250000, "red", true);
        sportCar.switchTurbo();

        Jeep jeep = new RangeRover(carShop2, "C500", 300, 220000, "black", true);
        jeep.driveOffRoad();
        jeep.switch4x4();

        Bus bus = new SchoolBus(carShop2, "T200", 120, 500000, "yellow", 30, 10);
        bus.drive();

        System.out.println("-----------------");
        carShop2.showAllCars();
    }
}