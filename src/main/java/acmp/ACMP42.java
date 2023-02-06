package acmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ACMP42 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int i = Integer.parseInt(reader.readLine());
        System.out.println(method(i));
    }

    public static long method(int i) {
        if (i == 1) return 1;
        if (i == 2) return 2;
        if (i == 3) return 2;

        long powOfThree = i / 3;
        long ost = i % 3;
        long res;

        if (ost == 0) {
            res = (long) Math.pow(3, powOfThree);
        } else if (ost == 1) {
            powOfThree -= 1;
            res = (long) Math.pow(3, powOfThree) * 2 * 2;
        } else {
            res = (long) Math.pow(3, powOfThree) * 2;
        }

        return res;
    }

}
