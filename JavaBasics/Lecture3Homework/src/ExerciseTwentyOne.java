import java.util.Scanner;

public class ExerciseTwentyOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You have to enter a number 1-52(for a card) and see the cards which are bigger than you entered.");
        int numberOfCard;
        int counter = 0;

        do{
            System.out.print("Enter a number: ");
            numberOfCard = scanner.nextInt();
        }while(numberOfCard < 1 || numberOfCard > 52);

        for (int cards = 2; cards <= 14; cards++) {
            for (int colors = 1; colors <= 4; colors++) {
                counter++;
                if (counter <= numberOfCard) {
                    if (cards <= 10) {
                        System.out.print(cards + " ");
                    }
                    switch (cards) {
                        case 11:
                            System.out.print("Вале ");
                            break;
                        case 12:
                            System.out.print("Дама ");
                            break;
                        case 13:
                            System.out.print("Поп ");
                            break;
                        case 14:
                            System.out.print("Асо ");
                            break;
                    }
                    switch (colors) {
                        case 1:
                            System.out.print("Спатия ");
                            break;
                        case 2:
                            System.out.print("Каро ");
                            break;
                        case 3:
                            System.out.print("Купа ");
                            break;
                        case 4:
                            System.out.print("Пика ");
                            break;
                    }
                }
            }
        }
    }
}