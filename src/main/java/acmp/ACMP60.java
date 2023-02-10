package acmp;

import java.util.Scanner;

public class ACMP60 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        System.out.println(method(number));
    }

    private static int method(int number) {
        int pos1 = 0;
        int pos2 = 0;

        for (int i = 2; ; i++) {
            if (isPrime(i)) {
                pos1++;
                if (isPrime(pos1)) {
                    pos2++;
                    if (pos2 == number) return i;
                }
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
