package acmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ACMP24 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(method1(reader.readLine()));
    }

    public static int method1(String str) {
        int[] arr = Arrays.stream(str.split(" "))
                .map(Integer::parseInt)
                .mapToInt(x -> x)
                .toArray();

        int n = arr[0];
        int m = arr[1];

        if (m == 0) return 1;
        if (m == 1) return n;

        int res = 0;

        for (int gap = 0; gap < n; gap++) {
            int capacity = gap * (m - 1) + m;
            int finish = n - capacity;
            for (int start = 0; start <= finish; start++) {
                res++;
            }
        }
        return res;
    }

}
