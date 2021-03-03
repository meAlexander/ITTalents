package people;

import enums.FruitType;
import main.RakiaPlacePreparation;
import util.Randomizer;

public class Picker extends Person implements Runnable {
    private FruitType fruitType;
    private int amountOfCollectedFruit;
    public static RakiaPlacePreparation rakiaPlacePreparation;
    public Picker(String name, int age) {
        super(name, age);
    }

    public int getAmountOfCollectedFruit() {
        return amountOfCollectedFruit;
    }

    public FruitType getFruitType() {
        return fruitType;
    }

    @Override
    public void run() {
        setRandomType();

        while (!RakiaMaker.isIsDone()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.amountOfCollectedFruit++;
            Picker.rakiaPlacePreparation.getFruits(fruitType);
        }
    }

    public void setRandomType() {
        FruitType[] constructionTypes = FruitType.values();
        this.fruitType = constructionTypes[Randomizer
                .generateInt(constructionTypes.length - 1, 0)];
    }
}