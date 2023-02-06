package acmp;

import java.io.*;
import java.util.*;

class ACMP38 {

    public static void Calc(int l, int r) {
        if (r - l == 1) {
            b[l][r][1] = Math.max(a[l], a[r]);
            b[l][r][2] = a[l] + a[r] - b[l][r][1];
        } else {
            if (b[l][r - 1][1] == 0) {
                Calc(l, r - 1);
            }
            if (b[l + 1][r][1] == 0) {
                Calc(l + 1, r);
            }
            if (b[l][r - 1][2] + a[r] > (b[l + 1][r][2] + a[l])) {
                b[l][r][1] = b[l][r - 1][2] + a[r];
                b[l][r][2] = b[l][r - 1][1];
            } else {
                b[l][r][1] = b[l + 1][r][2] + a[l];
                b[l][r][2] = b[l + 1][r][1];
            }

        }
    }

    public static int a[];
    public static int b[][][];

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in);
             PrintWriter out = new PrintWriter(System.out)) {

            int n = in.nextInt();
            a = new int[n + 1];
            b = new int[n + 1][n + 1][3];
            for (int i = 1; i <= n; i++) {
                a[i] = in.nextInt();
            }
            Calc(1, n);
            if (b[1][n][1] > b[1][n][2]) {
                out.print("1");
            }
            if (b[1][n][1] < b[1][n][2]) {
                out.print("2");
            }
            if (b[1][n][1] == b[1][n][2]) {
                out.print("0");
            }

            out.flush();
        }
    }

}
