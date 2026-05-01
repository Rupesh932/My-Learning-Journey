package dsa.arrays;

public class ArrayOperation {

    //search element(liner / brute force )
    public int searchElement(int[] array, int target) {
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                index = i;

                break;
            }
        }
        return index;
    }

    //reverse the array
    public int[] reverseArray(int[] array) {
        int length = array.length;
        int[] copyArray = new int[length];
        for (int i = 0, j = length - 1; i < length; i++, j--) {
            copyArray[i] = array[j];
        }
        return copyArray;
    }

    public int[] reverseArrayNext(int[] array) {
        int length = array.length;
        for (int i = 0, j = length - 1; i < j; i++, j--) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        return array;
    }

    //max element at array
    public int findMax(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int value : array) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    public int findSecondMax(int[] array) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int value : array) {
            if (value > max) {
                secondMax = max;
                max = value;

            } else if (value > secondMax && value != max) {
                secondMax = value;

            }

        }
        return secondMax;
    }

    public int findMissingNumber(int[] array, int n) {
        int sumN = (n * (n + 1)) / 2;
        int sumArr = 0;
        for (int j : array) {
            sumArr += j;
        }

        return sumN - sumArr;
    }

    public int fibonacciSeries(int n) {
        if (n <= 1) {
            return n;
        }
        int[] fibArray = new int[n];
        fibArray[0] = 0;
        fibArray[1] = 1;
        for (int i = 2; i < n; i++) {
            fibArray[i] = fibArray[i - 1] + fibArray[i - 2];

        }
        return fibArray[n - 1];
    }

    public int[] rotatedArray(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        int temp = array[array.length - 1];
        for (int i = array.length - 2; i >= 0; i--) {
            array[i + 1] = array[i];
        }
        array[0] = temp;
        return array;
    }
    // *********

    public int[] selectionSort(int[] array) {

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
        int n = array.length;
        if (n <= 1) {
            return array;
        }
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

    public int binarySearch(int[] array, int target) {

        if (array == null) {
            return -1;
        }
        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (array[mid] == target) {
                return mid;
            }

            if (target > array[mid]) {
                start = mid + 1;

            } else {
                end = mid - 1;

            }

        }

        return -11;
    }

    public int[] firstAndLastOccurrenceIndex(int[] array, int target) {
        if (array == null || array.length < 1) {
            return new int[]{-11, -11};
        }
        int first = findOccurrence(array, target, true);
        int last = findOccurrence(array, target, false);

        return new int[]{first, last};
    }

    public int findOccurrence(int[] array, int target, boolean isFirst) {
        int n = array.length;
        int start = 0;
        int end = n - 1;
        int result = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == array[mid]) {
                result = mid;
                if (isFirst) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (target < array[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }

    public int searchInsertPosition(int[] array, int element) {
        if (array == null || array.length < 1) {
            return -1;
        }
        int n = array.length;
        int start = 0;
        int end = n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (element == array[mid]) {
                return mid;
            }
            if (element < array[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;

            }
        }
        return start;

    }

    public int squareRoot(int value) {

        for (int i = 1; i <= value / 2; i++) {
            if (i * i == value) {
                return i;
            }
        }
        return -1;
    }

    public int squareRootOptimized(int value) {
        if(value < 2){
            return value;
        }
        int start = 0;
        int end = value/2;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid  == value/mid) {
                return mid;
            } else if (mid > value/mid) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return end;
    }
}
