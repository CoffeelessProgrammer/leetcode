package io.coffeelessprogrammer.leetcode.difficulty.easy;

/*
 * Problem: 680. Valid Palindrome II
 * Acceptance Rate: 37.7%
 * URL: https://leetcode.com/problems/valid-palindrome-ii/
 *
 * Runtime: 6 ms, faster than 77.83% of Java online submissions for Valid Palindrome II.
 * Memory Usage: 39.5 MB, less than 67.16% of Java online submissions for Valid Palindrome II.
 */

public class ValidPalindromeII {

    private String str;
    private int numRemovalsAllowed;

    public boolean isAlmostPalindrome(String str, int numRemovalsAllowed) {
        if(str.length() < 3) return true;

        this.str = str;
        this.numRemovalsAllowed = numRemovalsAllowed;

        final int length = str.length();

        for(int i=0; i < length/2; ++i) {
            if(str.charAt(i) != str.charAt(length-1-i)) {
                // → Skip left char
                if(skip(i+1, length-1-i, 1)) break;

                // → Skip right char
                return skip(i, length-2-i, 1);
            }
        }

        return true;
    }

    private boolean skip(int pL, int pR, int skipCount) {
        while(pL<pR) {
            if(this.str.charAt(pL) != this.str.charAt(pR)) {
                if(skipCount < this.numRemovalsAllowed) {
                    // → Skip left char
                    if(skip(pL+1, pR, skipCount+1)) break;

                    // → Skip right char
                    return skip(pL, pR-1, skipCount+1);
                }

                return false;
            }

            ++pL; --pR;
        }

        return true;
    }
}
