import java.util.Scanner;

public class ExerciseFour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a size of array: ");
        int size = scanner.nextInt();

        int flag = 0;
        int[] array = new int[size];

        for (int i = 0; i < array.length; i++) {
            System.out.print("Enter value for " + i + " element: ");
            array[i] = scanner.nextInt();
        }

        for (int begin = 0, end = array.length - 1; begin < end; begin++, end--) {
            if(array[begin] != array[end]){
                flag = 1;
                break;
            }
        }

        if(flag == 1){
            System.out.println("Not equals.");
        }else{
            System.out.println("Equals.");
        }
    }
}