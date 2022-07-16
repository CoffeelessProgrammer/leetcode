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
    public static int binarySearch(int[] nums, int target) {
        int leftBound = 0;
        int rightBound = nums.length-1;

        int position = middleIndex(leftBound, rightBound), value;

        displayWindowCenter(position, leftBound, rightBound);

        while(rightBound-leftBound > -1) {
            // position = middleIndex(leftBound, rightBound);
            value = nums[position];

            // Check middle index
            if(value == target) return position;
            else if(target < value) {
                if(nums[leftBound] == target) return leftBound;

                // Shift window left
                leftBound += 1;
                rightBound = position-1;
                position = middleIndex(leftBound, rightBound);

                displayWindowLeft(position, leftBound, rightBound);

            } else {
                if(nums[rightBound] == target) return rightBound;

                // Shift window right
                leftBound = position+1;
                rightBound -= 1;
                position = middleIndex(leftBound, rightBound);

                displayWindowRight(position, leftBound, rightBound);
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

    public static void displayWindowLeft(int current, int leftBound, int rightBound) {
        System.out.printf("Window [%d, %d, %d]\n", leftBound, current, rightBound);
    }

    public static void displayWindowCenter(int current, int leftBound, int rightBound) {
        System.out.printf("\t\tWindow [%d, %d, %d]\n", leftBound, current, rightBound);
    }

    public static void displayWindowRight(int current, int leftBound, int rightBound) {
        System.out.printf("\t\t\t\t\tWindow [%d, %d, %d]\n", leftBound, current, rightBound);
    }

    //#endRegion
}