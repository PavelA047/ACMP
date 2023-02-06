package acmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Hair {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String number = reader.readLine();
        String str = reader.readLine();
        method(str);
    }

    public static void method(String str) {
        int[] arr = Arrays.stream(str.split(" "))
                .map(Integer::parseInt)
                .mapToInt(x -> x)
                .toArray();

        int sum = 0;
        int numOfIndex = 0;
        int max = getMax(arr, 0, arr.length - 1);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == max) {
                sum += arr[i] * (i + 1 - numOfIndex);
                numOfIndex = i + 1;
                max = getMax(arr, i + 1, arr.length - 1);
            }
        }

        System.out.println(sum);
    }

    private static int getMax(int[] arr, int lIndex, int rIndex) {
        int max = 0;

        for (int i = lIndex; i <= rIndex; i++) {
            if (arr[i] > max) max = arr[i];
        }

        return max;
    }

}
