package dsa.arrays.basic;


import org.junit.jupiter.api.*;

import dsa.arrays.ArrayBasic;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayBasicTest {
    int[] array;
    static int counter = 0;

    @BeforeAll
    static void initAll() {
        System.out.println("**** Testing is starting ****");
    }

    @BeforeEach
    void setUp() {
        array = new int[]{33, 32, 21, 17, 0, -44, 100, 99, 21, 33, 41, 44, 51, 999, -999, 22, 21, 31, 66, 65, 71, 90, 91, 28, 73, -33, 33, 0, 1, 3, 9, 21, 44, 58, 21, -1, 0, 44, 1111};
        counter++;
        System.out.println("New Array is created : via setUp()");
        System.out.println("we have now " + counter + " new array so  far created for each testing(One test = one @Test).");
    }

    @Test
    @DisplayName("search element found")
    void testSearchElement() {

        assertAll(
                () -> assertEquals(0, ArrayBasic.searchElement(array, 33)),
                () -> assertEquals(-1, ArrayBasic.searchElement(array, 2000)),
                () -> assertEquals(array.length - 1, ArrayBasic.searchElement(array, array[array.length - 1]))
        );

    }


    @Test
    @DisplayName("Reverse array")
    void testReverse() {

        int[] copy = array.clone();
        assertThrows(NullPointerException.class, () -> ArrayBasic.reverseArray(null));
        assertThrows(IllegalArgumentException.class, () -> ArrayBasic.reverseArray(new int[]{}));
        int[] firstReserved = ArrayBasic.reverseArray(array);
        int[] secondReserved = ArrayBasic.reverseArray(firstReserved);
        ArrayBasic.reverseArrayNext(array);
        ArrayBasic.reverseArrayNext(array);
        assertAll(
                () -> assertArrayEquals(copy, secondReserved, "Failed to return new reverse array"),
                () -> assertArrayEquals(copy, array, "Failed to in-place reverse.")
        );


    }

    @Test
    @DisplayName("maximum element found")
    void testFindMax() {

        assertThrows(IllegalArgumentException.class, () -> ArrayBasic.findMax(new int[]{}));
        assertAll(
                () -> assertEquals(-5, ArrayBasic.findMax(new int[]{-11, -33, -5, -9})),
                () -> assertEquals(20, ArrayBasic.findMax(new int[]{10, 5, 20, 8})),
                () -> assertEquals(1111, ArrayBasic.findMax(array))
        );

    }

    @Test
    @DisplayName("Find second max")
    void testSecondMax() {
        assertThrows(NullPointerException.class, () -> ArrayBasic.findSecondMax(null));
        assertThrows(IllegalArgumentException.class, () -> ArrayBasic.findSecondMax(new int[]{}));
        assertThrows(IllegalArgumentException.class, () -> ArrayBasic.findSecondMax(new int[]{66, 66, 66, 66, 66, 66}), "Failed to get second max");
        assertThrows(IllegalArgumentException.class, () -> ArrayBasic.findSecondMax(new int[]{-66, -66, -66, -66}), "Failed to get second max");
        assertThrows(IllegalArgumentException.class, () -> ArrayBasic.findSecondMax(new int[]{66}), "Failed to get second max");

        assertAll(
                () -> assertEquals(45, ArrayBasic.findSecondMax(new int[]{22, 34, 11, 45, 66, 66}), "Failed to get second max"),
                () -> assertEquals(22, ArrayBasic.findSecondMax(new int[]{22, 22, 22, 22, 66, 66}), "Failed to get second max"),
                () -> assertEquals(-2, ArrayBasic.findSecondMax(new int[]{-22, -2, -2, 22, -2, -2}), "Failed to get second max"),
                () -> assertEquals(999, ArrayBasic.findSecondMax(array), "Failed to get second max")
        );
    }

    @Test
    @DisplayName("find missing number")
    void testMissingNumber(){
        assertThrows(NullPointerException.class,()->ArrayBasic.findMissingNumber(null,20));
        assertThrows(IllegalArgumentException.class,()->ArrayBasic.findMissingNumber(new int[]{},33));

        int[] arr = {2,3,4,5,6};
        int num = ArrayBasic.findMissingNumber(arr,arr.length+1);
        int[] arr1 = {1,3,4,6,5};
        int num1 = ArrayBasic.findMissingNumber(arr1,arr1.length+1);
        int[] arr2 = {1,3,4,5,2};
        int num2 = ArrayBasic.findMissingNumber(arr2,arr2.length+1);
        int[] arr3 = {1};
        int num3 = ArrayBasic.findMissingNumber(arr3,arr3.length+1);
        int[] arr4 = {2};
        int num4 = ArrayBasic.findMissingNumber(arr4,arr4.length+1);
        assertAll(
                ()->assertEquals(1,num,"failed to find missing numbers"),
                ()->assertEquals(2,num1,"failed to find missing numbers"),
                ()->assertEquals(6,num2,"Failed to find missing number"),
                ()->assertEquals(2,num3,"Failed to find missing number"),
                ()->assertEquals(1,num4,"Failed to find missing number")
        );
    }

    @Test
    @DisplayName("Right shift by one")
    void testRotate(){
        assertThrows(NullPointerException.class,()->ArrayBasic.rotatedArray(null));
        assertThrows(IllegalArgumentException.class,()->ArrayBasic.rotatedArray(new int[]{}));
        int[] arr = {22, 33, 44, 55, 66, 77};
        int[] expectedArr = {77,22,33,44,55,66};
        int[] result = ArrayBasic.rotatedArray(array.clone());

        assertAll(
                ()-> assertArrayEquals(expectedArr,ArrayBasic.rotatedArray(arr),"Failed to rotate array by one"),
                ()->assertArrayEquals(new int[]{10},ArrayBasic.rotatedArray(new int[]{10}),"Failed to rotate one element array"),
                ()->assertArrayEquals(new int[]{2,1},ArrayBasic.rotatedArray(new int[]{1,2}),"Failed to rotate array(length =2)"),
                ()->assertEquals(array[array.length-1],result[0],"Failed to rotate last index"),
                ()->{
                    for(int i = 0 ;i<array.length-1;i++){
                        assertEquals(array[i],result[i+1],"Element mismatch at index "+(i+1));
                    }
                }

        );
    }
    @AfterEach
    void tearDown() {
        System.out.println("One test is completed");
    }

    @AfterAll
    static void doneAll() {
        System.out.println("**** All test case is completed ****");
    }

}
