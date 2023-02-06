import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IsPrime {
    public static void main(String[] args) {
        System.out.println(prime(101));
        erato(101);
    }

    private static boolean prime(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    // включая само число
    private static void erato(int num) {
        boolean[] isPrime = new boolean[num];
        Arrays.fill(isPrime, true);

        //цикл по самим числам, идем до корня из числа, например в 64 до 8 включительно (включаем его при помощи =)
        for (int i = 2; i * i <= num; i++) {
            if (isPrime[i - 1]) {
                //опять идем по самим числам - делителям, тут мы включаем последнее число с помощью =
                for (int j = 2 * i; j <= num; j += i) {
                    isPrime[j - 1] = false;
                }
            }
        }

        List<Integer> p = new ArrayList<>();
        for (int i = 2; i <= num; i++) {
            if (isPrime[i - 1]) p.add(i);
        }

        System.out.println(p);
    }

}
