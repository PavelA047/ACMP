package acmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Message {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        String str2 = reader.readLine();
        System.out.println(method1(str, str2));
    }

    public static String method1(String str, String str2) {
        Integer[] arr = Arrays.stream(str.split(" "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        int count = arr[0];
        int codeRepeats = arr[1];

        if (count == 1) return "YES";

        int[] ints = str2.chars().map(Character::getNumericValue).toArray();
        int currentRepeats = 0;

        for (int i = 0; i < ints.length; i++) {
            for (int j = i + 1; j < ints.length; j++) {
                if (ints[i] == ints[j]) {
                    for (int k = 0; k < codeRepeats; k++) {
                        if (j + k < ints.length) {
                            if (ints[i + k] == ints[j + k]) {
                                currentRepeats++;
                            } else {
                                currentRepeats = 0;
                                break;
                            }
                        } else currentRepeats = 0;
                        if (currentRepeats == codeRepeats) return "YES";
                    }
                }
            }
        }

        return "NO";
    }

}
