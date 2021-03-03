import java.util.Scanner;

public class ExerciseFifteen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You have to enter an hour between 0 and 24 and look a message!");

        System.out.print("Enter an hour: ");
        int hour = scanner.nextInt();

        if(hour > 18 || hour < 4){
            System.out.println("Good evening!");
        }else if (hour > 4 && hour < 9){
            System.out.println("Good morning!");
        }else if(hour > 9 && hour < 18){
            System.out.println("Good afternoon!");
        }
    }
}