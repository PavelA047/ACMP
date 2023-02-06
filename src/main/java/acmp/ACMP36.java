package acmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ACMP36 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(method1(Integer.parseInt(reader.readLine())));
    }

    //медленно!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    //n*n
//    public static int method1(int i) {
//        int count = 0;
//
//        for (int j = i + 1; j < i * 2; j++) {
//            int k = 0;
//            for (int l = 2; l < j; l++) {
//                if (j % l == 0) k++;
//            }
//            if (k == 0) count++;
//        }
//
//        return count;
//    }

    //nLog(n)
    public static int method1(int num) {
        int count = 0;

        boolean[] isPrime = new boolean[num * 2];
        Arrays.fill(isPrime, true);

        for (int i = 2; i * i <= num * 2; i++) {
            if (isPrime[i - 1]) {
                for (int j = 2 * i; j <= num * 2; j += i) {
                    isPrime[j - 1] = false;
                }
            }
        }

        for (int i = num + 1; i <= isPrime.length - 1; i++) {
            if (isPrime[i - 1]) count++;
        }
        return count;
    }

}
