package acmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.Math.abs;

public class ACMP12 {
    public static void main(String[] args) throws IOException {
        int count = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());
        for (int i = 0; i < num; i++) {
            String str = reader.readLine();
            if (method1(str)) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static boolean method1(String str) {
        Integer[] arr = Arrays.stream(str.split(" "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        Point a = new Point(arr[2], arr[3]);
        Point b = new Point(arr[4], arr[5]);
        Point c = new Point(arr[6], arr[7]);
        Point d = new Point(arr[8], arr[9]);
        Point person = new Point(arr[0], arr[1]);

        double firstTrSqr = triangleSqr(a, b, person);
        double secondSqr = triangleSqr(b, c, person);
        double thirdSqr = triangleSqr(c, d, person);
        double forthSqr = triangleSqr(d, a, person);
        double rectangleSqr = triangleSqr(a, b, c) + triangleSqr(a, d, c);

        return rectangleSqr == firstTrSqr + secondSqr + thirdSqr + forthSqr;
    }

    static double triangleSqr(Point a, Point b, Point c) {
        return abs(0.5 * ((b.x - a.x) * (c.y - a.y) - (c.x - a.x) * (b.y - a.y)));
        // косое произведение 2 векторов
    }

    static class Point {
        double x;
        double y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public double getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

}

