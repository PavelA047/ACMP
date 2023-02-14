package acmp;

import java.util.Scanner;

public class ACMP65 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(method(scanner));
        }
    }

    private static String method(Scanner scanner) {
        String massage = scanner.next();
        int n = scanner.nextInt();
        int number = 0;
        int count = 0;
        int shortestDiff = Integer.MAX_VALUE;
        String current;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            current = scanner.next();
            number++;
            int difference = 0;
            if (massage.length() > current.length()) {
                for (int j = 0; j < current.length(); j++) {
                    if (massage.charAt(j) != current.charAt(j)) difference++;
                }
                difference += massage.length() - current.length();
            }
            if (massage.length() < current.length()) {
                for (int j = 0; j < massage.length(); j++) {
                    if (massage.charAt(j) != current.charAt(j)) difference++;
                }
                difference += current.length() - massage.length();
            } else {
                for (int j = 0; j < current.length(); j++) {
                    if (massage.charAt(j) != current.charAt(j)) difference++;
                }
            }

            if (shortestDiff > difference) {
                sb.setLength(0);
                count = 1;
                sb.append(number);
                shortestDiff = difference;
            } else if (shortestDiff == difference) {
                sb.append(" ").append(number);
                count++;
            }
        }

        return sb.insert(0, "\n").insert(0, count).toString();
    }

}
