package errors;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Input 1st Number:");
            int a = scanner.nextInt();
            System.out.println("Input 2st Number:");
            int b = scanner.nextInt();
        }catch (InputMismatchException e){
            e.printStackTrace();
            System.err.println("Wrong number format. Pleas use Integers only");
            return;// Беззаговорочный выход из метода.
        }

        System.out.println("End.");

    }
}
