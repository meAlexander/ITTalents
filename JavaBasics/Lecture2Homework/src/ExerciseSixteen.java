import java.util.Scanner;

public class ExerciseSixteen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You have to enter a three digit number and check if digit are in ascending or descending order!");

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        if (("" + number).length() != 3){
            System.out.println("Your number does not contain exactly 3 digits!");
        }else {
            int firstDigit = number / 100;
            int secondDigit = (number / 10) % 10; //other option (number % 100) / 10
            int thirdDigit = number % 10;

            if ((firstDigit == secondDigit) && (secondDigit == thirdDigit)) {
                System.out.println("The digits are equals!");
            } else if (firstDigit > secondDigit && secondDigit > thirdDigit) {
                System.out.println(number + ", The digits are in descending order!");
            } else if (firstDigit < secondDigit && secondDigit < thirdDigit) {
                System.out.println(number + " The digits are in ascending order!");
            } else {
                System.out.println(number + ", The digits are unordered!");
            }
        }

//        if((firstDigit == secondDigit) && (secondDigit == thirdDigit)){
//            System.out.println("The digits are equals!");
//        }else if(firstDigit > secondDigit){
//            if(secondDigit > thirdDigit) {
//                System.out.println(number + ", The digits are in descending order!");
//            }else{
//                System.out.println(number + ", The digits are unordered!");
//            }
//        }else if(firstDigit < secondDigit){
//            if(secondDigit < thirdDigit){
//                System.out.println(number + " The digits are in ascending order!");
//            }else{
//                System.out.println(number + ", The digits are unordered!");
//            }
//        }
    }
}