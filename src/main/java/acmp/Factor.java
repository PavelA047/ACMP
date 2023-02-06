package acmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Factor {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer i = Integer.parseInt(reader.readLine());
        System.out.println(method1(i));
    }

//    public static int method1(int i) {
//        if (i - 1 == 0 || i == 0) return 1;
//        return i * method1(i - 1);
//    }

    public static BigInteger method1(int i) {
        BigInteger returnInt = BigInteger.ONE;
        for (int j = i; j > 0; j--) {
            returnInt = returnInt.multiply(BigInteger.valueOf(j));
        }
        return returnInt;
    }

}
