package io.coffeelessprogrammer.leetcode.binarysearch;

/*
 * Problem: 704. Binary Search
 * Difficulty: Easy
 * Acceptance Rate: 55.2%
 * URL: https://leetcode.com/problems/binary-search/
 *
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Search.
 * Memory Usage: 54 MB, less than 61.50% of Java online submissions for Binary Search.
 */
public class BinarySearch {
    public static int search(int[] nums, int target) {
        int leftBound = 0;
        int rightBound = nums.length-1;

        int position, value;

        while(rightBound-leftBound > -1) {
            position = middleIndex(leftBound, rightBound);
            value = nums[position];

            displayWindow(position, leftBound, rightBound);

            // Check middle index
            if(value == target) return position;
            else if(target < value) {
                if(nums[leftBound] == target) return leftBound;

                // Shift window left
                leftBound += 1;
                rightBound = position-1;

            } else {
                if(nums[rightBound] == target) return rightBound;

                // Shift window right
                leftBound = position+1;
                rightBound -= 1;
            }
        }

        return -1;
    }

    //#region Helpers

    public static int middleIndex(int leftBound, int rightBound) {
        return leftBound + (rightBound-leftBound)/2;
    }

    public static int middleIndexCeil(int leftBound, int rightBound) {
        return rightBound - (rightBound-leftBound)/2;
    }

    public static void displayWindow(int current, int leftBound, int rightBound) {
        System.out.printf("Window [%d, %d, %d]\n", leftBound, current, rightBound);
    }

    //#endRegion
}