package acmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Divider2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(method(Integer.parseInt(reader.readLine())));
    }

    public static int method(int i) {
        if (i == 1) return 1;
        AtomicInteger maxValue = new AtomicInteger();
        AtomicInteger retKey = new AtomicInteger();

        IntStream.rangeClosed(1, i)
                .filter(x -> i % x == 0)
                .boxed()
                .map(x -> {
                    int sum = String.valueOf(x).chars()
                            .map(Character::getNumericValue)
                            .sum();
                    return Map.entry(x, sum);
                }).forEach(val -> {
                    Integer value = val.getValue();
                    if (value > maxValue.get()) {
                        maxValue.set(value);
                        retKey.set(val.getKey());
                    } else if (value == maxValue.get()) {
                        retKey.set(Math.min(retKey.get(), val.getKey()));
                    }
                });
        return retKey.get();
    }

//    public static int method(int i) {
//        if (i == 1) return 1;
//
//        Set<Integer> dividers = new HashSet<>();
//        dividers.addAll(Set.of(1, i));
//        for (int j = 2; j <= i / 2; j++) {
//            if (i % j == 0) dividers.add(j);
//        }
//
//        Map<Integer, Integer> map = new HashMap<>();
//        dividers.forEach(x -> {
//            int sum = String.valueOf(x).chars()
//                    .map(Character::getNumericValue)
//                    .sum();
//            map.put(x, sum);
//        });
//
//        int maxValue = 0;
//        int retKey = 0;
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            Integer value = entry.getValue();
//            if (value > maxValue) {
//                maxValue = value;
//                retKey = entry.getKey();
//            } else if (value == maxValue) {
//                retKey = Math.min(retKey, entry.getKey());
//            }
//        }
//        return retKey;
//    }

}
