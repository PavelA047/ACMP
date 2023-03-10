package acmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ACMP14 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        System.out.println(method1(str));
    }

    public static int method1(String str) {
        Integer[] arr = Arrays.stream(str.split(" "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        int a = arr[0];
        int b = arr[1];
        int c = a;

        while (c % b != 0) {
            c += a;
        }

        return c;
    }

}
