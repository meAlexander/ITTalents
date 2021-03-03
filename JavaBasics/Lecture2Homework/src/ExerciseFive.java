import java.util.Scanner;

public class ExerciseFive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You have to enter three numbers and order them in descending order!");

        System.out.print("Enter number one: ");
        double numberOne = scanner.nextDouble();

        System.out.print("Enter number two: ");
        double numberTwo = scanner.nextDouble();

        System.out.print("Enter number three: ");
        double numberThree = scanner.nextDouble();

        System.out.println("Ordering numbers....");
        if (numberOne >= numberTwo && numberThree >= numberTwo){
            if(numberOne >= numberThree){
                System.out.println(numberOne + "\n" + numberThree + "\n" + numberTwo);
            }else{
                System.out.println(numberThree + "\n" + numberOne + "\n" + numberTwo);
            }
        }else if(numberOne >= numberThree && numberTwo >= numberThree){
            if(numberOne >= numberTwo) {
                System.out.println(numberOne + "\n" + numberTwo + "\n" + numberThree);
            }else{
                System.out.println(numberTwo + "\n" + numberOne + "\n" + numberThree);
            }
        }else if (numberOne <= numberThree && numberOne <= numberThree){
            if(numberTwo >= numberThree){
                System.out.println(numberTwo + "\n" + numberThree + "\n" + numberOne);
            }else{
                System.out.println(numberThree + "\n" + numberTwo + "\n" + numberOne);
            }
        }
    }
}