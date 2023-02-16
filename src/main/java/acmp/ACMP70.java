package acmp;

import java.util.Scanner;

public class ACMP70 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(method(scanner));
        }
    }

    private static String method(Scanner scanner) {
        String str = scanner.next();
        String k = scanner.next();

        if (k.startsWith("-")) {
            int powerOfSqrt = Integer.parseInt(k.substring(1));
            if (str.length() % powerOfSqrt != 0) return "NO SOLUTION";
            int part = str.length() / powerOfSqrt;
            String strPart = str.substring(0, part);
            for (int i = part; i < str.length(); i += part) {
                if (!str.substring(i, i + part).equals(strPart)) return "NO SOLUTION";
            }
            return str.substring(0, part);
        } else {
            StringBuilder sb = new StringBuilder();
            int kInt = Integer.parseInt(k);
            for (int i = 0; i < kInt; i++) {
                sb.append(str);
                if (sb.length() >= 1023) {
                    return sb.substring(0, 1023);
                }
            }
            return sb.toString();
        }
    }

}
