package main;

import carShops.CarShop;

public class Car {
    private final String model;
    private double maxSpeed;
    private double currentSpeed;
    private String color;
    private int currentGear;
    private double price;
    private Person person;
    private CarShop carShop;
    private boolean addedForScrap = false;

    public Car(Person person, String model, double maxSpeed, double price, String color) {
        this.person = person;
        this.model = model;
        this.color = color;
        this.price = price;
        this.currentSpeed = 0;
        this.currentGear = 0;

        if (maxSpeed >= 100) {
            this.maxSpeed = maxSpeed;
        } else {
            System.out.println("Max speed must at least 100 km/h");
        }
    }

    public Car(String model, String color) {
        this.model = model;
        this.color = color;
    }

    public Car(CarShop carShop, String model, double maxSpeed, double price, String color) {
        this(model, color);
        this.carShop = carShop;
        carShop.addCar(this);
        this.maxSpeed = maxSpeed;
        this.price = price;
    }

    public Car(CarShop carShop, String model, double maxSpeed, double price, String color, double currentSpeed, int currentGear) {
        this(carShop, model, maxSpeed, price, color);
        this.currentSpeed = currentSpeed;
        this.currentGear = currentGear;
    }

    public double getPrice() {
        return price;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public Person getPerson() {
        return person;
    }

    public CarShop getCarShop() {
        return carShop;
    }

    public boolean getIsAddedForScrap() {
        return addedForScrap;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setCarShop(CarShop carShop) {
        this.carShop = carShop;
    }

    public void increaseGear() {
        if (person != null) {
            if (currentGear < 6) {
                currentGear++;
            } else {
                System.out.println("Max gear: " + this.currentGear);
            }
        }
    }

    public void reduceGear() {
        if (person != null) {
            if (currentGear > 0) {
                currentGear--;
            } else {
                System.out.println("Neutral gear!");
            }
        }
    }

    public void increaseCurrentSpeed(double speed) {
        if (person != null) {
            if (speed > 0) {
                if (speed + currentSpeed <= maxSpeed) {
                    currentSpeed += speed;
                } else {
                    System.out.println("Impossible acceleration!");
                }
            } else {
                System.out.println("Invalid speed");
            }
        }
    }

    public void reduceCurrentSpeed(double speed) {
        if (person != null) {
            if (speed > 0) {
                if (currentSpeed - speed >= 0) {
                    currentSpeed -= speed;
                } else {
                    System.out.println("Impossible reduction!");
                }
            } else {
                System.out.println("Invalid speed");
            }
        }
    }

    public void changeColor(String color) {
        this.color = color;
        System.out.println("The color of car model " + this.getModel() + " was changed to " + color);
    }

    public boolean isMoreExpensive(Car car) {
        return this.price > car.price;
    }

    public double calculateCarPriceForScrap(double metalPrice) {
        double coefficient = 0.2;

        if (this.color.equals("black") || this.color.equals("white")) {
            coefficient += 0.05;
        }
        return metalPrice * coefficient;
    }

    public double sellCarForScrap(double metalPrice) {
        double scrapPriceForCar = calculateCarPriceForScrap(metalPrice);
        if (carShop != null) {
            this.carShop.setMoney(this.carShop.getMoney() + scrapPriceForCar);
            this.carShop.removeCar(this);
            this.carShop = null;
        } else if (person != null) {
            this.person.setMoney(this.person.getMoney() + scrapPriceForCar);
            this.getPerson().setCar(null);
            this.setPerson(null);
        } else {
            System.out.println("The car hasn't got an owner.");
        }
        addedForScrap = true;
        return scrapPriceForCar;
    }

    public void changeOwner(Person newOwner) {
        if (newOwner.getCar() == null) {
            if (newOwner.getMoney() >= price) {
                if (getCarShop() != null) {
                    this.carShop.removeCar(this);
                    this.carShop = null;
                } else {
                    this.person.setCar(null);
                    this.person = null;
                }
                this.person = newOwner;
                this.person.setCar(this);
                System.out.println("Congratulations! The car model " + this.getModel() + " has a new owner - " + newOwner.getName());
            } else {
                System.out.println("Not enough money for this car model " + this.getModel());
            }
        } else {
            System.out.println("main.Person: " + newOwner.getName() + " already has a car model " + newOwner.getCar().getModel());
        }
    }

    @Override
    public String toString() {
        String info = "Car{" +
                "model='" + model + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", currentSpeed=" + currentSpeed +
                ", color='" + color + '\'' +
                ", \ncurrentGear=" + currentGear +
                ", price=" + price;

        if (person != null) {
            return info + ", Owner=" + this.person.getName();
        } else {
            return info + ", Owner=" + this.carShop.getShopName();
        }
    }
}