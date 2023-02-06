package acmp.dynamic;

import java.io.PrintWriter;

import static java.lang.Integer.min;
import static java.lang.Math.abs;

import java.util.*;
import java.util.stream.IntStream;

public class CompGame {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in);
             PrintWriter out = new PrintWriter(System.out)) {
            solve(in, out);
        }
    }

    private static void solve(Scanner in, PrintWriter out) {
        int n = in.nextInt();

        if (n == 1) {
            System.out.println(0);
            return;
        }

        int[] a = IntStream.range(0, n).map(i -> in.nextInt()).toArray();
        int[] b = new int[n];
        b[0] = 0;
        b[1] = abs(a[1] - a[0]);
        for (int i = 2; i < n; ++i) {
            b[i] = min(b[i - 1] + abs(a[i - 1] - a[i]),
                    b[i - 2] + 3 * abs(a[i - 2] - a[i]));
        }
        out.print(b[n - 1]);
        out.flush();
    }
}
