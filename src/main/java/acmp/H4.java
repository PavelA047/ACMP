package acmp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class H4 {
    public static void main(String[] args) {
//        Integer[] ints = Stream.generate(Math::random)
//                .limit(100)
//                .map(x -> x * 100)
//                .map(Double::intValue)
//                .toArray(Integer[]::new);
//
//        System.out.println(Arrays.toString(ints));
//        List<Integer> list = new ArrayList<>();
//        Collections.addAll(list, ints);

        int[] intsInt = Stream.generate(Math::random)
                .limit(100)
                .map(x -> x * 100)
                .map(Double::intValue)
                .mapToInt(x -> x)
                .toArray();

        int offset = 0;

        System.out.println(Arrays.toString(intsInt));

        for (int i = 0; i < intsInt.length; i++) {
            if (intsInt[i] == 60) {
                offset++;
            } else {
                intsInt[i - offset] = intsInt[i];
            }
        }

        System.out.println(Arrays.toString(Arrays.copyOfRange(intsInt, 0, intsInt.length - offset)));
    }
}
