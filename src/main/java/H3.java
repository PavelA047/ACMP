import java.util.stream.Stream;

public class H3 {
    public static void main(String[] args) {
        int[] ints = Stream.generate(Math::random)
                .limit(100)
                .map(x -> x * 100)
                .map(Double::intValue)
                .mapToInt(x -> x)
                .toArray();

        for (int i = 2; i < ints.length; i++) {
            int k = 0;
            for (int j = 2; j <= i; j++) {
                if (i % j == 0) {
                    k++;
                }
            }
            if (k == 1) {
                System.out.print(i + ",");
            }
        }
    }
}
