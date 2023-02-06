package acmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Pow {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(method(new BigInteger(reader.readLine())));
    }

    public static String method(BigInteger i) {
        if (i.equals(BigInteger.valueOf(0))) return String.valueOf(10);
        if (i.compareTo(BigInteger.valueOf(10)) < 0) return String.valueOf(i);

        StringBuilder sb = new StringBuilder();
        if (!getBiggestOldestDigit(i, sb)) return String.valueOf(-1);

        return sb.reverse().toString();
    }

    private static boolean getBiggestOldestDigit(BigInteger i, StringBuilder sb) {
        for (int j = 9; j > 1; j--) {
            if (i.remainder(BigInteger.valueOf(j)).intValue() == 0) {
                sb.append(j);
                return getBiggestOldestDigit(i.divide(BigInteger.valueOf(j)), sb);
            }
        }
        return i.equals(BigInteger.valueOf(1));
    }

}

//import java.io.PrintWriter;
//import java.util.Scanner;
//
//public class Pow {
//
//    public static void main(String[] args) {
//
//        try (Scanner in = new Scanner(System.in);
//             PrintWriter out = new PrintWriter(System.out)) {
//
//            solve(in, out);
//        }
//    }
//
//    private static void solve(Scanner in, PrintWriter out) {
//        int n = in.nextInt();
//
//        long result = 0;
//        long pow = 1;
//
//
//        if (n == 0) {
//            out.print("10");
//            out.flush();
//            return;
//        }
//        if (n < 10) {
//            out.print(n);
//            out.flush();
//            return;
//        }
//
//        for (int digit = 9; digit >= 2; digit--) {
//            while (n % digit == 0) {
//                n /= digit;
//                result += digit * pow;
//                pow *= 10;
//            }
//
//        }
//
//        if (n == 1) {
//            out.print(result);
//
//        } else {
//            out.print("-1");
//        }
//        out.flush();
//    }
//
//}
