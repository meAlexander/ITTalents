import java.util.Arrays;
import java.util.Scanner;

public class ExerciseFour {
    public static void main(String[] args) {
        getInput();
    }

    public static void getInput() {
        Scanner scanner = new Scanner(System.in);
        String[] names;

        do {
            System.out.print("Enter full name: ");
            names = scanner.nextLine().split("[,]+\\s|[,]");
        } while (names.length != 2 || names[0].split("\\s").length != 3 || names[1].split("\\s").length != 3);

        String fullName = names[0];
        String fullName2 = names[1];

        compareTwoFullNames(fullName, fullName2);
    }

    public static void compareTwoFullNames(String fullName, String fullName2) {
        int asciSum1 = 0;
        for (int i = 0; i < fullName.length(); i++) {
            asciSum1 += fullName.charAt(i);
        }

        int asciSum2 = 0;
        for (int i = 0; i < fullName2.length(); i++) {
            asciSum2 += fullName2.charAt(i);
        }
        System.out.println("ASCII values: " + asciSum1 + " " + asciSum2);

        if (asciSum1 > asciSum2) {
            System.out.println(fullName);
        } else if (asciSum1 < asciSum2) {
            System.out.println(fullName2);
        } else {
            System.out.println("Both names have Equal asci codes.");
        }

        byte[] firstName = fullName.getBytes();
        byte[] secondName = fullName2.getBytes();
        System.out.println(Arrays.toString(firstName));
        System.out.println(Arrays.toString(secondName));

//        int difference = fullName2.compareTo(fullName);
//        if(difference < 0){
//            System.out.println(fullName2);
//        }else if(difference > 0){
//            System.out.println(fullName);
//        }else{
//            System.out.println("Both names have Equal asci codes");
//        }
    }
}