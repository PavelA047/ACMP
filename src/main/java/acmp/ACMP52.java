package acmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;

public class ACMP52 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(method(reader.readLine()));
    }

    public static String method(String number) {
        String[] split = Optional.of(number).get().split("");

        int first = 0;
        int second = 0;

        for (int i = 0; i < number.length(); i++) {
            if (i < number.length() / 2) {
                first += Integer.parseInt(split[i]);
            } else {
                second += Integer.parseInt(split[i]);
            }
        }

        return first == second ? "YES" : "NO";
    }

}
