package acmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TwoCirc {
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
        int r1 = arr[2];

        int x2 = arr1[0];
        int y2 = arr1[1];
        int r2 = arr1[2];

        double r = Math.sqrt(Math.pow(x2 - x1, 2) + (Math.pow(y2 - y1, 2)));

        if (r1 + r2 >= r && r + r1 >= r2 && r + r2 >= r1) return "YES";
        else return "NO";
    }

}
