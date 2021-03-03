import java.util.Scanner;

public class ExerciseSeven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You have to enter three values and follow the instructions!");

        System.out.print("Enter hour: ");
        int hour = scanner.nextInt();

        System.out.print("Enter your money: ");
        double money = scanner.nextDouble();

        System.out.print("Enter true if you are sick and false if you are not: ");
        boolean sick = scanner.nextBoolean();

        if(sick){
            System.out.println("You have to stay home!");

            if(money > 50){
                System.out.println("You can buy medicines.");
            }else{
                System.out.println("You have to drink a lot of tea!");
            }
        }else{
            if(money < 10){
                System.out.println("You can go to coffee.");
            }else {
                System.out.println("You can go to cinema with friends.");
            }
        }
    }
}