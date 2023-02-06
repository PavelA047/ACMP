package acmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class ACMP40 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        System.out.println(method1(str));
    }

    public static BigInteger method1(String str) {
        int n = Integer.parseInt(str);
        BigInteger returnVal = BigInteger.valueOf(1);

        for (int i = 1; i <= n; i++) {
            returnVal = returnVal.multiply(BigInteger.valueOf(2));
        }

        return returnVal;
    }

}
