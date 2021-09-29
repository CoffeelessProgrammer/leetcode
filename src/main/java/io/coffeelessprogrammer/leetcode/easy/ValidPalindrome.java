package io.coffeelessprogrammer.leetcode.easy;

/*
 * Problem: 125. Valid Palindrome
 * Acceptance Rate: 39.7%
 * URL: https://leetcode.com/problems/valid-palindrome/
 *
 * Runtime: 21 ms, faster than 31.51% of Java online submissions for Valid Palindrome.
 * Memory Usage: 40 MB, less than 47.84% of Java online submissions for Valid Palindrome.
 */

public class ValidPalindrome {

    // #region BruteForce

    public static boolean isPalindrome(String str) {
        String simplified = reduceToAlphaNumeric(str);

        final int length = simplified.length();

        for(int i=0; i < length/2; ++i) {
            if(simplified.charAt(i) != simplified.charAt(length-1-i)) return false;
        }

        return true;
    }

    private static String reduceToAlphaNumeric(String str) {
        return str.toLowerCase().replaceAll("[^a-z0-9]", "");
    }

    // #endRegion
}
