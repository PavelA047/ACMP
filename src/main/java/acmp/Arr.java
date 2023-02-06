package acmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Arr {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String number = reader.readLine();
        String str = reader.readLine();
        System.out.println(method1(number, str));
    }

    public static String method1(String num, String str) {
        String[] arr = str.split(" ");

        int sum = Arrays.stream(arr)
                .map(Integer::parseInt)
                .filter(x -> x > 0)
                .mapToInt(x -> x)
                .sum();

        int min = Arrays.stream(arr)
                .map(Integer::parseInt)
                .min(Comparator.naturalOrder())
                .orElse(0);

        int max = Arrays.stream(arr)
                .map(Integer::parseInt)
                .max(Comparator.naturalOrder())
                .orElse(0);

        Integer reduce;

        if (Arrays.asList(arr).indexOf(String.valueOf(max)) < Arrays.asList(arr).indexOf(String.valueOf(min))) {
            reduce = Arrays.stream(arr)
                    .map(Integer::parseInt)
                    .dropWhile(x -> x < max)
                    .skip(1)
                    .takeWhile(x -> x > min)
                    .reduce(1, (x, y) -> x * y);
        } else {
            reduce = Arrays.stream(arr)
                    .map(Integer::parseInt).dropWhile(x -> x == max)
                    .dropWhile(x -> x > min)
                    .skip(1)
                    .takeWhile(x -> x < max)
                    .reduce(1, (x, y) -> x * y);
        }
        return sum + " " + reduce;
    }

}
