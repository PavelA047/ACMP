package acmp;

import java.util.Scanner;

public class ACMP84 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            method(scanner);
        }
    }

    private static void method(Scanner scanner) {
        int strNum = scanner.nextInt();
        int colNum = scanner.nextInt();

        int left = Integer.MAX_VALUE;
        int right = 0;
        int up = Integer.MAX_VALUE;
        int down = 0;

        for (int i = 0; i < strNum; i++) {
            char[] chars = scanner.next().toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == '*') {
                    if (j < left) left = j;
                    if (j > right) right = j;
                    if (i < up) up = i;
                    if (i > down) down = i;
                }
            }
        }

        if (left > right || up > down) {
            for (int i = 0; i < strNum; i++) {
                System.out.println(".".repeat(colNum));
            }
        } else {
            for (int i = 0; i < strNum; i++) {
                for (int j = 0; j < colNum; j++) {
                    if (i <= down && i >= up && j >= left && j <= right) {
                        System.out.print("*");
                    } else System.out.print(".");
                }
                System.out.println("");
            }
        }
    }

}
