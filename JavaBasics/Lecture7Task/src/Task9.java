public class Task9 {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4},
                {4, 5, 6, 88},
                {12, 16, 22, 13},
                {22, 39, 18, 5}
        };

        int tempSum = 0;
        int tempRow = 0;
        int tempCol = 0;
        for (int row = 0; row < arr.length - 1; row++) {
            for (int col = 0; col < arr[row].length - 1; col++) {
                int sum = arr[row][col] + arr[row][col+1] +
                     arr[row+1][col] + arr[row+1][col+1];
                if(tempSum < sum){
                    tempSum = sum;
                    tempRow = row;
                    tempCol = col;
                }
            }
        }
        System.out.println(arr[tempRow][tempCol] + " " + arr[tempRow][tempCol+1]);
        System.out.println(arr[tempRow+1][tempCol] + " " + arr[tempRow+1][tempCol+1]);
    }
}