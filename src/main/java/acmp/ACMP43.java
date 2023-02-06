package acmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ACMP43 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        System.out.println(method(str));
    }

    public static long method(String str) {
        if (str.length() == 0) return 0;
        char[] chars = str.toCharArray();
        int max = 0;
        int currentMax = 0;
        if (Character.getNumericValue(chars[0]) == 0) currentMax = max = 1;


        int current;
        int before;
        for (int i = 1; i < chars.length; i++) {
            current = Character.getNumericValue(chars[i]);
            before = Character.getNumericValue(chars[i - 1]);
            if (current == 0 && before == 0) {
                currentMax++;
            } else if (current == 0) currentMax = 1;
            max = Math.max(currentMax, max);
        }

        return max;
    }

}
