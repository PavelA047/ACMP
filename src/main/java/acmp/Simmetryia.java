package acmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Simmetryia {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        String str1 = reader.readLine();
        System.out.println(method1(str, str1));
    }

    public static String method1(String str, String str1) {
        Integer[] arr = Arrays.stream(str.split(" "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        Integer[] arr1 = Arrays.stream(str1.split(" "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        int x1 = arr[0];
        int y1 = arr[1];
        int x2 = arr[2];
        int y2 = arr[3];

        int a = arr1[0];
        int b = arr1[1];

        if (x1 == x2) {
            return (x1 * 2 - a) + " " + b;
        } else {
            return a + " " + (y2 * 2 - b);
        }
    }

}
