import java.util.stream.Stream;

public class H1 {
    public static void main(String[] args) {
        int[] ints = Stream.generate(Math::random)
                .limit(100)
                .map(x -> x * 100)
                .map(Double::intValue)
                .mapToInt(x -> x)
                .toArray();

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;

        for (int anInt : ints) {
            max = Math.max(anInt, max);
            min = Math.min(anInt, min);
            sum += anInt;
        }

        System.out.println(max);
        System.out.println(min);
        System.out.println(sum / 100);
    }
}
