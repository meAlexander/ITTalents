public class Season5Test1Task3 {
    public static void main(String[] args) {
        int[] arr = {1, 5, 8, -1, 50, 17, 13, 21};

        int difference = calculateDifference(arr, 1, 0, 0);
        System.out.println("Difference between max and min element is: " + difference);
    }

    private static int calculateDifference(int[] arr, int index, int min, int max) {
        if (arr[min] > arr[index]) {
            min = index;
        }

        if (arr[max] < arr[index]) {
            max = index;
        }

        if (index == arr.length - 1) {
            return arr[max] - arr[min];
        }

        return calculateDifference(arr, ++index, min, max);
    }
}