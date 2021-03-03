import java.util.Scanner;

public class ExerciseOne {
    public static void main(String[] args) {
        getInput();
    }

    public static void getInput(){
        Scanner scanner = new Scanner(System.in);
        String text1;
        do{
            System.out.print("Enter some string: ");
            text1 = scanner.nextLine();
        }while (text1.length() > 40);

        String text2;
        do{
            System.out.print("Enter some string: ");
            text2 = scanner.nextLine();
        }while (text2.length() > 40);

        transformTextToUpperCase(text1, text2);
        transformTextToLowerCase(text1, text2);
    }

    public static void transformTextToUpperCase(String text1, String text2){
        String text1ToUpperCase = text1.toUpperCase();
        String text2ToUpperCase = text2.toUpperCase();

        printTransformedText(text1ToUpperCase, text2ToUpperCase);
    }

    public static void transformTextToLowerCase(String text1, String text2){
        String text1ToLowerCase = text1.toLowerCase();
        String text2ToLowerCase = text2.toLowerCase();

        printTransformedText(text1ToLowerCase, text2ToLowerCase);
    }

    public static void printTransformedText(String text1, String text2){
        System.out.println(text1 + " " + text2);
    }
}