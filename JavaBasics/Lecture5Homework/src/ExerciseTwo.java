import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class ExerciseTwo {
    public static void main(String[] args) {
        int[] array = {5, 6, -5, 9, -6, 41, 8, 4};
        int[] reverseArray = new int[array.length];
        int counter = -1;
        int flag;

        //check if array length is even or odd
        if (array.length % 2 == 0) {
            flag = 0;
        } else {
            flag = 1;
        }

        //if array length is odd get half length + 1 elements
        for (int index = 0; index < array.length / 2 + flag; index++) {
            reverseArray[index] = array[index];
            counter++;
        }

        for (int index = counter + 1; index < reverseArray.length; index++) {
            if (flag == 0) {
                //if array length is even rewrite all elements in reverse order with duplicated middle
                reverseArray[index] = array[counter--];
            }else {
                //if array length is odd rewrite all elements in reverse order without duplicated middle
                reverseArray[index] = array[--counter];
            }
        }

        for (int i = 0; i < reverseArray.length; i++) {
            System.out.print(reverseArray[i] + " ");
        }
    }
}