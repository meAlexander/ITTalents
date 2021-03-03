import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] arr = {'a', 'c', 'd', 'f', 'v', 'r', 'p'};
        int flag = 0;

        System.out.print("Enter symbol: ");
        char symbol = scanner.next().charAt(0);

        for (int i = 0; i < arr.length; i++) {
            if(symbol == arr[i]){
                flag = 1;
                System.out.println("Symbol '"+symbol+"' is located at " + i + " index");
            }
        }

        if(flag == 0){
            System.out.println("Symbol '"+symbol+"' did not found in array");
        }
    }
}