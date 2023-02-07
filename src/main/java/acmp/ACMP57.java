package acmp;

import java.io.IOException;
import java.util.Scanner;

public class ACMP57 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int numberOfPigs = scanner.nextInt();
        long c = scanner.nextLong();
        double p = scanner.nextDouble();
        int[] pairs = new int[numberOfPigs * 2 + 2];
        for (int i = 0; i < pairs.length; i++) {
            pairs[i] = scanner.nextInt();
        }

        System.out.println(method(c, p, pairs));
    }

    private static String method(long c, double p, int[] pairs) {
        double shortestLength = Double.MAX_VALUE;
        double tempLength;
        int yNet = pairs[pairs.length - 1];
        int xNet = pairs[pairs.length - 2];
        int x1;
        int x2;
        int y1;
        int y2;
        for (int i = 0; i < pairs.length - 2; i += 2) {
            x1 = pairs[i];
            y1 = pairs[i + 1];
            tempLength = getLengthBetweenTwoPoints(x1, xNet, y1, yNet);
            for (int j = 0; j < pairs.length - 2; j += 2) {
                if (i == j) continue;
                x2 = pairs[j];
                y2 = pairs[j + 1];
                tempLength += getLengthBetweenTwoPoints(x1, x2, y1, y2);
            }
            shortestLength = Math.min(shortestLength, tempLength);
        }

        double price = shortestLength * c;
        return p >= price ? "YES" : "NO";
    }

    private static double getLengthBetweenTwoPoints(int x1, int x2, int y1, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

}
