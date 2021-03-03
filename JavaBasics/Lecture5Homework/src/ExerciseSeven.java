import java.util.Scanner;

public class ExerciseSeven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a size of array: ");
        int size = scanner.nextInt();

        int[] array = new int[size];
        int[] array2 = new int[size];

        for (int i = 0; i < array.length; i++) {
            System.out.print("Enter value for " + i + " element: ");
            array[i] = scanner.nextInt();
        }
        array2[0] = array[0];
        array2[size-1] = array[size-1];

        for (int i = 1; i < array2.length - 1; i++) {
            array2[i] = array[i-1] + array[i+1];
        }

        for(int element : array2){
            System.out.print(element + " ");
        }
    }
}