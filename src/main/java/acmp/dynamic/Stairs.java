package acmp.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Stairs {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int i = Integer.parseInt(reader.readLine());

        int count = 0;

        for (int level = 1; level <= i; ++level) {
            count += getCount(level, i - level);
        }

        System.out.println(count);
    }

    public static int getCount(int prevLevel, int n) {
        if (0 == n)
            return 1;

        int count = 0;
        for (int level = 1; level < prevLevel; ++level) {
            if ((n - level) < 0)
                break;
            count += getCount(level, n - level);
        }

        return count;
    }

}