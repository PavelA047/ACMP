package acmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BullsAndCows {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        System.out.println(method1(str));
    }

    public static String method1(String str) {
        String[] arr = Arrays.stream(str.split(" "))
                .toArray(String[]::new);

        String a = arr[0];
        String b = arr[1];

        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();

        int cows = 0;
        int bulls = 0;

        for (int i = 0; i < charsA.length; i++) {
            for (int j = 0; j < charsB.length; j++) {
                if (charsA[i] == charsB[j] && i == j) bulls++;
                if (charsA[i] == charsB[j] && i != j) cows++;
            }
        }

        return bulls + " " + cows;
    }

}
