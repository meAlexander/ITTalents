import java.util.Scanner;

public class ExerciseOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a size of array: ");
        int size = scanner.nextInt();

        int[] array = new int[size];
        int minValue = Integer.MAX_VALUE;

        for (int i = 0; i < array.length; i++) {
            System.out.print("Enter value for " + i + " element: ");
            array[i] = scanner.nextInt();
        }

        for (int index = 0; index < array.length; index++) {
            if(array[index] % 3 == 0){
                if(array[index] < minValue){
                    minValue = array[index];
                }
            }
        }
        System.out.println("-------\nMin value divisible by 3 is " + minValue);
    }
}