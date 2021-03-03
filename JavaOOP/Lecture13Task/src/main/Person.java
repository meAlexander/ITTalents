package main;

import java.util.Arrays;

public class Person {
    private final String name;
    private int age;
    private final String personalNumber;
    private final char sex;
    private double weight;
    private double money;
    private Car car;
    private final Person[] friends;

//    public Person() {
//        this.age = 0;
//        this.weight = 4;
//    }

    public Person(String name, String personalNumber, char sex) {
        this.name = name;
        this.personalNumber = personalNumber;
        this.sex = sex;
        friends = null;
    }

    public Person(String name, int age, double money, String personalNumber, char sex, double weight) {
        this(name, personalNumber, sex);
        this.age = age;
        this.money = money;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }

    public Car getCar() {
        return car;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void setCar(Car car) {
        if (car == null) {
            this.car = car;
            return;
        } else if (this.getCar() != null) {
            System.out.println("The person " + this.getName() + " already has a car");
            return;
        }
        this.car = car;
    }

    public void buyCar(Car car) {
        if(car != null) {
            if (this.money >= car.getPrice()) {
                if (car.getPerson() == null) {
                    System.out.println("main.Car model " + car.getModel() + " is available and sold to " + this.getName());
                    this.car = car;
                    car.setPerson(this);
                    this.setMoney(this.money - car.getPrice());
                    car.getCarShop().removeCar(car);
                    car.setCarShop(null);
                } else {
                    System.out.println("The car model " + car.getModel() + " already has an owner: " +
                            car.getPerson().getName() + " and " + this.getName() + " cannot buy it.");
                }
            } else {
                System.out.println("Not enough money!");
            }
        }else{
            System.out.println("Car does not exist!");
        }
    }

    @Override
    public String toString() {
        String info = "main.Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", personalNumber='" + personalNumber + '\'' +
                ", sex=" + sex +
                ", \nweight=" + weight +
                ", money=" + money;

        if (car == null && friends == null) {
            return info + ", car=No car" +
                    ", friends=No friends" + '}';
        } else if (car != null && friends == null) {
            return info + ", car=" + car +
                    ", friends=No friends" + '}';
        } else if (car == null) {
            return info + ", car=No car" +
                    ", friends=" + Arrays.toString(friends) + '}';
        }
        return info + ", car=" + car +
                ", friends=" + Arrays.toString(friends) + '}';
    }
}