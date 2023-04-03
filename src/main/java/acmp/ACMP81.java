package acmp;

import java.util.Scanner;

public class ACMP81 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(method(scanner));
        }
    }

    private static String method(Scanner scanner) {
        int count = scanner.nextInt();
        int current1 = scanner.nextInt();
        int min = current1;
        int max = current1;

        for (int i = 1; i < count; i++) {
            int current = scanner.nextInt();
            if (current > max) max = current;
            if (current < min) min = current;

        }
        return min + " " + max;
    }

}
