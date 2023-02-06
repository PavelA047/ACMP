package acmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ACMP51 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        System.out.println(method(str));
    }

    public static int method(String str) {
        String[] s = str.split(" ");
        int num = Integer.parseInt(s[0]);
        int count = s[1].length();

        if (num % count == 0) {
            for (int i = num - count; i >= count; i = i - count) {
                num *= i;
            }
//            num *= count;
        } else {
            for (int i = num - count; i >= num % count; i = i - count) {
                num *= i;
            }
//            num *= num % count;
        }

        return num;
    }

}
