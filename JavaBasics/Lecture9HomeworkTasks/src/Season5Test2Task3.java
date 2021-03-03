public class Season5Test2Task3 {
    public static void main(String[] args) {
        int[] arr = {-5, -2, 0, 1, 1, 2, 3, 4, 5, 8};
        int number = getNumberOfNegativeValue(arr);

        System.out.println("Number of negative values is: " + number);
    }

    private static int getNumberOfNegativeValue(int[] arr) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                break;
            }
            count++;
        }
        return count;
    }
}