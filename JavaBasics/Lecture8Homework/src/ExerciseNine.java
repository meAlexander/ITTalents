import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Scanner;

public class ExerciseNine {
    public static void main(String[] args) throws ParseException {
        getInput();
    }

    public static void getInput() throws ParseException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter some text: ");
        String text = scanner.nextLine();

        extractNumbersFromText(text);
    }

    public static void extractNumbersFromText(String text) {
        int sum = 0;
        int number = 0;
        boolean negative = false;

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (Character.isDigit(c)) {
                if (i > 0 && text.charAt(i - 1) == '-') {
                    negative = true;
                }
                number *= 10;
                number += c - '0';
            } else {
                if (negative) {
                    number *= -1;
                    negative = false;
                }
                if (number != 0) {
                    System.out.println(number);
                    sum += number;
                    number = 0;
                }
            }

            if (i == text.length() - 1) {
                if(Character.isDigit(c)){
                    System.out.println(number);
                    sum += number;
                }
            }
        }
        System.out.println("Total = " + sum);
    }
}