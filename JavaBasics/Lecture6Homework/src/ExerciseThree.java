public class ExerciseThree {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 0},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        int sum = 0;
        int counter = 0;
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                sum += arr[row][col];
                counter++;
            }
        }

        System.out.println("Sum of elements: " + sum);
        System.out.println("Average of elements: " + (double) sum / counter);
    }
}