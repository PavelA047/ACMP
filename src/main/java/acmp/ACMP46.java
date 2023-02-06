package acmp;

//неправильный алгоритм округления, но рабочий
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class Round {
//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println(method(Integer.parseInt(reader.readLine())));
//    }
//
//    public static String method(int num) {
//        if (num == 0) return String.valueOf(3);
//
//        int lastIndex = num - 1;
//        String substr = "7182818284590452353602875";
//        char[] chars = substr.toCharArray();
//        StringBuilder sb = new StringBuilder();
//        sb.append("2.");
//
//        for (int i = chars.length - 1; i > lastIndex || Character.getNumericValue(chars[i]) == 10; i--) {
//            if (Character.getNumericValue(chars[i]) == 10) {
//                chars[i] = '0';
//                chars[i - 1] += 1;
//            } else if (Character.getNumericValue(chars[i]) > 5) {
//                chars[i - 1] += 1;
//            }
//        }
//
//        //добавить отдельную проверку на lastIndex, если он == 10
//        //+ косяк, чтo '9' + 1 не 10
//
//        for (int i = 0; i <= lastIndex; i++) {
//            sb.append(chars[i]);
//        }
//
//        return sb.toString();
//    }
//
//}


//    Округление к ближайшему целому — наиболее часто используемое округление, при котором число округляется до целого, модуль разности с которым у этого числа минимален. В общем случае, когда число в десятичной системе округляют до N-го знака, правило может быть сформулировано следующим образом:
//
//        если N+1 знак < 5, то N-й знак сохраняют, а N+1 и все последующие обнуляют;
//        если N+1 знак ≥ 5, то N-й знак увеличивают на единицу, а N+1 и все последующие обнуляют;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ACMP46 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(method(Integer.parseInt(reader.readLine())));
    }

    public static String method(int num) {
        if (num == 0) return String.valueOf(3);
        StringBuilder sb = new StringBuilder();
        sb.append("2.");
        String substr = "7182818284590452353602875";
        if (num == 25) return sb.append(substr).toString();

        int lastIndex = num - 1;
        char[] chars = substr.toCharArray();

        if (Character.getNumericValue(chars[lastIndex + 1]) > 4) chars[lastIndex] += 1;

        for (int i = 0; i <= lastIndex; i++) {
            sb.append(chars[i]);
        }

        return sb.toString();
    }

}
