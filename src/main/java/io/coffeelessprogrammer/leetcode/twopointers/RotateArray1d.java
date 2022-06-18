package io.coffeelessprogrammer.leetcode.twopointers;

/*
 * Problem: 189. Rotate Array
 * Difficulty: Medium
 * Acceptance Rate: 38.7%
 * URL: https://leetcode.com/problems/rotate-array/
 *
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate Array.
 * Memory Usage: 64 MB, less than 73.19% of Java online submissions for Rotate Array.
 */
public class RotateArray1d {

    public void rotate(int[] nums, int k) {
        // Sanitize input
        if(k%nums.length==0)
            return;
        else
            k = k%nums.length;

        // Copy segments
        final int[] temp = new int[k];

        System.arraycopy(nums, nums.length-k, temp, 0, k);

        System.arraycopy(nums, 0, nums, k, nums.length-k);

        System.arraycopy(temp, 0, nums, 0, k);
    }

}
