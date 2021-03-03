package util;

import java.text.DecimalFormat;
import java.util.Random;

public final class Randomizer {
    private static final Random random = new Random();

    public static int generateInt(int max, int min) {
        return random.nextInt(max - min + 1) + min;
    }

    public static double generateDouble(int max, int min) {
        return Double.parseDouble(new DecimalFormat(".##")
                .format((min + (max - min) * random.nextDouble())).replace(',', '.'));
    }
}