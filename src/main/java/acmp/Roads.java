package acmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Roads {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        AtomicInteger returnNumber = new AtomicInteger();
        int i = Integer.parseInt(reader.readLine());
        for (int j = 0; j < i; j++) {
            Arrays.stream(reader.readLine().split(" "))
                    .forEach(x -> {
                        if (Integer.parseInt(x) == 1) returnNumber.getAndIncrement();
                    });
        }
        System.out.println(returnNumber.get() / 2);
    }

}
