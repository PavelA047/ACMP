package acmp;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class ACMP100 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(method(scanner));
        }
    }

    private static String method(Scanner scanner) {
        int number = scanner.nextInt();
        BigInteger[][] arr = new BigInteger[number / 2][number / 2 * 9 + 1];
        for (BigInteger[] bigIntegers : arr) {
            Arrays.fill(bigIntegers, BigInteger.ZERO);
        }

        for (int i = 0; i < 10; i++) {
            arr[0][i] = BigInteger.ONE;
        }

        int plusNineIndex = 9;
        for (int i = 1; i < arr.length; i++) {
            plusNineIndex += 9;
            for (int j = plusNineIndex; j >= 0; j--) {
                for (int k = 0; k < 10; k++) {
                    if (j - k < 0) break;
                    arr[i][j] = arr[i][j].add(arr[i - 1][j - k]);
                }
            }
        }

        BigInteger retVal = BigInteger.ZERO;
        for (BigInteger i : arr[number / 2 - 1]) {
            retVal = retVal.add(i.pow(2));
        }

        return retVal.toString();
    }

}
