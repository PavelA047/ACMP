package acmp;

import java.util.Scanner;

public class ACMP72 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(method(scanner));
        }
    }

    private static String method(Scanner scanner) {
        String str = scanner.next();
        char[] arr = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        int indexLowest = 0;
        int indexBiggest = 0;
        char charLowest = 0;
        char charBiggest = 0;

        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                indexLowest = i;
                charLowest = arr[i];
                break;
            }
        }

        for (int i = arr.length - 1; i > indexLowest; i--) {
            if (arr[i] > charLowest) {
                charBiggest = arr[i];
                indexBiggest = i;
                break;
            }
        }

        arr[indexBiggest] = charLowest;
        arr[indexLowest] = charBiggest;

        sb.append(arr, indexLowest + 1, arr.length - indexLowest - 1).reverse();
        sb.insert(0, arr, 0, indexLowest + 1);

        return sb.toString();
    }

}
