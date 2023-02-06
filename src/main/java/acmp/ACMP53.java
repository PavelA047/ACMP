package acmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;

public class ACMP53 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(method(reader.readLine()));
    }

    public static String method(String number) {
        String[] split = Optional.of(number).get().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        int black = 0;
        int red = 0;
        int green = 0;
        int blue = 0;

        int temp;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                temp = i * j;
                if (temp % 5 == 0) blue++;
                else if (temp % 3 == 0) green++;
                else if (temp % 2 == 0) red++;
                else black++;
            }
        }

        return String.format("RED : %d%nGREEN : %d%nBLUE : %d%nBLACK : %d", red, green, blue, black);
    }

}
