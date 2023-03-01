package acmp;

import java.util.Scanner;

public class ACMP78 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(method(scanner));
        }
    }

    private static int method(Scanner scanner) {
        int f = scanner.nextInt();
        int p = scanner.nextInt();
        int sumToReturn = f;
        int countOfBottles;
        int change;

        for (int i = 0; i < 4; i++) {
            countOfBottles = sumToReturn / p;
            change = sumToReturn % p;
            while (change + p < f) {
                change += p;
                countOfBottles -= 1;
            }

            sumToReturn = countOfBottles * f + change;
        }

        return sumToReturn;
    }

}
