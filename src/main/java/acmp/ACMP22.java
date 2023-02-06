package acmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ACMP22 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());
        System.out.println(method1(num));
    }

    public static int method1(int num) {
        List<Integer> list = new ArrayList<>();

        if (num >= 0) {
            while (num >= 1) {
                int i = num % 2;
                list.add(i);
                num = num / 2;
            }
        } else {

        }

        return (int) list.stream()
                .mapToInt(x -> x)
                .filter(x -> x == 1)
                .count();

    }

}
