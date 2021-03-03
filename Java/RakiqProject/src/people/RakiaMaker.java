package people;

import enums.FruitType;
import main.RakiaPlacePreparation;
import main.RakiaTank;

import java.util.TreeMap;

public class RakiaMaker extends Person implements Runnable {
    public static RakiaPlacePreparation rakiaPlacePreparation;
    private final TreeMap<FruitType, Integer> boiledRakia;
    private static boolean isDone;

    public RakiaMaker(String name, int age) {
        super(name, age);
        this.boiledRakia = new TreeMap<>();
    }

    public TreeMap<FruitType, Integer> getBoiledRakia() {
        return this.boiledRakia;
    }

    public static boolean isIsDone() {
        return RakiaMaker.isDone;
    }

    @Override
    public void run() {
        while (true) {
            RakiaTank tank = RakiaMaker.rakiaPlacePreparation.boilRakia(this);
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (tank != null) {
                System.out.println("Tank " + tank.getTankID() + " with " + tank.getType() + " boiled " + tank.getProducedRakia() + " liters!");

                if (!this.boiledRakia.containsKey(tank.getType())) {
                    this.boiledRakia.put(tank.getType(), 0);
                }
                this.boiledRakia.put(tank.getType(), this.boiledRakia.get(tank.getType()) + tank.getProducedRakia());

                RakiaMaker.rakiaPlacePreparation.cleanRakiaTankForNextLoading(tank);
            }

            int count = 0;

            //Общо(без значение от вида) поне 60 литра ракия
            for (FruitType type : RakiaMaker.rakiaPlacePreparation.getBoiledRakia().keySet()) {
                count += RakiaMaker.rakiaPlacePreparation.getBoiledRakia().get(type);
            }
            if(count >= 60){
                RakiaMaker.isDone = true;
                break;
            }

            //От всеки вид поне по 10 литра ракия
//            for (FruitType type : RakiaMaker.rakiaPlacePreparation.getBoiledRakia().keySet()) {
//                if (RakiaMaker.rakiaPlacePreparation.getBoiledRakia().get(type) >= 10) {
//                    count++;
//                }
//            }
//            if (count == 3) {
//                RakiaMaker.isDone = true;
//                break;
//            }
        }
    }
}