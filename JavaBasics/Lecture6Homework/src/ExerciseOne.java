public class ExerciseOne {
    public static void main(String[] args) {
        int[][] arr = {
                {48, 72, 13, 14, 15},
                {21, 22, 53, 24, 75},
                {31, 57, 33, 34, 35},
                {41, 95, 43, 44, 45},
                {59, 52, 103, 54, 55},
                {61, 69, 63, 64, 65}
        };

        int max = arr[0][0];
        int min = arr[0][0];
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                if(max < arr[row][col]){
                    max = arr[row][col];
                }
                if(min > arr[row][col]){
                    min = arr[row][col];
                }
            }
        }

        System.out.println("Max value: " + max);
        System.out.println("Min value: " + min);
    }
}