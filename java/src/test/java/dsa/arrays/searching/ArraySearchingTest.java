package dsa.arrays.searching;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class ArraySearchingTest {

    int[] array;
    static int counter = 0;

    @BeforeAll
    static void initAll() {
        System.out.println("**** Testing is starting ****");
    }

    @BeforeEach
    void setUp() {
        array = new int[]{2, 3, 4, 7, 11};
        counter++;
        System.out.println("New Array is created : via setUp()");
        System.out.println("we have now " + counter + " new array so  far created for each testing(One test = one @Test).");
    }



    @Test
    @DisplayName("peak mountain index in array")
    void testPeakIndexInMountainArray() {
        assertAll(
                () -> assertEquals(-1, ArraySearching.peakIndexInMountainArray(new int[]{}), "failed to test empty array"),
                () -> assertEquals(-1, ArraySearching.peakIndexInMountainArray(new int[]{22, 33}), "failed to test 'length <= 3' element array"),
                () -> assertEquals(-1, ArraySearching.peakIndexInMountainArray(null), "failed to test null array"),
                () -> assertEquals(4, ArraySearching.peakIndexInMountainArray(new int[]{2, 4, 6, 8, 10, 8, 5}), "failed to get peak index")
        );
    }

    @Test
    @DisplayName("peak mountain index in array optimized")
    void testPeakIndexInMountainArrayOptimized() {
        assertAll(
                () -> assertEquals(-1, ArraySearching.peakIndexInMountainArrayOptimized(new int[]{}), "failed to test empty array"),
                () -> assertEquals(-1, ArraySearching.peakIndexInMountainArrayOptimized(new int[]{22, 33}), "failed to test 'length <= 3' element array"),
                () -> assertEquals(-1, ArraySearching.peakIndexInMountainArrayOptimized(null), "failed to test null array"),
                () -> assertEquals(4, ArraySearching.peakIndexInMountainArrayOptimized(new int[]{2, 4, 6, 8, 10, 8, 5}), "failed to get peak index")
        );
    }

    @Test
    @DisplayName("search min in rotated sorted array")
    void testSearchMin(){
        assertAll(
                () -> assertEquals(-1, ArraySearching.searchMin(new int[]{}), "failed to test empty array"),
                () -> assertEquals(-1, ArraySearching.searchMin(new int[]{22}), "failed to test 'length <= 1' element array"),
                () -> assertEquals(-1, ArraySearching.searchMin(null), "failed to test null array"),
                () -> assertEquals(2, ArraySearching.searchMin(new int[]{2,4,5,8}), "failed to test sorted array")
        );
    }

    @Test
    @DisplayName("search min optimized")
    void testSearchMinOptimized(){
        // Edge Cases (Exceptions)
        assertThrows(IllegalArgumentException.class, () -> ArraySearching.searchMinOptimized(null));
        assertThrows(IllegalArgumentException.class, () -> ArraySearching.searchMinOptimized(new int[]{}));

        assertAll("Valid Rotated Arrays",
                () -> assertEquals(1, ArraySearching.searchMinOptimized(new int[]{4, 6, 8, 10, 1, 2}), "Failed: Middle pivot"),
                () -> assertEquals(1, ArraySearching.searchMinOptimized(new int[]{1, 2, 3, 4, 5}), "Failed: Already sorted"),
                () -> assertEquals(1, ArraySearching.searchMinOptimized(new int[]{2, 1}), "Failed: Two elements"),
                () -> assertEquals(1, ArraySearching.searchMinOptimized(new int[]{5, 1, 2, 3, 4}), "Failed: Smallest at index 1")
        );
    }

    @Test
    @DisplayName("search target in rotated array")
    void testSearchTarget(){
        assertAll(
                // Edge Cases
                () -> assertEquals(-1, ArraySearching.searchTarget(null, 9), "Should return -1 for null array"),
                () -> assertEquals(-1, ArraySearching.searchTarget(new int[]{}, 11), "Should return -1 for empty array"),
                () -> assertEquals(0, ArraySearching.searchTarget(new int[]{10}, 10), "Should find target in single-element array"),

                // Sorted & Absent Cases
                () -> assertEquals(-1, ArraySearching.searchTarget(new int[]{1, 2, 3, 4, 5, 6}, 10), "Should return -1 for absent element"),
                () -> assertEquals(4, ArraySearching.searchTarget(new int[]{2, 4, 6, 8, 10}, 10), "Should work on normal sorted array"),

                // Rotated Sorted Cases (Different Positions)
                () -> assertEquals(0, ArraySearching.searchTarget(new int[]{11, 14, 17, 22, 35, 5, 7, 9}, 11), "Target at the start"),
                () -> assertEquals(5, ArraySearching.searchTarget(new int[]{11, 14, 17, 22, 35, 5, 7, 9}, 5), "Target at the pivot (minimum)"),
                () -> assertEquals(7, ArraySearching.searchTarget(new int[]{11, 14, 17, 22, 35, 5, 7, 9}, 9), "Target at the end"),
                () -> assertEquals(1, ArraySearching.searchTarget(new int[]{3, 1}, 1), "Target in a two-element rotated array")
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
