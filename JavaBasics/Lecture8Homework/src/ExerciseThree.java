import java.util.Scanner;

public class ExerciseThree {
    public static void main(String[] args) {
        getInput();
    }

    public static void getInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter some word: ");
        String text1 = scanner.next();
        scanner.nextLine();

        System.out.print("Enter some word: ");
        String text2 = scanner.next();

        compareLength(text1, text2);
        compareContent(text1, text2);
    }

    public static void compareContent(String text1, String text2) {
        for (int i = 0; i < text1.length() && i < text2.length(); i++) {
            if(!(text1.charAt(i) == text2.charAt(i))){
                System.out.println(i+1 + " " + text1.charAt(i) + "-" + text2.charAt(i));
            }
        }
    }

    public static void compareLength(String text1, String text2) {
        if(text1.length() > text2.length()){
            System.out.println(text1 + " has larger length: " + text1.length());
        }else if(text2.length() > text1.length()) {
            System.out.println(text2 + " has larger length: " + text2.length());
        }else{
            System.out.println("Both word have same length: " + text1.length());
        }
    }
}