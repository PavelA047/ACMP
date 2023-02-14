package acmp;

import java.util.Scanner;

public class ACMP66 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(method(scanner));
        }
    }

    private static char method(Scanner scanner) {
        String keyBoard = "qwertyuiopasdfghjklzxcvbnm";
        String key = scanner.next();

        if (key.equals("m")) return 'q';
        return keyBoard.charAt(keyBoard.indexOf(key) + 1);
    }

}
