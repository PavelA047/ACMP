package acmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ACMP2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        System.out.println(method(n));
    }

    public static int method(int number) {
        if (number > 0) {
            int n = 0;
            for (int i = 1; i <= number; i++) {
                n += i;
            }
            return n;
        } else if (number < 0) {
            int n = 0;
            for (int i = 1; i >= number; number++) {
                n += number;
            }
            return n;
        } else return 1;
    }
}
