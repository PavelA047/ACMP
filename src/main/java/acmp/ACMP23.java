package acmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ACMP23 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());
        System.out.println(method1(num));
    }

    public static int method1(int num) {
        int res = 0;

        for (int i = 1; i <= num ; i++) {
            if (num % i == 0) res = res + i;
        }

        return res;
    }

}
