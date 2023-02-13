package acmp;

import java.util.Scanner;

public class ACMP63 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(method(scanner));
        }
    }

    private static String method(Scanner scanner) {
        int s = scanner.nextInt();
        int p = scanner.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= s; i++) {
            if (i * (s - i) == p) return sb.append(i).append(" ").append(s - i).toString();
        }

        return "";
    }
}
