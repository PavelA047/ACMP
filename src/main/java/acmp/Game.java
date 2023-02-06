package acmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        System.out.println(method1(n));
    }

    public static long method1(int number) {
        int third = 9 - number;
        StringBuilder sb = new StringBuilder();
        return Integer.parseInt(sb.append(number).append("9").append(third).toString());
    }

}
