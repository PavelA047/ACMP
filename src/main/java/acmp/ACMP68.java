package acmp;

import java.util.Scanner;

public class ACMP68 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(method(scanner));
        }
    }

    private static String method(Scanner scanner) {
        String place = scanner.next();
        int count = scanner.nextInt();

        if (place.equals("School") && count % 2 == 0) return "No";
        else return "Yes";
    }

}
