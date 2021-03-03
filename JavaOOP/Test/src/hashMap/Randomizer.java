package hashMap;

import java.text.DecimalFormat;
import java.util.Random;

public class Randomizer {

    public static int generateInt(int max, int min){
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public static double generateDouble(int max, int min){
        Random random = new Random();
        double a = Double.parseDouble(new DecimalFormat(".##").format((min + (max - min)*random.nextDouble())).replace(',','.'));
        return a;
    }
}