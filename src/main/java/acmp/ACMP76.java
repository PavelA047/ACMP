package acmp;

import java.util.Arrays;
import java.util.Scanner;

public class ACMP76 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(method(scanner));
        }
    }

    private static int method(Scanner scanner) {
        int n = scanner.nextInt();
        int[] a = new int[1440];
        String next;

        for (int i = 0; i < n; i++) {
            next = scanner.next();
            int temp = Integer.parseInt(next.substring(0, 2)) * 60 + Integer.parseInt(next.substring(3, 5));
            next = scanner.next();
            int temp1 = Integer.parseInt(next.substring(0, 2)) * 60 + Integer.parseInt(next.substring(3, 5));

            for (int j = temp; j <= temp1; j++) {
                a[j]++;
            }
        }

        Arrays.sort(a);
        return a[a.length - 1];
    }

}
