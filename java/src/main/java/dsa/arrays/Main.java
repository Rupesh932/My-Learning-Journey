package dsa.arrays;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = { 55, 33, -44, 555, 99, -23, -46, 11, 67, 88, 96, 18, 23, 48, 21, 0, -5923, 99654, 0, 1, 11, 21,
                -23, 0, 55, 33, 11, 0, -21, 8, 2, 11 };
        System.out.println("size of Array is : " + array.length);
        int target = 67;
        ArrayOperation operation = new ArrayOperation();
        int index = operation.searchElement(array, target);
        ProcessResult.processIntResult(index);

        int[] reverseArray = operation.reverseArrayNext(array);
        ProcessResult.processIntArrayResult(reverseArray);

        int max = operation.findMax(array);
        ProcessResult.processMax(max, "");
        int secondMax = operation.findSecondMax(array);
        ProcessResult.processMax(secondMax, "Second");

        int[] arr = { 1, 3, 4, 5, 2 };
        int missingNumber = operation.findMissingNumber(arr, arr.length + 1);
        ProcessResult.processMissingNumber(missingNumber);

        int fibTerm = 11;
        int value = operation.fibonacciSeries(fibTerm);
        ProcessResult.processFib(fibTerm, value);

        int[] rArray = { 22, 33, 44, 55, 66, 77 };
        int[] rotatedArr = operation.rotatedArray(rArray);
        ProcessResult.processRotatedArray(rotatedArr);

        int[] selectSorted = operation.selectionSort(array);
        ProcessResult.processSortedArray("Select", selectSorted);

        int[] bubbleSorted = operation.bubbleSort(array);
        ProcessResult.processSortedArray("Bubble", bubbleSorted);

        int[] array1 = { 55, 33, -44, 555, 99, -23, -46, 11, 67, 88, 96, 18, 23, 48, 21, 0, -5923, 99654, 0, 1, 11, 21,
                -23, 0, 55, 33, 11, 0, -21, 8, 2, 11 };
        int[] insertionSorted = operation.insertionSort(array1);
        System.out.println("insertion sort(swap): " + Arrays.toString(insertionSorted));
        int[] insertionSorted1 = operation.insertionSortShifting(array1);
        System.out.println("insertion sort(shifting): " + Arrays.toString(insertionSorted1));

        int searchedIndex = operation.binarySearch(insertionSorted1, 555);
        if (searchedIndex == -1) {
            System.out.println("Array is not created or empty ");
        } else if (searchedIndex == -11) {
            System.out.println("Element is not present in array");
        } else {
            System.out.println("Element present at index : " + searchedIndex);
        }

        int[] indexArray = operation.firstAndLastOccurrenceIndex(insertionSorted, 0);
        if (indexArray == null) {
            System.out.println("Array is empty.");
        } else if (indexArray[0] == -1) {
            System.out.println("Target element is not present in array." + Arrays.toString(indexArray));
        } else {
            System.out.println("Target element first  present at index:" + indexArray[0]);
            System.out.println("Target element last  present at index:" + indexArray[1]);
        }

        int[] uniqueValuedArray = { 2, 5, 8, 11, 23, 35, 64, 68, 77, 82, 91, 99 };
        index = operation.searchInsertPosition(uniqueValuedArray, 100);
        System.out.println("Target element's possible position(index) is " + index);

        value = 50;
        int result = operation.squareRoot(value);
        if (result != -1)
            System.out.println("square root of " + value + " is : " + result);
        else
            System.out.println("Exact square root of " + value + " is not found");

        result = operation.squareRootOptimized(value);
        System.out.println("Exact/approximate square root of " + value + " is " + result);
    }
}