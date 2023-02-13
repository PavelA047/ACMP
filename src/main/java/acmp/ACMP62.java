package acmp;

import java.util.Scanner;

public class ACMP62 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(method(scanner));
        }
    }

    private static String method(Scanner scanner) {
        int[] ints = scanner.next().chars().toArray();
        if (ints[0] % 2 == 0 && ints[1] % 2 == 0 || ints[0] % 2 != 0 && ints[1] % 2 != 0) return "BLACK";
        else return "WHITE";
    }
}
