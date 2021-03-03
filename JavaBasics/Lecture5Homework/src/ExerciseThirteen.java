import java.util.Scanner;

public class ExerciseThirteen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number: ");
        int number = scanner.nextInt();
        int binNumber = 0;
        int counter = 0;
        int[] binArray;

        for (int i = number; i > 0; i = i / 2) {
            counter++;
        }
        binArray = new int[counter];

        for (int i = number, j = 0; i > 0; i = i / 2, j++) {
            if(i % 2 == 0){
                binNumber = 0;
            }else{
                binNumber = 1;
            }
            binArray[j] = binNumber;
        }

        for (int i = 0, j = binArray.length - 1; i < binArray.length; i++, j--) {
            int temp = binArray[i];
            binArray[i] = binArray[j];
            binArray[j] = temp;
        }

        for(int element : binArray){
            System.out.print(element + "");
        }
    }
}