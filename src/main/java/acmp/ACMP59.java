package acmp;

import java.util.Scanner;

public class ACMP59 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int system = scanner.nextInt();
        System.out.println(method(number, system));
    }

    private static int method(int number, int system) {
        StringBuilder sb = new StringBuilder();

        while (number >= system) {
            sb.append(number % system);
            number /= system;
        }
        char[] chars = sb.append(number).toString().toCharArray();

        int sum = 0;
        int pow = 1;
        for (int i = 0; i < chars.length; i++) {
            int x = Character.getNumericValue(chars[i]);
            sum += x;
            pow *= x;
        }

        return pow - sum;
    }

}
