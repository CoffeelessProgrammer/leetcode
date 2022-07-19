package io.coffeelessprogrammer.leetcode.difficulty.easy;

/*
 * Problem: 844. Backspace String Compare
 * Acceptance Rate: 47.4%
 * URL: https://leetcode.com/problems/backspace-string-compare/
 *
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Backspace String Compare.
 * Memory Usage: 36.8 MB, less than 97.27% of Java online submissions for Backspace String Compare.
 */

public class BackspaceStringCompare {

    // #region SpaceOptimized

    public static boolean compare(String str1, String str2) {
        int i = findNextSigChar(str1, str1.length()-1),
                j = findNextSigChar(str2, str2.length()-1);

        while(i > -1 && j > -1) {
            if(str1.charAt(i) != str2.charAt(j)) return false;

            --i; --j;

            i = findNextSigChar(str1, i);
            j = findNextSigChar(str2, j);
        }

        if(i<0) {
            return findNextSigChar(str2, j) < 0;
        } else {
            return findNextSigChar(str1, i) < 0;
        }
    }

    /** Get the next significant character starting from index (backwards traversal)
     */
    private static int findNextSigChar(String str, int index) {
        int hashCount = 0;

        for(int i=index; i > -1; --i) {
            if(str.charAt(i) == '#') {
                ++hashCount;
            } else if(hashCount > 0) {
                --hashCount;
            } else {
                return i;
            }
        }

        return -1;
    }

    // #endRegion

    // #region BruteForce

    public static boolean compareBF (String str1, String str2) {
        return parse(str1).equals(parse(str2));
    }

    private static String parse(String str) {
        StringBuilder sb = new StringBuilder();

        for(int i=0; i < str.length(); ++i) {
            if(str.charAt(i) == '#') {
                if(sb.length() > 0)
                    sb.deleteCharAt(sb.length()-1);
                continue;
            }

            sb.append(str.charAt(i));
        }

        return sb.toString();
    }

    // #endRegion
}
