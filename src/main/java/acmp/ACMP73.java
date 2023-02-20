package acmp;

import java.util.*;

public class ACMP73 {

//    private static final Map<Character, Integer> mapCodeToInt = new HashMap<>();
//    private static final Map<Integer, Character> mapCodeToChar = new HashMap<>();
//
//    static {
//        mapCodeToInt.putAll(Map.of('a', 1, 'b', 2, 'c', 3, 'd', 4, 'e', 5, 'f', 6, 'g', 7, 'h', 8, 'i', 9, 'j', 10));
//        mapCodeToInt.putAll(Map.of('k', 11, 'l', 12, 'm', 13, 'n', 14, 'o', 15, 'p', 16, 'q', 17, 'r', 18, 's', 19, 't', 20));
//        mapCodeToInt.putAll(Map.of('u', 21, 'v', 22, 'w', 23, 'x', 24, 'y', 25, 'z', 26, ' ', 27));
//
//        mapCodeToChar.putAll(Map.of(0, '0', 1, '1', 2, '2', 3, '3', 4, '4', 5, '5', 6, '6', 7, '7', 8, '8', 9, '9'));
//        mapCodeToChar.putAll(Map.of(10, 'A', 11, 'B', 12, 'C', 13, 'D', 14, 'E', 15, 'F', 16, 'G', 17, 'H', 18, 'I', 19, 'J'));
//        mapCodeToChar.putAll(Map.of(20, 'K', 21, 'L', 22, 'M', 23, 'N', 24, 'O', 25, 'P', 26, 'Q'));
//    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
//            System.out.println(methodTo(scanner));
            System.out.println(methodFrom(scanner));
        }
    }

    private static String methodFrom(Scanner scanner) {
        String str = scanner.next();

        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int c = 0; c < chars.length; c++) {
            int i;
            if (chars[c] > 47 && chars[c] < 58) {
                i = Integer.parseInt(String.valueOf(chars[c])) - (c + 1);
            } else {
                i = Integer.parseInt(String.valueOf(chars[c] - 55)) - (c + 1);
            }
            while (i < 0) i += 27;
            if (i == 0) {
                sb.append(' ');
                continue;
            }
            sb.append((char) (i + 96));
        }

        return sb.toString();
    }

//    private static String methodTo(Scanner scanner) {
//        String str = scanner.next();
//
//        char[] chars = str.toCharArray();
//        StringBuilder sb = new StringBuilder();
//
//        for (int i = 0; i < chars.length; i++) {
//            int q = mapCodeToInt.get(chars[i]);
//            sb.append(mapCodeToChar.get((q + i + 1) % 27));
//        }
//
//        return sb.toString();
//    }

}
