package io.coffeelessprogrammer.leetcode.twopointers;

/*
 * Problem: 283. Move Zeroes
 * Difficulty: Easy
 * Acceptance Rate: 60.8%
 * URL: https://leetcode.com/problems/move-zeroes/
 *
 * Runtime: 2 ms, faster than 76.96% of Java online submissions for Move Zeroes.
 * Memory Usage: 43.8 MB, less than 85.98% of Java online submissions for Move Zeroes.
 */
public class MoveZeroes {

    public void bubble(int[] nums) {
        if(nums.length < 2) return;

        int leftmostZero=nextZeroIndex(nums, 0);
        if(leftmostZero == -1) return;  // Array has no zeroes

        int leftmostNumber = nextNonZeroIndex(nums, leftmostZero+1);

        while(leftmostNumber > -1) {
            nums[leftmostZero] = nums[leftmostNumber];
            nums[leftmostNumber] = 0;

            leftmostZero = nextZeroIndex(nums, leftmostZero+1);
            leftmostNumber = nextNonZeroIndex(nums, leftmostNumber+1);
        }
    }

    private static int nextZeroIndex(int[] nums, final int startFrom) {
        for(int i=startFrom; i<nums.length; ++i) {
            if(nums[i]==0) return i;
        }

        return -1;
    }

    private static int nextNonZeroIndex(int[] nums, final int startFrom) {
        for(int i=startFrom; i<nums.length; ++i) {
            if(nums[i]!=0) return i;
        }

        return -1;
    }

    //#region LeetcodeResearch

    public void moveZeroes(int[] nums) {
        int firstInsignificantIndex=0;

        // Move all significant numbers left
        for(int i=0; i<nums.length; ++i){
            if(nums[i] != 0){
                nums[firstInsignificantIndex] = nums[i];
                ++firstInsignificantIndex;
            }
        }

        // Fill remaining indices with 0
        for(int j=firstInsignificantIndex; j<nums.length; ++j)
            nums[j]=0;
    }

    //#endRegion
}
