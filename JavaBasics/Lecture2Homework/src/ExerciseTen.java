import java.util.Scanner;

public class ExerciseTen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You have to enter a volume between 10 and 9999!");

        System.out.print("Enter volume: ");
        int volume = scanner.nextInt();

        if(volume < 10 || volume > 9999){
            System.out.println("Your number is out of the boundary!");
        }else{
            int repetitiveCourses = volume / 5;
            int extraBuckets = volume % 5;

            System.out.println(repetitiveCourses + " times with 2 liters.\n" +
                               repetitiveCourses + " times with 3 liters.\n");

            if(extraBuckets == 1){
                System.out.println("Extra bucket with 2 liters(no bucket with 1 liter volume).");
            }else if(extraBuckets == 2){
                System.out.println("Extra bucket with 2 liters.");
            }else if(extraBuckets == 3){
                System.out.println("Extra bucket with 3 liters.");
            }else if(extraBuckets == 4){
                System.out.println("Two Extra bucket with 2 liters(or one with 2 liters and one with 3 liters if we have to use them together).");
            }
        }
    }
}