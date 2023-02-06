package acmp;

import java.io.PrintWriter;
import java.util.Scanner;

public class ACMP48 {

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in);
             PrintWriter out = new PrintWriter(System.out)) {

            solve(in, out);
        }
    }

    //самый большой делитель, начинающийся с 1 и самым длинным количеством нулей
    private static void solve(Scanner in, PrintWriter out) {
        String n = in.next();
        int l = n.length() - 1;
        int cnt = 0;
        while (n.charAt(l) == '0') {
            cnt++;
            l--;
        }
        out.print(1 + "0".repeat(cnt));
        out.flush();
    }

}
