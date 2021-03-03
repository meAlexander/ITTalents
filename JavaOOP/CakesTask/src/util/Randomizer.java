package util;

import java.util.Random;

public class Randomizer {
    private static Random random = new Random();

    public static int randomValue(int max, int min){
        return random.nextInt(max - min + 1) + min;
    }
}

//22 13 -> 22 - 13 + 1 = 10 -> 0 + 13 = 0

//4 1 -> 4 - 1 + 1 = 4 -> 0 + 1 = 1