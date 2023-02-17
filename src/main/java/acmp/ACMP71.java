package acmp;

import java.util.Scanner;

public class ACMP71 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(method(scanner));
        }
    }

//    private static int method(Scanner scanner) {
//        int n = scanner.nextInt();
//        int[] arr = new int[n];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = scanner.nextInt();
//        }
//        int min = Integer.MAX_VALUE;
//
//        for (int code = 0; code < (1 << (n - 1)); code++) {
//            int sum0 = 0;
//            int sum1 = 0;
//
//            for (int i = 0; i < n; i++) {
//                if (((code >> i) & 1) == 0) {
//                    sum0 += arr[i];
//                } else {
//                    sum1 += arr[i];
//                }
//            }
//
//            min = Math.min(min, Math.abs(sum0 - sum1));
//        }
//        return min;
//    }

    private static int method(Scanner scanner) {
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }

        return minDif(n - 2, arr[n - 1], 0, arr);
    }

    private static int minDif(int i, int sum0, int sum1, int[] arr) {
        if (i == -1) {
            return Math.abs(sum0 - sum1);
        } else {
            return Math.min(minDif(i - 1, sum0 + arr[i], sum1, arr), minDif(i - 1, sum0, sum1 + arr[i], arr));
        }
    }

}
