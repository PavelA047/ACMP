package acmp;

import java.util.Scanner;

public class ACMP74 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(method(scanner));
        }
    }

    private static int method(Scanner scanner) {
        int count = scanner.nextInt();
        int number = scanner.nextInt();
        int retVal = 0;

        return rec(retVal, count, number);
    }

    private static int rec(int retVal, int count, int number) {
        if (count == 1) return ++retVal;
        if (number % 2 == 0) return number / 2 + retVal;
        else {
            retVal += count / 2;
            int newCount = count / 2;
            if (count % 2 != 0) newCount++;
            return rec(retVal, newCount, number == 1 ? 1 : number / 2 + 1);
        }
    }

}
