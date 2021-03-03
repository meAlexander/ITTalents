public class Task2 {
    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 0, 1, 0};
        int[] arr2 = {0, 1, 0, 1, 0, 1};
        int[] arr3 = {1, 2, 3, 4, 5, 6};
        int[] arr4 = {6, 5, 4, 3, 2, 1};
        int flag = 0;


        if (arr4[0] > arr4[1]) {
            for (int j = 2; j < arr4.length; j++) {
                if (arr4[j - 1] <= arr4[j]) {
                    flag = 1;
                    break;
                }
            }
        } else if (arr4[0] < arr4[1]) {
            for (int j = 2; j < arr4.length; j++) {
                if (arr4[j - 1] >= arr4[j]) {
                    flag = 1;
                    break;
                }
            }
        }

        if (flag == 1) {
            System.out.println("Масивът не е назъбен.");
        } else {
            System.out.println("Масивът е назъбен.");
        }
    }
}