public class ExerciseFifteen {
    public static void main(String[] args) {
        double[] array = {7.13, 0.2, 4.9, 5.1, 6.34, 1.12};
        double[] arrayMaxValues = new double[3];
        int counter = 0;

        for (int i = array.length - 1; i >= 0; i--) {
            for (int j = array.length - 1; j >= 0; j--) {
                //move biggest numbers to first positions
                //sort array in descending order
                if (array[i] < array[j]) {
                    double temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                arrayMaxValues[counter] = array[i - 1];
                counter++;
            }

            if (counter == 3) {
                break;
            }
        }

        if (counter < 3) {
            System.out.println("There is no 3 different max numbers in the array.");
        } else {
            System.out.println("Number are: " + arrayMaxValues[0] +
                    ", " + arrayMaxValues[1] +
                    ", " + arrayMaxValues[2]);
        }
    }
}