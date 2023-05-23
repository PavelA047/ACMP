package acmp;

import java.util.Scanner;

public class ACMP83 {

    static int MAX_HEIGHT = 5;
    static int MAX_MASK = (1 << MAX_HEIGHT) - 1;
    static boolean adj_mask[][] = new boolean[MAX_MASK + 1][MAX_MASK + 1]; // маска допустимых профилей
    static int dp[][] = new int[35][MAX_MASK + 1]; // динамическая модель, в которой все считаем
    static int MASK;
    static int n, m;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(method(scanner));
        }
    }

    private static int method(Scanner scanner) {
        n = scanner.nextInt();
        m = scanner.nextInt();
        if (n > m) {
            n = m + n;
            m = n - m;
            n = n - m;// порядок неважен, но m должно быть не меньше n
        }
        MASK = (1 << n) - 1;       // создаем маску профиля из единиц
        precalc_matrix();   // готовим матрицу допустимых профилей
        solve();     // рассчитываем все комбинации, имея матрицу
        int res = 0;
        for (int mask = 0; mask <= MASK; ++mask)
            res += dp[m - 1][mask]; // сумма нижней строки - искомый результат
        return res;
    }

    public static int get_bit(int num, int bit) {// делаем встроенную функцию для скорости
        return (num & (1 << bit)) != 0 ? 1 : 0;// она возвращает бит из позиции bit
    }

    private static void precalc_matrix() { // процедура готовит матрицу допустимых профилей
        for (int prv = 0; prv <= MASK; ++prv) {
            for (int cur = 0; cur <= MASK; ++cur) {
                boolean isComp = true;
                for (int bit = 0; bit < n - 1; ++bit) {
                    int sum = get_bit(prv, bit) + get_bit(prv, bit + 1) +
                            get_bit(cur, bit) + get_bit(cur, bit + 1); // сумма первых двух битов профилей
                    if (sum == 0 || sum == 4) { // если там только нули или только единицы - профиль пролетает
                        isComp = false;
                        break;
                    }
                } // заполняем матрицу допустимых профилей
                adj_mask[prv][cur] = isComp;
            }
        }
    }

    private static void solve() { // процедура расчета всех комбинаций
        for (int mask = 0; mask <= MASK; ++mask)
            dp[0][mask] = 1; // ставим первый профиль, первую строку забиваем единицами
        for (int k = 1; k < m; ++k) {
            for (int prv = 0; prv <= MASK; ++prv) {
                for (int cur = 0; cur <= MASK; ++cur) {
                    if (adj_mask[prv][cur]) // если в матрице допустимых профилей здесь 1
                        dp[k][cur] += dp[k - 1][prv]; // то добавляем в ячейку содержимое ячейки верхней строки
                }
            }
        }      // теперь в нижней строке лежат все допустимые варианты
    }

}
