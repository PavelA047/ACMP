package acmp;

import java.util.Scanner;

public class ACMP79 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(method(scanner));
        }
    }

    private static int method(Scanner scanner) {
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int retVal = a;

        for (int i = 0; i < b - 1; i++) {
            retVal = retVal % 10 * a;
        }

        return retVal % 10;
    }

}
