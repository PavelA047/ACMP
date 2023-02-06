package acmp;

import java.io.*;
import java.util.Scanner;

public class ACMP27 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println(method(in));
    }

    public static int method(Scanner in) {
        int w = in.nextInt();
        int h = in.nextInt();

        int count = in.nextInt();

        int[][] holst = new int[h][w];

        for (int i = 0; i < count; i++) {
            int x1 = in.nextInt();
            int y1 = in.nextInt();
            int x2 = in.nextInt();
            int y2 = in.nextInt();
            for (int j = 0; j < h; j++) {
                for (int k = 0; k < w; k++) {
                    if (k >= x1 && j >= y1 && k < x2 && j < y2) {
                        holst[j][k] = 1;
                    }
                }
            }
        }

        int res = 0;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (holst[i][j] == 0) res++;
            }
        }
        return res;
    }

}
