import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BubbleCombSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{1, 8, 5, 3, 7, 4, 6, 2, 8, 8, 8, 8, 8, 8, 9})));
        System.out.println(Arrays.toString(sort2(new int[]{1, 8, 5, 3, 7, 4, 6, 2, 8, 8, 8, 8, 8, 8, 9})));
        System.out.println(Arrays.toString(sort3(new int[]{1, 8, 5, 3, 7, 4, 6, 2, 8, 8, 8, 8, 8, 8, 9})));
        System.out.println(Arrays.toString(sort3(new int[]{1, 18, 556, 3, 7, 4, 6, 2, 338, 18, 8, 8, 128, 8, 9})));
        int[] ints = {1, 18, 556, 3, 7, 4, 6, 2, 338, 18, 8, 8, 128, 8, 9};
        radixSort(ints);
        System.out.println(Arrays.toString(ints));
    }

    private static int[] sort(int[] arr) {
        int temp;
        boolean flag = false;

        while (!flag) {
            flag = true;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] < arr[i - 1]) {
                    temp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = temp;
                    flag = false;
                }
            }
        }

        return arr;
    }

    private static int[] sort2(int[] arr) {
        int temp;
        boolean flag = false;
        int gap = arr.length;

        while (!flag || gap != 1) {
            if (gap > 1) {
                gap /= 1.3;
            } else gap = 1;

            flag = true;
            for (int i = gap; i < arr.length; i++) {
                if (arr[i] < arr[i - gap]) {
                    temp = arr[i - gap];
                    arr[i - gap] = arr[i];
                    arr[i] = temp;
                    flag = false;
                }
            }
        }

        return arr;
    }

    private static int[] sort3(int[] arr) {
        int temp;

        for (int i = 0; i < arr.length; i++) {
            int smallestIndex = getSmallestIndex(arr, i + 1);
            if (smallestIndex == arr.length) return arr;
            if (arr[i] > arr[smallestIndex]) {
                temp = arr[i];
                arr[i] = arr[smallestIndex];
                arr[smallestIndex] = temp;
            }
        }

        return arr;
    }

    private static int getSmallestIndex(int[] arr, int l) {
        int smallestIndex = l;

        for (int i = l; i < arr.length; i++) {
            if (arr[i] < arr[smallestIndex]) {
                smallestIndex = i;
            }
        }

        return smallestIndex;
    }

    @SuppressWarnings("unchecked")
    public static void radixSort(int[] input) {

        List<Integer>[] buckets = new ArrayList[10];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        // sort
        boolean flag = false;
        int tmp;
        int divisor = 1;
        while (!flag) {
            flag = true;
            // split input between lists
            for (Integer i : input) {
                tmp = i / divisor;
                buckets[tmp % 10].add(i);
                if (flag && tmp > 0) {
                    flag = false;
                }
            }
            // empty lists into input array
            int a = 0;
            for (int b = 0; b < 10; b++) {
                for (Integer i : buckets[b]) {
                    input[a++] = i;
                }
                buckets[b].clear();
            }
            // move to next digit
            divisor *= 10;
        }
    }

}
