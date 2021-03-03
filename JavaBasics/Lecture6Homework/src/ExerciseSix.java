public class ExerciseSix {
    public static void main(String[] args) {
        int[][] arr = {
                {11, 12, 13, 14, 15, 16},
                {21, 22, 23, 24, 25, 26},
                {31, 32, 33, 34, 35, 36},
                {41, 42, 43, 44, 45, 46},
                {51, 52, 53, 54, 55, 56},
                {61, 62, 63, 64, 65, 66}
        };

        int sum = 0;
        int allSum = 0;
        for (int row = 0; row < arr.length; row++) {
            if(row % 2 != 0) {
                System.out.print("Elements: ");
                for (int col = 0; col < arr[row].length; col++) {
                    sum += arr[row][col];
                    System.out.print(arr[row][col] + ", ");
                }
                System.out.println("Sum: " + sum);
                allSum += sum;
                sum = 0;
            }
        }
        System.out.println("Sum of elements: " + allSum);
    }
}