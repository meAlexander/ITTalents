import java.util.Scanner;

public class ExerciseThirteen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You have to enter a degree and check what is the weather like!");

        System.out.print("Enter degree: ");
        int degree = scanner.nextInt();

        if(degree < -100 || degree > 100){
            System.out.println("Too big degree entered!");
        }else{
            if(degree < - 20){
                System.out.println("It is freezing cold!");
            }else if(degree < 0 && degree > -20){
                System.out.println("It is cold!");
            }else if(degree < 15 && degree > 0){
                System.out.println("It is cool!");
            }else if(degree < 25 && degree > 15){
                System.out.println("It is warm!");
            }else{
                System.out.println("It is hot!");
            }
        }
    }
}