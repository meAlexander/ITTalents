import java.util.Scanner;

public class ExerciseTwelve {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[7];

        for (int i = 0; i < array.length; i++) {
            System.out.print("Enter value for " + i + " element: ");
            array[i] = scanner.nextInt();
        }

        for (int i = 0; i < array.length; i++) {
            if(array[i] > 5 && array[i] % 5 == 0){
                System.out.print(array[i] + " ");
            }
        }

        for (int i = 0; i < array.length; i++) {
            if(i == 0){
                int tempValue = array[i];
                array[i] = array[i+1];
                array[i+1] = tempValue;
            }else if(i == 2){
                array[i] = array[i] + array[i+1]; // sum
                array[i+1] = array[i] - array[i+1]; //subtraction old value
                array[i] = array[i] - array[i+1]; //subtraction new value
            }else if(i == 4){
                array[i] = array[i] * array[i+1];
                array[i+1] = array[i] / array[i+1];
                array[i] = array[i] / array[i+1];
            }
        }

        for(int element : array){
            System.out.print(element + " ");
        }
    }
}
