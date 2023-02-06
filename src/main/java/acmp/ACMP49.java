package acmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ACMP49 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        String str2 = reader.readLine();
        System.out.println(method(str, str2));
    }

    public static int method(String str, String str2) {
        List[] first = parse(Optional.ofNullable(str).map(String::toCharArray).orElseThrow());
        List[] second = parse(Optional.ofNullable(str2).map(String::toCharArray).orElseThrow());

        for (int i = 0; i < first.length; i++) {
            first[i].retainAll(second[i]);
        }

        return Arrays.stream(first)
                .mapToInt(x -> x.size())
                .reduce(1, (x, y) -> x * y);
    }

    public static List[] parse(char[] chars) {
        List[] retList = new ArrayList[chars.length];

        for (int i = 0; i < retList.length; i++) {
            retList[i] = new ArrayList<>();
        }

        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case '0' -> retList[i].add(0);
                case '1' -> retList[i].add(1);
                case '2' -> retList[i].add(2);
                case '3' -> retList[i].add(3);
                case '4' -> retList[i].add(4);
                case '5' -> retList[i].add(5);
                case '6' -> retList[i].add(6);
                case '7' -> retList[i].add(7);
                case '8' -> retList[i].add(8);
                case '9' -> retList[i].add(9);
                case 'a' -> retList[i].addAll(Arrays.asList(0, 1, 2, 3));
                case 'b' -> retList[i].addAll(Arrays.asList(1, 2, 3, 4));
                case 'c' -> retList[i].addAll(Arrays.asList(2, 3, 4, 5));
                case 'd' -> retList[i].addAll(Arrays.asList(3, 4, 5, 6));
                case 'e' -> retList[i].addAll(Arrays.asList(4, 5, 6, 7));
                case 'f' -> retList[i].addAll(Arrays.asList(5, 6, 7, 8));
                case 'g' -> retList[i].addAll(Arrays.asList(6, 7, 8, 9));
                case '?' -> retList[i].addAll(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
            }
        }
        return retList;
    }

}
