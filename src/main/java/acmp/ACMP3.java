package acmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ACMP3 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(reader.readLine());
        System.out.println(method1(n));
    }

    public static long method1(long number) {
        if (number == 5) return 25;
        number = number / 10;
        number = number * (number + 1);
        String s = number + "25";
        return Long.parseLong(s);
    }

}
