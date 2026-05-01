package dsa.arrays.sorting;

public class ArraySorting {
    public int[] selectionSort(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        for (int i = 0; i < array.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[index] > array[j]) {
                    index = j;
                }
            }
            int temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }
        return array;
    }

    public int[] bubbleSort(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        for (int i = 0; i < array.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }

        }
        return array;
    }

    //old school(swap)
    public int[] insertionSort(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        int[] arr = array.clone();
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                } else {
                    break;//this is the core of IS to make best case O(n).
                }
            }
        }
        return arr;
    }

    //new school i.e. shifting
    public int[] insertionSortShifting(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        int n = array.length;

        int[] clone = array.clone();
        for (int i = 1; i < n; i++) {
            int item = clone[i];
            int j = i - 1;
            while ((j >= 0) && (clone[j] > item)) {

                clone[j + 1] = clone[j];
                j--;
            }
            clone[j + 1] = item;
        }
        return clone;
    }
}
