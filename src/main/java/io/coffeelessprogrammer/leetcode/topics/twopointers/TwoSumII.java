package io.coffeelessprogrammer.leetcode.topics.twopointers;

/*
 * Problem: 167. Two Sum II - Input Array Is Sorted
 * Difficulty: Medium
 * Acceptance Rate: 38.7%
 * URL: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 *
 * Runtime: 1 ms, faster than 99.24% of Java online submissions for Two Sum II - Input Array Is Sorted.
 * Memory Usage: 49.9 MB, less than 55.19% of Java online submissions for Two Sum II - Input Array Is Sorted.
 */
public class TwoSumII {

    public int[] twoSum(int[] nums, int target) {
        int sum;

        for(int i=0, j=nums.length-1; i < j; ) {
            sum = nums[i] + nums[j];

            if(sum == target)
                return new int[]{i+1, j+1};
            else if(sum > target)
                --j;
            else ++i;
        }

        return null;
    }

}
