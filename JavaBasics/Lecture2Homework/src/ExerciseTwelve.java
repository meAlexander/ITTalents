import java.util.Scanner;

public class ExerciseTwelve {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You have to enter three numbers: day, month and year and print the next date!");

        System.out.print("Enter day: ");
        int day = scanner.nextInt();

        System.out.print("Enter month: ");
        int month = scanner.nextInt();

        System.out.print("Enter year: ");
        int year = scanner.nextInt();

        //check if 1.leap year(no more days in february than 29)
        //check if 2.not leap year(no more days in february than 28)
        //check if 3.month is 4,6,9,11(no more days than 30)
        //check if 4.day, month, year are correct for any other cases
        if(day < 1 || day > 29 && (year % 4 == 0 || year % 400 == 0) && month == 2){
            System.out.println("Entered date does not exist!");
        }else if (day < 1 || day > 28 && (year % 4 != 0 || year % 400 != 0) && month == 2){
            System.out.println("Entered date does not exist!");
        }else if(day < 1 || day > 30 && (month == 4 || month == 6 || month == 9 || month == 11)){
            System.out.println("Entered date does not exist!");
        }else if((day < 1 || day > 31) || (month < 1 || month > 12) || year < 0){
            System.out.println("Entered date does not exist!");
        }else{
            if ((year % 4 != 0 || year % 400 != 0) && month == 2 && day == 28) {
                day = 1;
                month++;
            } else if ((year % 4 == 0 || year % 400 == 0) && month == 2 && day == 29) {
                day = 1;
                month++;
            } else if ((month == 4 || month == 6 || month == 9 || month == 11) && day == 30) {
                day = 1;
                month++;
            } else if (month == 12 && day == 31) {
                day = 1;
                month = 1;
                year++;
            } else if (day == 31) {
                day = 1;
                month++;
            } else {
                day++;
            }
            System.out.println("Day: " + day + "\nMonth: " + month + "\nYear: " + year);
        }
    }
}