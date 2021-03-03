import java.util.Scanner;

public class ExerciseEight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You have to enter one four digit number between 1000 and 9999!");

        System.out.print("Enter your four digit number: ");
        int fourDigitNumber = scanner.nextInt();

        if(fourDigitNumber < 1000 || fourDigitNumber > 9999){
            System.out.println("Your number is out of the boundary!");
        }else{
            int firstDigitFirstNumber = fourDigitNumber / 1000;
            int secondDigitFirstNumber = fourDigitNumber % 10;
            System.out.println("" + firstDigitFirstNumber + "  " + secondDigitFirstNumber);

            int firstDigitSecondNumber = (fourDigitNumber / 100) % 10;
            int secondDigitSecondNumber = (fourDigitNumber / 10) % 10;
            System.out.println("" + firstDigitSecondNumber + "  " + secondDigitSecondNumber);

            int firstNewNumber = Integer.parseInt(String.format("%d%d", firstDigitFirstNumber, secondDigitFirstNumber));
            int secondNewNumber = Integer.parseInt(String.format("%d%d", firstDigitSecondNumber, secondDigitSecondNumber));

            if(firstNewNumber > secondNewNumber){
                System.out.println("First new number is bigger than the second new number: " + firstNewNumber + ">" +secondNewNumber);
            }else if(firstNewNumber < secondNewNumber){
                System.out.println("Second new number is bigger than the first new number: " + firstNewNumber + "<" +secondNewNumber);
            }else{
                System.out.println("Two new numbers are equals: " + firstNewNumber + "=" + secondNewNumber);
            }
        }
    }
}