package acmp;

import java.util.Scanner;

public class ACMP75 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(method(scanner));
        }
    }

    private static String method(Scanner scanner) {
        int n = scanner.nextInt();
        StringBuilder sb = new StringBuilder();
        String retVal = "45";

        for (int i = 0; i < n - 1; i++) {
            retVal = pow(retVal, sb);
        }

        return retVal;
    }

    private static String pow(String x, StringBuilder sb) {
        sb.setLength(0);
        char[] chars = x.toCharArray();
        int temp = 0;
        int tempNum;

        for (int i = x.length() - 1; i >= 0; i--) {
            tempNum = Character.getNumericValue(chars[i]) * 45 + temp;
            sb.append(tempNum % 10);
            temp = tempNum / 10;
        }
        sb.reverse();
        if (temp != 0) sb.insert(0, temp);

        return sb.toString();
    }

}

//    private static String method(Scanner scanner) {
//        int n = scanner.nextInt();
//        if (n == 1) return "45";
//        String sum = "";
//        int cycle = 2;
//
//        for (int j = 1; j < 10; j++) {
//            sum = cycle(String.valueOf(j), sum, cycle, n);
//        }
//
//        return sum;
//    }
//
//    private static String cycle(String before, String sum, int cycle, int n) {
//
//        if (cycle < n) {
//            ++cycle;
//            for (int i = 1; i < 10; i++) {
//                sum = cycle(before + i, sum, cycle, n);
//            }
//        } else {
//            for (int i = 1; i < 10; i++) {
//                sum = sum(sum, pow(before + i));
//            }
//        }
//        return sum;
//    }
//
//    private static String pow(String x) {
//        String[] split = x.split("");
//
//        for (int i = 1; i < split.length; i++) {
//            split[i] = pow(split[i - 1], Integer.parseInt(split[i]));
//        }
//
//        return split[split.length - 1];
//    }
//
//    private static String pow(String x, int y) {
//        char[] chars = x.toCharArray();
//        int temp = 0;
//        int tempNum;
//        sb.setLength(0);
//
//        for (int i = x.length() - 1; i >= 0; i--) {
//            tempNum = Character.getNumericValue(chars[i]) * y + temp;
//            sb.append(tempNum % 10);
//            temp = tempNum / 10;
//        }
//        if (temp != 0) sb.append(temp);
//
//        return sb.reverse().toString();
//    }
//
//    private static String sum(String x, String y) {
//        sb.setLength(0);
//
//        if (y.length() > x.length()) {
//            sb.append("0".repeat(y.length() - x.length())).append(x);
//            x = sb.toString();
//            sb.setLength(0);
//        } else if (y.length() < x.length()) {
//            sb.append("0".repeat(x.length() - y.length())).append(y);
//            y = sb.toString();
//            sb.setLength(0);
//        }
//
//        char[] charsX = x.toCharArray();
//        char[] charsY = y.toCharArray();
//        int temp = 0;
//        int tempNum;
//
//        for (int i = x.length() - 1; i >= 0; i--) {
//            tempNum = Character.getNumericValue(charsX[i]) + Character.getNumericValue(charsY[i]) + temp;
//            sb.append(tempNum % 10);
//            temp = tempNum / 10;
//        }
//        if (temp != 0) sb.append(temp);
//
//        return sb.reverse().toString();
//    }
//
//}
