package acmp;

import java.util.Scanner;

public class ACMP58 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < number; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            sb.append(method(new int[n][m], scanner)).append("\n");
        }
        System.out.println(sb);
        scanner.close();
    }

    private static String method(int[][] arr, Scanner scanner) {
        if (arr.length < 2 || arr[0].length < 2) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    arr[i][j] = scanner.nextInt();
                }
            }
            return "YES";
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        boolean flag = false;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                if (arr[i][j] == arr[i - 1][j - 1] && arr[i][j] == arr[i][j - 1] && arr[i][j] == arr[i - 1][j]) {
                    flag = true;
                }
            }
        }

        return flag ? "NO" : "YES";
    }

}
