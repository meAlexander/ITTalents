import java.util.Scanner;

public class ExerciseFourteen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You have to enter two coordinates between 1 and 8!");

        /*
            нечетно нечетно -> тъмно
            четно  нечетно - > светло
            четно четно -> тъмно
            нечетно четно -> светло
            (или обратното)...
            нечетно нечетно -> светло
            четно  нечетно - > тъмно
            четно четно -> светло
            нечетно четно -> тъмно
         */

        System.out.print("Enter coordinate for aX: ");
        int aX = scanner.nextInt();
        System.out.print("Enter coordinate for aY: ");
        int aY = scanner.nextInt();

        System.out.print("Enter coordinate for bX: ");
        int bX = scanner.nextInt();
        System.out.print("Enter coordinate for bY: ");
        int bY = scanner.nextInt();

        if ((aX < 1 || aX > 8) || (aY < 1 || aY > 8) || (bX < 1 || bX > 8) || (bY < 1 || bY > 8)) {
            System.out.println("Your number/s is/are out of boundary!");
        } else {
            if ((aX % 2 == 0 && aY % 2 == 0) || (aX % 2 != 0 && aY % 2 != 0)) {
                if ((bX % 2 == 0 && bY % 2 == 0) || (bX % 2 != 0 && bY % 2 != 0)) {
                    System.out.println("The Positions have equals colors!");
                }
                else {
                    System.out.println("The Positions do NOT have equals colors!");
                }
            }else if(aX == bX){
                if((aY % 2 == 0 && bY % 2 == 0) || aY % 2 != 0 && bY % 2 != 0){
                    System.out.println("The Positions have equals colors!");
                }else {
                    System.out.println("The Positions do NOT have equals colors!");
                }
            }

            if ((aX % 2 != 0 && aY % 2 == 0) || (aX % 2 == 0 && aY % 2 != 0)){
                if((bX % 2 == 0 && bY % 2 != 0) || (bX % 2 != 0 && bY % 2 == 0)){
                    System.out.println("The Positions have equals colors!");
                }else {
                    System.out.println("The Positions do NOT have equals colors!");
                }
            }
        }
    }
}