import java.util.Scanner;

public class ExerciseEleven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You have to enter a three digit number and check if it is divisible by its own digits!");

        System.out.print("Enter number: ");
        int number = scanner.nextInt();

        /*int firstDigit = number / 100;
        int secondDigit = (number / 10) % 10; //other option (number % 100) / 10
        int thirdDigit = number % 10;

        if (firstDigit == 0 || secondDigit == 0 || thirdDigit == 0){
            System.out.println("Your number contains zero!");
        }else{
            //......
        }*/

        if(("" + number).contains("0")){
            System.out.println("Your number contains zero!");
        }else{
            int firstDigit = number / 100;
            int secondDigit = (number / 10) % 10; //other option (number % 100) / 10
            int thirdDigit = number % 10;

            if(number % firstDigit == 0){
                System.out.println("It is divided into: " + firstDigit);
            }else{
                System.out.println("It is not divided into: " + firstDigit);
            }

            if(number % secondDigit == 0){
                System.out.println("It is divided into: " + secondDigit);
            }else{
                System.out.println("It is not divided into: " + secondDigit);
            }

            if(number % thirdDigit == 0){
                System.out.println("It is divided into: " + thirdDigit);
            }else{
                System.out.println("It is not divided into: " + thirdDigit);
            }
        }
    }
}