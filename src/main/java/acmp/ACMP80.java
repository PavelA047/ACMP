package acmp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ACMP80 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(method(scanner));
        }
    }

    private static String method(Scanner scanner) {
        if (scanner.hasNextLine()) {
            String str = scanner.nextLine();

            if (!str.matches("-?\\d+[-+*/]-?\\d+=-?\\d+"))
                return "ERROR";


            List<String> numList = new ArrayList<>();
            List<Integer> indexes = new ArrayList<>();

            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(str);

            while (matcher.find()) {
                numList.add(str.substring(matcher.start(), matcher.end()));
                indexes.add(matcher.start());
            }

            int first = Integer.parseInt(numList.get(0));
            int second = Integer.parseInt(numList.get(1));
            int third = Integer.parseInt(numList.get(2));
            char operation;

            if (str.startsWith("-")) {
                first = -first;
            }

            if (String.valueOf(str.charAt(indexes.get(1) - 1)).equals("-") && String.valueOf(str.charAt(indexes.get(1) - 2)).matches("\\D")) {
                second = -second;
                operation = str.charAt(indexes.get(1) - 2);
            } else {
                operation = str.charAt(indexes.get(1) - 1);
            }

            if (String.valueOf(str.charAt(indexes.get(2) - 1)).equals("-")) {
                third = -third;
            }

            switch (operation) {
                case '-' -> {
                    return first - second == third ? "YES" : "NO";
                }
                case '+' -> {
                    return first + second == third ? "YES" : "NO";
                }
                case '*' -> {
                    return first * second == third ? "YES" : "NO";
                }
                case '/' -> {
                    if (second == 0) return "NO";
                    if (first % second != 0) return "NO";
                    return first / second == third ? "YES" : "NO";
                }
            }
        }
        return "ERROR";
    }

}
