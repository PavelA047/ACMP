package acmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;

public class Gold {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        System.out.println(method1(str));
    }

    public static BigInteger method1(String str) {
        return Arrays.stream(str.split(" "))
                .map(BigInteger::new)
                .max(Comparator.naturalOrder())
                .orElse(new BigInteger("0"));
    }

}
