package acmp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ACMP67 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(method(scanner));
        }
    }

    private static String method(Scanner scanner) {
        int numberOfMasks = scanner.nextInt();
        List<String> masks = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        StringBuilder returnSb = new StringBuilder();

        for (int i = 0; i < numberOfMasks; i++) {
            masks.add(parse(scanner.next(), sb));
        }

        int numberOfIPs = scanner.nextInt();
        for (int i = 0; i < numberOfIPs; i++) {
            char[] ip1 = parse(scanner.next(), sb).toCharArray();
            char[] ip2 = parse(scanner.next(), sb).toCharArray();
            int difIndex = 33;

            for (int j = 0; j < ip1.length; j++) {
                if (ip1[j] != ip2[j]) {
                    difIndex = j;
                    break;
                }
            }

            if (difIndex == 33) {
                returnSb.append(masks.size()).append("\n");
                continue;
            }

            int countToReturnSbForOneMask = 0;
            for (String mask : masks) {
                char[] maskCharArr = mask.toCharArray();
                for (int j = difIndex; j < maskCharArr.length; j++) {
                    if (maskCharArr[j] == '1') break;
                    if (j == maskCharArr.length - 1) countToReturnSbForOneMask++;
                }
            }
            returnSb.append(countToReturnSbForOneMask).append("\n");
        }
        return returnSb.toString();
    }

    private static String parse(String str, StringBuilder sb) {
        sb.setLength(0);
        Arrays.stream(str.split("\\."))
                .map(Integer::parseInt)
                .map(Integer::toBinaryString)
                .map(x -> {
                    if (x.length() < 8) return "0".repeat(8 - x.length()) + x;
                    else return x;
                })
                .forEach(sb::append);
        return sb.toString();
    }

}
