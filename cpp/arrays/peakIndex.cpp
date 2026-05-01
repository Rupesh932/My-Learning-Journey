#include <iostream>
#include <vector>
#include <cassert>
using namespace std;
// rotated sorted array
class Solution
{
public:
    int peakIndex(const vector<int> &array)
    {
        if (array.size() < 3)
        {
            return -1;
        }
        int start = 0;
        int end = array.size() - 1;
        while (start < end)
        {
            int mid = start + (end - start) / 2;
            if (array[mid] < array[mid + 1])
            {
                start = mid + 1;
            }
            else
            {
                end = mid;
            }
        }
        return start;
    }

    int searchMinInRotatedArray(const vector<int> &array)
    {
        if (array.empty())
        {
            throw invalid_argument("Array is empty");
        }
        int start = 0;
        int end = array.size() - 1;
        while (start < end)
        {
            int mid = start + (end - start) / 2;
            if (array[mid] > array[end])
            {
                start = mid + 1;
            }
            else
            {
                end = mid;
            }
        }
        return array[start];
    }

    int searchTargetInRotatedArray(const vector<int> &array, int target)
    {
        if (array.empty())
        {
            return -1;
        }
        int start = 0;
        int end = array.size() - 1;
        while (start <= end)
        {
            int mid = start + (end - start) / 2;
            if (array[mid] == target)
            {
                return mid;
            }
            if (array[start] <= array[mid])
            {
                if (target >= array[start] && target < array[mid])
                {
                    end = mid - 1;
                }
                else
                {
                    start = mid + 1;
                }
            }
            else
            {
                if (target > array[mid] && target <= array[end])
                {
                    start = mid + 1;
                }
                else
                {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
};

int main()
{
    Solution sol;
    // test case 1
    vector<int> test1 = {0, 10, 5, 2};
    assert(sol.peakIndex(test1) == 1);

    // test case 2
    vector<int> test2 = {3, 4, 5, 1};
    assert(sol.peakIndex(test2) == 2);

    // test casee 3
    vector<int> test3 = {2, 4, 6, 8, 10, 8, 5};
    assert(sol.peakIndex(test3) == 4);
    // test 4
    assert(sol.peakIndex({}) == -1);
    assert(sol.peakIndex({2, 3}) == -1);

    cout << "All test cases of peakIndex() are passed" << endl;

    // test cases for searchMinInRotatedArray()
    //  test edge case
    vector<int> rotatedTest1 = {};
    try
    {
        sol.searchMinInRotatedArray(rotatedTest1);
        assert(false && "Should have thrown an exception for empty array");
    }
    catch (const invalid_argument &e)
    {
        cout << "Success: expected exception caught: " << e.what() << endl;
    }

    // test valid array
    assert(sol.searchMinInRotatedArray({4, 6, 8, 10, 1, 2}) == 1);
    assert(sol.searchMinInRotatedArray({1, 2, 3, 4, 5}) == 1);
    assert(sol.searchMinInRotatedArray({1, 2}) == 1);
    assert(sol.searchMinInRotatedArray({5, 1, 2, 3, 5}) == 1);
    cout << "All test cases of searchMinInRotatedArray() are passed" << endl;

    // test cases for searchTargetInRotatedArray()
    cout << "Testing searchTargetInRotatedArray()..." << endl;
    
    // 1. Edge Cases (Empty array)
    assert(sol.searchTargetInRotatedArray({}, 5) == -1);

    // 2. Target at different positions in Rotated Array
    vector<int> rotatedArray = {11, 14, 17, 22, 35, 5, 7, 9};
    assert(sol.searchTargetInRotatedArray(rotatedArray, 11) == 0); 
    assert(sol.searchTargetInRotatedArray(rotatedArray, 35) == 4); 
    assert(sol.searchTargetInRotatedArray(rotatedArray, 5) == 5);  
    assert(sol.searchTargetInRotatedArray(rotatedArray, 9) == 7);  
    assert(sol.searchTargetInRotatedArray(rotatedArray, 17) == 2); 

    // 3. Small Arrays (Two elements)
    assert(sol.searchTargetInRotatedArray({3, 1}, 1) == 1);
    assert(sol.searchTargetInRotatedArray({3, 1}, 3) == 0);
    assert(sol.searchTargetInRotatedArray({1, 3}, 3) == 1);

    // 4. Element not present
    assert(sol.searchTargetInRotatedArray({4, 5, 6, 7, 0, 1, 2}, 10) == -1);
    assert(sol.searchTargetInRotatedArray({4, 5, 6, 7, 0, 1, 2}, -3) == -1);

    // 5. Normal Sorted Array (Not rotated)
    assert(sol.searchTargetInRotatedArray({1, 2, 3, 4, 5}, 3) == 2);

    cout << "All test cases of searchTargetInRotatedArray() are passed" << endl;
}