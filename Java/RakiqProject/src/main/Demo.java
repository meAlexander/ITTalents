package main;

import people.Picker;
import people.RakiaMaker;
import enums.FruitType;
import util.Randomizer;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        RakiaPlacePreparation rakiaPlacePreparation = new RakiaPlacePreparation();
        Picker.rakiaPlacePreparation = rakiaPlacePreparation;
        RakiaMaker.rakiaPlacePreparation = rakiaPlacePreparation;

        List<RakiaMaker> rakiaMakerList = new ArrayList<>();
        List<Picker> pickerList = new ArrayList<>();

        List<Thread> rakiaMakerThreads = new ArrayList<>();
        List<Thread> pickerThreads = new ArrayList<>();

        for (int i = 1; i <= 7; i++) {
            Picker picker = new Picker("Picker " + i, Randomizer.generateInt(60, 20));
            pickerList.add(picker);
            pickerThreads.add(new Thread(picker));
        }

        for (int i = 1; i <= 5; i++) {
            RakiaMaker rakiaMaker = new RakiaMaker("Rakia maker " + i, Randomizer.generateInt(75, 35));
            rakiaMakerList.add(rakiaMaker);
            rakiaMakerThreads.add(new Thread(rakiaMaker));
        }

        for (Thread t1 : pickerThreads) {
            t1.start();
        }

        for (Thread t1 : rakiaMakerThreads) {
            t1.start();
        }

        for (Thread t1 : pickerThreads) {
            t1.join();
        }

        for (Thread t1 : rakiaMakerThreads) {
            t1.join();
        }

//        RakiaMaker rakiaMaker1 = new RakiaMaker("Rakia maker 1", 55);
//        RakiaMaker rakiaMaker2 = new RakiaMaker("Rakia maker 2", 50);
//        RakiaMaker rakiaMaker3 = new RakiaMaker("Rakia maker 3", 44);
//        RakiaMaker rakiaMaker4 = new RakiaMaker("Rakia maker 4", 64);
//        RakiaMaker rakiaMaker5 = new RakiaMaker("Rakia maker 5", 76);
//
//        Thread thread1 = new Thread(rakiaMaker1);
//        Thread thread2 = new Thread(rakiaMaker2);
//        Thread thread3 = new Thread(rakiaMaker3);
//        Thread thread4 = new Thread(rakiaMaker4);
//        Thread thread5 = new Thread(rakiaMaker5);
//
//        Picker picker1 = new Picker("Ivan", 30);
//        Picker picker2 = new Picker("Gosho", 40);
//        Picker picker3 = new Picker("Pesho", 44);
//        Picker picker4 = new Picker("Marto", 35);
//        Picker picker5 = new Picker("Vasko", 22);
//        Picker picker6 = new Picker("Mitko", 27);
//        Picker picker7 = new Picker("Dimo", 27);
//
//        Thread thread6 = new Thread(picker1);
//        Thread thread7 = new Thread(picker2);
//        Thread thread8 = new Thread(picker3);
//        Thread thread9 = new Thread(picker4);
//        Thread thread10 = new Thread(picker5);
//        Thread thread11 = new Thread(picker6);
//        Thread thread12 = new Thread(picker7);
//
//        thread1.start();
//        thread2.start();
//        thread3.start();
//        thread4.start();
//        thread5.start();
//        thread6.start();
//        thread7.start();
//        thread8.start();
//        thread9.start();
//        thread10.start();
//        thread11.start();
//        thread12.start();
//
//        try {
//            thread1.join();
//            thread2.join();
//            thread3.join();
//            thread4.join();
//            thread5.join();
//            thread6.join();
//            thread7.join();
//            thread8.join();
//            thread9.join();
//            thread10.join();
//            thread11.join();
//            thread12.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        System.out.println("\nRESULTS...");

        System.out.println("-------------");
        System.out.println("All harvested fruits - ");
        pickerList.stream()
                .sorted((o1, o2) -> {
                    if(o1.getAmountOfCollectedFruit() >= o2.getAmountOfCollectedFruit()){
                        return 1;
                    }
                    return -1;
                })
                .forEach(e-> System.out.println(e.getName() + ", " + e.getAge() + " г - " + e.getAmountOfCollectedFruit() + " кг " + e.getFruitType()));

        System.out.println("-------------");
        for (RakiaMaker rakiaMaker : rakiaMakerList) {
            System.out.println("Produced rakia by " + rakiaMaker.getName() + " (" + rakiaMaker.getAge() + " years) - ");
            for (FruitType type : rakiaMaker.getBoiledRakia().keySet()) {
                System.out.println(type + " : " + rakiaMaker.getBoiledRakia().get(type) + " л");
            }
        }

        System.out.println("-----------Ordered rakia makers by produced rakia in descending order----------");
        rakiaMakerList.stream()
                .sorted((e1, e2) -> {
                    int e1Count = 0;
                    int e2Count = 0;
                    for (FruitType type : e1.getBoiledRakia().keySet()) {
                        e1Count += e1.getBoiledRakia().get(type);
                    }
                    for (FruitType type : e2.getBoiledRakia().keySet()) {
                        e2Count += e2.getBoiledRakia().get(type);
                    }

                    if(e1Count < e2Count){
                        return 1;
                    }
                    return -1;
                })
                .forEach(e-> System.out.println(e.getName()));

        System.out.println("-----------------");
        System.out.println("All produced rakia - ");
        for (FruitType type : rakiaPlacePreparation.getBoiledRakia().keySet()) {
            System.out.println(type + " : " + rakiaPlacePreparation.getBoiledRakia().get(type) + " л");
        }
    }
}