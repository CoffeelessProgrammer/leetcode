package io.coffeelessprogrammer.leetcode.easy;

/*
 * Problem: 1. Two Sum
 * Acceptance Rate: 47.3%
 * URL: https://leetcode.com/problems/two-sum/
 *
 * Runtime: 3 ms, faster than 60.58% of Java online submissions for Two Sum.
 * Memory Usage: 42.7 MB, less than 5.64% of Java online submissions for Two Sum.
 */

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum(int[] numbers, int target) {

        // Set<Integer> seeking = new HashSet<>();
        Map<Integer, Integer> seeking = new HashMap<>();    // <WantedValue, IndexOfPreviouslyFoundComplement>

        for (int i=0; i<numbers.length; ++i) {
            if(seeking.containsKey(numbers[i])) {
                return new int[]{ seeking.get(numbers[i]), i };
            } else {
                seeking.put(target - numbers[i], i);
            }
        }

        throw new IllegalArgumentException("No solution found... ヽ(ಠ_ಠ)ノ");
    }

    // #region BruteForce

    public static int[] twoSumBF(int[] nums, int target) {

        for (int a = 0; a<nums.length; ++a) {
            for (int b = a+1; b<nums.length; ++b) {

                if (nums[a] + nums[b] == target)
                    return new int[] {a,b};
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    // #endRegion
}
