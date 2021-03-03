package main;

import people.RakiaMaker;
import enums.FruitType;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class RakiaPlacePreparation {
    private final List<RakiaTank> tanks;
    private final TreeMap<FruitType, Integer> boiledRakia;

    public RakiaPlacePreparation() {
        this.tanks = new ArrayList<>();
        this.boiledRakia = new TreeMap<>();
        for (int i = 0; i < 5; i++) {
            this.tanks.add(new RakiaTank(i+1));
        }
    }

    public TreeMap<FruitType, Integer> getBoiledRakia() {
        return this.boiledRakia;
    }

    public void getFruits(FruitType fruitType) {
        try {
            if (fruitType == FruitType.грозде) {
                fillingTankWithGrapes(fruitType);
            } else if (fruitType == FruitType.сливи) {
                fillingTankWithGrapes(fruitType);
            } else {
                fillingTankWithGrapes(fruitType);
            }
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
    }

    public synchronized void fillingTankWithGrapes(FruitType fruitType) throws InterruptedException {
        RakiaTank tank = getAppropriateTank(fruitType);
        while (tank == null) {
            if(RakiaMaker.isIsDone()){
                notifyAll();
                return;
            }
            wait();
            tank = getAppropriateTank(fruitType);
        }
        tank.increaseTankQuantity();
        //System.out.println("Tank " + tank.getID() + " with " + tank.getType() + " has " + tank.getQuantity() + " kg " + tank.getType());
        if(tank.getQuantity() >= 10){
            notifyAll();
        }
    }

    public synchronized RakiaTank getAppropriateTank(FruitType fruitType) {
        for (RakiaTank tank : this.tanks) {
            if (tank.getType() == fruitType) {
                if (tank.getQuantity() > 0 && tank.getQuantity() <= 10) {
                    return tank;
                }
            }
        }

        for (RakiaTank tank : this.tanks){
            if (tank.getQuantity() == 0) {
                tank.setType(fruitType);
                return tank;
            }
        }
        return null;
    }

    public synchronized void cleanRakiaTankForNextLoading(RakiaTank tank){
        tank.setType(null);
        tank.emptyTank();
        tank.setBoilingStatus(false);
        notifyAll();
    }

    public synchronized RakiaTank boilRakia(RakiaMaker rakiaMaker){
        RakiaTank tank = checkForFullRakiaTank(rakiaMaker);
        while (tank == null){
            if(RakiaMaker.isIsDone()){
                notifyAll();
                return null;
            }
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tank = checkForFullRakiaTank(rakiaMaker);
        }

        if(!this.boiledRakia.containsKey(tank.getType())){
            this.boiledRakia.put(tank.getType(), 0);
        }
        tank.calculateProducedRakia();
        this.boiledRakia.put(tank.getType(), this.boiledRakia.get(tank.getType()) + tank.getProducedRakia());

        return tank;
    }

    public synchronized RakiaTank checkForFullRakiaTank(RakiaMaker rakiaMaker){
        for (RakiaTank tank : this.tanks) {
            if(tank.getQuantity() >= 10 && !tank.getBoilingStatus()){
                System.out.println("==========================");
                System.out.println("Enough quantity in tank " + tank.getTankID() + " for boiling rakia from " + tank.getType() + " - (" + tank.getQuantity() + " kilos)");
                System.out.println(rakiaMaker.getName() + " start boiling rakia from " + tank.getType() + "!");
                tank.setBoilingStatus(true);
                return tank;
            }
        }
        return null;
    }
}