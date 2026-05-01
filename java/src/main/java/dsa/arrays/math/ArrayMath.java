package dsa.arrays.math;

public class ArrayMath {
    public static int fibonacciSeries(int n) {
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
    public static int squareRoot(int value) {

        for (int i = 1; i <= value / 2; i++) {
            if (i * i == value) {
                return i;
            }
        }
        return -1;
    }

    public static int squareRootOptimized(int value) {
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
