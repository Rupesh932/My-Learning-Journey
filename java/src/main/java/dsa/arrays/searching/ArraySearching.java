package dsa.arrays.searching;

public class ArraySearching {
    public int binarySearch(int[] array, int target) {

        if (array == null || array.length < 1) {
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
        if (array == null || array.length < 1) {
            return -1;
        }
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



    //BRUTE FORCE(Linear Search => O(n))
    public static int peakIndexInMountainArray(int[] array) {
        if (array == null || array.length < 3) {
            return -1;
        }
        int i = 0;
        int index = -1;
        while (i < array.length - 1) {
            if (array[i + 1] > array[i]) {
                index = i + 1;
            }
            i++;
        }
        return index;
    }

    //OPTIMIZED (Binary Search => O(log n))
    public static int peakIndexInMountainArrayOptimized(int[] array) {
        if (array == null || array.length < 3) {
            return -1;
        }
        int start = 0;
        int end = array.length-1;
        while(start < end){
            int mid = start + (end - start)/2;
            if(array[mid] < array[mid+1] && array[mid] > array[mid-1]){
                start =  mid+1;
            }else if(array[mid] < array[mid+1]){
                start = mid +1;
            }else{
                end = mid;
            }
        }
    return start;
    }
    //ROTATED SORTED ARRAY
    //FIND MINIMUM BRUTE FORCE
    public static int searchMin(int[] array){
        if (array == null || array.length < 2) {
           return -1;
        }

        for(int i = 0;i<array.length-1;i++){
            if(array[i+1] < array[i] ){

                return array[i+1];
            }

        }

        return array[0];//not rotated
    }

    //OPTIMIZED -> Binary Search
    public static int searchMinOptimized(int[] array){
        if(array == null || array.length < 1){
            throw new IllegalArgumentException("array is null or too small");
        }
        int start = 0;
        int end = array.length-1;

        while(start < end){
            int mid = start + (end - start) / 2;
            if(array[mid] > array[end]){
                start = mid+1;
            }else{
                end = mid;
            }
        }
        return array[start];

    }
    public static int searchTarget(int[] array, int target){
        if(array == null || array.length < 1){
            return -1;
        }
        int start = 0;
        int end = array.length -1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(target == array[mid]){
               return mid;
            }
            if(array[start] <= array[mid]  ){
                if(target >= array[start] && target < array[mid]){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }else{
                if(target > array[mid] && target <= array[end]){
                    start = mid + 1;
                }else{
                    end = mid -1;
                }

            }
        }
        return -1;
    }
}
