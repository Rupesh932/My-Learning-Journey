package dsa.arrays;

import java.util.Arrays;

public class ProcessResult {
    private ProcessResult() {
    }

    public static void processIntResult(int index) {
        if (index == -1) {
            System.out.println("Target element is not present in container(array)");
            return;
        }
        System.out.println("Target element is found at index: " + index);
    }

    public static void processIntArrayResult(int[] array) {

        System.out.println("Reversed Array :" + Arrays.toString(array));
    }

    public static void processMax(int max, String concatMsg) {
        System.out.println(concatMsg + " Maximum element present in array is: " + max);
    }

    public static void processMissingNumber(int num) {
        System.out.println("Missing number in array is: " + num);
    }

    public static void processFib(int position, int value) {
        System.out.println(position + " term of Fibonacci series is: " + value);
    }

    public static void processRotatedArray(int[] array) {
        System.out.println("rotated Array :" + Arrays.toString(array));
    }

    public static void processSortedArray(String flag, int[] array) {
        System.out.println(flag + " Sorted Array: " + Arrays.toString(array));
    }
}
