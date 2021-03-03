public class ExerciseFourteen {
    public static void main(String[] args) {
        double[] array = {7.1,8.5,0.2,3.7,0.99,1.4,-3.5,-110,212,341,1.2};
        int counter = 0;

        for (double element : array) {
            if (element > -2.99 && element < 2.99) {
                counter++;
            }
        }

        double[] array2 = new double[counter];
        for (int i = 0, j = 0; i < array.length; i++) {
            if(array[i] > -2.99 && array[i] < 2.99){
                array2[j] = array[i];
                j++;
            }
        }

        for(double element : array2){
            System.out.print(element + " ");
        }
    }
}