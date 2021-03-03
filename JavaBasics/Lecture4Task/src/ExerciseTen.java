import java.util.Scanner;

public class ExerciseTen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many shops did you visit: ");
        int number = scanner.nextInt();

        double[] sums = new double[number];
        double allMoney = 0;

        for (int i = 0; i < sums.length; i++) {
            System.out.println("How much money did you spend: ");
            sums[i] = scanner.nextDouble();
            allMoney += sums[i];
        }
        System.out.println(allMoney);
    }
}