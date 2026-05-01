package dsa.arrays;

public class ArrayBasic {
    //search element(liner / brute force )
    public static int searchElement(int[] array, int target) {
        if (array == null || array.length <= 1) {
            return -1;
        }
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
    public static int[] reverseArray(int[] array) {
        if (array == null) throw new NullPointerException("Array is null");
        if (array.length <= 1) throw new IllegalArgumentException("Array is empty");

        int length = array.length;
        int[] copyArray = new int[length];
        for (int i = 0, j = length - 1; i < length; i++, j--) {
            copyArray[i] = array[j];
        }
        return copyArray;
    }

    public static void reverseArrayNext(int[] array) {
        if (array == null) throw new NullPointerException("Array is null");
        if (array.length < 1) throw new IllegalArgumentException("Array is empty");

        int length = array.length;
        for (int i = 0, j = length - 1; i < j; i++, j--) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

    }

    //max element at array
    public static int findMax(int[] array) {
        if (array == null) throw new IllegalArgumentException("Array is null");
        if (array.length < 1) throw new IllegalArgumentException("Array is empty");

        int max = Integer.MIN_VALUE;
        for (int value : array) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    public static int findSecondMax(int[] array) {
        if (array == null) throw new NullPointerException("Array is null");
        if (array.length < 1) throw new IllegalArgumentException("Array is empty");

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
        if(secondMax == Integer.MIN_VALUE){
            throw new IllegalArgumentException("No unique value found as second max.");
        }
        return secondMax;
    }

    public static int findMissingNumber(int[] array, int actualSize) {
        if (array == null) throw new NullPointerException("Array is null");
        if (array.length < 1) throw new IllegalArgumentException("Array is empty");

        int sumN = (actualSize * (actualSize + 1)) / 2;
        int sumArr = 0;
        for (int j : array) {
            sumArr += j;
        }


        return sumN - sumArr;
    }


    public static int[] rotatedArray(int[] array) {
        if (array == null) throw new NullPointerException("Array is null");
        if (array.length < 1) throw new IllegalArgumentException("Array is empty");

        int temp = array[array.length - 1];
        for (int i = array.length - 2; i >= 0; i--) {
            array[i + 1] = array[i];
        }
        array[0] = temp;
        return array;
    }
}
