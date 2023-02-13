package acmp;

import java.util.Scanner;

public class ACMP61 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(method(scanner));
        }
    }

    private static String method(Scanner scanner) {
        int x = 0;
        int y = 0;

        for (int i = 0; i < 4; i++) {
            x += scanner.nextInt();
            y += scanner.nextInt();
        }

        if (x == y) return "DRAW";
        return x > y ? "1" : "2";
    }

}
