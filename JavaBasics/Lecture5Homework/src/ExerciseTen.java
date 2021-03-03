import java.util.Scanner;

public class ExerciseTen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int[] array = new int[7];
        int difference = Integer.MAX_VALUE;

        for (int i = 0; i < array.length; i++) {
            System.out.print("Enter value for " + i + " element: ");
            array[i] = scanner.nextInt();
            sum += array[i];
        }
        int average = sum / 7;
        int closestToAverage = 0;
        System.out.println("Average: " + average);
        for (int i = 0; i < array.length; i++) {
            int currentDifference = Math.abs(array[i] - average);

            if(currentDifference < difference){
                closestToAverage = array[i];
                difference = currentDifference;
            }
        }

        System.out.println("Average value: " + array[3] + ", value closest to average from array is " + closestToAverage);
    }
}