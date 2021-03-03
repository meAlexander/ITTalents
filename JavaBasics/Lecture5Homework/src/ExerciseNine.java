import java.util.Scanner;

public class ExerciseNine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a size of array: ");
        int size = scanner.nextInt();

        int[] array = new int[size];
        int[] reversedArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            System.out.print("Enter value for " + i + " element: ");
            array[i] = scanner.nextInt();
        }

        //with additional array
        for (int i = 0, j = array.length-1; i < reversedArray.length; i++, j--) {
            reversedArray[i] = array[j];
        }

        for (int element : reversedArray){
            System.out.print(element + " ");
        }

        System.out.println();
        //without additional array
        for (int i = 0, j = array.length-1; i < j; i++, j--) {
            int firstElement = array[i];
            int lastElement = array[j];

            array[i] = lastElement;
            array[j] = firstElement;
        }

        for (int element : array){
            System.out.print(element + " ");
        }
    }
}