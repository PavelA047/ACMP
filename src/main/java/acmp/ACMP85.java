package acmp;

import java.util.Scanner;

public class ACMP85 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(method(scanner));
        }
    }

    private static String method(Scanner scanner) {
        int f = scanner.nextInt();
        int s = scanner.nextInt();
        StringBuilder sb = new StringBuilder();

        while (f != s) {
            if (f > s) f = f - s;
            else s = s - f;
        }

        sb.append("1".repeat(Math.max(0, f)));
        return sb.toString();
    }
}
