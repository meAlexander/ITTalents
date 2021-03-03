public class Task7 {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4},
                {4, 5, 6, 8},
                {12, 16, 22, 13},
                {22, 39, 18, 5}
        };

        int sum = 1;
        for (int row = 1; row < arr.length; row++) {
            for (int col = 0; col < row; col++) {
                sum *= arr[row][col];
            }
        }
        System.out.println("Multiplications of elements below the main diagonal: " + sum);
    }
}