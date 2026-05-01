package core.CoreBasic.array;

import java.util.Arrays;

public class ArrayBasic {
    public static void main(String[] args) {
        int rollNo = 100;
        int[] arr;
        arr = new int[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rollNo;
            rollNo++;
        }

        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {

            System.out.printf("%d ", arr[i]);
        }
        System.out.println();

        // multi dimensional array
        int[][] studentMarks = {
                { 55, 67, 42, 88 },
                { 77, 81, 89, 93 },
                { 61, 59, 70, 63 }
        };
        for (int[] marks : studentMarks) {
            for (int value : marks) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
        System.out.println(Arrays.deepToString(studentMarks));

        // jagged array
        int[][] studentMarks1 = new int[5][];

        for (int i = 0, k = 1; i < studentMarks1.length; i++) {
            if (i < 3) {
                studentMarks1[i] = new int[3 + i];

            } else {
                studentMarks1[i] = new int[studentMarks1.length - k++];
            }

            for (int j = 0; j < studentMarks1[i].length; j++) {
                studentMarks1[i][j] = (int) (Math.random() * 100);
            }
        }
        System.out.println("*****************************");
        System.out.println(Arrays.deepToString(studentMarks1));

        int[][][] ThreeDArray = {
                {
                        { 000, 001, 002 }, { 010, 011, 012 }, { 020, 021, 022 }
                },
                {
                        { 100, 101, 102 }, { 110, 111, 112 }, { 120, 121, 122 }
                },
                {
                        { 200, 201, 202 }, { 210, 211, 212 }, { 220, 221, 222 }
                }

        };
        System.out.println("*****************************");
        System.out.println(Arrays.deepToString(ThreeDArray));

    }
}
