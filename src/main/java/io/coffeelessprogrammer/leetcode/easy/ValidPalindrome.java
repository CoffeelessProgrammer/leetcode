package io.coffeelessprogrammer.leetcode.easy;

/*
 * Problem: 125. Valid Palindrome
 * Acceptance Rate: 39.7%
 * URL: https://leetcode.com/problems/valid-palindrome/
 *
 * Runtime: 21 ms, faster than 31.51% of Java online submissions for Valid Palindrome.
 * Memory Usage: 40 MB, less than 47.84% of Java online submissions for Valid Palindrome.
 *
 *   ↓ Switched from regex to custom string reduction algorithm
 *
 * Runtime: 2 ms, faster than 98.45% of Java online submissions for Valid Palindrome.
 * Memory Usage: 39.2 MB, less than 62.14% of Java online submissions for Valid Palindrome.
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
        // 0 to 9 = 48-57
        // A to Z = 65-90
        // a to z = 97-122
        StringBuilder sb = new StringBuilder();

        for(int i=0; i < str.length(); ++i) {
            char curr = str.charAt(i);

            if((curr < 123 && curr > 96) || (curr < 58 && curr > 47)) {
                sb.append(curr);
            } else if(curr < 91 && curr > 64) {
                sb.append((char) (curr+32));
            }
        }

        return sb.toString();
    }

    private static String reduceToAlphaNumericRegex(String str) {
        return str.toLowerCase().replaceAll("[^a-z0-9]", "");
    }

    // #endRegion
}
