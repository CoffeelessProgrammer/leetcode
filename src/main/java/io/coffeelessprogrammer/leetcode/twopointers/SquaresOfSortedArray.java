package io.coffeelessprogrammer.leetcode.twopointers;

/*
 * Problem: 977. Squares of a Sorted Array
 * Difficulty: Easy
 * Acceptance Rate: 71.7%
 * URL: https://leetcode.com/problems/squares-of-a-sorted-array/
 *
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Squares of a Sorted Array.
 * Memory Usage: 55.5 MB, less than 60.75% of Java online submissions for Squares of a Sorted Array.
 */
public class SquaresOfSortedArray {

    public int[] sortedSquares(int[] nums) {
        final int[] result = new int[nums.length];

        int i2, j2;

        for(int i=0, j=nums.length-1; i <= j;) {
            i2 = nums[i] * nums[i];
            j2 = nums[j] * nums[j];

            if(i2 > j2) {
                result[j-i] = i2;
                ++i;
            } else {
                result[j-i] = j2;
                --j;
            }
        }

        return result;
    }
}
