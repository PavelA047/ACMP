package acmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ACMP5 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int elements = Integer.parseInt(reader.readLine());
        String str = reader.readLine();
        method1(elements, str);
    }

    public static void method1(int number, String str) {
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = new StringBuilder();
        String[] arrStr = str.split(" ");
        int[] arrInt = new int[number];

        for (String s : arrStr) {
            int i = Integer.parseInt(s);
            if (i % 2 != 0) {
                sb3.append(i).append(" ");
            } else sb4.append(i).append(" ");
        }

        if (sb3.length() > sb4.length()) {
            System.out.println(sb3.append("\n").append(sb4).append("\n").append("NO"));
        } else {
            System.out.println(sb3.append("\n").append(sb4).append("\n").append("YES"));
        }
    }

}
