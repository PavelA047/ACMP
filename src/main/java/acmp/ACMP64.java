package acmp;

import java.util.Scanner;

public class ACMP64 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(method(scanner));
        }
    }

    private static String method(Scanner scanner) {
        int count = scanner.nextInt();
        int number;
        StringBuilder sb = new StringBuilder();
        StringBuilder sbReturn = new StringBuilder();
        sb.append(2);
        int lastPrimeNumber = 2;

        for (int i = 0; i < count; i++) {
            number = scanner.nextInt();
            while (number > sb.length()) lastPrimeNumber = resizeString(sb, lastPrimeNumber);
            sbReturn.append(Character.getNumericValue(sb.charAt(number - 1)));
        }

        return sbReturn.toString();
    }

    private static int resizeString(StringBuilder sb, int lastPrimeNumber) {
        int newLastNumber = nextPrime(lastPrimeNumber);
        sb.append(newLastNumber);
        return newLastNumber;
    }

    private static int nextPrime(int lastPrimeNumber) {
        for (int i = lastPrimeNumber + 1; ; i++) {
            if (isPrime(i)) {
                return i;
            }
        }
    }

    private static boolean isPrime(int n) {
        for (int i = 2; i <= n / i; i++) {
            if (n % i == 0) return false;
        }
        return n > 1;
    }
}
