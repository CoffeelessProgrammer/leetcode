package io.coffeelessprogrammer.leetcode.twopointers;

import io.coffeelessprogrammer.leetcode.utility.Array;

import java.util.Arrays;

/*
 * Problem: 567. Permutation in String
 * Difficulty: Medium
 * Acceptance Rate: 44.4%
 * URL: https://leetcode.com/problems/permutation-in-string/
 *
 * Runtime: 3 ms, faster than 99.85% of Java online submissions for Permutation in String.
 * Memory Usage: 41.9 MB, less than 98.16% of Java online submissions for Permutation in String.
 *
 * Visual Explanation: https://www.instagram.com/p/CfmDLmtLsi7/?igshid=YmMyMTA2M2Y=
 */
public class PermutationInString {
    private final int[] targetFrequency = new int[26];

    private void setTargetFrequency(String s) {
        // ASCII:   a=97    z=122
        for(int i=0; i < s.length(); ++i)
            targetFrequency[s.charAt(i)-97] += 1;
    }

    public boolean checkInclusionTallySum(String s1, String s2) {
        final int permutationLength = s1.length();

        setTargetFrequency(s1);

        int[] tally = new int[26];
        int tallySum = 0;

        int currentLetter;

        for(int i=0; tallySum < permutationLength && i < s2.length(); ++i) {
            currentLetter = s2.charAt(i) - 97;

            if(targetFrequency[currentLetter] < 1) {
                if(tallySum != 0) {
                    tallySum = 0;
                    Arrays.fill(tally, 0);
                }
                continue;
            }

            while(tally[currentLetter] >= targetFrequency[currentLetter])
                tally[s2.charAt(i-tallySum--) - 97] -= 1;

            tally[currentLetter] += 1;
            ++tallySum;
        }

        return tallySum == permutationLength;
    }

    /* Runtime: 4 ms, faster than 97.71% of Java online submissions for Permutation in String.
     * Memory Usage: 42.9 MB, less than 76.84% of Java online submissions for Permutation in String.
     */
    public boolean checkInclusionWindowLeftPointer(String s1, String s2) {
        final int permutationLength = s1.length();

        setTargetFrequency(s1);

        int[] tally = new int[26];

        int currentLetter;

        for(int i=0, left=0; i < s2.length(); ++i) {
            if(i-left == permutationLength) return true;
            currentLetter = s2.charAt(i) - 97;

            if(targetFrequency[currentLetter] < 1) {
                if(left < i)
                    Arrays.fill(tally, 0);
                left = i+1;
                continue;
            }

            while(tally[currentLetter] >= targetFrequency[currentLetter])
                tally[s2.charAt(left++) - 97] -= 1;

            tally[currentLetter] += 1;
        }

        return Array.sum(tally) == permutationLength;
    }
}
