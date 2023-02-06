package acmp;

import java.io.PrintWriter;

import static java.lang.Math.abs;

import java.util.Scanner;

public class ACMP19 {

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in);
             PrintWriter out = new PrintWriter(System.out)) {

            solve(in, out);
        }
    }

    private static void solve(Scanner in, PrintWriter out) {
        String[] pos = in.nextLine().split(" ");
        //A B C D E F G H  1 2 3 4 5 6 7 8 // "D1 D3 E5";
        int[][] doska = new int[8][8];

        int Fi = pos[0].charAt(0) - 65;
        int Fj = pos[0].charAt(1) - 49;

        int Li = pos[1].charAt(0) - 65;
        int Lj = pos[1].charAt(1) - 49;

        int Ki = pos[2].charAt(0) - 65;
        int Kj = pos[2].charAt(1) - 49;


        doska[Fi][Fj] = 2; //Ферзь
        doska[Li][Lj] = 2; //Ладья
        doska[Ki][Kj] = 2; //Конь

        for (int i = 0; i < doska.length; i++) {
            for (int j = 0; j < doska.length; j++) {

                if (doska[i][j] == 0) {

                    //Ферзь
                    if ((i == Fi || j == Fj) || (abs(i - Fi) == abs(j - Fj))) {
                        doska[i][j] = 1;
                    }

                    //Ладья
                    if (i == Li || j == Lj) {
                        doska[i][j] = 1;
                    }

                    //Конь
                    if (abs((i - Ki) * (j - Kj)) == 2) {
                        doska[i][j] = 1;
                    }
                }
            }
        }

        int count = 0;
        // out.println();
        for (int i = 0; i < doska.length; i++) {
            for (int j = 0; j < doska.length; j++) {
                if (doska[i][j] == 1) {
                    count++;
                }
                //     out.print(doska[j][i]);
            }
            //  out.println();
        }

        out.print(count);
        out.flush();
    }

}
