package acmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;

public class ACMP32 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        String str2 = reader.readLine();
        method1(str, str2);
    }

    public static void method1(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        boolean f = false;
        boolean s = false;

        if (str.startsWith("-")) {
            f = true;
            str = str.substring(1);
        }

        if (str2.startsWith("-")) {
            s = true;
            str2 = str2.substring(1);
        }

        long a;

        if (f) {
            AtomicInteger nullsA = new AtomicInteger();
            str.chars().map(Character::getNumericValue).filter(x -> {
                if (x == 0) {
                    nullsA.getAndIncrement();
                    return false;
                } else return true;
            }).sorted().forEach(sb::append);
            String aWithoutNulls = sb.toString();

            a = getA(str, sb, nullsA, aWithoutNulls);

            a = -a;
        } else {
            str.chars().map(Character::getNumericValue).boxed().sorted(Comparator.reverseOrder()).forEach(sb::append);
            a = Long.parseLong(sb.toString());
        }

        sb.setLength(0);
        AtomicInteger nulls = new AtomicInteger();

        if (s) {
            str2.chars().map(Character::getNumericValue).boxed().sorted(Comparator.reverseOrder()).forEach(sb::append);
        } else {
            str2.chars().map(Character::getNumericValue).sorted().filter(x -> {
                if (x == 0) {
                    nulls.getAndIncrement();
                    return false;
                } else return true;
            }).forEach(sb::append);
        }

        String bWithoutNulls = sb.toString();
        long b = getA(str2, sb, nulls, bWithoutNulls);

        if (s) {
            b = -b;
        }

        System.out.println(a - b);
    }

    private static long getA(String str, StringBuilder sb, AtomicInteger nullsA, String aWithoutNulls) {
        long a;
        if (str.length() > 1 && nullsA.get() != 0) {
            sb.setLength(0);
            sb.append(aWithoutNulls.charAt(0));
            sb.append("0".repeat(Math.max(0, nullsA.get())));
            a = Long.parseLong(sb.append(aWithoutNulls.substring(1)).toString());
        } else {
            if (aWithoutNulls.isEmpty()) {
                a = 0;
            } else {
                a = Long.parseLong(aWithoutNulls);
            }
        }
        return a;
    }

}
