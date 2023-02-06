package acmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class ACMP31 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        System.out.println(method1(str));
    }

    public static int method1(String str) {
        Integer[] arr = Arrays.stream(str.split(" "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        int n = arr[0];
        int k = arr[1];

        int facN = getFactorial(n);
        int facK = getFactorial(k);
        int facNK = getFactorial(n - k);
        int stampedVariants = facN / (facK * facNK);

        double subFac = 0;
        for (int i = 1; i <= n - k; i++) {
            subFac += Math.pow(-1, i) * ((double) 1 / getFactorial(i));
        }
        subFac = facNK * (1 + subFac);

        return (int) (stampedVariants * subFac);
    }

    private static int getFactorial(int n) {
        return IntStream.rangeClosed(1, n)
                .reduce(1, (x, y) -> x * y);
    }

}
