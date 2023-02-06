package acmp.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

import static java.lang.Math.min;

public class Rabbit {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        System.out.println(method(str));
    }

    private static BigInteger method(String str) {
        String[] arr = str.split(" ");
        BigInteger k = BigInteger.valueOf(Integer.parseInt(arr[0]));
        BigInteger n = BigInteger.valueOf(Integer.parseInt(arr[1]));
        return count(k, n);
    }

    private static BigInteger count(BigInteger k, BigInteger n) {
        n = n.add(BigInteger.ONE);
        BigInteger[] counts = new BigInteger[n.intValue()];
        //при шаге в 3
        //0 и 1 ступень всегда 1 шаг, 2 как 1 +1, 3 как 2+1 +1, 4 как 3+2+1, 5 как 4+3+2
        counts[0] = BigInteger.valueOf(1);
        for (int i = 1; i < n.intValue(); ++i) //на ступень вперед двигаемся
            for (int j = 1; j <= min(k.intValue(), i); ++j) { //-1 -2 -3 ступени проверяем кол-во
                if (counts[i] == null) counts[i] = BigInteger.ZERO;
                counts[i] = counts[i].add(counts[i - j]);
            }
        return counts[n.intValue() - 1];
    }

}
