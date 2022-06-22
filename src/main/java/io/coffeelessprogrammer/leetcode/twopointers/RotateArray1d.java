package io.coffeelessprogrammer.leetcode.twopointers;

import io.coffeelessprogrammer.leetcode.utility.Array;
import io.coffeelessprogrammer.leetcode.utility.BasicMath;

import java.util.Arrays;

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

    /*
     * Runtime: 3 ms, faster than 23.14% of Java online submissions for Rotate Array.
     * Memory Usage: 58.7 MB, less than 81.46% of Java online submissions for Rotate Array.
     */
    public void rotateInplace(int[] nums, int k) {
        // Sanitize input
        if(k%nums.length==0)
            return;
        else
            k = k%nums.length;

        // Setup
        final int lcm = BasicMath.leastCommonMultiple(nums.length, k);
        final int cycleAfter = lcm/k;

        // Rotate
        int currentCycle = 0;

        for(int position=0, j=0; j < nums.length; ++j) {
            if(j/cycleAfter > currentCycle) {
                ++currentCycle;
                ++position;
            }
            position = (position+k) % nums.length;
            Array.swapIndices(nums, currentCycle, position);
        }
    }

    public void rotateInplaceVerbose(int[] nums, int k) {
        // Sanitize input
        if(k%nums.length==0)
            return;
        else
            k = k%nums.length;

        // Setup
        final int lcm = BasicMath.leastCommonMultiple(nums.length, k);
        final int cycleAfter = lcm/k;

        System.out.printf("k=%d, iterationsPerCycle=%d\n", k, cycleAfter);
        System.out.printf("Before: %s\n\n", Arrays.toString(nums));

        // Rotate
        int currentCycle = 0;

        for(int position=0, j=0; j < nums.length; ++j) {
            if(j/cycleAfter > currentCycle) {
                ++currentCycle;
                ++position;
            }
            System.out.printf("iteration=%d, currentCycle=%d\n", j, currentCycle);
            position = (position+k) % nums.length;
            System.out.printf("\tSwapping:  nums[%d]=%d\tnums[%d]=%d\n", currentCycle, nums[currentCycle], position, nums[position]);
            Array.swapIndices(nums, currentCycle, position);
            System.out.printf("\tPost-swap: %s\n\n", Arrays.toString(nums));
        }

         System.out.println("After:  " + Arrays.toString(nums));
    }

    //#region LeetcodeResearch

    public void rotateConstantSpace(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    //#endRegion
}
