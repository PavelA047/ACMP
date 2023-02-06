import java.util.Arrays;
import java.util.stream.Stream;

public class H2 {
    public static void main(String[] args) {
        int[] ints = Stream.generate(Math::random)
                .limit(100)
                .map(x -> x * 100)
                .map(Double::intValue)
                .mapToInt(x -> x)
                .toArray();

        boolean sorted = false;

        while (!sorted) {
            sorted = true;
            for (int i = 1; i < ints.length; i++) {
                if (ints[i] < ints[i - 1]) {
                    int temp = ints[i - 1];
                    ints[i - 1] = ints[i];
                    ints[i] = temp;
                    sorted = false;
                }
            }
        }

        System.out.println(Arrays.toString(ints));
    }
}
