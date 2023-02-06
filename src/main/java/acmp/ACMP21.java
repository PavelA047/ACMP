package acmp;

import java.util.Arrays;
import java.util.Scanner;

public class ACMP21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int a = sc.nextInt();
        int[] sort = {x, y, a};
        Arrays.sort(sort);
        int difference = sort[2] - sort[0];
        System.out.println(difference);
    }
}
