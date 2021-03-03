public class Task5 {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3,4,5},
                {4,5,6,8,12},
                {12,16,22},
                {22,39,9},
                {89}
        };

        int sum = 0;
        int tempSum = 0;
        int tempRow = 0;
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                sum += arr[row][col];
            }
            if(tempSum < sum){
                tempSum = sum;
                tempRow = row;
            }
            sum = 0;
        }
        System.out.println("Max row sum is " + tempSum + " at row " + tempRow);
    }
}