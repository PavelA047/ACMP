package acmp;

import java.util.Scanner;

public class ACMP69 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(method(scanner));
        }
    }

    private static String method(Scanner scanner) {
        double count = scanner.nextDouble();
        double length = scanner.nextDouble();

        double x = Math.PI / count;

        double iR = length / (2 * Math.tan(x));
        double oR = length / (2 * Math.sin(x));

        return oR - iR < 1 ? "YES" : "NO";
    }

}
