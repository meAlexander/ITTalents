import java.util.Scanner;

public class Season12Test2Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] consecutiveNumberArray = new int[4];
        int totalAttempts = 0;
        int consecutiveAttempts = 0;
        int index = 0;
        int tempNumber = 9;

        while (true) {
            System.out.print("Enter a number: ");
            int number = scanner.nextInt();

            if(number < 10 || number > 99){
                System.out.println("Number must be 2-digit!");
                continue;
            }
            totalAttempts++;

            if(number > tempNumber){
                consecutiveNumberArray[index++] = number;
                consecutiveAttempts++;

                if(consecutiveAttempts == 4){
                    break;
                }
            }else{
                tempNumber = 9;
                consecutiveAttempts = 0;
                index = 0;
            }
        }

        for (int i = 0; i < consecutiveNumberArray.length; i++) {
            System.out.print(consecutiveNumberArray[i] + " ");
        }
        System.out.println("\nAttempts: " + totalAttempts);
    }
}