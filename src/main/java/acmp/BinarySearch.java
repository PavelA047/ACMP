package acmp;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 9, 12, 43, 91, 65};
        System.out.println(searchIndexRec(arr, 12, 0, arr.length - 1));
        System.out.println(searchIndex(arr, 12, 0, arr.length - 1));
    }

    private static int searchIndexRec(int[] arr, int numberToFind, int lIndex, int rIndex) {
//        int pivotIndex = lIndex + (rIndex - lIndex) / 2;
        int pivotIndex = (lIndex + rIndex) / 2;
        int pivotNumber = arr[pivotIndex];

        if (numberToFind == pivotNumber) return pivotIndex;
        if (lIndex == rIndex) return -1;

        if (numberToFind > pivotNumber) {
            return searchIndexRec(arr, numberToFind, pivotIndex + 1, rIndex);
        } else {
            return searchIndexRec(arr, numberToFind, lIndex, pivotIndex - 1);
        }
    }

    private static int searchIndex(int[] arr, int numberToFind, int lIndex, int rIndex) {
        int pivotIndex;
        int pivotNumber;

        while (lIndex <= rIndex) {
            pivotIndex = (lIndex + rIndex) / 2;
            pivotNumber = arr[pivotIndex];

            if (pivotNumber == numberToFind) return pivotIndex;
            if (lIndex == rIndex) return -1;

            if (numberToFind > pivotNumber) {
                lIndex = pivotIndex + 1;
            } else {
                rIndex = pivotIndex - 1;
            }
        }

        return -1;
    }

}
