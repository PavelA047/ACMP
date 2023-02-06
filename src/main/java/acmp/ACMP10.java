package acmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ACMP10 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        Integer[] arr = Arrays.stream(str.split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        System.out.println(kub(arr[0], arr[1], arr[2], arr[3]));
    }

    public static String kub(int a, int b, int c, int d) {
        StringBuilder sb = new StringBuilder();
        for (int x = -100; x <= 100; x++) {
            double result = a * Math.pow(x, 3) + b * x * x + c * x + d;
            if (result == 0) {
                sb.append(x).append(" ");
            }
        }
        return sb.toString();
    }
}
