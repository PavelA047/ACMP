package acmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Chess {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        method1(str);
    }

    public static void method1(String str) {
        if (!Pattern.matches("^[A-H][1-8]-[A-H][1-8]", str)) {
            System.out.println("ERROR");
            return;
        }

        String[] arr = Arrays.stream(str.split("-"))
                .flatMap(x -> Arrays.stream(x.split("")))
                .toArray(String[]::new);

        char indexFromLiter = arr[0].charAt(0);
        char indexToLiter = arr[2].charAt(0);
        int indexFromNumber = Integer.parseInt(arr[1]);
        int indexToNumber = Integer.parseInt(arr[3]);

        if ((indexFromLiter + 1 == indexToLiter || indexFromLiter - 1 == indexToLiter) &&
                (indexFromNumber + 2 == indexToNumber || indexFromNumber - 2 == indexToNumber)) {
            System.out.println("YES");
        } else if ((indexFromLiter + 2 == indexToLiter || indexFromLiter - 2 == indexToLiter) &&
                (indexFromNumber + 1 == indexToNumber || indexFromNumber - 1 == indexToNumber)) {
            System.out.println("YES");
        } else System.out.println("NO");
    }

}
