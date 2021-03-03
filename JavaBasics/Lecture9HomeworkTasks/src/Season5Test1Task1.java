import java.util.Scanner;

public class Season5Test1Task1 {
    public static void main(String[] args) {
        getInput();
    }

    private static void getInput() {
        Scanner scanner = new Scanner(System.in);
        int count = 0;

        while(true){
            System.out.print("Enter result: ");
            String result = scanner.nextLine();

            if(result.equals("Heads")){
                count++;

                if(count == 5){
                    System.out.println("Congrats! 5 consecutive \"Heads\"");
                    break;
                }
            }else{
                count = 0;
            }
        }
    }
}