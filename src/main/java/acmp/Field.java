package acmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Field {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String number = reader.readLine();
        String str = reader.readLine();
        System.out.println(method1(number, str));
    }

    public static int method1(String number, String str) {
        int num = Integer.parseInt(number) - 1;
        int[] arr = Arrays.stream(str.split(" "))
                .map(Integer::parseInt)
                .mapToInt(x -> x)
                .toArray();

        int result = 0;
        for (int k = 1; k <= num; k++) {
            if (num % k == 0) {
                int l = 0;
                while ((l < num - k) && (arr[l] == arr[(l + k)])) {
                    l++;
                }
                if (l == num - k) {
                    result = k;
                    break;
                }
            }
        }
        return result;
    }

}
