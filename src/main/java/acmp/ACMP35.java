package acmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ACMP35 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        for (int i = 0; i < count; i++) {
            System.out.println(method1(reader.readLine()));
        }
    }

    public static int method1(String str) {
        Integer[] arr = Arrays.stream(str.split(" "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        int n = arr[0];
        int m = arr[1];

        return 19 * m + (n + 239) * (n + 366) / 2;
    }
}
