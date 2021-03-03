import java.util.Scanner;

public class ExerciseEleven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int counter = 0;
        int[] array = new int[7];

        for (int i = 0; i < array.length; i++) {
            System.out.print("Enter value for " + i + " element: ");
            array[i] = scanner.nextInt();
        }

        for (int i = 0; i < array.length; i++) {
            if(array[i] > 5 && array[i] % 5 == 0){
                System.out.print(array[i] + " ");
                counter++;
            }
        }
        System.out.println(counter + " number.");
    }
}