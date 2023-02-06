package acmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ACMP44 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        System.out.println(method1(str));
    }

    public static int method1(String str) {
        if (str.length() < 5) return 0;

        char[] chars = str.toCharArray();
        int count = 0;

        for (int i = 4; i < chars.length; i++) {
            if (chars[i] == 60 && chars[i - 1] == 60 && chars[i - 2] == 45 && chars[i - 3] == 45 && chars[i - 4] == 60) count++;
            if (chars[i] == 62 && chars[i - 1] == 45 && chars[i - 2] == 45 && chars[i - 3] == 62 && chars[i - 4] == 62) count++;
        }

        return count;
    }

}
