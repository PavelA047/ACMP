import java.util.Scanner;

public class LastFib {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int f1 = 0, f2 = 1;
        for (int i = 2; i < n; i++) {
            int f3 = (f1 + f2) % 10;
            f1 = f2;
            f2 = f3;
        }
        System.out.println(f2);
    }
}
