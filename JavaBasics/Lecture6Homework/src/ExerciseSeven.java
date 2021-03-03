public class ExerciseSeven {
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
        int tempSum = 0;
        int col;
        for (int row = 0; row < arr.length; row++) {
//            for (int col = 0; col < arr[row].length; col++) {
//                if((row + col) % 2 == 0){
//                    sum += arr[row][col];
//                    System.out.print(arr[row][col] + " ");
//                }
//            }

            col = 0;
            if(row % 2 == 0){
                sum += arr[row][col];
                System.out.print(arr[row][col] + " ");
            }

            if((row + ++col) % 2 == 0){
                sum += arr[row][col];
                System.out.print(arr[row][col] + " ");
            }

            if((row + ++col) % 2 == 0){
                sum += arr[row][col];
                System.out.print(arr[row][col] + " ");
            }

            if((row + ++col) % 2 == 0){
                sum += arr[row][col];
                System.out.print(arr[row][col] + " ");
            }

            if((row + ++col) % 2 == 0){
                sum += arr[row][col];
                System.out.print(arr[row][col] + " ");
            }

            if((row + ++col) % 2 == 0){
                sum += arr[row][col];
                System.out.print(arr[row][col] + " ");
            }

            System.out.println("Sum of row elements: " + sum);
            tempSum += sum;
            sum = 0;
        }
        System.out.println("Sum of all elements: " + tempSum);

        //Second way with one loop
        int sum2 = 0;
        int tempSum2 = 0;
        int rowsCount = arr.length;
        int colsCount = arr[0].length;
        int rowIndex, colIndex;
        for (int i = 0; i < rowsCount * colsCount; i++) {
            rowIndex = i / rowsCount;
            colIndex = i % colsCount;

            if((rowIndex + colIndex) % 2 == 0){
                sum2 += arr[rowIndex][colIndex];
                System.out.print(arr[rowIndex][colIndex] + " ");
            }

            if(colIndex == colsCount - 1){
                System.out.println("Sum of row elements: " + sum2);
                tempSum2 += sum2;
                sum2 = 0;
            }
        }
        System.out.println("Sum of all elements: " + tempSum2);
    }
}